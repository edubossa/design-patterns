<%@ page import="br.com.globalcode.idp.model.Membership" %>
<%@ page import="br.com.globalcode.idp.dao.MembershipDAO"%>
 
<%
  long codigo = 0;
  if(request.getParameter("textCodigo")!=null) codigo = Long.parseLong(request.getParameter("textCodigo"));
  String nome        = request.getParameter("textNome");
  String endereco    = request.getParameter("textEndereco");
  Membership membership = new Membership(codigo, nome, endereco);
  MembershipDAO.getInstance().save(membership);
  response.sendRedirect(request.getContextPath() + "/index.jsp?page=membership/grid.jsp");
%>