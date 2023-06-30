package com.app.services;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.app.model.sentMail;

public interface EmailService {

	// Method
	// To send a simple email
	Map<String, String> sendSimpleMail(sentMail details);

	// Method
	// To send an email with attachment
	String sendMailWithAttachment(sentMail details1,  MultipartFile file);
}
