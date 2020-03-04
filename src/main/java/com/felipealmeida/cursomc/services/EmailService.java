package com.felipealmeida.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.felipealmeida.cursomc.domain.Cliente;
import com.felipealmeida.cursomc.domain.Pedido;



public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}

