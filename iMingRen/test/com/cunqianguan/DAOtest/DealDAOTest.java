package com.cunqianguan.DAOtest;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.Test;

import ren.iming.DAO.DealDAO;
import ren.iming.model.Deal;

public class DealDAOTest {


	@Test
	public void test() {
		Deal deal = new Deal();
		/*deal.setDeal_time(new Date());
		deal.setSum(0.3);
		deal.setUser_account("12");
		deal.setVip_account("222");
		deal.setVip_password("222");*/
		
		DealDAO dealDao = new DealDAO();
//		dealDao.saveOrUpdateDeal(deal);
		System.out.println(dealDao.getUserByUserId("12"));
//		System.out.println(new Date());
	}

}
