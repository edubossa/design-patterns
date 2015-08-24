package br.com.globalcode.command.chain;

import br.com.globalcode.command.BaseCommand;

public class LogCommandHandler extends CommandHandler{
  
  public LogCommandHandler() {
  }
  public void handle(BaseCommand command) {
    System.out.println("Log Command Handle!");
    if(next != null) {
        getNext().handle(command);
    }    
  }
}
