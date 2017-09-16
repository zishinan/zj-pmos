package com.common.jz.oa.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.common.jz.oa.dao.IntentionWorkerDao;
import com.common.jz.oa.model.IntentionWorker;

@Service
@Transactional(rollbackFor={Exception.class, RuntimeException.class})
public class IntentionWorkerService {
	private static final Logger logger = Logger.getLogger(IntentionWorkerService.class);
	@Autowired
	private IntentionWorkerDao intentionWorkerDao;
	
	public void add(IntentionWorker intentionWorker){
		intentionWorkerDao.save(intentionWorker);
		logger.info("add "+JSON.toJSONString(intentionWorker));
	}
}
