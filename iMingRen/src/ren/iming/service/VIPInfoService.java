package ren.iming.service;
/**
 * 提供一个用户服务的类,用于把用户信息存储到内存中或者数据库中
 * @author xiuyang
 * @version 2016年11月22日 10:23:22
 */

import java.util.List;

import ren.iming.DAO.VIPInfoDAO;
import ren.iming.model.VIPInfo;

public class VIPInfoService {
	private VIPInfoDAO vipInfoDao;
	public VIPInfoService(){
	}
	public VIPInfoService(VIPInfoDAO vipInfoDao){
		this();
		this.vipInfoDao = vipInfoDao; 
	}
	public VIPInfoDAO getVIPInfoDao() {
		return vipInfoDao;
	}
	public void setVIPInfoDao(VIPInfoDAO vipInfoDao) {
		this.vipInfoDao = vipInfoDao;
	}
	/**
	 * 将新增或者更改的用户信息保存到数据库中
	 * @param vipInfo
	 */
	public void save2DB(VIPInfo vipInfo){
		vipInfoDao.saveOrUpdateVIPInfo(vipInfo);
	}
	/**
	 * 一次性将多个用户保存到数据库中
	 * @param vipInfos
	 */
	public void save2DB(List<VIPInfo> vipInfos){
		vipInfoDao.saveOrUpdateVIPInfos(vipInfos);
	}
	/**
	 * 通过用户名,从数据库中查找相应的用户信息
	 * @param account
	 */
	public VIPInfo getFromDB(String account){
		return vipInfoDao.getVIPInfoById(account);
	}
	/**
	 * 从数据库中获取全部的用户信息
	 * @return
	 */
	public List<VIPInfo> getListFromDB(){
		return vipInfoDao.getVIPInfoList();
	}
	/**
	 * 从数据库中删除用户信息
	 * @param vipInfo
	 */
	public void deleteFromDB(VIPInfo vipInfo){
		vipInfoDao.deleteVIPInfo(vipInfo);
	}
	/**
	 * 从数据库中批量删除用户信息
	 * @param vipInfos
	 */
	public void deleteFromDB(List<VIPInfo> vipInfos){
		vipInfoDao.deleteVIPInfos(vipInfos);
	}
	
	
	
}
