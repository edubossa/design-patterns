package br.com.globalcode.factory;

import br.com.globalcode.command.BaseCommand;

public interface CommandFactory {
    
    public BaseCommand create(String name);
}
