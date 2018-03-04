package org.seckill.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* @author rh
* @version 创建时间：2018年3月4日 下午2:56:42
*/
//配置spring和junit整合，junit启动时加载springIoc容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉 junit spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillDaoTest {

	//注入Dao实现类
	@Resource
	private SeckillDao seckillDao;
	
	@Test
	public void testReduceNumber(){
		Date killTime = new Date();
		int result = seckillDao.reduceNumber(1000l, killTime);
		System.out.println(result);
	}
	
	@Test
	public void testQueryById(){
		long id = 1000;
		Seckill seckill = seckillDao.qureyById(id);
		System.out.println(seckill.getName());
		System.out.println(seckill);
	}
	
	@Test
	public void testQueryAll(){
		List<Seckill> seckills = seckillDao.queryAll(0,100);
		for(Seckill seckill : seckills){
			System.out.println(seckill);
		}
	}
	
}
