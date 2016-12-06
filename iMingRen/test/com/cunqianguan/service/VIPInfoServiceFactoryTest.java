package com.cunqianguan.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

import ren.iming.model.VIPInfo;
import ren.iming.service.VIPInfoService;
import ren.iming.service.VIPInfoServiceFactory;

public class VIPInfoServiceFactoryTest {

	@Test
	public void test() {
		VIPInfoServiceFactory vsf = VIPInfoServiceFactory.getInstance();
		VIPInfoService vs = vsf.getVIPInfoService();
		VIPInfo vi = new VIPInfo();
		vi.setAccount("15513814537");
		vi.seteMail("fuxiuyang100@sina.com");
		vi.setePassword("123456789**");
		vs.save2DB(vi);
		
		List<VIPInfo> vipInfos = vs.getListFromDB();
		for(int i = 0; i < vipInfos.size(); i ++){
			System.out.println(vipInfos.get(i).getAccount());
		}
		
	}

}
