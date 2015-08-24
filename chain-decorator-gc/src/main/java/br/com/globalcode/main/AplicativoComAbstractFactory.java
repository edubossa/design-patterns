package br.com.globalcode.main;

import br.com.globalcode.command.BaseCommand;
import br.com.globalcode.factory.GenericFactory;
import java.io.InputStream;
import java.util.Properties;

public class AplicativoComAbstractFactory {

  private GenericFactory<BaseCommand, String> commandFactory;
  
  public AplicativoComAbstractFactory() {}
  
  private void initCommandFactory() throws Exception {
    String nome = "br.com.globalcode.factory.CommandFactory3";
    Class classeFactoryCommandFactory = Class.forName(nome);
    commandFactory = (GenericFactory<BaseCommand, String>) classeFactoryCommandFactory.newInstance();    
  }
  
  public void buttonEnviar_clicked() {
    BaseCommand comandoEnviar = commandFactory.create("EnviarPedido");
    comandoEnviar.executar();
  }
  
  public void buttonGerarPDF_clicked() {
    BaseCommand comandoGerarPDF = commandFactory.create("GerarPDF");
    comandoGerarPDF.executar();
  }
  
  public static void main(String[] args) throws Exception {
	  AplicativoComAbstractFactory app = new AplicativoComAbstractFactory();
	  app.initCommandFactory();
	  app.buttonEnviar_clicked();
  }
}
