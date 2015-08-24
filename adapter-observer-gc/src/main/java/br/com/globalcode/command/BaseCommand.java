package br.com.globalcode.command;

import br.com.globalcode.visitor.Visitor;
import javax.swing.JTextArea;

public interface BaseCommand {
    public abstract void executar(JTextArea taMensagens);
    public void accept(Visitor visitor);
}
