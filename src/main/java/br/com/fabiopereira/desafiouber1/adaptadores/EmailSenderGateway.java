package br.com.fabiopereira.desafiouber1.adaptadores;

public interface EmailSenderGateway {

    void sendEmail(String to, String subject, String body);
}
