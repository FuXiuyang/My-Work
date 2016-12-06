package ren.iming.DAO;
/**
 * 对数据库中的订单详情进行操作
 * @author xiuyang
 * @version 1.0 2016年11月19日 13:42:12
 */
import java.util.List;

import org.hibernate.Session;

import ren.iming.model.Deal;

public class DealDAO extends DAO {
	private Deal deal;
	private List<Deal> deals;
	
	public void DealDAO(){}
	public void DealDAO(Deal deal){
		this.deal = deal;
	}
	
	public Deal getDeal() {
		return deal;
	}
	public void setDeal(Deal deal) {
		this.deal = deal;
	}
	public List<Deal> getDeals() {
		return deals;
	}
	public void setDeals(List<Deal> deals) {
		this.deals = deals;
	}
	/**
	 *	保存订单详情到数据库中
	 * @return 如果不没有发生异常,则返回true,否则返回flase
	 */
	public boolean saveOrUpdateDeal(){
		
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("DealDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			session.saveOrUpdate(deal);
			session.getTransaction().commit();
		}catch(Exception e){
			//发生异常数据库内容回滚
			session.getTransaction().rollback();
			System.out.println("DealDAO保存订单详情到数据库中操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return true;		
	}
	
	/**
	 *	通过传参的形式将订单详情保存到数据库中
	 * @return 如果不没有发生异常,则返回true,否则返回flase
	 */
	public boolean saveOrUpdateDeal(Deal deal){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("DealDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			session.saveOrUpdate(deal);
			session.getTransaction().commit();
		}catch(Exception e){
			//发生异常数据库内容回滚
			session.getTransaction().rollback();
			System.out.println("DealDAO保存订单详情信息到数据库中操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return true;		
	}
	/**
	 * 一次性将多个订单详情保存到数据库中
	 * @return 如果没有发生异常,则返回true,否则返回false
	 */
	public boolean saveOrUpdateUsers(){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){			
			System.out.println("DealDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			for(int i = 0; i < deals.size(); i ++){
				session.saveOrUpdate(deals.get(i));
			}
			session.getTransaction().commit();
		}catch(Exception e){
			//发生异常数据库内容回滚
			session.getTransaction().rollback();
			System.out.println("DealDAO保存多个订单详情到数据库中操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}
		return true;
	}
	
	/**
	 * 通过传参的形式一次性将多个订单详情保存到数据库中
	 * @return 如果没有发生异常,则返回true,否则返回false
	 */
	public boolean saveOrUpdateUsers(List<Deal> deals){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){			
			System.out.println("UserDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			for(int i = 0; i < deals.size(); i ++){
				session.saveOrUpdate(deals.get(i));
			}
			session.getTransaction().commit();
		}catch(Exception e){
			//发生异常数据库内容回滚
			session.getTransaction().rollback();
			System.out.println("USerDAO保存多个订单详情到数据库中操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}
		return true;
	}
	/**
	 * 通过用户account号去数据库中查找该用户的所有订单详情
	 * @param userId 用户账号即对应user中的account,对应Deal表中user_account
	 * @return 如果查找到数据返回一个列表,否则返回null
	 */
	public List getUserByUserId(String userId){
		Session session = null;
		List deals = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("DealDAO中数据库获取session值失败");
			return null;
		}
		try{
			session.beginTransaction();
			String str = "from Deal where user_account = :id";
			deals = session.createQuery(str).setString("id", userId).list();
			session.getTransaction().commit();
		}catch(Exception e){
			System.out.println("DealDAO到数据库中通过user_account查找用户所有的订单详情信息操作失败!");
			return null;
		}finally{
			//无论怎样都要把session给关了
			close();
		}
		return deals;
	}
	/**
	 * 从数据库中删除某一指定的订单详情
	 * @return 如果删除成功返回ture,否则返回flase,并且回滚
	 */
	public boolean deleteUser(){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("DealDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			session.delete(deal);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("DealDAO从数据库中删除订单详情操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}
		return true;
	}
	
	/**
	 * 通过传参的形式从数据库中删除某一指定的订单详情
	 * @return 如果删除成功返回ture,否则返回flase,并且回滚
	 */
	public boolean deleteUser(Deal deal){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("DealDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			session.delete(deal);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("DealDAO从数据库中删除订单详情操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}
		return true;
	}
	/**
	 * 一次性删除多个订单详情信息
	 * @return 如果删除成功,则返回true,否则返回false,并且数据库回滚
	 */
	public boolean deleteUsers(){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("UserDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			for(int i = 0; i < deals.size(); i ++){
				session.delete(deals.get(i));
			}
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("USerDAO从数据库中删除多个用户信息操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return true;
	}
	
	
}
