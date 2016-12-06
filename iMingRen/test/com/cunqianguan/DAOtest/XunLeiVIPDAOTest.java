package com.cunqianguan.DAOtest;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import ren.iming.DAO.IQiYiVIPDAO;
import ren.iming.DAO.UserDAO;
import ren.iming.DAO.VIPDAO;
import ren.iming.DAO.XunLeiVIPDAO;
import ren.iming.model.IQiYiVIP;
import ren.iming.model.User;
import ren.iming.model.VIP;
import ren.iming.model.XunLeiVIP;

public class XunLeiVIPDAOTest {

	@Test
	public void saveTest() {
		VIP xlVip = new XunLeiVIP();
		xlVip.setAccount("xunlei1");
		xlVip.setPassword("xunlei1");
		xlVip.setEndDate(new Date());
		VIPDAO xlVipDao = new XunLeiVIPDAO();
		xlVipDao.saveOrUpdateVIP(xlVip);
		System.out.println("XunLeiVIPDAO saveOrUpDate is OK!");
	}
	
	@Test
	public void getTest(){
		VIPDAO xlVipDao = new XunLeiVIPDAO();
		xlVipDao.getVIPList();
		System.out.println("XunLeiVIPDAO getVIPList is OK!");
	}

}
