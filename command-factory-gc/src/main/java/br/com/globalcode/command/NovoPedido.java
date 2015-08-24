package br.com.globalcode.command;

import br.com.globalcode.ConfigManager;
import javax.swing.JTextArea;

public class NovoPedido implements BaseCommand{
    
    public void executar(JTextArea taMensagens) {
        ConfigManager config = ConfigManager.getInstance();
        String server = config.getServerName();
        taMensagens.setText("Conexão com servidor " + server+"\n");
        //Código de criação de um novo pedido
        taMensagens.append("Setup para novo pedido...");
    }
    
    
}
