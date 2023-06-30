package com.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.sentMail;
import com.app.services.EmailService;

@RestController
@CrossOrigin("http://localhost:8086")
public class EmailController {

	@Autowired
	EmailService emailService;

	@PostMapping("/sendMail")
	public Map<String, String> sendMail(@RequestBody sentMail details) {
		Map<String, String> status = emailService.sendSimpleMail(details);
		return status;
	}

	@PostMapping(value = "/sendMailWithAttachment" , consumes = "multipart/form-data")
	public String sendMailWithAttachment(@RequestBody sentMail details, @RequestPart("attachment") MultipartFile file) {
		System.out.println("inside sendWith Attachment");
		String status = emailService.sendMailWithAttachment(details,file);

		return status;
	}

}
