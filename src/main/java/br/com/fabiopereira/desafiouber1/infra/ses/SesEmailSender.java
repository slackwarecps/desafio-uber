package br.com.fabiopereira.desafiouber1.infra.ses;

import br.com.fabiopereira.desafiouber1.adaptadores.EmailSenderGateway;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import br.com.fabiopereira.desafiouber1.nucleo.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SesEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        //
        SendEmailRequest request = new SendEmailRequest()
                .withSource("fabio.alvaro@gmail.com")
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content()))
                );
        try {
            this.amazonSimpleEmailService.sendEmail(request);
        } catch (AmazonServiceException exception){
            throw new EmailServiceException("Falha enviando o oemail - SES", exception);
        }



    }
}
