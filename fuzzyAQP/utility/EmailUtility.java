package com.fuzzyAQP.utility;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtility {

	public static boolean sendEmailUrl(String email ,String url)
	//public static boolean sendEmailUrl(String email ,String url,String pass)
	{
		final String userName="fuzzyaqp@gmail.com";
		final String password="fuzzy12345";
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session=Session.getInstance(properties,
				new javax.mail.Authenticator(){
			        protected PasswordAuthentication getPasswordAuthentication(){
			        	 return new PasswordAuthentication(userName, password);
			        }
		});
		
		try
		{
			Message message=new MimeMessage(session);
			message.setFrom(new InternetAddress("ticketingsystem007@gmail.com"));
		    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		    message.setSubject("EmailConfirmation");
		    message.setText("email :"+email +    "    URL :"  +url);
		//    message.setText("email :"+email +    "    URL :"  +url+    "    OldPassword :"  +pass);
			Transport.send(message);
            System.out.println("Done");
		}
		//?emailId='"+emailId+"'
		catch(MessagingException e)
		{
			throw new RuntimeException(e);
	}
		
		return true;
	
	}
	
	public static boolean sendEmailUtil(String email ,String pass)
	{
		final String userName="fuzzyaqp@gmail.com";
		final String password="fuzzy12345";
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session=Session.getInstance(properties,
				new javax.mail.Authenticator(){
			        protected PasswordAuthentication getPasswordAuthentication(){
			        	 return new PasswordAuthentication(userName, password);
			        }
		});
		
		try
		{
			Message message=new MimeMessage(session);
			message.setFrom(new InternetAddress("ticketingsystem007@gmail.com"));
		    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		    message.setSubject("EmailConfirmation");
		    message.setText("Username :"+email +    "    Password :"  +pass);
			Transport.send(message);
            System.out.println("Done");
		}
		//?emailId='"+emailId+"'
		catch(MessagingException e)
		{
			throw new RuntimeException(e);
	}
		
		return true;
	
	}

	public static boolean sendEmail1(String emailId ,String uname )
	{
		final String userName="fuzzyaqp@gmail.com";
		final String password="fuzzy12345";
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session=Session.getInstance(properties,
				new javax.mail.Authenticator(){
			        protected PasswordAuthentication getPasswordAuthentication(){
			        	 return new PasswordAuthentication(userName, password);
			        }
		});
		
		try
		{
			Message message=new MimeMessage(session);
			message.setFrom(new InternetAddress("ticketingsystem007@gmail.com"));
		    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailId));
		    message.setSubject("EmailConfirmation");
		    message.setText("Username :"+uname +    "        Trying Login Attempt More Than 3 Times..!!!!!!!!!!!");
			Transport.send(message);
            System.out.println("Done");
		}
		//?emailId='"+emailId+"'
		catch(MessagingException e)
		{
			throw new RuntimeException(e);
	}
		
		return true;
	
	}
	
	
	public static boolean sendEmail(String emailId, String OTPkey)
	{
		
		final String userName="fuzzyaqp@gmail.com";
		final String password="fuzzy12345";
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session=Session.getInstance(properties,
				new javax.mail.Authenticator(){
			        protected PasswordAuthentication getPasswordAuthentication(){
			        	 return new PasswordAuthentication(userName, password);
			        }
		});
		
		try
		{
			Message message=new MimeMessage(session);
			message.setFrom(new InternetAddress("ticketingsystem007@gmail.com"));
		    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailId));
		    message.setSubject("OTP");
		    message.setText("OTP :"+OTPkey);
			Transport.send(message);
            System.out.println("Mail sent");
		}
		catch(MessagingException e)
		{
			throw new RuntimeException(e);
	}
		
		return true;
	
	}
	
	public static void sendEmail(String toAddress, String subject, String message, String attachFiles) throws AddressException, MessagingException {
 
		final String userName="fuzzyaqp@gmail.com";
		final String password="fuzzy12345";
		
		
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
        
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
        
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");
        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
 
        // adds attachments
        
          
                MimeBodyPart attachPart = new MimeBodyPart();
 
                try {
                    attachPart.attachFile(attachFiles);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
 
                multipart.addBodyPart(attachPart);
         
        // sets the multi-part as e-mail's content
        msg.setContent(multipart);
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        
        // sets the multi-part as e-mail's content
        msg.setContent(multipart);
 
        // sends the e-mail
        Transport.send(msg);
 }

	
	
	public static void sendEmail(String[] toAddress, String subject, String message, String attachFiles) throws AddressException, MessagingException {
		 
		final String userName="fuzzyaqp@gmail.com";
		final String password="fuzzy12345";
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
        
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
        
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        
        message="Reminder!! "+message+"<br/><br/><br/><br/><br/>Regards<br/> Dobell Team<br/>Support Mail: support@dobell.com<br/>Contact At: 999999999<br/>Website : wwww.dobell.com<br/><img src='https://mvp.tribesgds.com/dyn/jZ/XK/jZXKAfmm3Ek/_/tIIyubfFgL0/Enk3/dobell-logo.jpg'>";
        messageBodyPart.setContent(message, "text/html");
        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
 
        // adds attachments
        
          
                MimeBodyPart attachPart = new MimeBodyPart();
 
              /*  try {
                    attachPart.attachFile(attachFiles);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
 
                multipart.addBodyPart(attachPart);*/
         
        // sets the multi-part as e-mail's content
        msg.setContent(multipart);
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toInternetAddress =new InternetAddress[toAddress.length]; 
        for(int i=0;i<toAddress.length;i++)
        {
        	if(toAddress[i]!= null)
        	toInternetAddress[i]=new InternetAddress(toAddress[i]);
        }
        InternetAddress[] toAddresses = toInternetAddress;
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        
        // sets the multi-part as e-mail's content
        msg.setContent(multipart);
 
        // sends the e-mail
        //System.out.println("Email Inside Sent");
        Transport.send(msg);
        System.out.println("Email Inside Sent Completed");
 }

	public void sendEmailForQuestionPaper(String email, String username,String pdf) {
		// TODO Auto-generated method stub
		
		final String userName="fuzzyaqp@gmail.com";
		final String password="fuzzy12345";
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session=Session.getInstance(properties,
				new javax.mail.Authenticator(){
			        protected PasswordAuthentication getPasswordAuthentication(){
			        	 return new PasswordAuthentication(userName, password);
			        }
		});
		
		try
		{
			Message message=new MimeMessage(session);
			message.setFrom(new InternetAddress("ticketingsystem007@gmail.com"));
		    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		    message.setSubject("EmailConfirmation");
		    message.setText("Username :"+username +    "   View   " +pdf+ " Question Paper Before 1 Hour..!!!!!!!!!!!");
			Transport.send(message);
            System.out.println("Done");
		}
		//?emailId='"+emailId+"'
		catch(MessagingException e)
		{
			throw new RuntimeException(e);
	}
		
	}
}
