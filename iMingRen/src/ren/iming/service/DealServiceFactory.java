package ren.iming.service;
/**
 * 创建一个工厂类,用他去组装一个服务应该声明的类,我们只需要调用工厂类,从中获取我们想要的对象就可以了,
 * 并且这个工厂类还提供了缓存技术,使运行效率更快
 * @author xiuyang
 * @version 2016年11月19日 15:00:11
 */
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ren.iming.DAO.DealDAO;
public class DealServiceFactory {
	private CookieNum dealServiceNum;
	private ApplicationContext context;
	private static ConcurrentLinkedQueue<DealService> dealServiceList;
	private static DealServiceFactory instance = new DealServiceFactory();
	
	/**
	 * 初始化DealServiceFactory工厂,将serviceNum个DealService放入到工厂内
	 */
	private DealServiceFactory(){
		dealServiceList = new ConcurrentLinkedQueue<DealService>();
		context = new ClassPathXmlApplicationContext("bean.xml");
		dealServiceNum = (CookieNum) context.getBean("dealServiceNum");
		for(int i = 0; i < dealServiceNum.getNum(); i ++){
			dealServiceList.offer(new DealService(new DealDAO()));
		}
	}
	
	/**
	 * 获取单例模式下的DealServiceFactory的实例
	 * @return
	 */
	public static DealServiceFactory getInstance(){
		return instance;
	}
	/**
	 * 获取DealService对象
	 * @return 如果队列中有DealService对象,则返回该对象,否则生成一个新的对象返回给调用者
	 */
	public synchronized DealService getDealService(){
		if(dealServiceList.peek() != null)
			return dealServiceList.poll();
		else
			return new DealService(new DealDAO());
	}
	/**
	 * 将DealService对象放回到DealServiceFactory工厂内
	 * @param dealService
	 * @return 如果成功放回就返回true,如果工厂内DealService数目已经达到上限,或者DealService对象为空,则返回false
	 */
	public boolean setDealService(DealService dealService){
		if(dealServiceList.size() > dealServiceNum.getNum())
			return false;
		return dealServiceList.offer(dealService);
	}
}
