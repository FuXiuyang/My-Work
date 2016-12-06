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
	//��¼��ť��״̬����ť��ʼֵΪfalse
	private boolean status=false;

	//Բ��ߵ���ɫ
	private int stroke_color=Color.BLACK;
	private int offcolor=Color.GRAY;
	//�򿪰�ťʱԲ����ɫ
	private int oncolor=Color.GREEN;
	//
	private float height=50;
	private float width=100;
	private float radius;

	//������Χֱ�߿�ʼ��x����
	private float startx;
	//������Χֱ�߿�ʼ��y����
	private float starty;
	//������Χֱ�߽�����x����
	private float stopx;
	//������Χֱ�߽�����y����
	private float stopy;
	//button��ť��߰�Բ���о���
	private RectF rect1;
	//button��ť�ұ߰�Բ���о���
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
		//��button��ť�������
		canvas.drawLine(startx, starty, stopx, stopy, paint);
		//��button��ť�������
		canvas.drawLine(startx, starty+2*radius, stopx, stopy+2*radius, paint);
		//����button�����Բ���о��ε�ֵ
		rect1.set(stopx-radius, stopy, stopx+radius, stopy+2*radius);
		//����button�����Բ
		canvas.drawArc(rect1, 270, 180, false, paint);
		//����button�����Բ���о��ε�ֵ
		rect2.set(startx-radius,stopy,startx+radius,stopy+2*radius);
		//����button�����Բ
		canvas.drawArc(rect2, 90, 180, false, paint);
		if(!status){						//���״̬Ϊ�٣���ť�ر�״̬����ֻ���ڳ�ʼbutton��ť�������滭��Բ����
			paint.setColor(offcolor);
			paint.setStyle(Style.FILL_AND_STROKE);
			canvas.drawCircle(startx, starty+radius,radius-2,paint);	
		}else{								//���״̬Ϊ�棬��Ҫ��button�������沿��������ɫ
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
	
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {//���û�����ť�ĳ���
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasure(widthMeasureSpec), heightMeasure(heightMeasureSpec));
		setMeasuredDimension(widthMeasure(widthMeasureSpec),heightMeasure(heightMeasureSpec));
	}
	public int widthMeasure(int widthMeasureSpec){						//���û�����ť�Ŀ�
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
	public int heightMeasure(int heightMeasureSpec){					//���û�����ť�ĳ�
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
	public boolean isStatus() {				//��ȡ��ť��״̬
		return status;
	}
	public void setStatus(boolean status) {		//�ı䰴ť��״̬
		this.status = status;
		invalidate();
	}

}
