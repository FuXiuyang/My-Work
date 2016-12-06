package ren.iming.DAO;
/**
 * @Date : 2016年10月29日 18:43:50
 * @author : xiuyang
 * @function : 类与数据库连接时,所使用的类,这里封装了一些方法,这些方法都是每个类连接数据库是所需要使用的.
 * @备注:在提交或者查找时一定要加上异常处理.
 */

import org.hibernate.Session;


public class DAO {
	/**
	 * 获取数据库连接时的session
	 * @return
	 */
	public synchronized Session getSession(){
		try{
			return HibernateHelper.getSessionFactory().getCurrentSession();
		}catch(Exception e){
			System.out.println("获取当前数据库session值失败");
			return HibernateHelper.getSessionFactory().openSession();
		}
	}
	public void close(){
		HibernateHelper.getSessionFactory().getCurrentSession().close();
	}
}
