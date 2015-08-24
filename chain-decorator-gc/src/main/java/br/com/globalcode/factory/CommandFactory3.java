package br.com.globalcode.factory;

import br.com.globalcode.command.BaseCommand;
import br.com.globalcode.command.chain.CommandAnnotationDecorator;
import java.io.*;
import java.util.Properties;

public class CommandFactory3 implements GenericFactory<BaseCommand, String>{
  Properties apelidosComandos = new Properties();;

  public BaseCommand create(String name) {
    BaseCommand command = null;
    String stringClasse = apelidosComandos.getProperty(name);
    try {
      Class classe = Class.forName(stringClasse);
      Object object = classe.newInstance();
      command = new CommandAnnotationDecorator((BaseCommand) object);
    } catch (Exception trateme) {
      //tratar
        trateme.printStackTrace();
      System.out.println(" Erro: " + trateme.getMessage());
    }
    return command;
  }
  public CommandFactory3() {
    try {
      apelidosComandos.load(getClass().getResourceAsStream("commands.properties"));
    } catch (Exception ex) {
      //tratar
    }
  }  
}
