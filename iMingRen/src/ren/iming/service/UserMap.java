package ren.iming.service;
/**
 * 实现单例的用户列表,把他放入内存中,方便查找.
 * @author xiuyang
 * 2016年11月14日 19:24:30
 */
import java.util.concurrent.ConcurrentHashMap;

import ren.iming.model.User;

public class UserMap {
	private static ConcurrentHashMap<String, User> users;
	private static UserMap instance = new UserMap();
	private UserMap(){
		users = new ConcurrentHashMap<String, User>();
	}
	public static UserMap getInstance(){
		return instance;
	}
	/**
	 * 将用户信息存放到用户列表中
	 * @param user
	 * @return 如果用户没有存到用户列表中,则返回false,否则返回true
	 */
	public synchronized boolean setUser(User user){
		try{
			users.put(user.getAccount(), user);
		}catch(Exception e){
			System.out.println("用户信息没有保存到用户表里.");
			return false;
		}
		return true;
		
	}
	/**
	 * 从用不列表中获取到用户的信息
	 * @param user
	 * @return 如果用户列表中有该用户,则返回该用户,否则返回null
	 */
	public synchronized User getUser(String account){
		if(!users.containsKey(account))
			return null;
		return users.get(account);
	}
	/**
	 * 从用户列表中删除用户信息
	 * @param user
	 */
	public synchronized void deleteUser(User user){
		users.remove(user.getAccount());	
	}
	
}
