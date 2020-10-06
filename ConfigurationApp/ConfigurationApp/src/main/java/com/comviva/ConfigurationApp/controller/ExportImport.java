package com.comviva.ConfigurationApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comviva.ConfigurationApp.JsonService.DeleteJsonFile;
import com.comviva.ConfigurationApp.JsonService.ExportJsonService;
import com.comviva.ConfigurationApp.JsonService.ImportUseCase;
import com.comviva.ConfigurationApp.model.UseCase;
import com.comviva.ConfigurationApp.service.ExportImportService;
import com.comviva.ConfigurationApp.service.UseCaseService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class ExportImport {
	
	@Autowired
	private ExportImportService exportImport;
	
	@Autowired
	private UseCaseService useCaseService;
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")

	@PostMapping("/Export")
	public void exportUseCase(@RequestBody UseCase useCase) {
		
		System.out.println(useCase.getName());
		
		System.out.println(useCase.getUserEmail());
		
		System.out.println("print ID" + useCase.getId());
		
		
		
		ExportJsonService usecase = new  ExportJsonService();
	
		usecase.exportJsonService(useCase);
		
		
	}
	
	@PostMapping("/deleteExport")
	public void deleteExport(@RequestBody UseCase useCase) {
		
		System.out.println("in delete file");
		
		DeleteJsonFile jsonFile = new  DeleteJsonFile();
	
		jsonFile.DeleteJsonFile(useCase);
		
		
	}
	
	@PostMapping("/importUseCase")
	public void importUseCase(@RequestBody  String userEmail ) {
		
		ImportUseCase importUseCase = new ImportUseCase();
		
		
		List<UseCase> usecases=importUseCase.readAllFile(userEmail);
		
		for(UseCase u:usecases) {
			
			useCaseService.saveUseCase(u);
			
			
		}
		
	}
		


}
