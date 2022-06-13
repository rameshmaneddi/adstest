package com.mss;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

@Service
public class SendingMailService {

	public String sendingMail(String mail) {
    	  //smtp means simple mail transfer protocol
    	  
    	  Properties prop=new Properties();
    	  prop.put("mail.smtp.auth", "true"); 
    	  prop.put("mail.smtp.host", "mapi.miraclesoft.com");//mapi.miraclesoft.com//smtp.gmail.com  
    	 prop.put("mail.smtp.port", 587);
    	 prop.put("mail.smtp.starttls.enable", "true");
    	//after writing the code error are cleared
    	  Session session= Session.getInstance(prop,new javax.mail.Authenticator() {
    		  protected PasswordAuthentication getPasswordAuthentication() {
    			 // return new PasswordAuthentication("rameshmaneddi6@gmail.com", "njesncjmupkaxhku");//rmaneddi@miraclesoft.com,password ....&&...gmail security password
    			  return new PasswordAuthentication("rmaneddi@miraclesoft.com", "P@ssw0rd!");
    		  }
    	  });
    	  
    	  try {
    	  Message msg = new MimeMessage(session);
    	  //here false for normal mails like internetAdderss("rameshmaneddi6@gmail.com",false);
    	  msg.setFrom(new InternetAddress("rmaneddi@miraclesoft.com",false));
    	  msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail,true));
    	  msg.addRecipient(RecipientType.CC, new InternetAddress("rmaneddi@miraclesoft.com",null));
    	  msg.setSubject("Verification");//Handing
    	  msg.setHeader("sir i am sending a picture", "text/html");
    	  msg.setSentDate(new Date());
    	  MimeBodyPart messageBody=new MimeBodyPart();
    	  messageBody.setContent("please click this link http://localhost:8080/verified","text/html");
    	  Multipart multipart=new MimeMultipart();
    	  multipart.addBodyPart(messageBody);
    	  MimeBodyPart attachedpart=new MimeBodyPart();
    	  attachedpart.attachFile("C:\\Users\\rmaneddi\\Desktop\\images.jpg");
    	  multipart.addBodyPart(attachedpart);
    	  msg.setContent(multipart);
    	  Transport.send(msg);
//    	  Transport tr = session.getTransport("smtp");
//          tr.connect("mapi.miraclesoft.com", "rmaneddi@miraclesoft.com", "P@ssw0rd");
//          msg.saveChanges();
//          tr.sendMessage(msg, msg.getAllRecipients());
//          tr.close();

    	  }catch (Exception e) {
			// TODO: handle exception
    		  e.printStackTrace();
		}
    	  return "Successfully sending mail";
      }
}
