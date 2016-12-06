package ren.iming.service;
/**
 * 提供一个用户服务的类,用于把用户信息存储到内存中或者数据库中
 * @author xiuyang
 * @version 1.0 2016年11月14日 19:24:40
 * 去掉没有用测UserMap
 * @version 2.0 2016年11月22日 10:22:06
 */

import java.util.List;

import ren.iming.DAO.UserDAO;
import ren.iming.model.User;

public class UserService {
	private UserDAO userDao;
//	private UserMap userMap;
	public UserService(){
//		userMap = UserMap.getInstance();
	}
	public UserService(UserDAO userDao){
		this();
		this.userDao = userDao; 
	}
	public UserDAO getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	/**
	 * 将用户信息保存到用户列表中,也就是内存中
	 * @param user
	 * @return 如果保存用户信息成功,则返回true,否则返回false
	 */
	/*public boolean save2Map(User user){
		return userMap.setUser(user);
	}*/
	/**
	 * 通过用户名,从内存的用户列表中获取到某一用户信息.
	 * @param user
	 * @return 如果存在该用户,则返回该用户,否则返回null
	 */
	
	/*public User getFromMap(String account){
		return userMap.getUser(account);
	}*/
	/**
	 * 从内存中的用户表中删除用户信息
	 * @param user
	 */
	/*public void deleteFromMap(User user){
		userMap.deleteUser(user);
	}*/
	/**
	 * 将新增或者更改的用户信息保存到数据库中
	 * @param user
	 */
	public void save2DB(User user){
		userDao.saveOrUpdateUser(user);
	}
	/**
	 * 一次性将多个用户保存到数据库中
	 * @param users
	 */
	public void save2DB(List<User> users){
		userDao.saveOrUpdateUsers(users);
	}
	/**
	 * 通过用户名,从数据库中查找相应的用户信息
	 * @param account
	 */
	public User getFromDB(String account){
		return userDao.getUserById(account);
	}
	/**
	 * 从数据库中获取全部的用户信息
	 * @return
	 */
	public List<User> getListFromDB(){
		return userDao.getUserList();
	}
	/**
	 * 从数据库中删除用户信息
	 * @param user
	 */
	public void deleteFromDB(User user){
		userDao.deleteUser(user);
	}
	/**
	 * 从数据库中批量删除用户信息
	 * @param users
	 */
	public void deleteFromDB(List<User> users){
		userDao.deleteUsers(users);
	}
	
	
	
}
