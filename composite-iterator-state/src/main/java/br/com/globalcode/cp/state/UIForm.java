package br.com.globalcode.cp.state;

public interface UIForm {
  void bindCurrentRecord();
  void changeState(UIState newState);
  void uiEditable(boolean editable);
  Object getCurrentData();
  void setCurrentData(Object o);
}
