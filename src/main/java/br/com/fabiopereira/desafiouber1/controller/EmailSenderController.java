package br.com.fabiopereira.desafiouber1.controller;

import br.com.fabiopereira.desafiouber1.aplicacao.EmailSenderService;
import br.com.fabiopereira.desafiouber1.nucleo.EmailRequest;
import br.com.fabiopereira.desafiouber1.nucleo.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {


   private final EmailSenderService emailSenderService;

   @Autowired
    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }
    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
       try {
           this.emailSenderService.sendEmail(request.to(), request.subject(), request.body());
           return ResponseEntity.ok("Email enviado com sucesso!!");
       }catch (EmailServiceException ex){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro enquanto estava enviando a mensagen");
       }



    }


}
