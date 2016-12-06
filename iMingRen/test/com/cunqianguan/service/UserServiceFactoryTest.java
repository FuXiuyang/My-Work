package com.cunqianguan.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

import ren.iming.model.User;
import ren.iming.service.UserService;
import ren.iming.service.UserServiceFactory;

public class UserServiceFactoryTest {

	@Test
	public void test() {
		UserServiceFactory usf = UserServiceFactory.getInstance();
		UserService us = usf.getUserService();
		List<User> users = us.getListFromDB();
		for(int i = 0; i < users.size(); i ++){
			System.out.println(users.get(i).getAccount());
		}
		
	}

}
