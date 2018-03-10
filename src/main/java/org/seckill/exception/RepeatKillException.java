package org.seckill.exception;
/**
* @author rh
* @version 创建时间：2018年3月11日 上午12:14:10
* 重复秒杀异常（运行期异常）
*/
public class RepeatKillException extends SeckillException{

	public RepeatKillException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepeatKillException(String message) {
		super(message);
	}
	
}
