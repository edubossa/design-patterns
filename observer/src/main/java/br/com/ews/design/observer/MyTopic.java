package br.com.ews.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Em Observer Pattern, o objeto que assistir sobre o estado de outro objeto 
 * são chamados Observer e do objeto que está sendo observado é chamado Subject
 * <p>
 * MyTopic - Objeto que esta sendo observado.
 */
public class MyTopic implements Subject {
	
	private List<Observer> observers;
	private String message;
	private boolean changed;
	
	/**
	 * Um mutex é um objeto bloqueável que é projetado para sinalizar quando seções 
	 * críticas do código precisa de acesso exclusivo, impedindo que outros segmentos 
	 * acessem simultaneamente as mesmas posições de memória.
	 */
	private final Object MUTEX = new Object();
	
	public MyTopic() {
		observers = new ArrayList<>();
	}
	
	@Override
	public void register(Observer obj) {
		if(obj == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
        	if(!observers.contains(obj)) observers.add(obj);
        }
	}

	@Override
	public void unregister(Observer obj) {
		synchronized (MUTEX) {
			observers.remove(obj);
		}
	}

	@Override
	public void notifyObservers() {
		List<Observer> observersLocal = null;
        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX) {
            if (!changed)
                return;
            observersLocal = new ArrayList<>(this.observers);
            this.changed=false;
        }
        for (Observer obj : observersLocal) {
            obj.update();
        }		
	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	}
	
	@Override
    public void postMessage(String msg){
        System.out.println("Message Posted to Topic:"+msg);
        this.message=msg;
        this.changed=true;
        notifyObservers();
    }
}
