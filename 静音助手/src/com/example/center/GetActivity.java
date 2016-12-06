package com.example.center;

import java.util.Calendar;
import java.util.List;



import android.content.Context;




import com.example.circlebutton.User;
import com.example.circlebutton.UserMySqlite;

public class GetActivity {
	
	//声明数据库操作类
	private UserMySqlite mysqlite;
	
	//数据库包含内容类
	private User user;
	
	//链表
	private List<User> users;
	
	//静音设置类
	private ChangeVoice cv;
	
	//获取系统时间类
	private Calendar calendar;
	
	//发送短信的内容
	private String msg;
	
	
	//静音标志和发送短信开关是否打开标志
	private boolean bl,issem;
	
	
	public GetActivity(Context context){
		cv = new ChangeVoice(context);
		calendar = Calendar.getInstance();
		mysqlite = new UserMySqlite(context);

			
		}
	
	public void runGa(){		//判断所有满足静音条件的活动
		users = mysqlite.findAllUsers();
		for(int i=0; i<users.size(); i++){
			user = users.get(i);
			isOpen(user);
		}
	}
	
	public void isOpen(User user){		//判断某一活动是否满足静音的条件
		if(user.getIsopen()==1){
			if(isWeek(user)){
			setVoice(user);
			}
		}
	}
	public boolean isWeek(User user){		//判断某一活动是否打开该星期的
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
	
	public void setVoice(User user){		//根据活动设置的开始、结束时间，设置是静音还是不静音
		
		if(user.getStarthour()==user.getStophour()){		//
			if(calendar.get(Calendar.MINUTE)>user.getStartminute()
					&&calendar.get(Calendar.MINUTE)<user.getStopminute()){//执行静音
				System.out.println(" 静音的"+calendar.get(Calendar.HOUR_OF_DAY));
				System.out.println("静音的 "+calendar.get(Calendar.MINUTE));
				msg="我现在正在"+user.getItem()+"，请在"+user.getStophour()+"："+user.getStopminute()+"之后打来。";
				System.out.println(msg);
				cv.setSilence();
				bl=true;
				setIssem(user);
			}else{										//取消静音
				System.out.println(" 不静音的"+calendar.get(Calendar.HOUR_OF_DAY));
				System.out.println("不静音的 "+calendar.get(Calendar.MINUTE));
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
							&&calendar.get(Calendar.MINUTE)<user.getStopminute())){//执行静音
				System.out.println(" 静音的"+calendar.get(Calendar.HOUR_OF_DAY));
				System.out.println("静音的 "+calendar.get(Calendar.MINUTE));
				msg="我现在正在"+user.getItem()+"，请在"+user.getStophour()+"："+user.getStopminute()+"之后打来。";
				System.out.println(msg);
				cv.setSilence();
				bl=true;
				setIssem(user);
			}else{									//取消静音
				System.out.println(" 不静音的"+calendar.get(Calendar.HOUR_OF_DAY));
				System.out.println("不静音的 "+calendar.get(Calendar.MINUTE));
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
							&&calendar.get(Calendar.MINUTE)<=user.getStopminute())){//执行静音
				System.out.println(" 静音的"+calendar.get(Calendar.HOUR_OF_DAY));
				System.out.println("静音的 "+calendar.get(Calendar.MINUTE));
				msg="我现在正在"+user.getItem()+"，请在"+user.getStophour()+"："+user.getStopminute()+"之后打来。";
				System.out.println(msg);
				cv.setSilence();
				bl=true;
				setIssem(user);
			}else{										//取消静音
				System.out.println(" 不静音的"+calendar.get(Calendar.HOUR_OF_DAY));
				System.out.println("不静音的 "+calendar.get(Calendar.MINUTE));
				cv.setNormal();
				bl=false;
			}
		}
	}

	public String getMsg(){								//让其他类可以接收到信息内容的方法
		  return msg;
	}
	

	public boolean getBl(){								//标志静音状态的方法
		return bl;
	}
	public boolean getIssem(){							//标志是否发送短信的方法
		return issem;
	}
	public void setIssem(User user){					//根据数据库信息，判断是否发送短信
		if(1==user.getIssem())
		{
			issem=true;
		}else
		{
			issem=false;
		}
	}


	
}
