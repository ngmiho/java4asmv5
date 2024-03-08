package com.fpoly.service;

import javax.servlet.ServletContext;

import com.fpoly.entity.User;

public interface EmailService {
	
	void sendEmail(ServletContext context, User recipient, String type);
}
