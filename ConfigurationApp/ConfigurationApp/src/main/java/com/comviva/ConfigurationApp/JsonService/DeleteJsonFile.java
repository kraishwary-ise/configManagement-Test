package com.comviva.ConfigurationApp.JsonService;

import java.io.File;

import com.comviva.ConfigurationApp.model.UseCase;

public class DeleteJsonFile {

	public void DeleteJsonFile(UseCase useCase) {
		
		try  
		{         
		String path="C:\\Users\\himanshu.jain\\Desktop\\comviva-configuration-management\\ConfigurationApp\\"+useCase.getUserEmail();
		String name=useCase.getName();
		String filename="Uc-"+name+".json";
		String fullFileName=path+"\\"+filename;
		File file = new File(fullFileName);
		if(file.delete())                        
		{  
		System.out.println(file.getName() + " deleted");     
		}  
		else  
		{  
		System.out.println("failed");  
		}  
		}  
		catch(Exception e)  
		{  
		e.printStackTrace();  
		}  
		
	}

}
