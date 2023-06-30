package com.app.services;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.sentMail;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	@Value("${spring.mail.username}")
	private String sender;

	@Override
	public Map<String, String> sendSimpleMail(sentMail details) {
		// TODO Auto-generated method stub

		try {

			// Creating a simple mail message
			SimpleMailMessage mailMessage = new SimpleMailMessage();

			System.out.println("sendeeeeer" + sender);

			// Setting up necessary details
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getRecipient());
			mailMessage.setText(details.getMsgBody());
			mailMessage.setSubject(details.getSubject());

			// Sending the mail
			javaMailSender.send(mailMessage);
			String message = "Mail Sent Successfully";
			return successEmail(message);
		}

		// Catch block to handle the exceptions
		catch (Exception e) {
			String message = "Erro Sending Mail";
			return errorEmail(message);
		}

	}

	private Map<String, String> successEmail(String message) {
		Map<String, String> response = new HashMap<>();
		response.put("message", message);
		return response;
	}

	private Map<String, String> errorEmail(String message) {
		Map<String, String> response = new HashMap<>();
		response.put("message", message);
		return response;
	}

	@Override
	public String sendMailWithAttachment(sentMail details,MultipartFile file) {
		// TODO Auto-generated method stub

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;

		try {

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(details.getRecipient());
			mimeMessageHelper.setText(details.getMsgBody());
			mimeMessageHelper.setSubject(details.getSubject());

			System.out.println("before attachments file++++" + details.getAttachment());
			// Adding the attachment
//			FileSystemResource file = new FileSystemResource(new File(details.getAttachment()));
			 File file1 = new File(((MultipartFile) file).getOriginalFilename());
			System.out.println("file++++" + file1);
			mimeMessageHelper.addAttachment(file1.getName(), file1);
			// Sending the mail
			javaMailSender.send(mimeMessage);
			return "Mail sent with attachments Successfully";
		}

		// Catch block to handle MessagingException
		catch (MessagingException e) {

			// Display message when exception occurred
			return "Error while sending mail!!!";
		}

	}

}
