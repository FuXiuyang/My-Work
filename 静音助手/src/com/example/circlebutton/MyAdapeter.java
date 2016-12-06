package com.example.circlebutton;



import java.util.List;

import com.example.silence.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapeter extends BaseAdapter {
	private Context context;
	
	
	private int i=0;
	
	
	private List<User> users;
	
	private UserMySqlite mysqlite;
	
	
	
	public MyAdapeter(Context context){
		this.context = context;
		mysqlite = new UserMySqlite(context);

	}
	public int getCount() {
		// TODO Auto-generated method stub
		users = mysqlite.findAllUsers();	
		return users.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	public class ViewHolder{
		public CircleButton cb;
		public TextView starthour;
		public TextView startminute;
		public TextView stophour;
		public TextView stopminute;
		public TextView item;
	}

	@Override
	public View getView( int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder vholder = null;
		if(convertView==null){
			vholder = new ViewHolder();
			
			convertView = View.inflate(context, R.layout.text, null);
			
			vholder.starthour = (TextView) convertView.findViewById(R.id.starttimehour);
			vholder.startminute = (TextView) convertView.findViewById(R.id.starttimeminute);
			vholder.stophour = (TextView) convertView.findViewById(R.id.stoptimehour);
			vholder.stopminute = (TextView) convertView.findViewById(R.id.stoptimeminute);
			vholder.item = (TextView) convertView.findViewById(R.id.item);
			vholder.cb = (CircleButton) convertView.findViewById(R.id.cb);
			vholder.cb.setTag(position);
			vholder.cb.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					CircleButton cb = (CircleButton) v;
					i = (Integer) cb.getTag();
					UserMySqlite mysqlite = new UserMySqlite(context);
					User user = users.get(i);
					if(cb.isStatus()==false){
						user.setIsopen(1);
						mysqlite.modifyuser(user);
						cb.setStatus(true);
					}					
					else {
						user.setIsopen(0);
						mysqlite.modifyuser(user);
//						map.put(i,false);
						cb.setStatus(false);
					}
				
				}
			});
			convertView.setTag(vholder);
		}else{
			vholder = (ViewHolder) convertView.getTag();
		}
		User user = users.get(position);
		if(user.getStarthour()<10)
			vholder.starthour.setText("0"+String.valueOf(user.getStarthour()));
		else
			vholder.starthour.setText(String.valueOf(user.getStarthour()));
		if(user.getStartminute()<10)
			vholder.startminute.setText("0"+String.valueOf(user.getStartminute()));
		else
			vholder.startminute.setText(String.valueOf(user.getStartminute()));
		
		if(user.getStophour()<10)
			vholder.stophour.setText("0"+String.valueOf(user.getStophour()));
		else
			vholder.stophour.setText(String.valueOf(user.getStophour()));
		if(user.getStopminute()<10)
			vholder.stopminute.setText("0"+String.valueOf(String.valueOf(user.getStopminute())));
		else
			vholder.stopminute.setText(String.valueOf(String.valueOf(user.getStopminute())));
		vholder.item.setText(user.getItem());
		
		vholder.cb.setTag(position);
		vholder.cb.setStatus(Int_Boolean(user.getIsopen()));
		return convertView;
	}
	public boolean Int_Boolean(int i){
		if(i==0){
			return false;
		}else{
			return true;
		}
	}


			

}
