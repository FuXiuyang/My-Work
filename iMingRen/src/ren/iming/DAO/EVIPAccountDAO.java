package ren.iming.DAO;
/**
 * 用户类进行数据库操作时所使用的类
 * @author : xiuyang 
 * @version 1.0 2016年10月29日 18:42:53
 * @version 2.0 2016年11月19日 13:43:02
 */

import java.util.List;

import org.hibernate.Session;

import ren.iming.model.EVIPAccount;

public class EVIPAccountDAO extends DAO {
	private EVIPAccount EVIPAccount;
	private List<EVIPAccount> EVIPAccounts;
	public EVIPAccountDAO(){
		
	}
	public EVIPAccountDAO(EVIPAccount EVIPAccount){
		this.EVIPAccount = EVIPAccount;
	}
	public EVIPAccountDAO(List<EVIPAccount> EVIPAccounts){
		this.EVIPAccounts = EVIPAccounts;
	}
	
	public EVIPAccount getEVIPAccount() {
		return EVIPAccount;
	}
	public void setEVIPAccount(EVIPAccount EVIPAccount) {
		this.EVIPAccount = EVIPAccount;
	}
	public List<EVIPAccount> getEVIPAccounts() {
		return EVIPAccounts;
	}
	public void setEVIPAccounts(List<EVIPAccount> EVIPAccounts) {
		this.EVIPAccounts = EVIPAccounts;
	}
	/**
	 * 保存一个用户信息到数据库中
	 * @return 如果保存成功返回true,否则返回false 并且数据回滚
	 */
	public synchronized boolean saveOrUpdateEVIPAccount(){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("EVIPAccountDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			session.saveOrUpdate(EVIPAccount);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("EVIPAccountDAO保存用户信息到数据库中操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}
		return true;
	}
	/**
	 * 通过传参的形式保存一个用户信息到数据库中
	 * @param EVIPAccount
	 * @return 如果保存成功返回true,否则返回false 并且数据回滚
	 */
	public synchronized boolean saveOrUpdateEVIPAccount(EVIPAccount EVIPAccount){
		//保存或更新一个用户
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("EVIPAccountDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			session.saveOrUpdate(EVIPAccount);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("EVIPAccountDAO保存用户信息到数据库中操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}		
		return true;
	}
	/**
	 * 保存多个用户信息到数据库中
	 * @return 如果保存成功返回true,否则返回false 并且数据回滚
	 */
	public synchronized boolean saveOrUpdateEVIPAccounts(){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("EVIPAccountDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			for(int i = 0; i < EVIPAccounts.size(); i ++){
				session.saveOrUpdate(EVIPAccounts.get(i));
			}
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("EVIPAccountDAO保存多个用户信息到数据库中操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return true;
	}
	/**
	 * 通过传参的形式保存多个用户信息到数据库中
	 * @return 如果保存成功返回true,否则返回false 并且数据回滚
	 */
	public synchronized boolean saveOrUpdateEVIPAccounts(List<EVIPAccount> EVIPAccounts){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("EVIPAccountDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			for(int i = 0; i < EVIPAccounts.size(); i ++){
				session.saveOrUpdate(EVIPAccounts.get(i));
			}
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("EVIPAccountDAO保存多个用户信息到数据库中操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return true;
	}
	/**
	 * 通过用户id到数据库中进行查找
	 * @param id
	 * @return 如果找到,返回该用户信息,如果找不到或者发生异常返回null
	 */
	public synchronized EVIPAccount getFirstEVIPAccount(){
		Session session = null;
		EVIPAccount EVIPAccount = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("EVIPAccountDAO中数据库获取session值失败");
			return null;
		}
		try{
			session.beginTransaction();
			String str = "from EVIPAccount";
			EVIPAccount = (EVIPAccount) session.createQuery(str).setMaxResults(1).uniqueResult();
			session.getTransaction().commit();
		}catch(Exception e){
			System.out.println("EVIPAccountDAO到数据库中通过id查找用户信息操作失败!");
			return null;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return EVIPAccount;
	}
	/**
	 * 通过用户id到数据库中进行查找
	 * @param id
	 * @return 如果找到,返回该用户信息,如果找不到或者发生异常返回null
	 */
	public synchronized EVIPAccount getEVIPAccountById(String id){
		Session session = null;
		EVIPAccount EVIPAccount = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("EVIPAccountDAO中数据库获取session值失败");
			return null;
		}
		try{
			session.beginTransaction();
			String str = "from EVIPAccount where account = :id";
			EVIPAccount = (EVIPAccount) session.createQuery(str).setString("id", id).uniqueResult();
			session.getTransaction().commit();
		}catch(Exception e){
			System.out.println("EVIPAccountDAO到数据库中通过id查找用户信息操作失败!");
			return null;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return EVIPAccount;
	}
	/**
	 * 一次性查找用户表中所有的用户信息
	 * @return 如果找到,返回该用户信息,如果找不到或者发生异常返回null
	 */
	public synchronized List<EVIPAccount> getEVIPAccountList(){
		Session session = null;
		List<EVIPAccount> EVIPAccounts = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("EVIPAccountDAO中数据库获取session值失败");
			return null;
		}
		try{
			session.beginTransaction();
			String str = "from EVIPAccount";
			EVIPAccounts = session.createQuery(str).list();
			session.getTransaction().commit();
		}catch(Exception e){
			System.out.println("EVIPAccountDAO到数据库中通过id查找用户信息操作失败!");
			return null;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return EVIPAccounts;
	}
	/**
	 * 将用户信息从数据库中进行删除
	 * @return 如果删除成功则返回true,否则返回flase,并且数据库回滚数据
	 */
	public synchronized boolean deleteEVIPAccount(){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("EVIPAccountDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			session.delete(EVIPAccount);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("EVIPAccountDAO从数据库中删除用户信息操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return true;
	}
	/**
	 * 通过传参的形式将用户信息从数据库中进行删除
	 * @return 如果删除成功则返回true,否则返回flase,并且数据库回滚数据
	 */
	public synchronized boolean deleteEVIPAccount(EVIPAccount EVIPAccount){
		//删除一个用户资料
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("EVIPAccountDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			session.delete(EVIPAccount);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("EVIPAccountDAO从数据库中删除用户信息操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}
		return true;
	}
	/**
	 * 将多个用户信息从数据库中进行删除
	 * @return 如果删除成功则返回true,否则返回false,并且数据库中的额数据进行回滚.
	 */
	public synchronized boolean deleteEVIPAccounts(){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("EVIPAccountDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			for(int i = 0; i < EVIPAccounts.size(); i ++){
				session.delete(EVIPAccounts.get(i));
			}
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("EVIPAccountDAO从数据库中删除多个用户信息操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return true;
	}
	/**
	 * 通过传参的形式将多个用户信息从数据库中进行删除
	 * @param EVIPAccounts
	 * @return 如果删除成功则返回true,否则返回false,并且数据库中的额数据进行回滚.
	 */
	
	public synchronized boolean deleteEVIPAccounts(List<EVIPAccount> EVIPAccounts){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("EVIPAccountDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			for(int i = 0; i < EVIPAccounts.size(); i ++){
				session.delete(EVIPAccounts.get(i));
			}
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("EVIPAccountDAO从数据库中删除多个用户信息操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return true;
	}

}
