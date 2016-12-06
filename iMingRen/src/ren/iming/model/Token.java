package ren.iming.model;
/**
 * 设置token加密,使用户更加安全的登陆
 * @author xiuyang
 * @version 2016年11月26日 22:41:11
 */
public class Token {
	/**
	 * 先加这两个属性,如果以后还需要,后期再加
	 */
	private String token;
	//account是用户名
	private String account;
	
	public Token(){}
	public Token(String token,String account){
		this.token = token;
		this.account = account;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
}
