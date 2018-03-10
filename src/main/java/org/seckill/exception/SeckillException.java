package org.seckill.exception;
/**
* @author rh
* @version 创建时间：2018年3月11日 上午12:18:37
* 秒杀相关业务异常
*/
public class SeckillException extends RuntimeException{

	public SeckillException(String message, Throwable cause) {
		super(message, cause);
	}

	public SeckillException(String message) {
		super(message);
	}

}
