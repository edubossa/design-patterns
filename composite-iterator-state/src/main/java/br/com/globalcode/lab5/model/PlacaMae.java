package br.com.globalcode.lab5.model;

public class PlacaMae extends ComponenteComposite{
  public PlacaMae() {
    this.precoCusto=100;
    this.precoLucroMaximo=200;
    this.precoLucroMinimo=150;
    
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
