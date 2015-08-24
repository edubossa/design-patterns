<%@ page import="br.com.globalcode.idp.model.*" %>
<%@ page import="br.com.globalcode.idp.dao.*"%>
<%@ page import="br.com.globalcode.idp.util.FormatHelper"%>

<%
  long codigo = 0;
  Matricula matricula = null;
  if(request.getParameter("textCodigoMatricula")!=null) codigo = Long.parseLong(request.getParameter("textCodigoMatricula"));
  String dataMatricula = null;
  String codigoTurma = null;
  String codigoMembership = null;
  java.util.Date dateMatricula = null;
  codigoMembership = request.getParameter("comboMemberships");
  dataMatricula = request.getParameter("textDataMatricula");
  dateMatricula = FormatHelper.getInstance().parseSimpleDate(dataMatricula);
  codigoTurma = request.getParameter("textCodigoTurma");
  long longCodigoMember = Long.parseLong(codigoMembership);
  long longCodigoTurma = Long.parseLong(codigoTurma);
  matricula = new Matricula(codigo, dateMatricula, longCodigoTurma, longCodigoMember);
  MatriculaDAO.getInstance().save(matricula);
  response.sendRedirect(request.getContextPath() + "/index.jsp?page=turmas/formdata.jsp&textCodigoTurma=" + codigoTurma);
%>

