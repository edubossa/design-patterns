package br.com.globalcode.idp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FormatHelper {
  private static FormatHelper instance = new FormatHelper();
  private SimpleDateFormat dataCompleta=new SimpleDateFormat("dd/MM/yyyy hh:mm");
  private SimpleDateFormat dataSimples=new SimpleDateFormat("dd/MM/yyyy");
  private SimpleDateFormat dataDatabase=new SimpleDateFormat("yyyy-MM-dd hh:mm");

  public static FormatHelper getInstance() {
    return instance;
  }
  private FormatHelper() {
  }
  public String fullDateFormat(java.util.Date data) {
    if(data==null || data.equals("")) return "";
    else return dataCompleta.format(data);
  }
  public String simpleDateFormat(java.util.Date data) {
    if(data==null || data.equals("")) return "";
    else return dataSimples.format(data);
  }
  public String databaseDateFormat(java.util.Date data) {
    if(data==null || data.equals("")) return "";
    else return dataDatabase.format(data);
  }
  public java.util.Date parseSimpleDate(String data) throws ParseException {
    if(data==null || data.equals(""))
      return null;
    else {
      return dataSimples.parse(data);
    }
  }
}