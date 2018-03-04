package org.seckill.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* @author rh
* @version 创建时间：2018年3月4日 下午6:56:31
*/
//配置spring和junit整合，junit启动时加载springIoc容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉 junit spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SuccessKilledDaoTest {
	
	@Resource
	private SuccessKilledDao successKilledDao;
	
	@Test
	public void testInsertSuccessKilled(){
		long seckillId = 1000l;
		long userPhone = 283605776601l;
		int insertNum = successKilledDao.insertSuccessKilled(seckillId, userPhone);
		System.out.println(insertNum);
	}
	
	@Test
	public void testQueryByIdWithSeckill(){
		long seckillId = 1000l;
		long userPhone = 283605776601l;
		SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
		System.out.println(successKilled);
		System.out.println(successKilled.getSeckill());
	}

}
