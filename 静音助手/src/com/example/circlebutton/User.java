package com.example.circlebutton;

public class User {		//数据库一个单元操作的类
	private Integer id;
	private Integer starthour,startminute,stophour,stopminute;
	private Integer mon,tue,wed,thu,fri,sat,sun;
	private Integer isopen,issem,isholiday;
	private String item;
	public Integer getId() {
		return id;
	}
	public Integer getStarthour() {
		return starthour;
	}
	public void setStarthour(Integer starthour) {
		this.starthour = starthour;
	}
	public Integer getStartminute() {
		return startminute;
	}
	public void setStartminute(Integer startminute) {
		this.startminute = startminute;
	}
	public Integer getStophour() {
		return stophour;
	}
	public void setStophour(Integer stophour) {
		this.stophour = stophour;
	}
	public Integer getStopminute() {
		return stopminute;
	}
	public void setStopminute(Integer stopminute) {
		this.stopminute = stopminute;
	}
	public Integer getMon() {
		return mon;
	}
	public void setMon(Integer mon) {
		this.mon = mon;
	}
	public Integer getTue() {
		return tue;
	}
	public void setTue(Integer tue) {
		this.tue = tue;
	}
	public Integer getWed() {
		return wed;
	}
	public void setWed(Integer wed) {
		this.wed = wed;
	}
	public Integer getThu() {
		return thu;
	}
	public void setThu(Integer thu) {
		this.thu = thu;
	}
	public Integer getFri() {
		return fri;
	}
	public void setFri(Integer fri) {
		this.fri = fri;
	}
	public Integer getSat() {
		return sat;
	}
	public void setSat(Integer sat) {
		this.sat = sat;
	}
	public Integer getSun() {
		return sun;
	}
	public void setSun(Integer sun) {
		this.sun = sun;
	}
	public Integer getIsopen() {
		return isopen;
	}
	public void setIsopen(Integer isopen) {
		this.isopen = isopen;
	}
	public Integer getIssem() {
		return issem;
	}
	public void setIssem(Integer issem) {
		this.issem = issem;
	}
	public Integer getIsholiday() {
		return isholiday;
	}
	public void setIsholiday(Integer isholiday) {
		this.isholiday = isholiday;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User(Integer id, Integer starthour, Integer startminute,
			Integer stophour, Integer stopminute, Integer mon, Integer tue,
			Integer wed, Integer thu, Integer fri, Integer sat, Integer sun,
			Integer isopen, Integer issem, Integer isholiday, String item) {
		super();
		this.id = id;
		this.starthour = starthour;
		this.startminute = startminute;
		this.stophour = stophour;
		this.stopminute = stopminute;
		this.mon = mon;
		this.tue = tue;
		this.wed = wed;
		this.thu = thu;
		this.fri = fri;
		this.sat = sat;
		this.sun = sun;
		this.isopen = isopen;
		this.issem = issem;
		this.isholiday = isholiday;
		this.item = item;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
