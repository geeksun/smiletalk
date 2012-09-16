package com.bird.service.impl;

import com.bird.dao.LogDao;
import com.bird.domain.LogBean;
import com.bird.service.LogService;

public class LogServiceImpl implements LogService {
	
	private LogDao logDao;
	
	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}

	@Override
	public void addLog(LogBean log) {
		logDao.addLog(log);
	}

}
