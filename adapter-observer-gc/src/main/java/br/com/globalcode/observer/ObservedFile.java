package br.com.globalcode.observer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ObservedFile extends File implements Runnable{
   
    private List<FileObserver> observers = new ArrayList<FileObserver>();
    private long ultimaAtualizacao = 0;
    private final long INTERVALO_OBS = 500;
    
    public ObservedFile(String name) {
        super(name);
        Thread observacao = new Thread(this);
        observacao.start();
    }
    
    
    public void run() {
        ultimaAtualizacao = this.lastModified();
        while(true) {
            if (ultimaAtualizacao!= this.lastModified()) {
                notifyObservers();
                ultimaAtualizacao = this.lastModified();
            }
            try {
                Thread.sleep(INTERVALO_OBS);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
    
    public void addObserver(FileObserver f) {
        this.observers.add(f);
    }
    
    public void notifyObservers() {
        for (FileObserver observer: observers) {
            observer.fileChanged(this);
        }
    }
    
}
