package ren.iming.model;
/*
 * @date : 2016年10月29日 17:58:31
 * @author : xiuyang
 * @function : 用户的模型,里面封装了用户的各种属性和和属性的get和set方法
 */

public class User {
	private String account;
	private String password;
	private long iQiYiTime;
	private long xunLeiTime;
	private boolean holdIQiYi;
	private boolean holdXunLei;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getiQiYiTime() {
		return iQiYiTime;
	}
	public void setiQiYiTime(long iQiYiTime) {
		this.iQiYiTime = iQiYiTime;
	}
	public long getXunLeiTime() {
		return xunLeiTime;
	}
	public void setXunLeiTime(long xunLeiTime) {
		this.xunLeiTime = xunLeiTime;
	}
	public boolean isHoldIQiYi() {
		return holdIQiYi;
	}
	public void setHoldIQiYi(boolean holdIQiYi) {
		this.holdIQiYi = holdIQiYi;
	}
	public boolean isHoldXunLei() {
		return holdXunLei;
	}
	public void setHoldXunLei(boolean holdXunLei) {
		this.holdXunLei = holdXunLei;
	}
	
}
