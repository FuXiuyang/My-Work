package com.cunqianguan.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

import ren.iming.DAO.IQiYiVIPDAO;
import ren.iming.DAO.UserDAO;
import ren.iming.DAO.VIPDAO;
import ren.iming.DAO.XunLeiVIPDAO;
import ren.iming.model.IQiYiVIP;
import ren.iming.model.User;
import ren.iming.model.VIP;
import ren.iming.model.XunLeiVIP;
import ren.iming.service.IQiYiVIPService;
import ren.iming.service.VIPService;

public class VIPServiceTest {

	@Test
	public void test() {
		/*
		 * 第一种方法,采用构造函数来设置DAO的值
		 * IQiYiVIPDAO iVipDao = new IQiYiVIPDAO();
		VIPService vs = new VIPService(iVipDao);
		vs.setVips2Queue(vs.getVipsFromDB());
		System.out.println(vs.getVipFromQueue().getAccount());*/

//		第二种方法通过set方法设置DAO的值
		/*VIPDAO iVipDao = new IQiYiVIPDAO();
		VIPService vs = new XunLeiVIPService();
		vs.setVipDao(iVipDao);
		vs.setVips2Queue(vs.getVipsFromDB());
		System.out.println(vs.getVipFromQueue().getAccount());
		
		
		VIPDAO xlVipDao = new XunLeiVIPDAO();
		vs.setVipDao(xlVipDao);
		vs.setVips2Queue(vs.getVipsFromDB());
		System.out.println(vs.getVipFromQueue().getAccount());
		System.out.println(vs.getVipFromQueue().getAccount());*/
		VIPService vs = new IQiYiVIPService();
		VIPDAO vd = new XunLeiVIPDAO();
		vs.setVipDao(vd);
		List<VIP> list = vs.getVipsFromDB();
		for(int i = 0; i < list.size(); i ++){
			System.out.println(list.get(i).getAccount());
		}
		

	}

}
