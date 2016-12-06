package com.example.circlebutton;


import com.example.silence.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;


public class Circle extends View{
	
	//设置圆关闭是的颜色为灰色
	private int offcolor=Color.GRAY;
	//设置圆打开时字体颜色为白色
	private int onwordcolor=Color.WHITE;
	//设置圆打开时的颜色为红色
	private int oncolor=Color.RED;
	//设置圆按钮的默认状态为关闭
	private boolean status=false;
	

	private Paint paint;
	//设置圆按钮内文字默认为1
	private String st="1";
	//设置圆按钮默认位置的x坐标
	private float x=30;
	//设置圆按钮默认位置的y坐标
	private float y=30;
	//设置圆按钮中字体默认大小
	private int wordsize=25;
	//设置圆默认半径
	private float radius=23;

	public Circle(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		paint = new Paint();
		init(attrs);
	}
	public void init(AttributeSet attrs){
		TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.Cir);
		st = ta.getString(R.styleable.Cir_name);
		x = this.getLeft()+radius;
		y = this.getTop()+radius; 
		ta.recycle();
		
	}
	@Override
	protected void onDraw(Canvas canvas) {				//重写ondraw方法
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		if(!status){					//设置圆按钮关闭时的图像
			paint.setColor(offcolor);
			paint.setStyle(Style.STROKE);
			canvas.drawCircle(x, y, radius, paint);
			paint.setTextSize(wordsize);
			canvas.drawText(st, x-7, y+10, paint);
		}else{						//设置圆按钮打开时的图像
			paint.setColor(oncolor);
			paint.setStyle(Style.FILL);
			canvas.drawCircle(x, y, radius, paint);
			paint.setColor(onwordcolor);
			paint.setTextSize(wordsize);
			canvas.drawText(st, x-7, y+10, paint);
		}
	}
	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {													//圆按钮的位置
		// TODO Auto-generated method stub
		super.onLayout(changed, left, top, right, bottom);
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {			//圆按钮大小的设置
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasure(widthMeasureSpec), heightMeasure(heightMeasureSpec));
		setMeasuredDimension(widthMeasure(widthMeasureSpec),heightMeasure(heightMeasureSpec));
	}
	public int widthMeasure(int widthMeasureSpec){			//圆按钮宽的设置
		int result=0;
		int specMode=MeasureSpec.getMode(widthMeasureSpec);
		int specSize=MeasureSpec.getSize(widthMeasureSpec);
		if(specMode==MeasureSpec.EXACTLY){
			result=specSize;
		}else{
			result=(int)(2*radius)+getRight()+getLeft();
			if(specMode==MeasureSpec.AT_MOST)
			result=Math.min(result, specSize);
		}
		return result;
	}
	public int heightMeasure(int heightMeasureSpec){		//圆按钮长的设置
		int result=0;
		int specMode=MeasureSpec.getMode(heightMeasureSpec);
		int specSize=MeasureSpec.getSize(heightMeasureSpec);
		if(specMode==MeasureSpec.EXACTLY){
			result=specSize;
		}else{
			result=(int)(2*radius)+getBottom()+getTop();
			if(specMode==MeasureSpec.AT_MOST)
			result=Math.min(result, specSize);
		}
		return result;
	}
	public boolean isStatus() {			//获取circle状态
		return status;
	}
	public void setStatus(boolean status) {		//改变设置circle状态
		this.status = status;
		invalidate();
	}
	
}
