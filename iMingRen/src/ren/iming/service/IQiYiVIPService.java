package ren.iming.service;

import java.util.List;

import ren.iming.DAO.IQiYiVIPDAO;
import ren.iming.DAO.VIPDAO;
import ren.iming.model.IQiYiVIP;
import ren.iming.model.VIP;

public class IQiYiVIPService extends VIPService{
	private VIPQueue vipList;
	public IQiYiVIPService(){
		vipList = IQiYiVIPQueue.getInstance();
	}
	public IQiYiVIPService(IQiYiVIPDAO vipDao){
		super(vipDao);
		vipList = IQiYiVIPQueue.getInstance();
	}
	public IQiYiVIPService(IQiYiVIPDAO vipDao,IQiYiVIP vip){
		super(vipDao,vip);
		vipList = IQiYiVIPQueue.getInstance();
	}
	
	//通过传参的方式将VIP设置到VIP队列中
	public boolean setVip2Queue(VIP vip){
		return vipList.setVIP(vip);
	}
	//通过VIP列表将VIP对象批量的设置到VIP队列中
	public boolean setVips2Queue(List<VIP> vips){
		for(int i =0;i < vips.size();i++){
			if(!setVip2Queue(vips.get(i))){
				return false;
			}
		}
		return true;
	}
	//返回VIP队列中第一个元素
	public VIP getVipFromQueue(){
		return vipList.getVIP();
	}
		
	

}
