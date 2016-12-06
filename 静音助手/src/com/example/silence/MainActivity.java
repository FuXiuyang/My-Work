package com.example.silence;

import com.example.center.SilenceService;
import com.example.circlebutton.MyAdapeter;
import com.example.circlebutton.User;
import com.example.circlebutton.UserMySqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
public class MainActivity extends Activity {
	

	private	int stahour,staminute,stohour,stominute;
	
	private String st;
	
	private ListView lvtime;
	
	private MyAdapeter myadapter;
	
	
	private UserMySqlite mysqlite;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test3);
		myadapter = new MyAdapeter(this);
		
		lvtime = (ListView) findViewById(R.id.lvtime);
		
		lvtime.setAdapter(myadapter);
		
		setListener(lvtime);
		
		startService();
		
	}
	
	public void init(){					//点击添加按钮时，对数据进行添加新内容操作
		
		User user = new User();
		
		user.setIsopen(0);
		user.setIssem(0);
		user.setIsholiday(0);
		user.setMon(0);
		user.setTue(0);
		user.setWed(0);
		user.setThu(0);
		user.setFri(0);
		user.setSat(0);
		user.setSun(0);
		user.setStarthour(stahour);
		user.setStartminute(staminute);
		user.setStophour(stohour);
		user.setStopminute(stominute);
		user.setItem(st);
		mysqlite = new UserMySqlite(MainActivity.this);
		mysqlite.saveUser(user);
		
		
	}
	
	protected void onStart() {					//重新进入mainactivity时，对其进行刷新操作
		// TODO Auto-generated method stub
		myadapter.notifyDataSetChanged();
		startService();
		super.onStart();
	}
	
	public void startService(){				//开始服务
		
		Intent intent = new Intent(this,SilenceService.class);

		startService(intent);
		
		
		
		
	}
	
	public void addPro(View v){				//添加按钮监听
		init();
		myadapter.notifyDataSetChanged();
	}
	
	public void setListener(ListView lv){		//listview单个项目的监听
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long arg3) {
				// TODO Auto-generated method stub
				int id = position;		
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, SetActivity.class);
				intent.putExtra("id", id);
				startActivity(intent);
			}
		});
	}


}
