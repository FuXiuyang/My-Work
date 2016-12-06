package com.cunqianguan.DAOtest;

import static org.junit.Assert.*;

import org.junit.Test;

import ren.iming.DAO.UserDAO;
import ren.iming.model.User;

public class UserDAOTest {

	@Test
	public void test() {
/*		User user = new User();
		user.setAccount("111");
		user.setPassword("22233");
		user.setiQiYiTime(333);
		user.setXunLeiTime(444);
		UserDAO userDAO = new UserDAO(user);
		userDAO.saveOrUpdateUser();*/
		User user = new User();
		user.setAccount("121");
		user.setPassword("212");
		user.setiQiYiTime(213);
		user.setXunLeiTime(324);
		user.setHoldIQiYi(false);
		user.setHoldXunLei(false);
		UserDAO userDAO = new UserDAO(user);
		userDAO.saveOrUpdateUser();
//		userDAO.deleteUser();
	}

}
