package ren.iming.service;
/*
 * @Date: 2016年11月4日 18:30:39
 * @author: xiuyang
 * @function: 提供VIP服务,为了使相应的Action的类获取到该VIP账号
 */

import java.util.List;

import ren.iming.DAO.VIPDAO;
import ren.iming.model.VIP;

public class VIPService {
	private VIP vip;
	private VIPDAO vipDao;
	
	public VIPService(){}
	public VIPService(VIPDAO vipDao) {
		this.vipDao = vipDao;	
	}
	public VIPService(VIPDAO vipDao,VIP vip) {
		this(vipDao);
		this.vip = vip;	
	}
	
	public VIPDAO getVipDao() {
		return vipDao;
	}
	public void setVipDao(VIPDAO vipDao) {
		this.vipDao = vipDao;
	}
	public VIP getVip() {
		return vip;
	}
	public void setVip(VIP vip) {
		this.vip = vip;
	}
	/*
	 * 以下的操作主要是与队列进行交互
	 */
	//设置VIP成功返回ture,失败为false
/*	public boolean setVip2Queue(){
		return vipList.setVIP(vip);
	}*/
/*	//通过传参的方式将VIP设置到VIP队列中
	public abstract boolean setVip2Queue(VIP vip);
	//通过VIP列表将VIP对象批量的设置到VIP队列中
	public abstract boolean setVips2Queue(List<VIP> vips);
	//返回VIP队列中第一个元素
	public abstract VIP getVipFromQueue();*/
	
	/**
	 * 将vip账号信息存入到数据库中
	 * @return 如果存入成功,则返回true,否则返回fasle
	 */
	public boolean setVip2DB(){
		return vipDao.saveOrUpdateVIP(vip);
	}
	/**
	 * 通过传参的形式将VIP账户数据保存到数据库内
	 * @param vip
	 * @return 如果存入成功,则返回true,否则返回fasle
	 */
	public boolean setVip2DB(VIP vip){
		return vipDao.saveOrUpdateVIP(vip);
	}
	//将多个VIP账户数据保存到数据库内
	/**
	 * 通过传参的形式,一次将多个VIP账号信息存入DAO数据库中
	 * @param vips
	 * @return 如果存入成功,则返回true,否则返回false
	 */
	public boolean setVips2DB(List<VIP> vips){
		return vipDao.saveOrUpdateVIPs(vips);
	}
	/**
	 * 通过vip的账号,查找数据库中相应的VIP账号信息
	 * @return 如果查找成功,则返回该VIP信息,否则返回null
	 */
	public VIP getVipFromDB(){
		return vipDao.getVIPById(vip.getAccount());
	}
	//通过VIP的账号信息在数据库内查找
	/**
	 * 通过传参的形式,在数据库中查找相应的VIP信息
	 * @param vip
	 * @return 如果查找成功,则返回该VIP信息,否则返回null
	 */
	public VIP getVipFromDB(VIP vip){
		return vipDao.getVIPById(vip.getAccount());
	}
	//通过VIP的账号信息在数据库内查找
	/**
	 * 通过账号查找,是否有该账号的vip在数据库中
	 * @param account
	 * @return 如果查找成功,则返回该VIP账号信息,否则返回null
	 */
	public VIP getVipFromDB(String account){
		return vipDao.getVIPById(account);
	}
	//直接查找全部的VIP账号信息
	/**
	 * 一次性查找到数据库中所有的VIP账号信息
	 * @return 如果查找成功,则返回所有的一个列表,里面存着所有的VIP账号信息,否则返回null
	 */ 
	public List getVipsFromDB(){
		return vipDao.getVIPList();
	}
	/**
	 * 将相应的VIP账号信息给删除
	 * @return 如果删除成功,则返回true,否则返回false
	 */
	public boolean deleteFromDB(){
		return vipDao.deleteVIP(vip);
	}
	/**
	 * 通过传递参数,将相应的VIP账号信息给删除
	 * @return 如果删除成功,则返回true,否则返回false
	 */
	public boolean deleteFromDB(VIP vip){
		return vipDao.deleteVIP(vip);
	}
	/**
	 * 一次性删除多个VIP账户信息
	 * @return 如果删除成功,则返回true,否则返回false
	 */
	public boolean deleteVIPsFromDB(List vips){
		return vipDao.deleteVIPs(vips);
	}
	
	

}
