package br.com.globalcode.cp.state;

public class UIStateEdit extends UIState{
  public UIStateEdit(UIForm form) {
    super(form);
  }
  public void save() {
    System.out.println("Salvando dados no objeto");
  }
  public void cancel() {
    form.bindCurrentRecord();
  }
  public void setupUI() {
    form.uiEditable(true);
  }
}
