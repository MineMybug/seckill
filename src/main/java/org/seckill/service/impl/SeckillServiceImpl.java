package org.seckill.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.reflection.wrapper.BaseWrapper;
import org.junit.experimental.theories.Theories;
import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExcution;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStateEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

/**
* @author rh
* @version 创建时间：2018年3月11日 上午12:22:40
* 
* @Componet (不知道是什么,用这个注解)
*/
@Service
public class SeckillServiceImpl implements SeckillService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired  
	private SeckillDao seckillDao;
	@Autowired
	private SuccessKilledDao successKilledDao;
	
	//MD5盐值字符串，用于混淆MD5
	private final String slat = "13%$5354sad~!^&&";
	
	@Override
	public List<Seckill> getSeckillList() {

		return seckillDao.queryAll(0, 4);
	}

	@Override
	public Seckill getById(long seckillId) {

		return seckillDao.qureyById(seckillId);
	}

	@Override
	public Exposer exportSeckillUrl(long seckillId) {

		Seckill seckill = seckillDao.qureyById(seckillId);
		if(seckill ==null){
			return new Exposer(false, seckillId);
		}
		Date startTime = seckill.getStartTime();
		Date endTime = seckill.getEndTime();
		
		//获取当前时间
		Date nowTime = new Date();
		if(nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()){
			return new Exposer(false,seckillId,nowTime.getTime(),startTime.getTime(),endTime.getTime());
		}
		//轉化特定字符的過程，不可逆
		String md5 = getMd5(seckillId);
		return new Exposer(true,md5,seckillId);
	}
	
	private String getMd5(long seckillId){
		String base = seckillId + "/" + slat;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}

	@Override
	@Transactional
	/**
	 * 使用註解控制事务方法的优点
	 */
	public SeckillExcution executeSeckill(long seckillId, long userPhone, String md5)
			throws SecurityException, RepeatKillException, SeckillCloseException {

		if(md5 == null || !md5.equals(getMd5(seckillId)) ){
			throw new SeckillException("seckill data rewrite");
		}
		
		//执行秒杀逻辑：减库存 + 记录购买明细
		Date nowTime = new Date();
		
		try {
			//减库存
			int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
			if(updateCount <= 0){
				//没有更新记录
				throw new SeckillCloseException("seckill is closed");
			}else{
				//记录购买行为
				int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
				//唯一： seckillID + userPhone
				if(insertCount <= 0){
					//重复秒杀
					throw new RepeatKillException("seckill repeated");
				}else{
					//秒杀成功
					SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
					return new SeckillExcution(seckillId, SeckillStateEnum.SUCCESS, successKilled);
				}
			}
		}catch(SeckillCloseException e1){
			throw e1;
		}catch (RepeatKillException e2) {
			throw e2;
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			//所有编译器异常，转化运行期异常
			throw new SeckillException("seckill inner error", e);	
		}
				
	}

}
