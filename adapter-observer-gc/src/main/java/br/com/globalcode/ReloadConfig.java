package br.com.globalcode;

import br.com.globalcode.observer.*;
import java.io.File;

public class ReloadConfig implements FileObserver{
    
    Aplicativo aplicativo;
    
    public ReloadConfig(Aplicativo aplicativo) {
        this.aplicativo = aplicativo;
    }
    
     public void fileChanged(File f) {
         System.out.println("Arquivo foi alterado!!!");
         aplicativo.initCommandFactory();
    }
}
