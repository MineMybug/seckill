package org.seckill.dto;

import org.seckill.entity.SuccessKilled;

/**
* @author rh
* @version 创建时间：2018年3月11日 上午12:07:35
* 封装秒杀执行后的结果
*/
public class SeckillExcutetion {

	private long seckillId;
	
	//秒杀执行结果状态
	private int state;

	//状态表示
	private String stateInfo;

	//秒杀成功对象
	private SuccessKilled successKilled;

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}

	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}

	public SeckillExcutetion(long seckillId, int state, String stateInfo, SuccessKilled successKilled) {
		super();
		this.seckillId = seckillId;
		this.state = state;
		this.stateInfo = stateInfo;
		this.successKilled = successKilled;
	}

	public SeckillExcutetion(long seckillId, int state, String stateInfo) {
		super();
		this.seckillId = seckillId;
		this.state = state;
		this.stateInfo = stateInfo;
	}
		
}
