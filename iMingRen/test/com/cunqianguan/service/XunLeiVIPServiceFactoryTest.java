package com.cunqianguan.service;

import java.util.List;

import org.junit.Test;

import ren.iming.model.Deal;
import ren.iming.model.VIP;
import ren.iming.service.VIPService;
import ren.iming.service.XunLeiVIPServiceFactory;

public class XunLeiVIPServiceFactoryTest {

	@Test
	public void test() {
		XunLeiVIPServiceFactory isf = XunLeiVIPServiceFactory.getInstance();
		VIPService vipser = isf.getXunLeiVIPService();
		List<VIP> vips = vipser.getVipsFromDB();
		for(int i = 0; i < vips.size(); i ++){
			System.out.println(vips.get(i).getAccount());
		}
		
	}

}
