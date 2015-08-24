package br.com.ews.design.memento;

/**
 * Memento pattern is implemented with two objects – Originator and Caretaker.
 * Originator is the object whose state needs to be saved and restored and it
 * uses an inner class to save the state of Object.
 * <p>
 * <b>Originator Class</b>
 */
public class FileWriterUtil {

	private String fileName;
	private StringBuilder content;

	public FileWriterUtil(String fileName) {
		this.fileName = fileName;
		this.content = new StringBuilder();
	}

	public void write(String s) {
		content.append(s);
	}

	@Override
	public String toString() {
		return content.toString();
	}

	public Memento save() {
		return new Memento(this.fileName, this.content);
	}

	public void undoToLastSave(Object obj) {
		Memento memento = (Memento) obj;
		this.fileName = memento.fileName;
		this.content = memento.content;
	}

	private class Memento {

		private String fileName;
		private StringBuilder content;

		public Memento(String fileName, StringBuilder content) {
			this.fileName = fileName;
			this.content = new StringBuilder(content);
		}
	}

}
