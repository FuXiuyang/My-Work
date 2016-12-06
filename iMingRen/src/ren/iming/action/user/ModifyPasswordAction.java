package ren.iming.action.user;
/**
 * 修改密码
 * @author xiuyang
 * @version 1.0 2016年11月29日 15:46:58
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ren.iming.model.Token;
import ren.iming.model.User;
import ren.iming.service.TokenService;
import ren.iming.service.UserService;
import ren.iming.service.UserServiceFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyPasswordAction extends ActionSupport {
	private String password;
	private String password1;
	private String password2;
	private ApplicationContext context;
	
	public ModifyPasswordAction(){
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	/**
	 * 设置密码
	 * @return
	 */
	public String setPassword(){
		context = new ClassPathXmlApplicationContext("bean.xml");
		if(checkInfo()){
			String tokenStr = ActionContext.getContext().getSession().get("tt").toString();
			TokenService tokenService = (TokenService) context.getBean("tokenService");
			Token token = tokenService.getToken(tokenStr);
			User user = getUser(token.getAccount());
			if(user != null && password.equals(user.getPassword())){
				user.setPassword(password1);
				if(saveUser(user))
					return SUCCESS;
			}
		}
		return ERROR;		
	}
	/**
	 * 检查用户输入信息是否合规
	 * @return
	 */
	public boolean checkInfo(){
		if(
			password.length() >= 8 && password.length() <= 15
			&& password1.length() >= 8 && password1.length() <= 15
			&& password1.equals(password2)
			&& ActionContext.getContext().getSession().get("tt") != null
		){
			return true;
		}
		return false;
	}
	/**
	 * 获取用户
	 * @param account
	 * @return
	 */
	public User getUser(String account){
		UserServiceFactory userServiceFactory = (UserServiceFactory) context.getBean("userServiceFactory");
		UserService userService = userServiceFactory.getUserService();
		try{
			User user = userService.getFromDB(account);
			return user;
		}catch(Exception e){
			System.out.println("更改密码的Action出现了错误"+e);
			return null;
		}finally{
			userServiceFactory.setUserService(userService);
		}
		
	}
	/**
	 * 查找数据库中是否有该用户
	 * @param user
	 * @return
	 */
	public boolean saveUser(User user){
		UserServiceFactory userServiceFactory = (UserServiceFactory) context.getBean("userServiceFactory");
		UserService userService = userServiceFactory.getUserService();
		try{
			userService.save2DB(user);	
		}catch(Exception e){
			System.out.println("用户更改密码时出现差错"+e);
			return false;
		}finally{
			userServiceFactory.setUserService(userService);
		}
		return true;
		
	}
}
