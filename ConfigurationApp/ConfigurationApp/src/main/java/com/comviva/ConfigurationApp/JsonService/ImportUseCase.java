package com.comviva.ConfigurationApp.JsonService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.comviva.ConfigurationApp.model.UseCase;

public class ImportUseCase {

	public List<UseCase> readAllFile(String userEmail)  {
		
		String path="C:\\Users\\himanshu.jain\\Desktop\\comviva-configuration-management\\ConfigurationApp\\"+userEmail;
		
		File folder = new File(path);
		
		JSONParser parser = new JSONParser();
		
		List<UseCase> usecases = new ArrayList<UseCase>(); 
		
		File[] listOfFiles = folder.listFiles();
		
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	
		    	try {
					Object obj = parser.parse(new FileReader(file));
					JSONObject jsonObject = (JSONObject)obj;
					
					String name=(String) jsonObject.get("Name");
					
					String descr=(String) jsonObject.get("Desc");
					
					String sDate = (String) jsonObject.get("Start Date");
					
					String campeingObjective = (String) jsonObject.get("Campeing Objective");
					
					String eDate = (String) jsonObject.get("End Date");
					
					String businessGroup = (String) jsonObject.get("Business Group");
					
					String Direction = (String) jsonObject.get("Direction");
					
					usecases.add(new UseCase(name, descr, sDate, eDate,  Direction,campeingObjective,businessGroup,userEmail));
					
				} catch (FileNotFoundException e) {
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
		    	
		    	
		    }
		}
		return usecases;

		
		
		
	}

}
