package com.bird.service;

import org.springframework.transaction.annotation.Transactional;

import com.bird.domain.LogBean;

/**
 * Description ��־����ӿ�
 * @author Administrator
 * 2012-9-16
 */
public interface LogService {

	/**
	 * ��־��¼
	 * @param log
	 */
    @Transactional  
	public void addLog(LogBean log); 
    
}
