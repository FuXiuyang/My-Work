package ren.iming.action.login;
/**
 * 用户登陆,登出时对相应的事件进行相应
 * @author xiuyang
 * @version 1.0 2016年11月15日 15:07:23
 */
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.CookiesAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ren.iming.model.Token;
import ren.iming.model.User;
import ren.iming.service.TokenService;
import ren.iming.service.UserService;
import ren.iming.service.UserServiceFactory;
import sun.misc.BASE64Encoder;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements CookiesAware{
	private String account;
	private String password;
	private String token;
	private Token userToken;
	private Map<String,String> cookiesMap;
	private TokenService tokenService;
	private ApplicationContext context;
	
	public LoginAction(){
		context = new ClassPathXmlApplicationContext("bean.xml");
	}
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
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	public Token getUserToken() {
		return userToken;
	}
	public void setUserToken(Token token) {
		this.userToken = userToken;
	}
	
	public TokenService getTokenService() {
		return tokenService;
	}
	public void setTokenService(TokenService tokenService) {
		this.tokenService = tokenService;
	}
	@Override
	public void setCookiesMap(Map<String, String> arg0) {
		// TODO 自动生成的方法存根
		this.cookiesMap = arg0;
	}

	/**
	 * 用户点击登陆时,服务器进行账号密码验证,都正确时,将用户账号进行md5加密后写入session中
	 * @return 如果账号密码正确,则返回success,否则返回error
	 * @throws Exception
	 */
	public String login() throws Exception{
		if(!checkInfo())
			return ERROR;
		if(!hasUser())
			return ERROR;
		setToken();
		ActionContext.getContext().getSession().put("tt",token);
//		setCookie("account",account);
		return SUCCESS;
	}
	/**
	 * 检测用户登陆时输入的信息
	 * @return
	 */
	public boolean checkInfo(){
		if(account.length() != 11 || password.length() < 8 || password.length() > 15)
			return false;
		return true;
	}
	/**
	 * 将Token设置到内存中
	 */
	public void setToken(){
		Token userToken = (Token) context.getBean("token");
		TokenService tokenService = (TokenService) context.getBean("tokenService");
		userToken = new Token();
		userToken.setToken(token);
		userToken.setAccount(account);
		tokenService = new TokenService();
		tokenService.setToken(userToken);
	}
	/**
	 * 实现向客户端写入cookie的值
	 * @param name
	 * @param value
	 */
	public void setCookie(String name,String value){
		HttpServletResponse response = ServletActionContext.getResponse();
		Cookie cookie =  new Cookie(name,value);
		cookie.setMaxAge(30000); //设置cookie有效期
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	/**
	 * 进行数据库查找,查看用户名和账号是否匹配
	 * @return 如果数据库中有该账号信息,并且与密码匹配则返回true,否则返回false
	 */
	public boolean hasUser(){
		UserServiceFactory userServiceFactory = (UserServiceFactory) context.getBean("userServiceFactory");
		UserService userService = userServiceFactory.getUserService();
		try{
			User user = userService.getFromDB(account);
			if(user != null && password.equals(user.getPassword()))
				return true;
		}catch(Exception e){
			System.out.println("登陆账户时,判断账户是否存在时,出现错误"+e);
			return false;
		}finally{
			userServiceFactory.setUserService(userService);
		}
		return false;
		
		
	}
	 /**利用MD5进行加密
     * @param str  待加密的字符串
     * @return  加密后的字符串
     * @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
     * @throws UnsupportedEncodingException  
     */
    public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        return base64en.encode(md5.digest(str.getBytes("utf-8")));
    }
	/**
	 * 用户点击注销时,从session中移除该用户账号信息
	 * @return 移除成功返回success
	 * @throws Exception
	 */
	public String logout() throws Exception {  
	    /*Map session = ActionContext.getContext().getSession();  
	    session.remove("username");  */
		ActionContext.getContext().getSession().remove("tt");
	    return SUCCESS;  
	}


}
