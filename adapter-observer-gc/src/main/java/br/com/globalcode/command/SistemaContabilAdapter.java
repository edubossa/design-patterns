package br.com.globalcode.command;

import br.com.globalcode.AcionarSistemaContabil;
import br.com.globalcode.visitor.Visitor;
import javax.swing.JTextArea;

public class SistemaContabilAdapter implements BaseCommand{
 
    private AcionarSistemaContabil comando = new AcionarSistemaContabil();
    
    public void executar(JTextArea taMensagens) {
        comando.executarOperacaoContabil();
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
}
