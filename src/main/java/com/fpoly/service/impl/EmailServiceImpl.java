package com.fpoly.service.impl;

import javax.servlet.ServletContext;

import com.fpoly.entity.User;
import com.fpoly.service.EmailService;
import com.fpoly.util.SendEmailUtil;

public class EmailServiceImpl implements EmailService {
	
	private static final String EMAIL_WELCOME_SUBJECT = "Welcome to Online Entertaiment";
	private static final String EMAIL_FORGOT_PASSWORD = "Online Entertaiment - New password";
	
	@Override
	public void sendEmail(ServletContext context, User recipient, String type) {
		// reads SMTP server setting from web.xml file
        String host = context.getInitParameter("host");
        String port = context.getInitParameter("port");
        String user = context.getInitParameter("user");
        String pass = context.getInitParameter("pass");
        
        try {
        	String content = null;
        	String subject = null;
        	switch (type) {
        		case "welcome":
        			subject = EMAIL_WELCOME_SUBJECT;
        			content = "Dear " + recipient.getUsername() + ", hope you have a good time!";
        			break;
        		case "forgot":
        			subject = EMAIL_FORGOT_PASSWORD;
        			content = "Dear " + recipient.getUsername() + ", ypur new password here: " + recipient.getPassword();
        			break;
        		default:
        			subject = "Online Entertaiment";
        			content = "Maybe this email is wrong, don't care about it";
        	}
        	SendEmailUtil.sendEmail(host, port, user, pass, recipient.getEmail(), subject, content);
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
}
