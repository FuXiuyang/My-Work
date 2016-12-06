package com.cunqianguan.DAOtest;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.Test;

import ren.iming.DAO.IQiYiVIPDAO;
import ren.iming.DAO.VIPDAO;
import ren.iming.DAO.VIPInfoDAO;
import ren.iming.model.IQiYiVIP;
import ren.iming.model.VIP;
import ren.iming.model.VIPInfo;

public class VIPInfoDAOTest {

	@Test
	public void test() {
		VIPInfo vipInfo = new VIPInfo();
		vipInfo.setAccount("15513814537");
		vipInfo.seteMail("fuxiuyang100");
		vipInfo.setePassword("123456789**");
		VIPInfoDAO vipInfoDao = new VIPInfoDAO();
		vipInfoDao.saveOrUpdateVIPInfo(vipInfo);
	}

}
