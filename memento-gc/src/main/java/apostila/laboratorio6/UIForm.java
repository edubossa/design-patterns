package apostila.laboratorio6;

public interface UIForm {
  void bindCurrentRecord();

  void changeState(UIState newState);

  void uiEditable(boolean editable);
  Object getCurrentData();
  void bindUIToObject();
  void setCurrentData(Object o);
  CaretakerUI getCaretakerUI();
}
