package br.com.globalcode.idp.web.command;

public class CommandFactory {
  public static String prefixoClasse = "br.com.globalcode.idp.web.command.";

  public static WebCommand createWebCommand(String command) throws WebCommandException {
    if(command == null || command.equals("")) {
      throw new WebCommandException("Command nao foi informado ou eh nulo");
    }
    Class classe = null;
    try {
      classe = Class.forName(prefixoClasse + command + "Command");
    }
    catch(ClassNotFoundException e) {
      throw new WebCommandException("Classe " + command + " nao encontrada ou inconsistente.", e);
    }
    Object objetoCommand = null;
    try {
      objetoCommand = classe.newInstance();
    }
    catch(Exception e) {
      throw new WebCommandException("Erro ao criar objeto do command " + command +".", e);
    }
    return (WebCommand) objetoCommand;
  }
}
