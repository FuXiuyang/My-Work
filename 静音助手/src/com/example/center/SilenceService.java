package com.example.center;


import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;

import android.os.IBinder;


public class SilenceService extends Service {					//执行后台运行的类
	
	//接收系统时间改变广播的类
	private GetTineChange gtc;
	
	//接收系统电话改变广播的类
	private SendMessage sm;
	
	private IntentFilter filter1,filter2;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();

		
		filter1 = new IntentFilter("android.intent.action.TIME_TICK"); 
		gtc = new GetTineChange();  
		
		filter2 = new IntentFilter("android.intent.action.PHONE_STATE");
		sm = new SendMessage();
	}


	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		//注册接收系统时间改变
		registerReceiver(gtc, filter1); 
		
		//注册接收系统电话状态改变
		registerReceiver(sm, filter2);

	}

}


