package ren.iming.service;
/**
 * 用来开启多线程监听和修改会员密码
 */
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import ren.iming.DAO.EVIPAccountDAO;
import ren.iming.model.EVIPAccount;
import ren.iming.reset.password.ResetPasswordService;

public class TimeService implements Runnable {
	private TimeQueue timeQueue;
	private EVIPAccountDAO eVipDao;
	private EVIPAccount eVip;
	private ResetPasswordService resetPasswordService;
	
	public TimeService(){}
	
	public TimeQueue getTimeQueue() {
		return timeQueue;
	}


	public void setTimeQueue(TimeQueue timeQueue) {
		this.timeQueue = timeQueue;
	}


	public EVIPAccountDAO geteVipDao() {
		return eVipDao;
	}


	public void seteVipDao(EVIPAccountDAO eVipDao) {
		this.eVipDao = eVipDao;
	}


	public EVIPAccount geteVip() {
		return eVip;
	}


	public void seteVip(EVIPAccount eVip) {
		this.eVip = eVip;
	}


	public ResetPasswordService getResetPasswordService() {
		return resetPasswordService;
	}


	public void setResetPasswordService(ResetPasswordService resetPasswordService) {
		this.resetPasswordService = resetPasswordService;
	}
	/**
	 * 开启多线程程更改密码
	 */
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		/*timeQueue = TimeQueue.getInstance();
		eVipDao = new EVIPAccountDAO();*/
		while(true){
			while(timeQueue.length() > 0){
				try {
					if(System.currentTimeMillis() > timeQueue.getFirst().endTime){
						try {
							resetPasswordService.init(timeQueue.getFirst().vip_account);
							Thread thread = new Thread(resetPasswordService);
							thread.start();
						} catch (Exception e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
							System.err.println("获取时间列表中的第一个元素是出现了问题.");
						}
						timeQueue.removeFirst();
					}else if((eVip = eVipDao.getFirstEVIPAccount()) != null){
						try {
							resetPasswordService.init(eVip.getAccount());
							Thread thread = new Thread(resetPasswordService);
							thread.start();
							eVipDao.deleteEVIPAccount(eVip);
						} catch (MessagingException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			if((eVip = eVipDao.getFirstEVIPAccount()) != null){
				try {
					/*Thread thread = new Thread(new ResetPasswordService(eVip.getAccount()));*/
					resetPasswordService.init(eVip.getAccount());
					Thread thread = new Thread(resetPasswordService);
					thread.start();
					eVipDao.deleteEVIPAccount(eVip);
				} catch (MessagingException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
			
		}
	}

}
