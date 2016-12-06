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

import ren.iming.DAO.UserDAO;


public class UserServiceFactory {
	private static ConcurrentLinkedQueue<UserService> userServiceList;
	private ApplicationContext context;
	private CookieNum userServiceNum;
	private static UserServiceFactory instance = new UserServiceFactory();
	/**
	 * 初始化UserServiceFactory工厂,将userServiceNum.getNum()个UserService放入到工厂内
	 */
	private UserServiceFactory(){
		userServiceList = new ConcurrentLinkedQueue<UserService>();
		context = new ClassPathXmlApplicationContext("bean.xml");
		//获取默认缓存个数
		userServiceNum = (CookieNum) context.getBean("userServiceNum");
		for(int i = 0; i < userServiceNum.getNum(); i ++){
			userServiceList.offer(new UserService(new UserDAO()));
		}
	}
	/**
	 * 获取单例模式下的UserServiceFactory的实例
	 * @return
	 */
	public static UserServiceFactory getInstance(){
		return instance;
	}
	/**
	 * 获取UserService对象
	 * @return 如果队列中有UserService对象,则返回该对象,否则生成一个新的对象返回给调用者
	 */
	public synchronized UserService getUserService(){
		if(userServiceList.peek() != null)
			return userServiceList.poll();
		else
			return new UserService(new UserDAO());
	}
	/**
	 * 将UserService对象放回到UserServiceFactory工厂内
	 * @param userService
	 * @return 如果成功放回就返回true,如果工厂内UserService数目已经达到上限,或者UserService对象为空,则返回false
	 */
	public boolean setUserService(UserService userService){
		if(userServiceList.size() > userServiceNum.getNum())
			return false;
		return userServiceList.offer(userService);
	}
	
}
