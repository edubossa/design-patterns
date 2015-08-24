<%@ page import="br.com.globalcode.idp.model.Curso" %>
<%@ page import="br.com.globalcode.idp.dao.CursoDAO"%>
<%@ page import="br.com.globalcode.idp.exception.GlobalcodeException"%>

<%
  String strCodigo = request.getParameter("textCodigo");
  if (strCodigo == null || strCodigo.equals("") || strCodigo.equals("0")) {
    throw new GlobalcodeException("Parametro para execução do servlet textCodigo inválido ou inexistente.");
  }
  Curso curso = null;
  curso = new Curso(Long.parseLong(strCodigo), "", "");
  CursoDAO.getInstance().delete(curso);
  response.sendRedirect(request.getContextPath() + "/index.jsp?page=cursos/grid.jsp");


%>
 
 