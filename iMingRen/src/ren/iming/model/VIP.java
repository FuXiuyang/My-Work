package ren.iming.model;
/*
 * @Date : 2016年10月29日 18:01:09
 * @author : xiuyang
 * @function : 里面封装了VIP账号所具有的一些属性和这些属性的set和个体方法 
 */

import java.util.Date;

public class VIP {
	private String account;
	private String password;
	private Date endDate;
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
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
