package ren.iming.action.work;
/**
 * 监控用户购买行为
 * @author xiuyang
 */

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ren.iming.model.Deal;
import ren.iming.model.Token;
import ren.iming.model.VIP;
import ren.iming.service.DealService;
import ren.iming.service.DealServiceFactory;
import ren.iming.service.IQiYiVIPQueue;
import ren.iming.service.TimeQueue;
import ren.iming.service.TokenService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BuyAction extends ActionSupport {
	final static String LOGIN = "login"; 
	private String webName;
	private String timeLong;
	private ApplicationContext context;
	
	public BuyAction(){
		
	}
	public String getWebName() {
		return webName;
	}

	public void setWebName(String webName) {
		this.webName = webName;
	}
	public String getTimeLong() {
		return timeLong;
	}

	public void setTimeLong(String timeLong) {
		this.timeLong = timeLong;
	}
	/**
	 * 如果用户选择项没有确实,则返回success,否则返回error
	 */
	@Override
	public String execute() throws Exception {
		context = new ClassPathXmlApplicationContext("bean.xml");
		// TODO 自动生成的方法存根
		if(!ActionContext.getContext().getSession().containsKey("tt"))
			return LOGIN;
		if(webName != null && timeLong != null){
			//日后加上支付功能时,去掉
			if(!setIQiYiVIP2Request())
				return ERROR;
			return SUCCESS;
		}
		return ERROR;
	}
	/**
	 * 设置爱奇艺会员给用户
	 * @return
	 */
	public boolean setIQiYiVIP2Request(){
		VIP vip = null;
		
		IQiYiVIPQueue iQueue = (IQiYiVIPQueue) context.getBean("iQiYiVIPQueue");
		if(iQueue.size() > 0){
			vip = iQueue.getVIP();
			ActionContext.getContext().put("vip_account", vip.getAccount());
			ActionContext.getContext().put("vip_password", vip.getPassword());
			TimeQueue timeQueue = (TimeQueue) context.getBean("timeQueue");
			try {
				//以后希望将这些参数放到spring里,让spring去管控,看到我时记得改啊!
				timeQueue.insert(vip.getAccount(), System.currentTimeMillis()+36000*Integer.parseInt(timeLong));
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				System.err.println("在Action中将爱奇艺VIP放入进时间列里出现的错误"+e);
				iQueue.setVIP(vip);
				return false;
			}
			save2Deal(vip.getAccount(), vip.getPassword());
			return true;
		}
		return false;
	}
	/**
	 * 将用户订单详情存储到数据库中
	 * @param vip_account
	 * @param vip_password
	 */
	public boolean save2Deal(String vip_account,String vip_password){
		DealServiceFactory dealServiceFactory = (DealServiceFactory) context.getBean("dealServiceFactory");
		DealService dealService = dealServiceFactory.getDealService();
		Deal deal = (Deal) context.getBean("deal");
//		double sum = Double.parseDouble(timeLong.substring(0, 1));
		TokenService tokenService = (TokenService) context.getBean("tokenService");
		Token token = tokenService.getToken(ActionContext.getContext().getSession().get("tt").toString());
		int sum = Integer.parseInt(timeLong);
		if(0 < sum && sum <= 12){
			deal.setDeal_time(new Date());
			deal.setSum(0.1*sum);
			deal.setUser_account(token.getAccount());
			deal.setVip_account(vip_account);
			deal.setVip_password(vip_password);
			dealService.save2DB(deal);
			dealServiceFactory.setDealService(dealService);
			return true;
		}
		return false;
	}
}
