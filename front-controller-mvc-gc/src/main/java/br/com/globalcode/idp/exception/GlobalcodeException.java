package br.com.globalcode.idp.exception;

public class GlobalcodeException extends Exception{

    public GlobalcodeException(String mensagem) {
        super(mensagem);
    }
    
    public GlobalcodeException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
