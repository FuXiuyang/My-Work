package com.cunqianguan.service;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import ren.iming.model.Token;
import ren.iming.service.TokenMap;

public class TokenMapTest {


	@Test
	public void test() {
		String tokenStr = "111";
		String accountStr = "222";
		Token token = new Token(tokenStr,accountStr);
		
		TokenMap tm01 = TokenMap.getInstance();
		tm01.setToken(token);
		TokenMap tm02 = TokenMap.getInstance();
		System.out.println(tm01 == tm02);
		System.out.println(tm02.getToken(tokenStr).getAccount());
	}

}
