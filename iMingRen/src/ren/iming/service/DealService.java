package ren.iming.service;
/**
 * 提供一个将操作订单详情数据库与订单详情类相连接的一个服务类
 * @author xiuyang
 * @version 1.0 2016年11月19日 14:53:33
 */
import java.util.List;

import ren.iming.DAO.DealDAO;
import ren.iming.model.Deal;
import ren.iming.model.User;

public class DealService {
	private Deal deal;
	private DealDAO dealDao;
	
	public DealService(){}
	public DealService(DealDAO dealDao){
		this.dealDao = dealDao;
	}
	public DealService(DealDAO dealDao,Deal deal){
		this(dealDao);
		this.deal = deal;
	}
	
	/**
	 * 保存订单详情到数据库中
	 * @return 如果保存成功,则返回true,否则返回false
	 */
	public boolean save2DB(){
		return dealDao.saveOrUpdateDeal(deal);
	}
	/**
	 * 通过传参的形式将订单详情保存到数据库中
	 * @param deal
	 * @return 如果保存成功,则返回true,否则返回false
	 */
	public boolean save2DB(Deal deal){
		return dealDao.saveOrUpdateDeal(deal);
	}
	/**
	 * 通过传参的形式,将用户传入,查找该帐号的所有的订单详情
	 * @param user_account
	 * @return 如果查找成,则返回所有定订单详情,否则返回null
	 */
	public List<Deal> getDeal(User user){
		return dealDao.getUserByUserId(user.getAccount());
	}
	/**
	 * 通过传参的形式,将用户账号传入,查找该帐号的所有的订单详情
	 * @param user_account
	 * @return 如果查找成功,则返回所有的订单详情,否则返回null
	 */
	public List<Deal> getDeal(String user_account){
		return dealDao.getUserByUserId(user_account);
	}
	/**
	 * 删除某一订单详情
	 * @return 如果删除成功,则返回true,否则返回false
	 */
	public boolean deleteFromDB(){
		return dealDao.deleteUser(deal);
	}
	/**
	 * 通过传参的形式,删除某一订单详情
	 * @return 如果删除成功,则返回true,否则返回false
	 */
	public boolean deleteFromDB(Deal deal){
		return dealDao.deleteUser(deal);
	}
}
