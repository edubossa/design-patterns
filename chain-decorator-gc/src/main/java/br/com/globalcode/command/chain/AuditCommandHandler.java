package br.com.globalcode.command.chain;

import br.com.globalcode.command.BaseCommand;

public class AuditCommandHandler extends CommandHandler{
  
  public AuditCommandHandler() {
  }
  public void handle(BaseCommand command) {
    System.out.println("Audit Command Handle!");
    if(next != null) {
        getNext().handle(command);
    }    
  }
}
