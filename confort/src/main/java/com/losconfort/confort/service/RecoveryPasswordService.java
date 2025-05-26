package com.losconfort.confort.service;

import com.losconfort.confort.model.PersonModel;
import com.losconfort.confort.model.RecoveryPasswordModel;
import com.losconfort.confortstarterrest.helper.DefaultService;
import org.thymeleaf.context.Context;

public interface RecoveryPasswordService extends DefaultService<RecoveryPasswordModel, Long> {

  void sendRecoveryPassword(PersonModel person, String subject, Context context, String template);

  RecoveryPasswordModel findByCode(String code);

  void saveNewStatus(RecoveryPasswordModel status);
}
