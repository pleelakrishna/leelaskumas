package com.charvikent.issuetracking.config;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilesStuff {
	
	@Autowired
	HttpServletRequest request;
	
	List<String>  fileNames = new ArrayList<String>();    //Global variable
	
	/** Here rename the existing file.
	 * @param fileName     user browsed file name
	 * @return     getTime() return value added to  @param fileName before "."
	 */
	public String renameFile(String fileName)
	{
		String extension = "";
		String name = "";
		
		int idxOfDot = fileName.lastIndexOf('.'); 
		extension = fileName.substring(idxOfDot + 1);
		name = fileName.substring(0, idxOfDot);
		 Date d= new Date();
		    fileName = name+d.getTime()+"."+extension;
		
	return fileName;	
	}
	
	
	/** here defined customized  fixed directory
	 * @return name of directory 
	 */
	public  File   makeDirectory()
	{
		 String path = request.getServletContext().getRealPath("/");
    	 File dir = new File (path +"reportDocuments");
    	 if (!dir.exists()) {
				dir.mkdirs();
			}
    	 
    	 return dir;
	}
	
	
	
	/** here checking file exists or not.
	 * 
	 * here control go to multipart loop in controller layer
	 * @param fileName
	 * @return   file that to be transfer to directory.
	 */
	public File moveFileTodir(String fileName)
	{
		File dir=makeDirectory();
		File  moveFile = new File(dir,fileName);
		if(moveFile.exists()){
			  System.out.println("file exists already");
			 String reNamedFile=renameFile(fileName);
			 fileNames.add(reNamedFile);
			  moveFile = new File(dir,reNamedFile);
			  return moveFile;
		  }
		  else
		  {
			 fileNames.add(fileName);
		 return moveFile;
		  }
	}
	
	
 /*  
  * here we combined all files name.
  * 
  * assign return value to particular filed of model class in dao layer
  * 
  */
	
	public String concurrentFileNames()
	{
		String sfn ="";
        for(String files: fileNames)
        {
        	sfn=sfn+files+"*"; 
        }
        String sfn2=sfn.substring(0,sfn.length()-1);
 
         System.out.println(sfn);
         System.out.println(sfn2);
		
		return sfn2;
	}
	
	
	/**call this method after concurrentFileNames() insertion in dao layer
	 * 
	 */
	public void clearFiles()
	{
		 fileNames.clear();
		
	}


}
