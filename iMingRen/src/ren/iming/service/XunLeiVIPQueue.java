package ren.iming.service;
/*
 * @Date: 2016年11月4日 18:29:11
 * @author: xiuyang
 * @function: 实现多线程安全下,VIP加入队列和取出队列.该类为单例模式,主要是因为,所有线程所需要的数据一样.
 */
import java.util.concurrent.ConcurrentLinkedQueue;

import ren.iming.model.VIP;


public class XunLeiVIPQueue implements VIPQueue{
	
	//这个类是多线程安全的队列
	private static ConcurrentLinkedQueue<VIP> vipList;
	private static XunLeiVIPQueue instance = new XunLeiVIPQueue();
	private XunLeiVIPQueue(){
		vipList = new ConcurrentLinkedQueue<VIP>();
	}
	public static XunLeiVIPQueue getInstance(){
		return instance;
	}
	//获取vip,返回值为VIP对象
	public synchronized VIP getVIP(){
		return vipList.poll();
	}
	//设置vip,设置成功返回ture,设置失败返回false
	public synchronized boolean setVIP(VIP vip){
		return vipList.offer(vip);	
	}
	/**
	 * 获取队列大小
	 * @return 获取队列的大小
	 */
	public synchronized int size() {
		return vipList.size();
	}
}
