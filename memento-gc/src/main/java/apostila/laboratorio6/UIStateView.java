package apostila.laboratorio6;

public class UIStateView extends UIState{
  public UIStateView(UIForm form) {
    super(form);
  }
  public void save() {
    System.out.println("Nada a fazer, apenas visualizando...");
  }
  public void cancel() {
    System.out.println("Nada a fazer, apenas visualizando...");
  }
  public void setupUI() {
    form.uiEditable(false);
  }
}
