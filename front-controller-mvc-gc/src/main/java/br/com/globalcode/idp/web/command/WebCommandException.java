package br.com.globalcode.idp.web.command;
import javax.servlet.ServletException;

public class WebCommandException extends ServletException {
    
        public WebCommandException() {
            super();
        }
	public WebCommandException(String msg) {
		super(msg);
	}
	public WebCommandException(String msg, Throwable e) {
		super(msg,e);
	}
}
