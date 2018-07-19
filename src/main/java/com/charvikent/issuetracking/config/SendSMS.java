package com.charvikent.issuetracking.config;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Component
public class SendSMS {
	
	
	@Autowired
	private Environment env;
	
	
	
	//public  String  mobileNumber =null;
	//static String username = "KumarPumps";
	//static String password = "Tallygems@9";
		//static String from = "mtmrph";
		
		//String username = environment.getProperty("app.smsusername");
		//String password = environment.getProperty("app.smspassword");
		
		//static String from = "KPTMS";
		//static String from = "AARNA-MATRIMONY";
	    static String requestUrl = null;
	    static String toAddress = null;
	    
	     //public String message=null;
	    
	    
	    
	    
	    
	    public String sendSMS(String message, String mobileNumber) throws IOException
		{
	    	String username =env.getProperty("app.smsusername");
	    	String password =env.getProperty("app.smspassword");
	    	String from =env.getProperty("app.smsfrom");
	    	 
	    	
	    	
	    	
			System.out.println("hello sms class");
			requestUrl  = "http://182.18.160.225/index.php/api/bulk-sms?username="+URLEncoder.encode(username, "UTF-8")+"&password="+ URLEncoder.encode(password, "UTF-8")+"&from="+from+"&to="+URLEncoder.encode(mobileNumber, "UTF-8")+"&message="+URLEncoder.encode(message, "UTF-8")+"&sms_type=2";
	        URL url = new URL(requestUrl);
	        HttpURLConnection uc = (HttpURLConnection)url.openConnection();
	        String response = uc.getResponseMessage();
	        System.out.println("SMS response:"+response);
	        uc.disconnect();
	        return response;
		}
	    
	    
	    

}
