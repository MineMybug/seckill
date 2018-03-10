package org.seckill.enums;
/**
* @author rh
* @version 创建时间：2018年3月11日 上午1:00:40
* 使用枚举表示常量
*/
public enum SeckillStateEnum {
	
	
}

//SUCCSS(1,"秒杀成功");
//END(0,"秒杀结束");
//REPEAT_KILL(-1,"重复秒杀");
//INNER_ERROR(-2,"系统异常");
//DATE_REWRITE(-3,"数据篡改");
//
//private int state;
//
//private String stateInfo;
//
//private SeckillStateEnum(int state, String stateInfo) {
//	this.state = state;
//	this.stateInfo = stateInfo;
//}
//
//public int getState() {
//	return state;
//}
//
//public void setState(int state) {
//	this.state = state;
//}
//
//public String getStateInfo() {
//	return stateInfo;
//}
//
//public void setStateInfo(String stateInfo) {
//	this.stateInfo = stateInfo;
//}
//
//public static SeckillStateEnum stateOf(int index){
//	for(SeckillStateEnum state : values()){
//		return state;
//	}
//}