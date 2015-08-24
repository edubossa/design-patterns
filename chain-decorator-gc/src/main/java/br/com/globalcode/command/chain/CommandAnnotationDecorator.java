package br.com.globalcode.command.chain;

import br.com.globalcode.command.BaseCommand;
import br.com.globalcode.factory.CommandHandlerFactory;

public class CommandAnnotationDecorator extends BaseCommand {

  protected BaseCommand commandDecorado;
  protected CommandHandler next;
  protected boolean pre;
  protected boolean pos;

  public CommandAnnotationDecorator(BaseCommand c) {
    this.commandDecorado = c;
    setupCommandHandlerChain();
  }

  public void setupCommandHandlerChain() {
    CommandHandlerFactory handlerFactory = new CommandHandlerFactory();
    if (commandDecorado.getClass().isAnnotationPresent(CommandInterceptor.class)) {
      CommandInterceptor aci = commandDecorado.getClass().getAnnotation(CommandInterceptor.class);
      pre = aci.preProcess();
      pos = aci.posProcess();
      String handlers[] = aci.interceptor().split(",");
      CommandHandler cmd = null;
      CommandHandler cmdPrevious = null;
      for (String handler : handlers) {
        if (cmdPrevious == null) {
          cmdPrevious = handlerFactory.create(handler.trim());
          next=cmdPrevious;

        } else {
          cmd = handlerFactory.create(handler.trim());
          cmdPrevious.setNext(cmd);
          cmdPrevious = cmd;
        }
      }
    }

  }

  public void executar() {
    //analise de annotations pre
    //a execucao representa um command no topo da cadeia
    System.out.println("Analise de annotation e chamada de chain of responsibility");
    processPreAnnotation();
    System.out.println("Vai executar " + commandDecorado.getClass().getName());
    commandDecorado.executar();
    processPosAnnotation();
  }

  public void processPreAnnotation() {
    if (!pre) {
      return;
    }
    next.handle(commandDecorado);
  }

  public void processPosAnnotation() {
    if (!pos) {
      return;
    }
    next.handle(commandDecorado);
  }
}
