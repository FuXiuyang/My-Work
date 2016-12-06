package com.example.center;



import java.util.List;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;

import android.telephony.TelephonyManager;

public class SendMessage extends BroadcastReceiver{				//���յ绰״̬�ı�Ĺ㲥����
	
	private GetActivity ga;

	//���ó�ʼ״̬Ϊ����״̬
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


	 PhoneStateListener listener=new PhoneStateListener(){			//�绰״̬����
		 
		  @Override
		  public void onCallStateChanged(int state, String phonenum) {
		   super.onCallStateChanged(state, phonenum);
		   switch(state){
		   case TelephonyManager.CALL_STATE_RINGING:
			   num=phonenum;									//��¼����绰����
			   break;
		   }
		   if(oldstate==TelephonyManager.CALL_STATE_RINGING
				   &&state==TelephonyManager.CALL_STATE_IDLE){		//�жϵ绰�Ƿ�Ҷ�
			   System.out.println("�绰�Ҷ���");
			   ga.runGa();
			   if(ga.getIssem())									//�жϷ��Ͷ��Ű�ť�Ƿ��
			   if(ga.getBl()){										//�ж��Ƿ����ھ���״̬
				   System.out.println("�鿴������ʱ���Ƿ�Ϊ��");
			   if(ga.getMsg()!=null){
				   System.out.println("�鿴�����Ƿ��ͳɹ�");
				   sendMsg(num,ga.getMsg());							//���Ͷ���
			   
			   }
			   }
			   
		   }
		   oldstate=state;
		  }
		 };
	public void sendMsg(String phonenum,String msg){					//���Ͷ��ŷ���
		
		List<String> divideContents = smsManager.divideMessage(msg);
		for (String text : divideContents) {       
			 smsManager.sendTextMessage(phonenum, 
					 null, text, null, null);     
			}  
	}

}
