package br.com.globalcode.idp.web.command;

import javax.servlet.http.HttpServletRequest;

public interface WebCommand {
  public void doAction(HttpServletRequest request) throws WebCommandException;
}
