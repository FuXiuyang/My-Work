package com.example.center;


import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;

import android.os.IBinder;


public class SilenceService extends Service {					//ִ�к�̨���е���
	
	//����ϵͳʱ��ı�㲥����
	private GetTineChange gtc;
	
	//����ϵͳ�绰�ı�㲥����
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
		//ע�����ϵͳʱ��ı�
		registerReceiver(gtc, filter1); 
		
		//ע�����ϵͳ�绰״̬�ı�
		registerReceiver(sm, filter2);

	}

}


