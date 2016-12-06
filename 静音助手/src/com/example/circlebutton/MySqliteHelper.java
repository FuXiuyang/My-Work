package com.example.circlebutton;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqliteHelper extends SQLiteOpenHelper {

	public MySqliteHelper(Context context) {
		super(context, "myslient.db", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {			//数据库的创建
		// TODO Auto-generated method stub
		String sql = "create table users(id integer primary key autoincrement,starthour integer,startminute integer,"
				+" stophour integer,stopminute integer,mon integer,tue integer,wed integer,thu integer,fri integer," +
				" sat integer,sun integer,isopen integer,issem integer,isholiday integer,item text)";
		db.execSQL(sql);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
