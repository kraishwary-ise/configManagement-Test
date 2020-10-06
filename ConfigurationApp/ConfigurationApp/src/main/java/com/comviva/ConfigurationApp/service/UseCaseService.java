package com.comviva.ConfigurationApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comviva.ConfigurationApp.dao.UseCaseDao;
import com.comviva.ConfigurationApp.model.UseCase;

@Service
public class UseCaseService {
	
	
	@Autowired
	private UseCaseDao userCaseDao;
	
	
	public String saveUseCase(UseCase useCase) {
		
		
		return userCaseDao.saveUseCase(useCase);
		
		
		
	}


	public List<UseCase> getUseCase(String userEmail) {
		return userCaseDao.getUseCase(userEmail);
	}


	public void deleteUseCase(UseCase useCase) {
		
		userCaseDao.deleteUseCase(useCase);
		
	}

}
