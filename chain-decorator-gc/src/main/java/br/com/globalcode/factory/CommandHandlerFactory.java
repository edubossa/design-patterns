package br.com.globalcode.factory;

import br.com.globalcode.command.chain.*;
import java.io.*;
import java.util.Properties;

public class CommandHandlerFactory implements GenericFactory<CommandHandler, String>{
  Properties apelidosComandos = new Properties();

  public CommandHandler create(String name) {
    CommandHandler command = null;
    String stringClasse = apelidosComandos.getProperty(name);
    try {
      Class classe = Class.forName(stringClasse);
      Object object = classe.newInstance();
      command = (CommandHandler) object;
      
    } catch (Exception trateme) {
      //tratar
      System.out.println(" Erro: " + trateme.getMessage());
      trateme.printStackTrace();
    }
    return command;
  }
  public CommandHandlerFactory() {
    try {
      apelidosComandos.load(getClass().getResourceAsStream("handlers.properties"));
    } catch (Exception ex) {
      System.out.println(" Erro ao obter arquivo de config handlers.properties");
      ex.printStackTrace();
    }
  }  
}
