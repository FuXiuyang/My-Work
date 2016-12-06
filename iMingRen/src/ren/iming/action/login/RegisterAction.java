package ren.iming.action.login;
/**
 * 监听,实现用户注册
 * @author xiuyang
 * @version 1.0 2016年11月15日 15:08:48
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ren.iming.model.User;
import ren.iming.service.UserService;
import ren.iming.service.UserServiceFactory;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
	final static long TIME_LONG = 200000;
	private String account;
	private String password1;
	private String password2;
	private ApplicationContext context;
	private String mail;
	
	public RegisterAction(){
		context = new ClassPathXmlApplicationContext("bean.xml");
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * 该方法是在register_struts.xml中调用的方法,实现用户注册
	 * @return 如果用户填写的信息符合要求,并且将用户的信息写入到了数据中,则返回success,表示用户注册成功,否则失败.
	 * @throws Exception
	 */
	public String register() throws Exception{
		if(checkInfo())
			return ERROR;
		if(saveUser(account,password1))
			return SUCCESS;
		else
			return ERROR;
	}
	/**
	 * 检查用户输入信息
	 * @return 如果用户输入信息符合要求返回true,否则返回false
	 */
	public boolean checkInfo(){
		if(account.length() != 11
			|| password1.length() < 8 
			|| password1.length() > 15
			|| !password1.equals(password2)
			)
			return false;
		return true;
	}
	/**
	 * 将新注册用的信息放到内存中和数据库中
	 * @param account
	 * @param password
	 * @return
	 */
	public boolean saveUser(String account,String password){
		UserServiceFactory userServiceFactory = null;
		UserService userService = null;
		// 以下是初始化操作
		try{
			userServiceFactory = (UserServiceFactory) context.getBean("userServiceFactory");
			userService = userServiceFactory.getUserService();
			User user = (User) context.getBean("user");
			user.setAccount(account);
			user.setPassword(password);
			user.setiQiYiTime(TIME_LONG );
			user.setXunLeiTime(TIME_LONG );
			user.setHoldIQiYi(false);
			user.setHoldXunLei(false);		
//			userService.save2Map(user);
			userService.save2DB(user);
			return true;
		}catch(Exception e){
			System.out.println("注册时存入到数据中的信息丢失,没有存储进去."+e);
			return false;
		}finally{
			//无论怎样,结束时,一定要把UserService对象返还给UserserviceFactory工厂
			userServiceFactory.setUserService(userService);
		}
		
		
	}

	public String execute() throws Exception{
		if(checkInfo())
			return ERROR;
		return SUCCESS;
	}
}
