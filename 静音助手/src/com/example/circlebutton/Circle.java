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
	
	//����Բ�ر��ǵ���ɫΪ��ɫ
	private int offcolor=Color.GRAY;
	//����Բ��ʱ������ɫΪ��ɫ
	private int onwordcolor=Color.WHITE;
	//����Բ��ʱ����ɫΪ��ɫ
	private int oncolor=Color.RED;
	//����Բ��ť��Ĭ��״̬Ϊ�ر�
	private boolean status=false;
	

	private Paint paint;
	//����Բ��ť������Ĭ��Ϊ1
	private String st="1";
	//����Բ��ťĬ��λ�õ�x����
	private float x=30;
	//����Բ��ťĬ��λ�õ�y����
	private float y=30;
	//����Բ��ť������Ĭ�ϴ�С
	private int wordsize=25;
	//����ԲĬ�ϰ뾶
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
	protected void onDraw(Canvas canvas) {				//��дondraw����
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		if(!status){					//����Բ��ť�ر�ʱ��ͼ��
			paint.setColor(offcolor);
			paint.setStyle(Style.STROKE);
			canvas.drawCircle(x, y, radius, paint);
			paint.setTextSize(wordsize);
			canvas.drawText(st, x-7, y+10, paint);
		}else{						//����Բ��ť��ʱ��ͼ��
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
			int bottom) {													//Բ��ť��λ��
		// TODO Auto-generated method stub
		super.onLayout(changed, left, top, right, bottom);
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {			//Բ��ť��С������
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasure(widthMeasureSpec), heightMeasure(heightMeasureSpec));
		setMeasuredDimension(widthMeasure(widthMeasureSpec),heightMeasure(heightMeasureSpec));
	}
	public int widthMeasure(int widthMeasureSpec){			//Բ��ť�������
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
	public int heightMeasure(int heightMeasureSpec){		//Բ��ť��������
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
	public boolean isStatus() {			//��ȡcircle״̬
		return status;
	}
	public void setStatus(boolean status) {		//�ı�����circle״̬
		this.status = status;
		invalidate();
	}
	
}
