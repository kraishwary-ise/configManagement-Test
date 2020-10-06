package com.comviva.ConfigurationApp.dao;

import java.util.List;

import com.comviva.ConfigurationApp.model.UseCase;

public interface UseCaseDao {
	
	
	
	public String saveUseCase(UseCase useCases);

	public List<UseCase> getUseCase(String userEmail);

	public void deleteUseCase(UseCase useCase);

}
