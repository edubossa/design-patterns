package br.com.globalcode.lab5.model;

public class PlacaVideo extends ComponenteComposite{
  
  public String getPlacaNome() {
    return "Placa video XPTO";
  }
    
 
  public PlacaVideo() {
    this.precoCusto=70;
    this.precoLucroMaximo=150;
    this.precoLucroMinimo=120;
    
  }
  public double getPrecoCusto() {
    double preco = precoCusto;
    for(Componente c: componentes) {
      preco += c.getPrecoCusto();
    }
    return preco;
  }
  public double getPrecoLucroMinimo() {
    double preco = precoLucroMinimo;
    for(Componente c: componentes) {
      preco += c.getPrecoLucroMinimo();
    }
    return preco;
  }
  public double getPrecoLucroMaximo() {
    double preco = precoLucroMaximo;
    for(Componente c: componentes) {
      preco += c.getPrecoLucroMaximo();
    }
    return preco;
  }  
}
