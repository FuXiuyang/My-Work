package com.example.center;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class GetTineChange extends BroadcastReceiver{

	private GetActivity ga;
	@Override
	public void onReceive(Context context, Intent intent) {		//接收系统时间改变广播
		// TODO Auto-generated method stub
		ga = new GetActivity(context);
		ga.runGa();										//时间改变就执行一遍判断是否静音的操作
		System.out.println("日期被修改了");
	}

}