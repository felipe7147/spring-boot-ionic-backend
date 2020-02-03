package com.felipealmeida.cursomc.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.ws.mime.MimeMessage;

import com.felipealmeida.cursomc.domain.Pedido;
import com.sun.xml.messaging.saaj.packaging.mime.MessagingException;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj) ;
	
	void sendEmail(SimpleMailMessage msg);
	
	
	void sendOrderConfirmationHtmlEmail(Pedido obj) throws MessagingException ;
	void sendHtmlEmail(MimeMessage msg);
	
		

}
