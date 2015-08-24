package br.com.globalcode.factory;

import br.com.globalcode.command.BaseCommand;
import br.com.globalcode.command.EnviarPorEMail;
import br.com.globalcode.command.ExcluirPedido;
import br.com.globalcode.command.GerarPDF;
import br.com.globalcode.command.NovoPedido;

public class CommandFactory1 implements CommandFactory{
    
    public BaseCommand create(String name) {
        BaseCommand command = null;
        if (name.equals("GerarPDF")) {
            command = new GerarPDF();
        } else if (name.equals("NovoPedido")) {
            command = new NovoPedido();
        } else if (name.equals("ExcluirPedido")) {
            command = new ExcluirPedido();
        } else if (name.equals("EnviarPedido")) {
            command = new EnviarPorEMail();
        }
        return command;
    }    
}
