package com.example.center;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class GetTineChange extends BroadcastReceiver{

	private GetActivity ga;
	@Override
	public void onReceive(Context context, Intent intent) {		//����ϵͳʱ��ı�㲥
		// TODO Auto-generated method stub
		ga = new GetActivity(context);
		ga.runGa();										//ʱ��ı��ִ��һ���ж��Ƿ����Ĳ���
		System.out.println("���ڱ��޸���");
	}

}