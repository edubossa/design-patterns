package br.com.ews.design.test;

import org.junit.Test;

import br.com.ews.design.memento.FileWriterCaretaker;
import br.com.ews.design.memento.FileWriterUtil;

public class FilewriterTest {

	@Test
	public void testMemento() {
		
		FileWriterCaretaker caretaker = new FileWriterCaretaker();
		
		FileWriterUtil fw = new FileWriterUtil("relatorio.txt");
		fw.write("Primeira linha do arquivo");
		
		System.out.println(fw);
		
		caretaker.save(fw);
		
		fw.write("\nSegunda linha do arquivo");
		
		System.out.println("-------------------------------------------------");
		System.out.println(fw);
		
		caretaker.undo(fw);
		
		System.out.println();
		System.out.println("-------------------[undo]-------------------------");
		System.out.println();
		System.out.println(fw);
		
	}

}
