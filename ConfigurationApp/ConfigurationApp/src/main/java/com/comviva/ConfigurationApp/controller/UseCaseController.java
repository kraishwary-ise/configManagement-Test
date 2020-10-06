package com.comviva.ConfigurationApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comviva.ConfigurationApp.model.UseCase;
import com.comviva.ConfigurationApp.response.StringResponse;
import com.comviva.ConfigurationApp.service.UseCaseService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class UseCaseController {
	
	@Autowired
	private UseCaseService useCaseService;
		

	@PostMapping("/usecase")
	public StringResponse  saveUseCase(@RequestBody UseCase useCase) {
		
		
		System.out.println(useCase.toString());
		
		String res = useCaseService.saveUseCase(useCase);
		
		StringResponse response=new StringResponse(res);
		
		response.setName(useCase.getName());
		
		response.setResponse(res);
		
		return response;
}
	
	@PostMapping("/dashboard")
	public List<UseCase> getUseCase(@RequestBody String userEmail) {
		
		
		
		System.out.println(userEmail);
		
		return useCaseService.getUseCase(userEmail);
	}
	
	@PostMapping("/delete")
	public void  deleteUseCase(@RequestBody UseCase useCase) {
		
		useCaseService.deleteUseCase(useCase);
		
		

		
		
		
	}
	
}
