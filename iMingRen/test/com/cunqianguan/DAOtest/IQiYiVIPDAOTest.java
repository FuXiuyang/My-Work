package com.cunqianguan.DAOtest;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import ren.iming.DAO.IQiYiVIPDAO;
import ren.iming.DAO.UserDAO;
import ren.iming.DAO.VIPDAO;
import ren.iming.model.IQiYiVIP;
import ren.iming.model.User;
import ren.iming.model.VIP;

public class IQiYiVIPDAOTest {

	@Test
	public void saveTest() {
		VIP iVip = new IQiYiVIP();
		iVip.setAccount("iqiyi2");
		iVip.setPassword("iqiyi2");
		iVip.setEndDate(new Date());
		VIPDAO iVipDao = new IQiYiVIPDAO();
		iVipDao.saveOrUpdateVIP(iVip);
		System.out.println("IQiYiVIPDAO saveOrUpDate is OK!");
	}
	
	@Test
	public void getTest(){
		VIPDAO iVipDao = new IQiYiVIPDAO();
		iVipDao.getVIPList();
		System.out.println("IQiYiVIPDAO getVIPList is OK!");
	}

}
