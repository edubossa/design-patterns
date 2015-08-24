package br.com.globalcode.factory;

import java.util.Properties;

import br.com.globalcode.command.BaseCommand;

public class CommandFactory2 implements CommandFactory{
    
    Properties apelidosComandos = new Properties();
    
    public BaseCommand create(String name) {
        BaseCommand command = null;
        String stringClasse = apelidosComandos.getProperty(name);
        try {
            Class classe = Class.forName(stringClasse);
            Object object = classe.newInstance();
            command = (BaseCommand) object;
        } catch (Exception e) {
            System.out.println("Erro na criação do Command " + e.getMessage());
            e.printStackTrace();
        }
        return command;
    }
    public CommandFactory2() {
        try {
            apelidosComandos.load(getClass().getResourceAsStream("commands.properties"));
        } catch (Exception ex) {
            System.out.println("Erro carregando commands.properties" + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
}
