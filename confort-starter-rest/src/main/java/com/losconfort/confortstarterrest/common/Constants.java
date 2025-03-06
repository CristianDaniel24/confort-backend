package com.losconfort.confortstarterrest.common;

public class Constants {
  public static final String BASE_POINTCUT =
      "execution(* com.losconfort.confortstarterrest.helper.*.*(..)) "
          + "|| within(@org.springframework.web.bind.annotation.RestController *) "
          + "|| within(@org.springframework.stereotype.Service *)";
}
