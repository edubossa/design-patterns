package br.com.globalcode.factory;

import br.com.globalcode.command.BaseCommand;
import br.com.globalcode.visitor.LogVisitor;
import br.com.globalcode.visitor.Visitor;

public class CommandFactoryLogged extends CommandFactoryVisitor{

    Visitor visitor = new LogVisitor();
    
    public void addVisitor(BaseCommand command) {
        command.accept(visitor);
    }
    
}
