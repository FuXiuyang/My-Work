package ren.iming.service;
/**
 * 会员时间队列列表每个节点的元素
 * @author xiuyang
 * @version 2016年11月23日
 */

public class Node {
	public String vip_account;
	public long endTime;
	public Node next;
	
	public Node(){
		this(null,0,null);
	}
	
	public Node(String vip_account,long endTime){
		this(vip_account,endTime,null);
	}

	public Node(String vip_account,long endTime,Node next) {
		// TODO Auto-generated constructor stub
		this.vip_account = vip_account;
		this.endTime = endTime;
		this.next = next;
	}
}
