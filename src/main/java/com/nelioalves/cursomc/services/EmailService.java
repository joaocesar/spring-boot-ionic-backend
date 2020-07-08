package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido pedido);

    void sendMail(SimpleMailMessage message);

//    void sendOrderConfirmationHtmlEmail(Pedido pedido);

//    void sendHtmlEmail(MimeMessage message);

}
