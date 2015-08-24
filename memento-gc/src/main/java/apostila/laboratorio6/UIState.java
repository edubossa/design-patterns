package apostila.laboratorio6;

public abstract class UIState {
  protected UIForm form;
  public UIState(UIForm form) {
    this.form= form;
  }
  public void save() {
  }
  public void cancel() {
  }
  public void setupUI() {
  }
}
