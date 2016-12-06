package ren.iming.DAO;
/**
 * 用户类进行数据库操作时所使用的类
 * @author : xiuyang 
 * @version 1.0 2016年10月29日 18:42:53
 * @version 2.0 2016年11月19日 13:43:02
 */

import java.util.List;

import org.hibernate.Session;

import ren.iming.model.User;

public class UserDAO extends DAO {
	private User user;
	private List<User> users;
	public UserDAO(){
		
	}
	public UserDAO(User user){
		this.user = user;
	}
	public UserDAO(List<User> users){
		this.users = users;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	/**
	 * 保存一个用户信息到数据库中
	 * @return 如果保存成功返回true,否则返回false 并且数据回滚
	 */
	public boolean saveOrUpdateUser(){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("UserDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			session.saveOrUpdate(user);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("UserDAO保存用户信息到数据库中操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}
		return true;
	}
	/**
	 * 通过传参的形式保存一个用户信息到数据库中
	 * @param user
	 * @return 如果保存成功返回true,否则返回false 并且数据回滚
	 */
	public boolean saveOrUpdateUser(User user){
		//保存或更新一个用户
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("UserDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			session.saveOrUpdate(user);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("UserDAO保存用户信息到数据库中操作失败!");
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
	public boolean saveOrUpdateUsers(){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("UserDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			for(int i = 0; i < users.size(); i ++){
				session.saveOrUpdate(users.get(i));
			}
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("UserDAO保存多个用户信息到数据库中操作失败!");
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
	public boolean saveOrUpdateUsers(List<User> users){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("UserDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			for(int i = 0; i < users.size(); i ++){
				session.saveOrUpdate(users.get(i));
			}
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("UserDAO保存多个用户信息到数据库中操作失败!");
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
	public User getUserById(String id){
		Session session = null;
		User user = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("UserDAO中数据库获取session值失败");
			return null;
		}
		try{
			session.beginTransaction();
			String str = "from User where account = :id";
			user = (User) session.createQuery(str).setString("id", id).uniqueResult();
			session.getTransaction().commit();
		}catch(Exception e){
			System.out.println("UserDAO到数据库中通过id查找用户信息操作失败!");
			return null;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return user;
	}
	/**
	 * 一次性查找用户表中所有的用户信息
	 * @return 如果找到,返回该用户信息,如果找不到或者发生异常返回null
	 */
	public List<User> getUserList(){
		Session session = null;
		List<User> users = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("UserDAO中数据库获取session值失败");
			return null;
		}
		try{
			session.beginTransaction();
			String str = "from User";
			users = session.createQuery(str).list();
			session.getTransaction().commit();
		}catch(Exception e){
			System.out.println("UserDAO到数据库中通过id查找用户信息操作失败!");
			return null;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return users;
	}
	/**
	 * 将用户信息从数据库中进行删除
	 * @return 如果删除成功则返回true,否则返回flase,并且数据库回滚数据
	 */
	public boolean deleteUser(){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("UserDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("UserDAO从数据库中删除用户信息操作失败!");
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
	public boolean deleteUser(User user){
		//删除一个用户资料
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("UserDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("UserDAO从数据库中删除用户信息操作失败!");
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
			for(int i = 0; i < users.size(); i ++){
				session.delete(users.get(i));
			}
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("UserDAO从数据库中删除多个用户信息操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return true;
	}
	/**
	 * 通过传参的形式将多个用户信息从数据库中进行删除
	 * @param users
	 * @return 如果删除成功则返回true,否则返回false,并且数据库中的额数据进行回滚.
	 */
	
	public boolean deleteUsers(List<User> users){
		Session session = null;
		try{
			session = getSession();
		}catch(Exception e){
			System.out.println("UserDAO中数据库获取session值失败");
			return false;
		}
		try{
			session.beginTransaction();
			for(int i = 0; i < users.size(); i ++){
				session.delete(users.get(i));
			}
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("UserDAO从数据库中删除多个用户信息操作失败!");
			return false;
		}finally{
			//无论怎样都要把session给关了
			close();
		}	
		return true;
	}

}
