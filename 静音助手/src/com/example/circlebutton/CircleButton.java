package com.example.circlebutton;

import com.example.silence.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CircleButton extends View{
	private Paint paint;
	//记录按钮的状态，按钮初始值为false
	private boolean status=false;

	//圆描边的颜色
	private int stroke_color=Color.BLACK;
	private int offcolor=Color.GRAY;
	//打开按钮时圆的颜色
	private int oncolor=Color.GREEN;
	//
	private float height=50;
	private float width=100;
	private float radius;

	//滑块外围直线开始的x坐标
	private float startx;
	//滑块外围直线开始的y坐标
	private float starty;
	//滑块外围直线结束的x坐标
	private float stopx;
	//滑块外围直线结束的y坐标
	private float stopy;
	//button按钮左边半圆内切矩形
	private RectF rect1;
	//button按钮右边半圆内切矩形
	private RectF rect2;
	
	public CircleButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		paint = new Paint();
		rect1 = new RectF();
		rect2 = new RectF();

		init(attrs);
	
	}
	public void init(AttributeSet attrs){
		TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.CircleButton);
		height = ta.getDimension(R.styleable.CircleButton_height,height);
		width =  ta.getDimension(R.styleable.CircleButton_width,width);
		radius = height/2;
		startx = this.getRight()+radius;
		starty = this.getTop();
		stopx = startx+width;
		stopy = starty;
		ta.recycle();
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		paint.setColor(stroke_color);
		paint.setStyle(Style.STROKE);
		//画button按钮上面的线
		canvas.drawLine(startx, starty, stopx, stopy, paint);
		//画button按钮下面的线
		canvas.drawLine(startx, starty+2*radius, stopx, stopy+2*radius, paint);
		//设置button左面半圆内切矩形的值
		rect1.set(stopx-radius, stopy, stopx+radius, stopy+2*radius);
		//画出button左面半圆
		canvas.drawArc(rect1, 270, 180, false, paint);
		//设置button右面半圆内切矩形的值
		rect2.set(startx-radius,stopy,startx+radius,stopy+2*radius);
		//画出button右面半圆
		canvas.drawArc(rect2, 90, 180, false, paint);
		if(!status){						//如果状态为假（按钮关闭状态），只需在初始button按钮背景左面画个圆滑标
			paint.setColor(offcolor);
			paint.setStyle(Style.FILL_AND_STROKE);
			canvas.drawCircle(startx, starty+radius,radius-2,paint);	
		}else{								//如果状态为真，需要把button滑标左面部分填充成绿色
			paint.setColor(oncolor);
			paint.setStyle(Style.FILL_AND_STROKE);
			canvas.drawCircle(stopx, stopy+radius,radius-2,paint);
		}
	}
	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		super.onLayout(changed,left, top,right, bottom);
	}
	
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {//设置滑动按钮的长宽
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasure(widthMeasureSpec), heightMeasure(heightMeasureSpec));
		setMeasuredDimension(widthMeasure(widthMeasureSpec),heightMeasure(heightMeasureSpec));
	}
	public int widthMeasure(int widthMeasureSpec){						//设置滑动按钮的宽
		int result=0;
		int specMode=MeasureSpec.getMode(widthMeasureSpec);
		int specSize=MeasureSpec.getSize(widthMeasureSpec);
		if(specMode==MeasureSpec.EXACTLY){
			result=specSize;
		}else{
			result=(int)(2*radius)+(int)(stopx-startx)+getRight()+getLeft();
			if(specMode==MeasureSpec.AT_MOST)
			result=Math.min(result, specSize);
		}
		return result;
	}	
	public int heightMeasure(int heightMeasureSpec){					//设置滑动按钮的长
		int result=0;
		int specMode=MeasureSpec.getMode(heightMeasureSpec);
		int specSize=MeasureSpec.getSize(heightMeasureSpec);
		if(specMode==MeasureSpec.EXACTLY){
			result=specSize;
		}else{
			result=(int)(2*radius+1)+getBottom()+getTop();
			if(specMode==MeasureSpec.AT_MOST)
			result=Math.min(result, specSize);
		}
		return result;
	}
	public boolean isStatus() {				//获取按钮的状态
		return status;
	}
	public void setStatus(boolean status) {		//改变按钮的状态
		this.status = status;
		invalidate();
	}

}
