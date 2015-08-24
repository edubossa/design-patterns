package br.com.globalcode.factory;


public interface GenericFactory <Retorno, Entrada>{
  public Retorno create(Entrada name);
}
