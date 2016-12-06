package ren.iming.service;
/**
 * 创建一个工厂类,用他去组装一个服务应该声明的类,我们只需要调用工厂类,从中获取我们想要的对象就可以了,
 * 并且这个工厂类还提供了缓存技术,使运行效率更快
 * @author xiuyang
 * @version 1.0 2016年11月22日 10:24:38
 */
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ren.iming.DAO.VIPInfoDAO;


public class VIPInfoServiceFactory {
	private static ConcurrentLinkedQueue<VIPInfoService> vipInfoServiceList;
	private static VIPInfoServiceFactory instance = new VIPInfoServiceFactory();
	private ApplicationContext context;
	private CookieNum vipInfoServiceNum;
	/**
	 * 初始化VIPInfoServiceFactory工厂,将vipInfoServiceNum.getNum()个VIPInfoService放入到工厂内
	 */
	private VIPInfoServiceFactory(){
		vipInfoServiceList = new ConcurrentLinkedQueue<VIPInfoService>();
		context = new ClassPathXmlApplicationContext("bean.xml");
		vipInfoServiceNum = (CookieNum) context.getBean("vipInfoServiceNum");
		for(int i = 0; i < vipInfoServiceNum.getNum(); i ++){
			vipInfoServiceList.offer(new VIPInfoService(new VIPInfoDAO()));
		}
	}
	/**
	 * 获取单例模式下的VIPInfoServiceFactory的实例
	 * @return
	 */
	public static VIPInfoServiceFactory getInstance(){
		return instance;
	}
	/**
	 * 获取VIPInfoService对象
	 * @return 如果队列中有VIPInfoService对象,则返回该对象,否则生成一个新的对象返回给调用者
	 */
	public synchronized VIPInfoService getVIPInfoService(){
		if(vipInfoServiceList.peek() != null)
			return vipInfoServiceList.poll();
		else
			return new VIPInfoService(new VIPInfoDAO());
	}
	/**
	 * 将VIPInfoService对象放回到VIPInfoServiceFactory工厂内
	 * @param vipInfoService
	 * @return 如果成功放回就返回true,如果工厂内VIPInfoService数目已经达到上限,或者VIPInfoService对象为空,则返回false
	 */
	public boolean setVIPInfoService(VIPInfoService vipInfoService){
		if(vipInfoServiceList.size() > vipInfoServiceNum.getNum())
			return false;
		return vipInfoServiceList.offer(vipInfoService);
	}
	
}
