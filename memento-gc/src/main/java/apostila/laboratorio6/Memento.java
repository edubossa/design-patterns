package apostila.laboratorio6;

import apostila.laboratorio6.model.*;

public class Memento {
  private Componente componenteTarget;
  private String modelo;
  private double precoCusto;
  private double precoLucroMax;
  private double precoLucroMin;
  public Memento(Componente c) {
    setComponenteTarget(c);
    modelo = c.getModelo();
    precoCusto = c.getPrecoCusto();
    precoLucroMax = c.getPrecoLucroMaximo();
    precoLucroMin = c.getPrecoLucroMinimo();
  }
  public void undoRedo() {
    String modeloNovo="";
    double precoLucroMaxNovo=0, precoCustoNovo=0, precoLucroMinNovo=0;
    modeloNovo = modelo;
    precoLucroMaxNovo = precoLucroMax;
    precoLucroMinNovo = precoLucroMin;
    precoCustoNovo = precoCusto;
    
    modelo = componenteTarget.getModelo();
    precoCusto = componenteTarget.getPrecoCusto();
    precoLucroMin = componenteTarget.getPrecoLucroMinimo();
    precoLucroMax = componenteTarget.getPrecoLucroMaximo();
    
    getComponenteTarget().setModelo(modeloNovo);
    getComponenteTarget().setPrecoCusto(precoCustoNovo);
    getComponenteTarget().setPrecoLucroMaximo(precoLucroMaxNovo);
    getComponenteTarget().setPrecoLucroMinimo(precoLucroMinNovo);
  }
  
  public Componente getComponenteTarget() {
    return componenteTarget;
  }
  public void setComponenteTarget(Componente componenteTarget) {
    this.componenteTarget = componenteTarget;
  }
	@Override
	public String toString() {
		return "Memento [modelo=" + modelo + "]";
	}
  
  
}
