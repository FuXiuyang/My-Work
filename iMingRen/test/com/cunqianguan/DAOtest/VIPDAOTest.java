package com.cunqianguan.DAOtest;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.Test;

import ren.iming.DAO.IQiYiVIPDAO;
import ren.iming.DAO.VIPDAO;
import ren.iming.model.IQiYiVIP;
import ren.iming.model.VIP;

public class VIPDAOTest {

	@Test
	public void test() {
		VIP vip = new IQiYiVIP();
		vip.setAccount("15513814537");
		vip.setPassword("Iup2MNmzB");
		vip.setEndDate(new Date());
		VIPDAO vipDao = new IQiYiVIPDAO();
		vipDao.saveOrUpdateVIP(vip);
	}

}
