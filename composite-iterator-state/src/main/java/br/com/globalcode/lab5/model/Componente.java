package br.com.globalcode.lab5.model;

import java.util.Collection;

public abstract class Componente {
  private Componente owner;
  private String modelo;
  protected double precoCusto;
  protected double precoLucroMaximo;
  protected double precoLucroMinimo;
  
  
  public Componente getOwner() {
    return owner;
  }
  public void setOwner(Componente c) {
    this.owner = c;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public double getPrecoCusto() {
    return precoCusto;
  }

  public void setPrecoCusto(double precoCusto) {
    this.precoCusto = precoCusto;
  }

  public double getPrecoLucroMaximo() {
    return precoLucroMaximo;
  }

  public void setPrecoLucroMaximo(double precoLucroMaximo) {
    this.precoLucroMaximo = precoLucroMaximo;
  }

  public double getPrecoLucroMinimo() {
    return precoLucroMinimo;
  }

  public void setPrecoLucroMinimo(double precoLucroMinimo) {
    this.precoLucroMinimo = precoLucroMinimo;
  }
}
