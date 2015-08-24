package br.com.ews.design.observer;

/**
 * Em Observer Pattern, o objeto que assistir sobre o estado de outro objeto 
 * são chamados Observer e do objeto que está sendo observado é chamado Subject
 */
public interface Subject {
	
	/**
	 * methods to register observers
	 */
    public void register(Observer obj);
    
    /**
     * methods unregister observers
     * @param obj
     */
    public void unregister(Observer obj);
     
    /**
     * method to notify observers of change
     */
    public void notifyObservers();
     
    /**
     * method to get updates from subject
     * @param obj
     * @return
     */
    public Object getUpdate(Observer obj);
    
    /**
     * method to post message to the topic
     * @param msg
     */
    public void postMessage(String msg);
	
}
