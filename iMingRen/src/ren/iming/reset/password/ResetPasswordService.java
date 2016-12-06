package ren.iming.reset.password;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ren.iming.DAO.EVIPAccountDAO;
import ren.iming.model.EVIPAccount;
import ren.iming.model.IQiYiVIP;
import ren.iming.model.VIPInfo;
import ren.iming.service.IQiYiVIPService;
import ren.iming.service.IQiYiVIPServiceFactory;
import ren.iming.service.VIPInfoService;
import ren.iming.service.VIPInfoServiceFactory;

public class ResetPasswordService implements Runnable{
	private HttpRequest request;
	private AutoWeb autoWeb;
	private CheckMail mail;
	private Password newPassword;
	private String eAccount;
	private String ePassword;
	private String vipAccount;
	private String senderAddress;
	private String pattern;
	private long sleepTime;
	private ApplicationContext context;
	
	public ResetPasswordService(){}
	public ResetPasswordService(String vipAccount) throws MessagingException{
		this();
		init(vipAccount);
	}
	/**
	 * 初始化,从数据库中获取找回VIP账号时所需的邮箱账号和密码
	 * @param vipAccount
	 * @throws MessagingException 
	 */
	public void init(String vipAccount) throws MessagingException{
		context = new ClassPathXmlApplicationContext("bean.xml");
		this.vipAccount = vipAccount;
		VIPInfoServiceFactory vipInfoServiceFactory = (VIPInfoServiceFactory) context.getBean("vipInfoServiceFactory");
		VIPInfoService vipInfoService = vipInfoServiceFactory.getVIPInfoService();
		VIPInfo vipInfo = vipInfoService.getFromDB(vipAccount);
		this.eAccount = vipInfo.geteMail();
		this.ePassword = vipInfo.getePassword();
		vipInfoServiceFactory.setVIPInfoService(vipInfoService);
		try {
			mail = new CheckMail(eAccount, ePassword);
			Message[] messages = mail.receive();
			mail.deleteMail(messages);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			mail.close();
		}
	}
	
	public HttpRequest getRequest() {
		return request;
	}
	public void setRequest(HttpRequest request) {
		this.request = request;
	}
	public AutoWeb getAutoWeb() {
		return autoWeb;
	}
	public void setAutoWeb(AutoWeb autoWeb) {
		this.autoWeb = autoWeb;
	}
	public Password getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(Password newPassword) {
		this.newPassword = newPassword;
	}
	public String getSenderAddress() {
		return senderAddress;
	}
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public long getSleepTime() {
		return sleepTime;
	}
	public void setSleepTime(long sleepTime) {
		this.sleepTime = sleepTime;
	}
	/**
	 * 向爱奇艺发出更改密码的申请
	 */
	public void sendMail(){
		String str = request.sendGet(eAccount);
		System.out.println(str);
	}
	/**
	 * 获取修改地址的url
	 * @return 如果找到就返回该url
	 * @throws Exception
	 */
	public String getUrl() throws Exception{
		String url = null;
//		String senderAddress = "no-reply@qiyi.com";
		Message[] messages = mail.receive();
		for(int i = 0; i < mail.size(); i ++){
			//邮件未查看，且发件人地址是no-reply@qiyi.com，才表示是爱奇艺发的修改密码账号
			if(!mail.isSeen((MimeMessage) messages[i]) 
				&& senderAddress.equals(mail.getAddress((MimeMessage) messages[i]))){
				StringBuffer content = new StringBuffer(30); 
	            mail.getMailTextContent(messages[i], content);
//	            String pattern = "http://passport.iqiyi.com/pages/secure/account/verfiy_email.action[^\"]+";
	            // 创建 Pattern 对象
	            System.out.println(pattern);
	            Pattern r = Pattern.compile(pattern);
	            // 现在创建 matcher 对象
	            Matcher m = r.matcher(content);
	            if (m.find()) {
	                System.out.println(m.group(0));
	                url = m.group(0);
	                break;
	             } 
			}
		}
		return url;
	}
	/**
	 * 将更改完密码的会员存储到数据库中,并且把他同步到对列中
	 * @param resetPassword 修改后的密码
	 */
	public void saveVIP2DBAndQueue(String resetPassword){
		IQiYiVIPServiceFactory iQiYiVIPServiceFactory = (IQiYiVIPServiceFactory) context.getBean("iQiYiVIPServiceFactory");
		IQiYiVIPService iQiYiVIPService = (IQiYiVIPService) iQiYiVIPServiceFactory.getIQiYiVIPService();
		IQiYiVIP iQiYiVip = (IQiYiVIP) iQiYiVIPService.getVipFromDB(vipAccount);
		iQiYiVip.setPassword(resetPassword);
		iQiYiVIPService.setVip2DB(iQiYiVip);
		iQiYiVIPService.setVip2Queue(iQiYiVip);
		iQiYiVIPServiceFactory.setIQiYiVIPService(iQiYiVIPService);
	}
	/**
	 * 将更改密码出现异常的账号存放到异常账号数据库中
	 */
	public void saveEVIP2DB(){
		EVIPAccount eVIP = (EVIPAccount) context.getBean("eVIPAccount");
		eVIP.setAccount(vipAccount);
		EVIPAccountDAO eVIPDao = (EVIPAccountDAO) context.getBean("eVIPAccountDAO");
		eVIPDao.saveOrUpdateEVIPAccount(eVIP);
	}
	public void resetPassword() throws Exception{
		try{
			sendMail();
			Thread.sleep(sleepTime);
			mail = new CheckMail(eAccount, ePassword);
			autoWeb.setUrl(getUrl());
			String resetPassword = newPassword.getPassword();
			autoWeb.resetPassword(resetPassword);
			saveVIP2DBAndQueue(resetPassword);
			
		}catch(Exception e){
			System.err.println("爱奇艺会员"+vipAccount+"修改密码时发生了异常"+e);
			try{
				saveEVIP2DB();
			}catch(Exception ee){
				System.err.println("修改密码出现异常的爱奇艺会员"+vipAccount+"保存到数据库中也发生了异常"+ee);
			}
		}finally{
			mail.close();
//			autoWeb.close();
		}
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try {
			resetPassword();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
