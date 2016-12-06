package com.cunqianguan.DAOtest;

import org.junit.Test;
import ren.iming.DAO.EVIPAccountDAO;
import ren.iming.model.EVIPAccount;

public class EVIPAccountDAOTest {

	@Test
	public void test() {
		/*EVIPAccount eVIP = new EVIPAccount();
		eVIP.setAccount("12");
		EVIPAccountDAO eVIPDao = new EVIPAccountDAO();
		eVIPDao.saveOrUpdateEVIPAccount(eVIP);*/
		EVIPAccountDAO eVIPDao = new EVIPAccountDAO();
		System.out.println(eVIPDao.getFirstEVIPAccount());
	}

}
