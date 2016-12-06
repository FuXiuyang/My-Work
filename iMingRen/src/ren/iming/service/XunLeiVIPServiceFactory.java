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

import ren.iming.DAO.XunLeiVIPDAO;


public class XunLeiVIPServiceFactory {
	private CookieNum xunLeiVIPServiceNum;
	private ApplicationContext context;
	private static ConcurrentLinkedQueue<XunLeiVIPService> vipServiceList;
	private static XunLeiVIPServiceFactory instance = new XunLeiVIPServiceFactory();
	/**
	 * 初始化XunLeiVIPServiceFactory工厂,将SERVICE_NUM个(即15个)XunLeiVIPService放入到工厂内
	 */
	private XunLeiVIPServiceFactory(){
		vipServiceList = new ConcurrentLinkedQueue<XunLeiVIPService>();
		context = new ClassPathXmlApplicationContext("bean.xml");
		xunLeiVIPServiceNum = (CookieNum) context.getBean("xunLeiVIPServiceNum");
		for(int i = 0; i < xunLeiVIPServiceNum.getNum(); i ++){
			vipServiceList.offer(new XunLeiVIPService(new XunLeiVIPDAO()));
		}
	}
	/**
	 * 获取单例模式下的XunLeiVIPServiceFactory的实例
	 * @return
	 */
	public static XunLeiVIPServiceFactory getInstance(){
		return instance;
	}
	/**
	 * 获取XunLeiVIPService对象
	 * @return 如果队列中有XunLeiVIPService对象,则返回该对象,否则生成一个新的对象返回给调用者
	 */
	public synchronized VIPService getXunLeiVIPService(){
		if(vipServiceList.peek() != null)
			return vipServiceList.poll();
		else
			return new XunLeiVIPService(new XunLeiVIPDAO());
	}
	/**
	 * 将XunLeiVIPService对象放回到XunLeiVIPServiceFactory工厂内
	 * @param XunLeiVipService
	 * @return 如果成功放回就返回true,如果工厂内XunLeiVIPService数目已经达到上限,或者XunLeiVIPService对象为空,则返回false
	 */
	public boolean setXunLeiVIPService(XunLeiVIPService XunLeiVipService){
		if(vipServiceList.size() > xunLeiVIPServiceNum.getNum())
			return false;
		return vipServiceList.offer(XunLeiVipService);
	}
	
}
