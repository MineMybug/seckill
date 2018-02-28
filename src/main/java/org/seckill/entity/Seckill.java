package org.seckill.entity;

import java.util.Date;

/**
* @author rh
* @version 创建时间：2018年2月28日 下午10:15:56
*/
public class Seckill {
	
	private long seckill_id;
	
	private String name;
	
	private int number;
	
	private Date startTime;
	
	private Date endTime;
	
	private Date createTime;

	public long getSeckill_id() {
		return seckill_id;
	}

	public void setSeckill_id(long seckill_id) {
		this.seckill_id = seckill_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Seckill [seckill_id=" + seckill_id + ", name=" + name + ", number=" + number + ", startTime="
				+ startTime + ", endTime=" + endTime + ", createTime=" + createTime + "]";
	}
}
