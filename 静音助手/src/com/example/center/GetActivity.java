package com.example.center;

import java.util.Calendar;
import java.util.List;



import android.content.Context;




import com.example.circlebutton.User;
import com.example.circlebutton.UserMySqlite;

public class GetActivity {
	
	//�������ݿ������
	private UserMySqlite mysqlite;
	
	//���ݿ����������
	private User user;
	
	//����
	private List<User> users;
	
	//����������
	private ChangeVoice cv;
	
	//��ȡϵͳʱ����
	private Calendar calendar;
	
	//���Ͷ��ŵ�����
	private String msg;
	
	
	//������־�ͷ��Ͷ��ſ����Ƿ�򿪱�־
	private boolean bl,issem;
	
	
	public GetActivity(Context context){
		cv = new ChangeVoice(context);
		calendar = Calendar.getInstance();
		mysqlite = new UserMySqlite(context);

			
		}
	
	public void runGa(){		//�ж��������㾲�������Ļ
		users = mysqlite.findAllUsers();
		for(int i=0; i<users.size(); i++){
			user = users.get(i);
			isOpen(user);
		}
	}
	
	public void isOpen(User user){		//�ж�ĳһ��Ƿ����㾲��������
		if(user.getIsopen()==1){
			if(isWeek(user)){
			setVoice(user);
			}
		}
	}
	public boolean isWeek(User user){		//�ж�ĳһ��Ƿ�򿪸����ڵ�
		boolean bl = false;
		switch(calendar.get(Calendar.DAY_OF_WEEK)){
		case Calendar.MONDAY :
			if(user.getMon()==1)
				bl=true;
			else
				bl=false;
			break;
		case Calendar.TUESDAY:
			if(user.getTue()==1)
				bl=true;
			else
				bl=false;
			break;
		case Calendar.WEDNESDAY:
			if(user.getWed()==1)
				bl=true;
			else
				bl=false;
			break;
		case Calendar.THURSDAY:
			if(user.getThu()==1)
				bl=true;
			else 
				bl=false;
			break;
		case Calendar.FRIDAY:
			if(user.getFri()==1)
				bl=true;
			else
				bl=false;
			break;
		case Calendar.SATURDAY:
			if(user.getSat()==1)
				bl=true;
			else
				bl=false;
			break;
		case Calendar.SUNDAY :
			if(user.getSun()==1)
				bl=true;
			else
				bl=false;
			break;
		}
		//
		if((user.getMon()!=1)&&(user.getTue()!=1)&&(user.getWed()!=1)
				&&(user.getThu()!=1)&&(user.getFri()!=1)&&(user.getSat()!=1)
				&&(user.getSun()!=1))
			bl=true;
		return bl;
	}
	
	public void setVoice(User user){		//���ݻ���õĿ�ʼ������ʱ�䣬�����Ǿ������ǲ�����
		
		if(user.getStarthour()==user.getStophour()){		//
			if(calendar.get(Calendar.MINUTE)>user.getStartminute()
					&&calendar.get(Calendar.MINUTE)<user.getStopminute()){//ִ�о���
				System.out.println(" ������"+calendar.get(Calendar.HOUR_OF_DAY));
				System.out.println("������ "+calendar.get(Calendar.MINUTE));
				msg="����������"+user.getItem()+"������"+user.getStophour()+"��"+user.getStopminute()+"֮�������";
				System.out.println(msg);
				cv.setSilence();
				bl=true;
				setIssem(user);
			}else{										//ȡ������
				System.out.println(" ��������"+calendar.get(Calendar.HOUR_OF_DAY));
				System.out.println("�������� "+calendar.get(Calendar.MINUTE));
				cv.setNormal();
				bl=false;
			}				
		}
		if(user.getStarthour()<user.getStophour()){		//
			if((calendar.get(Calendar.HOUR_OF_DAY)>user.getStarthour()
					&&calendar.get(Calendar.HOUR_OF_DAY)<user.getStophour())
					||(calendar.get(Calendar.HOUR_OF_DAY)==user.getStarthour()
					&&calendar.get(Calendar.MINUTE)>user.getStartminute())
					||(calendar.get(Calendar.HOUR_OF_DAY)==user.getStophour()
							&&calendar.get(Calendar.MINUTE)<user.getStopminute())){//ִ�о���
				System.out.println(" ������"+calendar.get(Calendar.HOUR_OF_DAY));
				System.out.println("������ "+calendar.get(Calendar.MINUTE));
				msg="����������"+user.getItem()+"������"+user.getStophour()+"��"+user.getStopminute()+"֮�������";
				System.out.println(msg);
				cv.setSilence();
				bl=true;
				setIssem(user);
			}else{									//ȡ������
				System.out.println(" ��������"+calendar.get(Calendar.HOUR_OF_DAY));
				System.out.println("�������� "+calendar.get(Calendar.MINUTE));
				cv.setNormal();
				bl=false;
			}
		}
		if(user.getStarthour()>user.getStophour()){		//
			if(calendar.get(Calendar.HOUR_OF_DAY)>user.getStarthour()
					||(calendar.get(Calendar.HOUR_OF_DAY)==user.getStarthour()
							&&calendar.get(Calendar.MINUTE)>=user.getStartminute())
					||(calendar.get(Calendar.HOUR_OF_DAY)<user.getStophour())
					||(calendar.get(Calendar.HOUR_OF_DAY)==user.getStophour()
							&&calendar.get(Calendar.MINUTE)<=user.getStopminute())){//ִ�о���
				System.out.println(" ������"+calendar.get(Calendar.HOUR_OF_DAY));
				System.out.println("������ "+calendar.get(Calendar.MINUTE));
				msg="����������"+user.getItem()+"������"+user.getStophour()+"��"+user.getStopminute()+"֮�������";
				System.out.println(msg);
				cv.setSilence();
				bl=true;
				setIssem(user);
			}else{										//ȡ������
				System.out.println(" ��������"+calendar.get(Calendar.HOUR_OF_DAY));
				System.out.println("�������� "+calendar.get(Calendar.MINUTE));
				cv.setNormal();
				bl=false;
			}
		}
	}

	public String getMsg(){								//����������Խ��յ���Ϣ���ݵķ���
		  return msg;
	}
	

	public boolean getBl(){								//��־����״̬�ķ���
		return bl;
	}
	public boolean getIssem(){							//��־�Ƿ��Ͷ��ŵķ���
		return issem;
	}
	public void setIssem(User user){					//�������ݿ���Ϣ���ж��Ƿ��Ͷ���
		if(1==user.getIssem())
		{
			issem=true;
		}else
		{
			issem=false;
		}
	}


	
}
