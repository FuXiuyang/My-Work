package ren.iming.service;
/**
 * 创建一个工厂类,用他去组装一个服务应该声明的类,我们只需要调用工厂类,从中获取我们想要的对象就可以了,
 * 并且这个工厂类还提供了缓存技术,使运行效率更快
 * @author xiuyang
 * @version 1.0 2016年11月19日 14:59:59
 */
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ren.iming.DAO.IQiYiVIPDAO;


public class IQiYiVIPServiceFactory {
	private CookieNum iQiYiVIPServiceNum;
	private ApplicationContext context;
	private static ConcurrentLinkedQueue<IQiYiVIPService> vipServiceList;
	private static IQiYiVIPServiceFactory instance = new IQiYiVIPServiceFactory();
	/**
	 * 初始化IQiYiVIPServiceFactory工厂,将SERVICE_NUM个(即15个)IQiYiVIPService放入到工厂内
	 */
	private IQiYiVIPServiceFactory(){
		vipServiceList = new ConcurrentLinkedQueue<IQiYiVIPService>();
		context = new ClassPathXmlApplicationContext("bean.xml");
		iQiYiVIPServiceNum = (CookieNum) context.getBean("iQiYiVIPServiceNum");
		for(int i = 0; i < iQiYiVIPServiceNum.getNum(); i ++){
			vipServiceList.offer(new IQiYiVIPService(new IQiYiVIPDAO()));
		}
	}
	/**
	 * 获取单例模式下的IQiYiVIPServiceFactory的实例
	 * @return
	 */
	public static IQiYiVIPServiceFactory getInstance(){
		return instance;
	}
	/**
	 * 获取IQiYiVIPService对象
	 * @return 如果队列中有IQiYiVIPService对象,则返回该对象,否则生成一个新的对象返回给调用者
	 */
	public synchronized VIPService getIQiYiVIPService(){
		if(vipServiceList.peek() != null)
			return vipServiceList.poll();
		else
			return new IQiYiVIPService(new IQiYiVIPDAO());
	}
	/**
	 * 将IQiYiVIPService对象放回到IQiYiVIPServiceFactory工厂内
	 * @param iQiYiVipService
	 * @return 如果成功放回就返回true,如果工厂内IQiYiVIPService数目已经达到上限,或者IQiYiVIPService对象为空,则返回false
	 */
	public boolean setIQiYiVIPService(IQiYiVIPService iQiYiVipService){
		if(vipServiceList.size() > iQiYiVIPServiceNum.getNum())
			return false;
		return vipServiceList.offer(iQiYiVipService);
	}
	
}
