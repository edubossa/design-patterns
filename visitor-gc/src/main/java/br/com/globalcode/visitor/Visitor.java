package br.com.globalcode.visitor;

import br.com.globalcode.command.BaseCommand;
import br.com.globalcode.command.EnviarPorEMail;
import br.com.globalcode.command.ExcluirPedido;
import br.com.globalcode.command.GerarPDF;
import br.com.globalcode.command.NovoPedido;

public abstract class Visitor {
    
    public void visit(BaseCommand comando) {
        System.out.println("Visitando comando identificado por " + comando.getClass().getName());
    }
    
    public abstract void visit(EnviarPorEMail command);
    public abstract void visit(ExcluirPedido command);
    public abstract void visit(GerarPDF command);
    public abstract void visit(NovoPedido command);
}
