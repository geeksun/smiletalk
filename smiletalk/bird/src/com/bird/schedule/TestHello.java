package com.bird.schedule;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ambow.log.util.LogUtil;
import com.ambow.log.vo.PropertiesBean;

public class TestHello {
	
	public static void main(String[] args) {
		// 加载配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("application-timer.xml");   
		System.out.println("*****完毕******");
		
		PropertiesBean propertiesBean = (PropertiesBean) context.getBean("propertiesBean");
		String filterFields = propertiesBean.getFilterFields();
		if(!LogUtil.isBlank(filterFields)){
			if(filterFields.contains("&&")){
				for(String str:filterFields.split("&&")){
					System.out.println(str);
				}
			}else{
				System.out.println(filterFields);
			}
		}
		
		
	}

}
