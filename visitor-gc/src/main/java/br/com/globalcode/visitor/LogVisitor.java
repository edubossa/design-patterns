package br.com.globalcode.visitor;


import br.com.globalcode.command.EnviarPorEMail;
import br.com.globalcode.command.ExcluirPedido;
import br.com.globalcode.command.GerarPDF;
import br.com.globalcode.command.NovoPedido;

public class LogVisitor extends Visitor {
    
    public void visit(EnviarPorEMail comando) {
        System.out.println("Enviando pedido por email...");
    }

    public void visit(ExcluirPedido command) {
        System.out.println("Excluindo pedido...");        
    }

    public void visit(GerarPDF command) {
        System.out.println("Gerando PDF ...");        
    }

    public void visit(NovoPedido command) {
        System.out.println("Criando novo pedido...");        
    }
}
