package br.com.globalcode.command.chain;

import br.com.globalcode.command.BaseCommand;

public class ValidarDadosCommand extends CommandHandler{
  public void handle(BaseCommand command) {
    System.out.println("Validando dados!!!");
    if(next != null) {
        getNext().handle(command);
    }      
  }
}
