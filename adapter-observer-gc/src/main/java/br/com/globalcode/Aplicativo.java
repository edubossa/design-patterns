package br.com.globalcode;

import br.com.globalcode.command.BaseCommand;
import br.com.globalcode.factory.CommandFactory;
import br.com.globalcode.factory.CommandFactory1;
import br.com.globalcode.observer.ObservedFile;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Aplicativo extends JFrame {
    
    private JTextArea taMensagens = new JTextArea();
    private CommandFactory commandFactory = new CommandFactory1();
    
    public static void main(String[] args) {
        new Aplicativo();
    }
    
    void initCommandFactory() {
        try {
            Properties propriedades = new Properties();
            InputStream f = getClass().getResourceAsStream("config.properties");
            propriedades.load(f);
            f.close();
            String nome = propriedades.getProperty("command.factory.class");
            Class classeFactoryCommandFactory = Class.forName(nome);
            commandFactory = (CommandFactory) classeFactoryCommandFactory.newInstance();
        } catch (Exception e) {
            System.out.println("Não foi possivel inicializar a CommandFactory " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public Aplicativo() {
        super("Curso de Design Patterns - lab03");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initCommandFactory();
        JPanel panel = montaPainelBotoes();
        add(panel,BorderLayout.SOUTH);
        add(taMensagens,BorderLayout.CENTER);
        setSize(700,200);
        setVisible(true);
        ObservedFile configFile = new ObservedFile(getClass().getResource("config.properties").getFile());
        configFile.addObserver(new ReloadConfig(this));
         
    }
    
    private JPanel montaPainelBotoes() {
        JPanel panel = new JPanel();
        JButton btEnviarPedido = new JButton("Enviar Pedido");
        JButton btGerarPDF = new JButton("Gerar PDF");
        JButton btNovoPedido = new JButton("Novo Pedido");
        JButton btExcluirPedido = new JButton("Excluir Pedido");
        JButton btAcionarContabil = new JButton("Acionar Sistema Contabil");
        
        panel.add(btExcluirPedido);
        panel.add(btNovoPedido);
        panel.add(btGerarPDF);
        panel.add(btEnviarPedido);
        panel.add(btAcionarContabil);
        
        btExcluirPedido.setActionCommand("ExcluirPedido");
        btGerarPDF.setActionCommand("GerarPDF");
        btEnviarPedido.setActionCommand("EnviarPedido");
        btNovoPedido.setActionCommand("NovoPedido");
        btAcionarContabil.setActionCommand("SistemaContabil");
        
        ActionListener listener = new BotaoHandler();
        btEnviarPedido.addActionListener(listener);
        btGerarPDF.addActionListener(listener);
        btNovoPedido.addActionListener(listener);
        btExcluirPedido.addActionListener(listener);
        btAcionarContabil.addActionListener(listener);
        
        return panel;
    }
    
    public class BotaoHandler implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            String nome = e.getActionCommand();
            BaseCommand command = commandFactory.create(nome);
            command.executar(taMensagens);
        }
    }
    
}
