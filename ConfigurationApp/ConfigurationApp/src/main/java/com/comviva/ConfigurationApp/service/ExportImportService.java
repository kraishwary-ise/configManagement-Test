package com.comviva.ConfigurationApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comviva.ConfigurationApp.dao.ExportImportDao;

@Service
public class ExportImportService {
	
	@Autowired
	private  ExportImportDao exportImportDao;
	

}
