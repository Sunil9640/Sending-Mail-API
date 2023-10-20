package com.mailsending.JavaMail;

import java.io.File;
import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.net.ssl.ExtendedSSLSession;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Testing mail " );
        
        String message="hello this is testing mail API";
        String to="sunilkumar9347@gmail.com";
        String from="sunilyadav202396";
        String subject="SUNIL TESTING API FOR EMAIL";
        
       //  sendEmail( message, subject, from, to);
        sendAttachedEmail( message, subject, from, to);
    }
    
    
    // sending attached mail method
    
    private static void sendAttachedEmail(String message, String subject, String from, String to) {
		
    	String host="smtp.gmail.com";
        
    	Properties properties=System.getProperties();
    	
    	properties.put("mail.smtp.host", host);
    	properties.put("mail.smtp.port","465");
    	properties.put("mail.smtp.ssl.enable","true");
    	properties.put("mail.smtp.auth","true");
    	
    	
    Session session=Session.getInstance(properties, new Authenticator() {
    	    
    		@Override
    		protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
    			return new javax.mail.PasswordAuthentication("sunilyadav202396@gmail.com", "hwyx nnwy xycn pxet");
    		}
		});
    session.setDebug(true);
    
    
    MimeMessage m= new MimeMessage(session);
    try {
    	
    	//from 
		m.setFrom(from);
		
		//to receiver:
		
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding subject 
		m.setSubject(subject);
		
		//adding attatched file to message
		
		String path="C:\\Users\\sunilna\\Desktop\\APPLICATION\\login.jpg";
		
		MimeMultipart mimeMultipart=new  MimeMultipart();
		
		MimeBodyPart textpart= new MimeBodyPart();
	   MimeBodyPart filepart=new MimeBodyPart();
		
		try {
			
			textpart.setText(message);
			
			File file=new File(path);
             filepart.attachFile(file);	
             mimeMultipart.addBodyPart(textpart);
           mimeMultipart.addBodyPart(filepart);
             
            
             
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
		 m.setContent(mimeMultipart);
		
		//sending the mail
		Transport.send(m);
		
		System.out.println(m);
		
		
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
    	
    	
	}


    // sending plain text method
    
	public static void sendEmail(String message,String subject,String from,String to) {
    	
    	String host="smtp.gmail.com";
         
    	Properties properties=System.getProperties();
    	
    	properties.put("mail.smtp.host", host);
    	properties.put("mail.smtp.port","465");
    	properties.put("mail.smtp.ssl.enable","true");
    	properties.put("mail.smtp.auth","true");
    	
    	
    Session session=Session.getInstance(properties, new Authenticator() {
    	    
    		@Override
    		protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
    			return new javax.mail.PasswordAuthentication("sunilyadav202396@gmail.com", "hwyx nnwy xycn pxet");
    		}
		});
    session.setDebug(true);
    
    //setting MIMI message:
    
    MimeMessage m= new MimeMessage(session);
    try {
    	
    	//from 
		m.setFrom(from);
		
		//to receiver:
		
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding subject 
		m.setSubject(subject);
		
		//adding text to message
		m.setText(message);
		
		//sending the mail
		Transport.send(m);
		
		System.out.println(m);
		
		
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
    
    }
}
