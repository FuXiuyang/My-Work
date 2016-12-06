package ren.iming.service;
/**
 * 提供一个用户服务的类,用于把用户信息存储到内存中或者数据库中
 * @author xiuyang
 * @version 1.0 2016年11月23日
 */

import java.util.List;
import ren.iming.DAO.EVIPAccountDAO;
import ren.iming.model.EVIPAccount;

public class EVIPAccountService {
	private EVIPAccountDAO eVIPAccountDao;
	public EVIPAccountService(){}
	public EVIPAccountService(EVIPAccountDAO eVIPAccountDao){
		this();
		this.eVIPAccountDao = eVIPAccountDao; 
	}
	public EVIPAccountDAO getEVIPAccountDao() {
		return eVIPAccountDao;
	}
	public void setEVIPAccountDao(EVIPAccountDAO eVIPAccountDao) {
		this.eVIPAccountDao = eVIPAccountDao;
	}
	/**
	 * 将新增或者更改的用户信息保存到数据库中
	 * @param eVIPAccount
	 */
	public void save2DB(EVIPAccount eVIPAccount){
		eVIPAccountDao.saveOrUpdateEVIPAccount(eVIPAccount);
	}
	/**
	 * 一次性将多个用户保存到数据库中
	 * @param eVIPAccounts
	 */
	public void save2DB(List<EVIPAccount> eVIPAccounts){
		eVIPAccountDao.saveOrUpdateEVIPAccounts(eVIPAccounts);
	}
	/**
	 * 通过用户名,从数据库中查找相应的用户信息
	 * @param account
	 */
	public EVIPAccount getFromDB(String account){
		return eVIPAccountDao.getEVIPAccountById(account);
	}
	/**
	 * 从数据库中获取全部的用户信息
	 * @return
	 */
	public List<EVIPAccount> getListFromDB(){
		return eVIPAccountDao.getEVIPAccountList();
	}
	/**
	 * 从数据库中删除用户信息
	 * @param eVIPAccount
	 */
	public void deleteFromDB(EVIPAccount eVIPAccount){
		eVIPAccountDao.deleteEVIPAccount(eVIPAccount);
	}
	/**
	 * 从数据库中批量删除用户信息
	 * @param eVIPAccounts
	 */
	public void deleteFromDB(List<EVIPAccount> eVIPAccounts){
		eVIPAccountDao.deleteEVIPAccounts(eVIPAccounts);
	}
}
