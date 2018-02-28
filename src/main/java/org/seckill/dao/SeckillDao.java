package org.seckill.dao;

import java.util.Date;
import java.util.List;

import org.seckill.entity.Seckill;

/**
* @author rh
* @version 创建时间：2018年2月28日 下午10:22:28
*/
public interface SeckillDao {

	/**
	 * 减库存
	 * @param seckillId
	 * @param killTime
	 * @return
	 */
	int reduceNumber(long seckillId, Date killTime);
	
	/**
	 * 根据ID查询秒杀对象
	 * @param seckillId
	 * @return
	 */
	Seckill qureyById(long seckillId);
	
	/**
	 * 根据偏移量查询秒杀商品列表
	 * @param offet
	 * @param limit
	 * @return
	 */
	List<Seckill> queryAll(int offet,int limit);
}
