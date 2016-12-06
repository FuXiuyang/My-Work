
package ren.iming.DAO;
/**
 * 用户类进行数据库操作时所使用的类
 * @author : xiuyang 
 * @version 1.0 2016年11月22日 10:19:15
 */

import java.util.List;

import org.hibernate.Session;

import ren.iming.model.VIPInfo;

public class VIPInfoDAO extends DAO {
	private VIPInfo vipInfo;
	private List<VIPInfo> vipInfos;
	public VIPInfoDAO(){
		
	}
	public VIPInfoDAO(VIPInfo vipInfo){
		this.vipInfo = vipInfo;
	}
	public VIPInfoDAO(List<VIPInfo> vipInfos){
		this.vipInfos = vipInfos;
	}
	
	public synchronized  VIPInfo getVIPInfo() {
		return vipInfo;
	}
	public synchronized  void setVIPInfo(VIPInfo vipInfo) {
		this.vipInfo = vipInfo;
	}
	public synchronized  List<VIPInfo> getVIPInfos() {
		return vipInfos;
	}
	public synchronized  void setVIPInfos(List<VIPInfo> vipInfos) {
		this.vipInfos = vipInfos;
	}
	/**
	 * 保存一个用户信息到数据库中
	 * @return 如果保存成功返回true,否则返回false 并且数据回滚
	 */
	public synchronized  boolean saveOrUpdateVIPInfo(){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("VIPInfoDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			session.saveOrUpdate(vipInfo);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("VIPInfoDAO保存用户信息到数据库中操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}
		return true;
	}
	/**
	 * 通过传参的形式保存一个用户信息到数据库中
	 * @param vipInfo
	 * @return 如果保存成功返回true,否则返回false 并且数据回滚
	 */
	public synchronized  boolean saveOrUpdateVIPInfo(VIPInfo vipInfo){
		//保存或更新一个用户
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("VIPInfoDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			session.saveOrUpdate(vipInfo);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("VIPInfoDAO保存用户信息到数据库中操作失败!");
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
	public synchronized  boolean saveOrUpdateVIPInfos(){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("VIPInfoDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			for(int i = 0; i < vipInfos.size(); i ++){
				session.saveOrUpdate(vipInfos.get(i));
			}
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("VIPInfoDAO保存多个用户信息到数据库中操作失败!");
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
	public synchronized  boolean saveOrUpdateVIPInfos(List<VIPInfo> vipInfos){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("VIPInfoDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			for(int i = 0; i < vipInfos.size(); i ++){
				session.saveOrUpdate(vipInfos.get(i));
			}
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("VIPInfoDAO保存多个用户信息到数据库中操作失败!");
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
	public synchronized  VIPInfo getVIPInfoById(String id){
		Session session = null;
		VIPInfo vipInfo = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("VIPInfoDAO中数据库获取session值失败");
			return null;
		}
		try{
			session.beginTransaction();
			String str = "from VIPInfo where account = :id";
			vipInfo = (VIPInfo) session.createQuery(str).setString("id", id).uniqueResult();
			session.getTransaction().commit();
		}catch(Exception e){
			System.out.println("VIPInfoDAO到数据库中通过id查找用户信息操作失败!");
			return null;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return vipInfo;
	}
	/**
	 * 一次性查找用户表中所有的用户信息
	 * @return 如果找到,返回该用户信息,如果找不到或者发生异常返回null
	 */
	public synchronized  List<VIPInfo> getVIPInfoList(){
		Session session = null;
		List<VIPInfo> vipInfos = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("VIPInfoDAO中数据库获取session值失败");
			return null;
		}
		try{
			session.beginTransaction();
			String str = "from VIPInfo";
			vipInfos = session.createQuery(str).list();
			session.getTransaction().commit();
		}catch(Exception e){
			System.out.println("VIPInfoDAO到数据库中通过id查找用户信息操作失败!");
			return null;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return vipInfos;
	}
	/**
	 * 将用户信息从数据库中进行删除
	 * @return 如果删除成功则返回true,否则返回flase,并且数据库回滚数据
	 */
	public synchronized  boolean deleteVIPInfo(){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("VIPInfoDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			session.delete(vipInfo);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("VIPInfoDAO从数据库中删除用户信息操作失败!");
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
	public synchronized  boolean deleteVIPInfo(VIPInfo vipInfo){
		//删除一个用户资料
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("VIPInfoDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			session.delete(vipInfo);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("VIPInfoDAO从数据库中删除用户信息操作失败!");
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
	public synchronized  boolean deleteVIPInfos(){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("VIPInfoDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			for(int i = 0; i < vipInfos.size(); i ++){
				session.delete(vipInfos.get(i));
			}
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("VIPInfoDAO从数据库中删除多个用户信息操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return true;
	}
	/**
	 * 通过传参的形式将多个用户信息从数据库中进行删除
	 * @param vipInfos
	 * @return 如果删除成功则返回true,否则返回false,并且数据库中的额数据进行回滚.
	 */
	
	public synchronized  boolean deleteVIPInfos(List<VIPInfo> vipInfos){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("VIPInfoDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			for(int i = 0; i < vipInfos.size(); i ++){
				session.delete(vipInfos.get(i));
			}
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("VIPInfoDAO从数据库中删除多个用户信息操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return true;
	}

}
