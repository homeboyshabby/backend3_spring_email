package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Email;


@RestController
@CrossOrigin
@RequestMapping("/email")
public class SendEmailController {
	@Autowired
	private JavaMailSender sender;
	
	@RequestMapping
	public String showForm(Email e)
	{
	//	m.addAttribute(new Email());
		return "send_mail";
	}
	@PostMapping
	public String processForm(@RequestBody Email em,BindingResult res)
	{
		System.out.println("Hi" +em.getDestEmail()+"  "+em.getMessage());
		SimpleMailMessage mesg=new SimpleMailMessage();
		mesg.setTo(em.getDestEmail());
		mesg.setSubject(em.getSubject());
		mesg.setText(em.getMessage());
		sender.send(mesg);
		return "sent-mail";
	}
}
