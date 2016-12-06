package ren.iming.service;
/**
 * 此时间列表是按时间的顺序进行插入的
 * @author xiuyang
 * @version 2016年11月23日
 */

public class TimeQueue{
	private Node head;						//设置时间队列的头部
	private static TimeQueue instance = new TimeQueue();	
	private TimeQueue(){
		head = new Node();
	}
	public static TimeQueue getInstance(){
		return instance;
	}
	public void clear() {
		// TODO Auto-generated method stub
		head.vip_account = null;
		head.endTime = 0;
		head.next = null;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head.next == null;
	}

	public int length() {
		// TODO Auto-generated method stub
		int length=0;
		Node p = head.next;
		while(p != null){
			length++;
			p = p.next;
		}
		return length;
	}

	public Node get(int i) throws Exception {
		// TODO Auto-generated method stub
		Node p = head.next;
		int j = 0;
		while(p != null && j < i){
			j++;
			p = p.next;
		}
		if(p == null || j > i){
			throw new Exception("TimeQueue中第"+i+"个元素不存在");
		}
		return p;
	}
	/**
	 * 获取列表中第一个元素
	 * @return
	 * @throws Exception
	 */
	public synchronized Node getFirst() throws Exception {
		// TODO Auto-generated method stub
		Node p = head;
		return p.next;
	}
	/**
	 * 按照时间的顺序进行插入
	 * @param vip_account
	 * @param endTime
	 * @throws Exception
	 */
	public synchronized void insert(String vip_account,long endTime) throws Exception {
		// TODO Auto-generated method stub
		Node p = head;
		Node q = p;
		while(p != null && p.endTime < endTime){
			q = p;
			p = p.next; 
		}
		Node s = new Node(vip_account,endTime);
		q.next = s;
		s.next = p;
	}
	public void remove(int i) throws Exception {
		// TODO Auto-generated method stub
		Node p = head;
		int j = 0;
		while(p != null && j < i){
			j++;
			p = p.next;
		}
		if(p == null || j > i){
			throw new Exception("TimeQueue列表移除时发生了异常");
		}
		p.next = p.next.next;
	}
	/**
	 * 移除列表中的第一个元素
	 * @throws Exception
	 */
	public synchronized void removeFirst() throws Exception {
		// TODO Auto-generated method stub
		Node p = head;
		p.next = p.next.next;
	}

	public int indexOf(long x) {
		// TODO Auto-generated method stub
		Node p = head.next;
		int j = 0;
		while(p != null && p.endTime != x){
			j++;
			p = p.next;
		}
		if(p == null){
			return -1;
		}
		else
			return j;
	}

	public void display() {
		// TODO Auto-generated method stub
		Node p = head.next;
		while(p != null){
			System.out.print(p.endTime+"\t");
			p = p.next;
		}
		System.out.println();
	}

}
