package apostila.laboratorio6;

import apostila.laboratorio6.model.*;

public class UIStateEdit extends UIState{
  public UIStateEdit(UIForm form) {
    super(form);
  }
  public void save() {
    form.getCaretakerUI().add(
      new Memento((Componente) form.getCurrentData()));
    System.out.println("Salvando dados no objeto");
    form.bindUIToObject();
  }
  public void cancel() {
    form.bindCurrentRecord();
    form.getCaretakerUI().removeLast();
  }
  public void setupUI() {
    form.uiEditable(true);
    
  }
}
