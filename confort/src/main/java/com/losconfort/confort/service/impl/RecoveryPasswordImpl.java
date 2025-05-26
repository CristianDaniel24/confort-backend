package com.losconfort.confort.service.impl;

import com.losconfort.confort.model.PersonModel;
import com.losconfort.confort.model.RecoveryPasswordModel;
import com.losconfort.confort.repository.RecoveryPasswordRepository;
import com.losconfort.confort.service.RecoveryPasswordService;
import com.losconfort.confortstarterrest.exception.ResourceNotFoundException;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class RecoveryPasswordImpl
    extends DefaultServiceImpl<RecoveryPasswordModel, Long, RecoveryPasswordRepository>
    implements RecoveryPasswordService {

  private final JavaMailSender mailSender;
  private final TemplateEngine templateEngine;

  public RecoveryPasswordImpl(
      RecoveryPasswordRepository repository,
      JavaMailSender mailSender,
      TemplateEngine templateEngine) {
    super(repository);
    this.mailSender = mailSender;
    this.templateEngine = templateEngine;
  }

  @Override
  public void sendRecoveryPassword(
      PersonModel person, String subject, Context context, String templateHtml) {
    try {
      MimeMessage message = mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, true);

      helper.setTo(person.getEmail());
      helper.setSubject(subject);
      String template = templateEngine.process(templateHtml, context);
      helper.setText(template, true);
      mailSender.send(message);

    } catch (MessagingException e) {
      throw new ResourceNotFoundException("Ocurrio un error al enviar el correo");
    }
  }

  @Override
  public RecoveryPasswordModel findByCode(String code) {
    return this.repository
        .findByCode(code)
        .orElseThrow(() -> new ResourceNotFoundException("El codigo es invalido o no existe"));
  }

  @Override
  public void saveNewStatus(RecoveryPasswordModel recovery) {
    this.repository.save(recovery);
  }
}
