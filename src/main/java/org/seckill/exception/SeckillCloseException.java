package org.seckill.exception;
/**
* @author rh
* @version 创建时间：2018年3月11日 上午12:17:25
* 秒杀关闭异常
*/
public class SeckillCloseException extends SeckillException{

	public SeckillCloseException(String message, Throwable cause) {
		super(message, cause);
	}

	public SeckillCloseException(String message) {
		super(message);
	}

}
