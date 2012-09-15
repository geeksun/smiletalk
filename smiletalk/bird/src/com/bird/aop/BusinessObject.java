package com.bird.aop;


/**
 * Description 业务对象
 * @author Administrator
 * 2012-9-15
 */
public class BusinessObject implements BusinessInterface {

	public void processBusiness(){
		//business processing
		System.out.println("here is business logic");
	}

}
