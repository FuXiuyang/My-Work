package com.example.silence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.circlebutton.Circle;
import com.example.circlebutton.CircleButton;
import com.example.circlebutton.User;
import com.example.circlebutton.UserMySqlite;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SetActivity extends Activity {
	private Circle c1,c2,c3,c4,c5,c6,c7; 
	
	private CircleButton cb1,cb2;
	
	private ImageView addstarthour,addstartminute,addstophour,addstopminute,
					   substarthour,substartminute,substophour,substopminute;
	
	private TextView  starthour,startminute,stophour,stopminute,setitem;
	
	private int starttimehour,starttimeminute,stoptimehour,stoptimeminute;
	
	private LinearLayout biaoqian;
	
	private int stahour,staminute,stohour,stominute;
	
	private Button save,delete;
	
	private int id;
	
	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	private List<User> users;
	
	
	private User user =null;
	
	private UserMySqlite mysqlite;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_timewhile);
		
		mysqlite = new UserMySqlite(this);
		
		users = mysqlite.findAllUsers();
		
		for(int i=0;i<users.size();i++){
			user = users.get(i);		
			map.put(i, user.getId());
		}
		init();
	}
	public void init(){
		Intent intent = getIntent();

		id = intent.getIntExtra("id", 1);
		
		user = users.get(id);
		
		c1 = (Circle) findViewById(R.id.c1);
		
		if(user.getMon()==1)
			c1.setStatus(true);
		
		c2 = (Circle) findViewById(R.id.c2);
		
		if(user.getTue()==1)
			c2.setStatus(true);
		
		c3 = (Circle) findViewById(R.id.c3);
		
		if(user.getWed()==1)
			c3.setStatus(true);
		
		c4 = (Circle) findViewById(R.id.c4);
		
		if(user.getThu()==1)
			c4.setStatus(true);
		
		c5 = (Circle) findViewById(R.id.c5);
		
		if(user.getFri()==1)
			c5.setStatus(true);
			
			
		c6 = (Circle) findViewById(R.id.c6);
		
		if(user.getSat()==1)
			c6.setStatus(true);
		
		c7 = (Circle) findViewById(R.id.c7);
		
		
		if(user.getSun()==1)
			c7.setStatus(true);
		
		
		cb1 = (CircleButton) findViewById(R.id.cb1);
		
		if(user.getIssem()==1)
			cb1.setStatus(true);
		
		cb2 = (CircleButton) findViewById(R.id.cb2);
		
		if(user.getIsholiday()==1)
			cb2.setStatus(true);
		
		setonclik(c1,1);
		setonclik(c2,2);
		setonclik(c3,3);
		setonclik(c4,4);
		setonclik(c5,5);
		setonclik(c6,6);
		setonclik(c7,7);


		
		setonclik(cb1, 8);
		setonclik(cb2, 9);
		
		starthour = (TextView) findViewById(R.id.starthour);
		startminute = (TextView) findViewById(R.id.startminute);
		
		stahour = user.getStarthour();
		if(stahour<10)
			starthour.setText("0"+String.valueOf(stahour));
		else
			starthour.setText(String.valueOf(stahour));
		
		staminute = user.getStartminute();
		if(staminute<10)
		startminute.setText("0"+String.valueOf(staminute));
		else
			startminute.setText(String.valueOf(staminute));
		
		
		starttimehour = Integer.parseInt(starthour.getText().toString());
		starttimeminute = Integer.parseInt(startminute.getText().toString());
		

		
		stophour = (TextView) findViewById(R.id.stophour);
		stopminute = (TextView) findViewById(R.id.stopminute);
		
		stohour = user.getStophour();
		if(stohour<9)
			stophour.setText("0"+String.valueOf(stohour));
		else
			stophour.setText(String.valueOf(stohour));
		
		stominute = user.getStopminute();
		if(stominute<10)
			stopminute.setText("0"+String.valueOf(stominute));
		else
			stopminute.setText(String.valueOf(stominute));
		
		stoptimehour = Integer.parseInt(stophour.getText().toString());
		stoptimeminute = Integer.parseInt(stopminute.getText().toString());
		
		setitem = (TextView) findViewById(R.id.setitem);
		
		setitem.setText(user.getItem());
		
		addstarthour = (ImageView) findViewById(R.id.addstarthour);
		addStartHour(addstarthour);
		
		addstartminute = (ImageView) findViewById(R.id.addstartminute);
		addStartMinute(addstartminute);
		
		addstophour = (ImageView) findViewById(R.id.addstophour);
		addStopHour(addstophour);
		
		addstopminute = (ImageView) findViewById(R.id.addstopminute);
		addStopMinute(addstopminute);
		
		substarthour = (ImageView) findViewById(R.id.substarthour);
		subStartHour(substarthour);
		
		substartminute = (ImageView) findViewById(R.id.substartminute);
		subStartMinute(substartminute);
		
		substophour = (ImageView) findViewById(R.id.substophour);
		subStopHour(substophour);
		
		substopminute = (ImageView) findViewById(R.id.substopminute);
		subStopMinute(substopminute);
		
		biaoqian = (LinearLayout) findViewById(R.id.biaoqian);
		setDialog(biaoqian);
		
		save = (Button) findViewById(R.id.save);
		setsaveonclik(save);
		
		delete = (Button) findViewById(R.id.delete);
		setdeleteonclick(delete);

		
	}
	public void setsaveonclik(Button btn){
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				
				user.setStarthour(starttimehour);
				user.setStartminute(starttimeminute);
				user.setStophour(stoptimehour);
				user.setStopminute(stoptimeminute);
				user.setItem(setitem.getText().toString());
				user.setIssem(Boolean_Int(cb1));
				user.setIsholiday(Boolean_Int(cb2));
				user.setMon(Boolean_Int(c1));
				user.setTue(Boolean_Int(c2));
				user.setWed(Boolean_Int(c3));
				user.setThu(Boolean_Int(c4));
				user.setFri(Boolean_Int(c5));
				user.setSat(Boolean_Int(c6));
				user.setSun(Boolean_Int(c7));
				user.setId(map.get(id));
				
				
				mysqlite.modifyuser(user);
				finish();
			}
		});
	}
	public int Boolean_Int(Circle c){
		if(c.isStatus()==true)
			return 1;
		else
			return 0;
	}
	public int Boolean_Int(CircleButton cb){
		if(cb.isStatus()==true)
			return 1;
		else
			return 0;
	}
	public void setdeleteonclick(Button btn){
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				mysqlite.deleteUserByID(map.get(id));
				
				
				finish();
			}
		});
	}
	public void setonclik(Circle c,final int i){
		c.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Message message = new Message();
				message.what=i;
				handler.sendMessage(message);				
			}
		});
	}
	
	public void setonclik(CircleButton cb,final int i){
		cb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Message message = new Message();
				message.what=i;
				handler.sendMessage(message);				
			}
		});
	}
	public void addStartHour(ImageView iv){
		iv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				starttimehour++;
				if (starttimehour > 23) {
					starttimehour = 0;
					starthour.setText("0"+String.valueOf(starttimehour));
					}else if(starttimehour<10)
					{
					starthour.setText("0"+String.valueOf(starttimehour));
					}else
					starthour.setText(String.valueOf(starttimehour));
			}
		});
	}
	
	
	public void addStopHour(ImageView iv){
		iv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stoptimehour++;
				if (stoptimehour > 23) {
					stoptimehour = 0;
					stophour.setText("0"+String.valueOf(stoptimehour));
					}else if(stoptimehour<10)
					{
					stophour.setText("0"+String.valueOf(stoptimehour));
					}else
					stophour.setText(String.valueOf(stoptimehour));
			}
		});
	}
	
	
	public void addStartMinute(ImageView iv){
		iv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				starttimeminute++;
				if (starttimeminute > 59) {
					starttimeminute = 0;
					startminute.setText("0"+String.valueOf(starttimeminute));
					}else if(starttimeminute<10)
					{
					startminute.setText("0"+String.valueOf(starttimeminute));
					}else
					startminute.setText(String.valueOf(starttimeminute));
			}
		});
	}
	
	
	public void addStopMinute(ImageView iv){
		iv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stoptimeminute++;
				if (stoptimeminute > 59) {
					stoptimeminute = 0;
					stopminute.setText("0"+String.valueOf(stoptimeminute));
					}else if(stoptimeminute<10)
					{
					stopminute.setText("0"+String.valueOf(stoptimeminute));
					}else
					stopminute.setText(String.valueOf(stoptimeminute));
			}
		});
	}
	
	
	public void subStartHour(ImageView iv){
		iv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				starttimehour--;
				if (starttimehour < 0) {
					starttimehour = 23;
					starthour.setText(String.valueOf(starttimehour));
					}else if(starttimehour<10)
					{
					starthour.setText("0"+String.valueOf(starttimehour));
					}else
					starthour.setText(String.valueOf(starttimehour));
			}
		});
	}
	
	public void subStopHour(ImageView iv){
		iv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stoptimehour--;
				if (stoptimehour < 0) {
					stoptimehour = 23;
					stophour.setText(String.valueOf(stoptimehour));
					}else if(stoptimehour<10)
					{
					stophour.setText("0"+String.valueOf(stoptimehour));
					}else
					stophour.setText(String.valueOf(stoptimehour));
			}
		});
	}
	
	
	public void subStartMinute(ImageView iv){
		iv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				starttimeminute--;
				if (starttimeminute < 0) {
					starttimeminute = 59;
					startminute.setText(String.valueOf(starttimeminute));
					}else if(starttimeminute<10)
					{
					startminute.setText("0"+String.valueOf(starttimeminute));
					}else
					startminute.setText(String.valueOf(starttimeminute));
			}
		});
	}
	
	public void subStopMinute(ImageView iv){
		iv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stoptimeminute--;
				if (stoptimeminute < 0) {
					stoptimeminute = 59;
					stopminute.setText(String.valueOf(stoptimeminute));
					}else if(stoptimeminute<10)
					{
					stopminute.setText("0"+String.valueOf(stoptimeminute));
					}else
					stopminute.setText(String.valueOf(stoptimeminute));
			}
		});
	}
	
	public void setDialog(LinearLayout ll){
		ll.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(SetActivity.this);
				
				 final EditText et = new EditText(SetActivity.this);
				
				builder.setTitle("标签");
				builder.setView(et);
				builder.setPositiveButton("确定",new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
						setitem.setText(et.getText().toString());
					}
				});
				builder.setNegativeButton("取消", null);
				builder.setCancelable(false);
				builder.create().show();
			}
		});
	}
	
	public void change(Circle c){
		if(c.isStatus()==true)
			c.setStatus(false);
		else
			c.setStatus(true);
	}
	public void change(CircleButton cb){
		if(cb.isStatus()==true)
			cb.setStatus(false);
		else
			cb.setStatus(true);
	}
	Handler handler = new Handler(){
		public void handleMessage(Message msg){
			switch(msg.what){
			case 1:
				change(c1);
				break;
			case 2:
				change(c2);
				break;
			case 3:
				change(c3);
				break;
			case 4:
				change(c4);
				break;
			case 5:
				change(c5);
				break;
			case 6:
				change(c6);
				break;
			case 7:
				change(c7);
				break;
			case 8:
				change(cb1);
				break;
			case 9:
				change(cb2);
				break;
				
			}
			super.handleMessage(msg);
		}
	};
	
	
	
}
