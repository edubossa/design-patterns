package br.com.globalcode.command.chain;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)  
public @interface CommandInterceptor {
  public boolean preProcess();
  public boolean posProcess();
  public String interceptor();
}
