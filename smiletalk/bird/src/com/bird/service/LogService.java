package com.bird.service;

import org.springframework.transaction.annotation.Transactional;

import com.bird.domain.LogBean;

/**
 * Description 日志服务接口
 * @author Administrator
 * 2012-9-16
 */
public interface LogService {

	/**
	 * 日志记录
	 * @param log
	 */
    @Transactional  
	public void addLog(LogBean log); 
    
}
