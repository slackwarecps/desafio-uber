package br.com.fabiopereira.desafiouber1.aplicacao;

import br.com.fabiopereira.desafiouber1.adaptadores.EmailSenderGateway;
import br.com.fabiopereira.desafiouber1.nucleo.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUseCase {


    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway emailGateway) {
        this.emailSenderGateway = emailGateway;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.sendEmail(to,subject,body);

    }
}
