package com.cunqianguan.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

import ren.iming.DAO.UserDAO;
import ren.iming.model.User;
import ren.iming.service.UserService;

public class UserServiceTest {

	@Test
	public void test() {
		UserDAO userDao = new UserDAO();
		UserService us = new UserService();
		us.setUserDao(userDao);
		List<User> list = us.getListFromDB();
		
		for(int i = 0; i < list.size(); i ++){
			System.out.println(list.get(i).getAccount());
		}
	}

}
