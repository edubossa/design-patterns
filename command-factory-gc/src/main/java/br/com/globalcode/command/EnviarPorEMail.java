package br.com.globalcode.command;

import br.com.globalcode.ConfigManager;
import javax.swing.JTextArea;

public class EnviarPorEMail implements BaseCommand {
    
    public void executar(JTextArea taMensagens) {
        ConfigManager config = ConfigManager.getInstance();
        String server = config.getServerName();
        taMensagens.setText("Conexão com servidor " + server +"\n");
        //Código de envio do pedido por email
        taMensagens.append("Enviando Pedido por Email...");
    }
    
}
