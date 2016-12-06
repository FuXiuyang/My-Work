package ren.iming.DAO;
/*
 * @Date : 2016年10月29日 18:38:16
 * @author : xiuyang
 * @function : 使用单例模式获取SessionFactory
 */

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHelper {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory(){
		try{
			return new Configuration().configure().buildSessionFactory();
		}catch(Throwable e){
			System.err.println("获取sessionFactory时出错了,错误为:"+e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
