package br.com.globalcode.cp.state;

public abstract class UIState {
  protected UIForm form;
  public UIState(UIForm form) {
    this.form= form;
  }
  public abstract void save();
  public abstract void cancel();
  public abstract void setupUI();
}
