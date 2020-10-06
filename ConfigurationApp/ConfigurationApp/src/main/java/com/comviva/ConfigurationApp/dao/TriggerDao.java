package com.comviva.ConfigurationApp.dao;

import java.util.List;

import com.comviva.ConfigurationApp.model.TriggerLib;
import com.comviva.ConfigurationApp.response.NameEmail;

public interface TriggerDao {
	
	
	
	public List<TriggerLib> getTrigger();

	public void saveTrigger(NameEmail nameEmail[]);

}
