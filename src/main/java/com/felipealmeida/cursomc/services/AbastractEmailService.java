package com.felipealmeida.cursomc.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ws.mime.MimeMessage;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.felipealmeida.cursomc.domain.Pedido;
import com.sun.xml.messaging.saaj.packaging.mime.MessagingException;

public abstract class AbastractEmailService implements EmailService {
	
	@Value("${default.sender}")
	private String sender;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendOrderConfirmationEmail(Pedido obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
	}

	private SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
      SimpleMailMessage sm = new SimpleMailMessage();
      sm.setTo(obj.getCliente().getEmail());
      sm.setSubject("Pedido confirmado! Codigo: " + obj.getId());
      sm.setSentDate(new Date(System.currentTimeMillis()));
      sm.setText(obj.toString());
      
		return sm;
}
	protected String htmlFromTemplatePedido(Pedido obj) {
		Context context = new Context();
		context.setVariable("pedido", obj);
		return templateEngine.process("email/confirmacaoPedido", context);
		
	}
	
	@Override
	public void sendOrderConfirmationHtmlEmail(Pedido obj) throws MessagingException {
		try {
		MimeMessage mm = prepareMimeMessageFromPedido(obj);
		sendHtmlEmail(mm);
	}
		catch(javax.mail.MessagingException e) {
			sendOrderConfirmationEmail(obj);
		}
	}
	protected MimeMessage prepareMimeMessageFromPedido(Pedido obj) throws javax.mail.MessagingException {
		MimeMessage mimeMessage = (MimeMessage) javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper((javax.mail.internet.MimeMessage) mimeMessage, true);
		mmh.setTo(obj.getCliente().getEmail());
		mmh.setFrom(sender);
		mmh.setSubject("Pedido confirmado! Codigo: " + obj.getId());
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplatePedido(obj), true);
		
		return mimeMessage;
	}
	
}