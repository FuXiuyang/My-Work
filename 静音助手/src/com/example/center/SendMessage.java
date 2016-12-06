package com.example.center;



import java.util.List;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;

import android.telephony.TelephonyManager;

public class SendMessage extends BroadcastReceiver{				//接收电话状态改变的广播方法
	
	private GetActivity ga;

	//设置初始状态为待机状态
	private static int oldstate=TelephonyManager.CALL_STATE_IDLE;
	
	private SmsManager smsManager;
	
	private static String num; 
	

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		 TelephonyManager tm = (TelephonyManager)context.getSystemService(Service.TELEPHONY_SERVICE);  
		   tm.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
		   smsManager = SmsManager.getDefault();
		   ga = new GetActivity(context);
	}


	 PhoneStateListener listener=new PhoneStateListener(){			//电话状态监听
		 
		  @Override
		  public void onCallStateChanged(int state, String phonenum) {
		   super.onCallStateChanged(state, phonenum);
		   switch(state){
		   case TelephonyManager.CALL_STATE_RINGING:
			   num=phonenum;									//记录来电电话号码
			   break;
		   }
		   if(oldstate==TelephonyManager.CALL_STATE_RINGING
				   &&state==TelephonyManager.CALL_STATE_IDLE){		//判断电话是否挂断
			   System.out.println("电话挂断了");
			   ga.runGa();
			   if(ga.getIssem())									//判断发送短信按钮是否打开
			   if(ga.getBl()){										//判断是否是在静音状态
				   System.out.println("查看静音的时候是否为真");
			   if(ga.getMsg()!=null){
				   System.out.println("查看短信是否发送成功");
				   sendMsg(num,ga.getMsg());							//发送短信
			   
			   }
			   }
			   
		   }
		   oldstate=state;
		  }
		 };
	public void sendMsg(String phonenum,String msg){					//发送短信方法
		
		List<String> divideContents = smsManager.divideMessage(msg);
		for (String text : divideContents) {       
			 smsManager.sendTextMessage(phonenum, 
					 null, text, null, null);     
			}  
	}

}
