package apostila.laboratorio6;

import java.util.ArrayList;
import java.util.Collection;

public class CaretakerUI {
  private Collection<Memento> mementos;
  private Memento lastOne;
  
  public CaretakerUI() {
    mementos=new ArrayList<Memento>();
  }

  void add(Memento memento) {
    mementos.add(memento);
    lastOne = memento;
    
  }
  void removeLast() {
    if(lastOne!=null) {
      mementos.remove(lastOne);
      lastOne=null;
    }
  }
  public Memento getLast() {
    return lastOne;
  }
}
