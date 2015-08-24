package br.com.globalcode.lab5.model;

public class ComputadorIterator {
  private Computador computador;
  private int current;
  private int steps;
  public ComputadorIterator(Computador c) {
    this.computador=c;
  }
  public Componente proximoComponente() {
    current++;
    steps=0;
    Componente r = getComponente(computador);
    if(r==null) current--;
    return r;
  }
  public Componente componenteAnterior() {
    current--;
    steps=0;
    Componente r = getComponente(computador);
    if(r==null) current++;
    return r;
  }
  private Componente getComponente(ComponenteComposite c1) {
    Componente retorno = null;
    for(Componente c: c1.componentes) {
      steps++;
      if(c instanceof ComponenteComposite) {
        if(steps==current) {
          retorno=c;
          break;
        } else {
          Componente c11 = getComponente((ComponenteComposite) c);
          if(steps==current) return c11;
        }
      } else {
        if(steps==current) {
          retorno = c;
          break;
        }
      }
    }
    return retorno;
  }
}
