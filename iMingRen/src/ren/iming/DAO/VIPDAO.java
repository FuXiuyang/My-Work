package ren.iming.DAO;
/*
 * @Date : 2016年10月29日 18:41:27
 * @author : xiuyang
 * @function : VIP类实现数据库操作时所使用的类
 */

import java.util.List;

import org.hibernate.Session;

import ren.iming.model.VIP;

public  abstract class VIPDAO extends DAO{
	private VIP vip;
	private List<VIP> vips;
	public VIPDAO(){
		
	}
	public VIPDAO(VIP vip){
		this.vip = vip;
	}
	public VIPDAO(List vips){
		this.vips = vips;
	}
	
	public synchronized  VIP getVip() {
		return vip;
	}
	public synchronized  void setVip(VIP vip) {
		this.vip = vip;
	}
	public synchronized  List<VIP> getVips() {
		return vips;
	}
	public synchronized  void setVips(List<VIP> vips) {
		this.vips = vips;
	}
	/**
	 * 保存一个vip账户信息到数据库中
	 * @return 如果保存成功返回true,否则返回false 并且数据回滚
	 */
	public synchronized  boolean saveOrUpdateVIP(){
		//更新或者插入一个vip账号的数据
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("VIPDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			session.saveOrUpdate(vip);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("VIPDAO保存vip账户信息到数据库中操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}
		return true;
	}
	/**
	 * 通过传参的形式保存一个vip账户信息到数据库中
	 * @param vip
	 * @return 如果保存成功返回true,否则返回false 并且数据回滚
	 */
	public synchronized  boolean saveOrUpdateVIP(VIP vip){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("VIPDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			session.saveOrUpdate(vip);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("VIPDAO保存vip账户信息到数据库中操作失败!");
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
	public synchronized  boolean saveOrUpdateVIPs(){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("VIPDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			for(int i = 0; i < vips.size(); i ++){
				session.saveOrUpdate(vips.get(i));
			}
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("VIPDAO保存多个vip账户信息到数据库中操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return true;
	}
	/**
	 * 通过传参的形式保存多个用户信息到数据库中
	 * @param vips
	 * @return 如果保存成功返回true,否则返回false 并且数据回滚
	 */
	public synchronized  boolean saveOrUpdateVIPs(List vips){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("VIPDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			for(int i = 0; i < vips.size(); i ++){
				session.saveOrUpdate(vips.get(i));
			}
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("VIPDAO保存多个vip账户信息到数据库中操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return true;	
	}
	//由子类进行实现
	public abstract VIP getVIPById(String id);
	//由子类进行实现
	public  abstract List getVIPList();
	/**
	 * 将vip信息从数据库中进行删除
	 * @return 如果删除成功则返回true,否则返回flase,并且数据库回滚数据
	 */
	public synchronized  boolean deleteVIP(){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("VIPDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			session.delete(vip);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("VIPDAO从数据库中删除VIP账号信息操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return true;	
	}
	/**
	 * 通过传参的形式将vip信息从数据库中进行删除
	 * @param vip
	 * @return 如果删除成功则返回true,否则返回flase,并且数据库回滚数据
	 */
	public synchronized  boolean deleteVIP(VIP vip){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("VIPDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			session.delete(vip);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("VIPDAO从数据库中删除VIP账户信息操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return true;	
	}
	/**
	 * 将多个VIP账户信息从数据库中进行删除
	 * @return 如果删除成功则返回true,否则返回false,并且数据库中的额数据进行回滚.
	 */
	public synchronized  boolean deleteVIPs(){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("VIPDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			for(int i = 0; i < vips.size(); i ++){
				session.delete(vips.get(i));
			}
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("VIPDAO从数据库中删除多个VIP账号信息操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return true;
	}
	/**
	 *通过传参的形式将多个VIP账户信息从数据库中进行删除
	 * @param vips
	 * @return 如果删除成功则返回true,否则返回false,并且数据库中的额数据进行回滚.
	 */
	public synchronized  boolean deleteVIPs(List vips){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("VIPDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			for(int i = 0; i < vips.size(); i ++){
				session.delete(vips.get(i));
			}
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("VIPDAO从数据库中删除多个VIP账户信息操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return true;
	}
	
}
