package com.comviva.ConfigurationApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comviva.ConfigurationApp.model.TriggerLib;
import com.comviva.ConfigurationApp.response.NameEmail;
import com.comviva.ConfigurationApp.service.TriggerService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class TriggerController {
	
	@Autowired
	private TriggerService triggerService;
	
	@CrossOrigin(origins = "http://localhost:4200")

	@GetMapping("/getTrigger") 
	public List<TriggerLib> getTrigger() {
		
		
		return triggerService.getTrigger();
		
		
	}
	

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/saveTrigger")
	public void saveTrigger(@RequestBody NameEmail[] nameEmail) {
		
		System.out.println("in save");
		
		System.out.println(nameEmail.length);
		
		System.out.println(nameEmail[0].getTriggerName());
		
		
		triggerService.saveTrigger(nameEmail);
		
		
		
		
	}
	
		
		
		
	
		
	


}
