<%@ page import="br.com.globalcode.idp.model.Membership" %>
<%@ page import="br.com.globalcode.idp.dao.MembershipDAO"%>
<%@ page import="br.com.globalcode.idp.exception.GlobalcodeException"%>
 
<%
  String strCodigo = request.getParameter("textCodigo");
  if(strCodigo == null || strCodigo.equals("") || strCodigo.equals("0")) {
    throw new GlobalcodeException("Parametro para execu��o do servlet textCodigo inv�lido ou inexistente.");
  }
  Membership membership = new Membership(Long.parseLong(strCodigo), "");
  MembershipDAO.getInstance().delete(membership);
  response.sendRedirect(request.getContextPath() + "/index.jsp?page=membership/grid.jsp");
%>
