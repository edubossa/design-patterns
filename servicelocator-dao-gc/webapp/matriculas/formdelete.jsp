<%@ page import="br.com.globalcode.idp.model.*" %>
<%@ page import="br.com.globalcode.idp.dao.*"%>
<%@ page import="br.com.globalcode.idp.exception.GlobalcodeException" %>

<%
    String strCodigo = request.getParameter("textCodigoMatricula");
    if(strCodigo == null || strCodigo.equals("") || strCodigo.equals("0")) {
      throw new GlobalcodeException("Parametro para execu��o do jsp textCodigo inv�lido ou inexistente.");
    }
    Matricula matricula = null;
    matricula = MatriculaDAO.getInstance().getMatricula(Long.parseLong(strCodigo));
    MatriculaDAO.getInstance().delete(matricula);
    response.sendRedirect(request.getContextPath() + "/index.jsp?page=turmas/formdata.jsp&textCodigoTurma=" + matricula.getCodigoTurma());
%>
