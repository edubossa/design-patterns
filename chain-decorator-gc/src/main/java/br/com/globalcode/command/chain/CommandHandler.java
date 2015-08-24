package br.com.globalcode.command.chain;

import br.com.globalcode.command.BaseCommand;

public abstract class CommandHandler {
  protected CommandHandler next;
  
  public CommandHandler() {
  }
  public abstract void handle(BaseCommand command);
  public CommandHandler getNext() {
    return next;
  }
  public void setNext(CommandHandler next) {
    this.next = next;
  }
}
