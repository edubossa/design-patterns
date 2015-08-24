package br.com.globalcode.command.chain;

import br.com.globalcode.command.BaseCommand;

public class SegurancaCommandHandler extends CommandHandler{
  
  public SegurancaCommandHandler() {
  }
  public void handle(BaseCommand command) {
    System.out.println("Segurança Command Handle!");
    if(next != null) {
        getNext().handle(command);
    }    
  }
}
