package ren.iming.DAO;

import java.util.List;

import org.hibernate.Session;

import ren.iming.model.VIP;

public class XunLeiVIPDAO extends VIPDAO {
	@Override
	/**
	 * 通过VIP的账号id到数据库中进行查找
	 * @param id
	 * @return 如果找到,返回该VIP账号信息,如果找不到或者发生异常返回null
	 */
	public synchronized  VIP getVIPById(String id) {
		// TODO 自动生成的方法存根
		//通过id查找VIP用户的数据
		Session session = null;
		VIP vip = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("XunLeiVIPDAO中数据库获取session值失败");
			return null;
		}
		try{
			session.beginTransaction();
			String str = "from XunLeiVIP where account = :id";
			
			vip = (VIP) session.createQuery(str).setString("id", id).uniqueResult();
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("XunLeiVIPDAO到数据库中通过id查找VIP账户信息操作失败!");
			return null;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return vip;
	}
	@Override
	public synchronized  List getVIPList() {
		// TODO 自动生成的方法存根
		//通过id查找VIP用户的数据
		Session session = null;
		List<VIP> vips = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("XunLeiVIPDAO中数据库获取session值失败");
			return null;
		}
		try{
			session.beginTransaction();
			String str = "from XunLeiVIP";
			
			vips = session.createQuery(str).list();
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("XunLeiVIPDAO到数据库中一次性查找所有的XunLeiVIP账号信息操作失败!");
			return null;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return vips;
	}
}
