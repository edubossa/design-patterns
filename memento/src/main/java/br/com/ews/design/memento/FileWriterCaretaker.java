package br.com.ews.design.memento;

/**
 * Caretaker Class 
 */
public class FileWriterCaretaker {
	
	private Object obj;
	
	public void save(FileWriterUtil fileWrite) {
		obj = fileWrite.save();
	}
	
	public void undo(FileWriterUtil fileWrite) {
		fileWrite.undoToLastSave(obj);
	}
	
}
