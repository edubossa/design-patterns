<%@ page import="br.com.globalcode.idp.model.Turma" %>
<%@ page import="br.com.globalcode.idp.dao.TurmaDAO"%>
<%@ page import="br.com.globalcode.idp.exception.GlobalcodeException"%>

<%
    String strCodigo = request.getParameter("textCodigoTurma");
    if(strCodigo == null || strCodigo.equals("") || strCodigo.equals("0")) {
      throw new GlobalcodeException("Parametro para execução do jsp textCodigo inválido ou inexistente.");
    }
    Turma turma = null;
    turma = new Turma(Long.parseLong(strCodigo), null, null, null);
    TurmaDAO.getInstance().delete(turma);
    response.sendRedirect(request.getContextPath() + "/index.jsp?page=turmas/grid.jsp");
%>