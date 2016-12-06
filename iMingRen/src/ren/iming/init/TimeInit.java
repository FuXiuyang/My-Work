package ren.iming.init;
/**
 * tomcat打开时就将时间监控打开,用来监控已经被领取的VIP账号密码
 * @author xiuyang
 * @version 1.0  2016年11月30日 12:44:45
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TimeInit extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// TODO 自动生成的方法存根
		super.init();
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Thread thread = (Thread) context.getBean("threadTimeService");
		thread.start();
		System.out.println("监听会员使用时间的线程开启了... ...");
	}
}
