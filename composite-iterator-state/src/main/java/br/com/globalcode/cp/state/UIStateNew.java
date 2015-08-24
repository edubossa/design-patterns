package br.com.globalcode.cp.state;

public class UIStateNew extends UIState{
  private Object oldOne;
  public UIStateNew(UIForm form) {
    super(form);
  }
  public void save() {
    System.out.println("Salvando novo objeto");
  }
  public void cancel() {
    form.setCurrentData(oldOne);
    form.bindCurrentRecord();
  }
  public void setupUI() {
    oldOne=form.getCurrentData();
    form.uiEditable(true);
  } 
}
