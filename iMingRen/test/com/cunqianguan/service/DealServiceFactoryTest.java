package com.cunqianguan.service;

import java.util.List;

import org.junit.Test;

import ren.iming.model.Deal;
import ren.iming.service.DealService;
import ren.iming.service.DealServiceFactory;

public class DealServiceFactoryTest {

	@Test
	public void test() {
		DealServiceFactory usf = DealServiceFactory.getInstance();
		DealService ds = usf.getDealService();
		List<Deal> deals = ds.getDeal("12");
		for(int i = 0; i < deals.size(); i ++){
			System.out.println(deals.get(i).getSum());
		}
		
	}

}
