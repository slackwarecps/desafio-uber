package br.com.fabiopereira.desafiouber1.nucleo;

public interface EmailSenderUseCase {
    void sendEmail(String to, String subject, String body);
}
