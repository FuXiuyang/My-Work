package com.cunqianguan.service;

import java.util.List;

import org.junit.Test;

import ren.iming.model.Deal;
import ren.iming.model.VIP;
import ren.iming.service.IQiYiVIPServiceFactory;
import ren.iming.service.VIPService;

public class IQiYiVIPServiceFactoryTest {

	@Test
	public void test() {
		IQiYiVIPServiceFactory isf = IQiYiVIPServiceFactory.getInstance();
		VIPService vipser = isf.getIQiYiVIPService();
		List<VIP> vips = vipser.getVipsFromDB();
		for(int i = 0; i < vips.size(); i ++){
			System.out.println(vips.get(i).getAccount());
		}
		
	}

}
