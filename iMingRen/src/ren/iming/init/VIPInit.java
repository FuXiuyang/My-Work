package ren.iming.init;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ren.iming.model.IQiYiVIP;
import ren.iming.model.XunLeiVIP;
import ren.iming.service.IQiYiVIPQueue;
import ren.iming.service.IQiYiVIPService;
import ren.iming.service.IQiYiVIPServiceFactory;
import ren.iming.service.XunLeiVIPQueue;
import ren.iming.service.XunLeiVIPService;
import ren.iming.service.XunLeiVIPServiceFactory;

public class VIPInit extends HttpServlet {
	@Override
	/**
	 * 初始化服务器,将会员账号密码信息写入到内存中
	 */
	public void init() throws ServletException {
		// TODO 自动生成的方法存根
		super.init();
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		System.out.println("初始化正在运行中......");
//		将爱奇艺会员从数据库中取出放到爱奇艺队列中
		IQiYiVIPQueue iQueue = (IQiYiVIPQueue) context.getBean("iQiYiVIPQueue");
		IQiYiVIPServiceFactory iFactory = (IQiYiVIPServiceFactory) context.getBean("iQiYiVIPServiceFactory");
		IQiYiVIPService iService = (IQiYiVIPService) iFactory.getIQiYiVIPService();
		List<IQiYiVIP> iList = iService.getVipsFromDB();
		for(IQiYiVIP i:iList){
			try{
				iService.setVip2Queue(i);
			}catch(Exception e){
				System.err.println("将爱奇艺会员放入对列中发生了错误!"+e);
			}finally{
				
			}
			
		}
//		将迅雷会员从数据库中取出放到迅雷队列中
		XunLeiVIPQueue xQueue = (XunLeiVIPQueue) context.getBean("xunLeiVIPQueue");
		XunLeiVIPServiceFactory xFactory = (XunLeiVIPServiceFactory) context.getBean("xunLeiVIPServiceFactory");
		XunLeiVIPService xService = (XunLeiVIPService) xFactory.getXunLeiVIPService();
		List<XunLeiVIP> xList = xService.getVipsFromDB();
		for(XunLeiVIP x:xList){
			try{
				xService.setVip2Queue(x);
			}catch(Exception e){
				System.err.println("将迅雷会员放入对列中发生了错误!"+e);
			}finally{
				
			}
		}
		iFactory.setIQiYiVIPService(iService);
		xFactory.setXunLeiVIPService(xService);
	}
	
}
