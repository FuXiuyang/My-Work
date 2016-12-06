package ren.iming.model;
/**
 * 订单详情
 * @author xiuyang
 */
import java.util.Date;

public class Deal {
	private int id;
	private Date deal_time;
	private double sum;
	private String user_account;
	private String vip_account;
	private String vip_password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDeal_time() {
		return deal_time;
	}
	public void setDeal_time(Date deal_time) {
		this.deal_time = deal_time;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public String getVip_account() {
		return vip_account;
	}
	public void setVip_account(String vip_account) {
		this.vip_account = vip_account;
	}
	public String getVip_password() {
		return vip_password;
	}
	public void setVip_password(String vip_password) {
		this.vip_password = vip_password;
	}
}
