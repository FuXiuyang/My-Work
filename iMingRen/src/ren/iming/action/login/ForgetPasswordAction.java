package ren.iming.action.login;
/**
 * 用来处理用户找回密码的行为
 * @author xiuyang
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ren.iming.model.User;
import ren.iming.service.UserService;
import ren.iming.service.UserServiceFactory;

import com.opensymphony.xwork2.ActionSupport;

public class ForgetPasswordAction extends ActionSupport {
	private String account;
	private String identifyingCode;
	private String password1;
	private String password2;
	private String msg = null;
	private boolean flag = false;
	private ApplicationContext context;
	public ForgetPasswordAction(){
		context = new ClassPathXmlApplicationContext("bean.xml");
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getIdentifyingCode() {
		return identifyingCode;
	}
	public void setIdentifyingCode(String identifyingCode) {
		this.identifyingCode = identifyingCode;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * 发送验证码
	 * @return 如果成功发送验证码,则返回success,否则返回error
	 */
	public String sendIdentifyingCode(){
		if(account == null || !hasUser() || sendMsg() != null)
			return ERROR;
		return SUCCESS;
	}
	/**
	 * 找回密码第一步,验证手机号和密码
	 * @return 如果手机号和密码匹配,则返回success,否则返回error
	 */
	public String firstStep(){
		/*if(account == null || identifyingCode == null)
			return ERROR;
		if(!flag || msg == null)
			return ERROR;*/
		return SUCCESS;
		
	}
	/**
	 * 判断是否有该用户
	 * @return 如果有返回true,并且标志位flag设置为true,否则返回false,
	 */
	public boolean hasUser(){
		UserServiceFactory userServiceFactory = (UserServiceFactory) context.getBean("userServiceFactory");
		UserService userService = userServiceFactory.getUserService();
		User user = userService.getFromDB(account);
		if(user == null)
			flag=false;
		else
			flag=true;
		return flag;
	}
	/**
	 * 发送短信方法,是通过该方法,向用户手机号发送短信
	 * @return 如果发送成功,则返回该验证码,并且将验证码保存,否则返回null
	 */
	public String sendMsg(){
		//向手机发短信
		msg=null;
		return msg;
	}
}
