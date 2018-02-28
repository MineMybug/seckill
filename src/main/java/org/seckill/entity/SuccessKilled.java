package org.seckill.entity;

import java.util.Date;

/**
* @author rh
* @version 创建时间：2018年2月28日 下午10:19:05
*/
public class SuccessKilled {

	private long seckill_id;
	
	private long userPhone;
	
	private short state;
	
	private Date createTime;

	private Seckill seckill;
		
	public long getSeckill_id() {
		return seckill_id;
	}

	public void setSeckill_id(long seckill_id) {
		this.seckill_id = seckill_id;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public short getState() {
		return state;
	}

	public void setState(short state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Seckill getSeckill() {
		return seckill;
	}

	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}

	@Override
	public String toString() {
		return "SuccessKilled [seckill_id=" + seckill_id + ", userPhone=" + userPhone + ", state=" + state
				+ ", createTime=" + createTime + "]";
	}	
}
