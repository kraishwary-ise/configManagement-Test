package com.comviva.ConfigurationApp.JsonService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.comviva.ConfigurationApp.model.UseCase;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class ExportJsonService {

	
	public void exportJsonService(UseCase useCase){
		JSONObject jsonData=new JSONObject();
		
		int ucId=useCase.getId();
		String name=useCase.getName();
		System.out.println("name passed ");
		jsonData.put("Name", name);
		String Desc=useCase.getDesc();
		jsonData.put("Desc", Desc);
		String sdate=useCase.getSdate();
		jsonData.put("Start Date", sdate);
		String edate=useCase.getEdate();
		jsonData.put("End Date", edate);
		String direction=useCase.getDirection();
		jsonData.put("Direction", direction);
		String campeing=useCase.getCampeing();
		jsonData.put("Campeing Objective", campeing);
		String businesslogic=useCase.getBusinesslog();
		jsonData.put("Business Group", businesslogic);
		String email=useCase.getUserEmail();
		jsonData.put("email", email);
		
		String path;
		
		
		path="C:\\Users\\himanshu.jain\\Desktop\\comviva-configuration-management\\ConfigurationApp\\"+useCase.getUserEmail();
		
		
		
		
		File file = new File(path);
		String filename="Uc-"+name+".json";

		String fullFileName=path+"\\"+filename;
		
		boolean fileExists=file.exists();
		if(!fileExists) {
		      boolean bool = file.mkdir();

		}
		try {
	        	BufferedWriter out = new BufferedWriter(new FileWriter(fullFileName));
	        	
	        	System.out.println("File Name"+fullFileName);
	            out.append(jsonData.toJSONString());
	            out.close();
	            
	        }
	        	
	        	
	        	
	        	catch (IOException e) {
	         e.printStackTrace();
	            System.out.println("writing problem");
	        }
	
	
	}
	
}
