package com.charvikent.issuetracking.config;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Component;
@Component
public class SendSMS {
	
   //public  String  mobileNumber =null;
    String username = "RKKIDS";
    String password = "RK@kids987";
    String from = "RKKIDS";
    String requestUrl = null;
    String toAddress = null;
    
     //public String message=null;
    
    
    public void sendSMSFromClass(String message, String mobileNumber) throws IOException
	{
		System.out.println("hello sms class");
		requestUrl  = "http://182.18.160.225/index.php/api/bulk-sms?username="+URLEncoder.encode(username, "UTF-8")+"&password="+ URLEncoder.encode(password, "UTF-8")+"&from="+from+"&to="+URLEncoder.encode(mobileNumber, "UTF-8")+"&message="+URLEncoder.encode(message, "UTF-8")+"&sms_type=2";
        URL url = new URL(requestUrl);
        HttpURLConnection uc = (HttpURLConnection)url.openConnection();
        System.out.println(uc.getResponseMessage());
        uc.disconnect();
	}


}
