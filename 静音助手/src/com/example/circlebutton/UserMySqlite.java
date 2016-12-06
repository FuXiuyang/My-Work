package com.example.circlebutton;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserMySqlite {					//数据库操作类
	MySqliteHelper mysqlite;
	SQLiteDatabase db;
	
	public UserMySqlite(Context context){
		mysqlite = new MySqliteHelper(context);
	}


	public void saveUser(User user){		//数据库保存
		System.out.println("保存了");
		String sql = "insert into users(starthour,startminute,stophour," +
				" stopminute,item,isopen,issem,isholiday,mon,tue,wed,thu,fri,sat,sun)" +
				" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		db = mysqlite.getWritableDatabase();
		db.execSQL(sql, new Object[]{user.getStarthour(),user.getStartminute(),user.getStophour(),
									user.getStopminute(),user.getItem(),user.getIsopen(),user.getIssem(),
									user.getIsholiday(),user.getMon(),user.getTue(),user.getWed(),user.getThu(),
									user.getFri(),user.getSat(),user.getSun()});
//		db.close();
	}
	public List<User> findAllUsers(){			//	数据库查找
		System.out.println("查找了");
		String sql = "select id,starthour,startminute,stophour,stopminute," +
				" item,isopen,issem,isholiday,mon,tue,wed,thu,fri,sat,sun from users";
		Cursor cursor = mysqlite.getReadableDatabase().rawQuery(sql, null);
		List<User> users = new ArrayList<User>();
		User user = null;
		while(cursor.moveToNext()){
			user = new	User();
			user.setId(cursor.getInt(cursor.getColumnIndex("id")));
			user.setStarthour(cursor.getInt(cursor.getColumnIndex("starthour")));
			user.setStartminute(cursor.getInt(cursor.getColumnIndex("startminute")));
			user.setStophour(cursor.getInt(cursor.getColumnIndex("stophour")));
			user.setStopminute(cursor.getInt(cursor.getColumnIndex("stopminute")));
			user.setItem(cursor.getString(cursor.getColumnIndex("item")));
			user.setIsopen(cursor.getInt(cursor.getColumnIndex("isopen")));
			user.setIssem(cursor.getInt(cursor.getColumnIndex("issem")));
			user.setIsholiday(cursor.getInt(cursor.getColumnIndex("isholiday")));
			user.setMon(cursor.getInt(cursor.getColumnIndex("mon")));
			user.setTue(cursor.getInt(cursor.getColumnIndex("tue")));
			user.setWed(cursor.getInt(cursor.getColumnIndex("wed")));
			user.setThu(cursor.getInt(cursor.getColumnIndex("thu")));
			user.setFri(cursor.getInt(cursor.getColumnIndex("fri")));
			user.setSat(cursor.getInt(cursor.getColumnIndex("sat")));
			user.setSun(cursor.getInt(cursor.getColumnIndex("sun")));
			users.add(user);
		
			
		}
		cursor.close();
	
		return users;
		
	}
	public void modifyuser(User user){					//数据库内容更改
		System.out.println("更改了");
		String sql = "update users set starthour=?,startminute=?,stophour=?," +
				" stopminute=?,item=?,isopen=?,issem=?,isholiday=?,mon=?,tue=?,wed=?,thu=?,fri=?,sat=?,sun=? where id=?" ;
		db = mysqlite.getWritableDatabase();
		db.execSQL(sql, new Object[]{user.getStarthour(),user.getStartminute(),user.getStophour(),
									user.getStopminute(),user.getItem(),user.getIsopen(),user.getIssem(),
									user.getIsholiday(),user.getMon(),user.getTue(),user.getWed(),user.getThu(),
									user.getFri(),user.getSat(),user.getSun(),user.getId()});
//		db.close();
	}
	public void deleteUserByID(int id){				//数据库内容删除
		System.out.println("删除了");
		String sql = "delete from users where id=?";
		db = mysqlite.getWritableDatabase();
		db.execSQL(sql, new Object[]{id});
//		db.close();
	}
}
