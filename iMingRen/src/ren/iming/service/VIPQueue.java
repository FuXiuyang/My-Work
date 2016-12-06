package ren.iming.service;
/*
 * @Date: 2016年11月4日 18:29:11
 * @author: xiuyang
 * @function: 实现多线程安全下,VIP加入队列和取出队列.该类为单例模式,主要是因为,所有线程所需要的数据一样.
 */
import java.util.concurrent.ConcurrentLinkedQueue;

import ren.iming.model.VIP;


public interface VIPQueue {
	//获取vip,返回值为VIP对象
	public VIP getVIP();
	//设置vip,设置成功返回ture,设置失败返回false
	public boolean setVIP(VIP vip);
}
