package com.comviva.ConfigurationApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comviva.ConfigurationApp.dao.TriggerDao;
import com.comviva.ConfigurationApp.dao.UseCaseDao;
import com.comviva.ConfigurationApp.model.TriggerLib;
import com.comviva.ConfigurationApp.response.NameEmail;

@Service
public class TriggerService {
	
	@Autowired
	private TriggerDao triggerDao;
	

	public List<TriggerLib> getTrigger() {
	
		return triggerDao.getTrigger();
		
	}


	public void saveTrigger(NameEmail nameEmail[]) {
		
		triggerDao.saveTrigger(nameEmail);
		
	}
	
	
	
	
	

}
