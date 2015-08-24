<%@ page import="br.com.globalcode.idp.model.Curso" %>
<%@ page import="br.com.globalcode.idp.dao.CursoDAO"%>
<%@ page import="br.com.globalcode.idp.exception.GlobalcodeException"%>

<%
  String strCodigo = request.getParameter("textCodigo");
  if(strCodigo == null || strCodigo.equals("")) {
    throw new GlobalcodeException("Parametro para execução do servlet textCodigo inválido ou inexistente.");
  }
  Curso curso = null;
  if(strCodigo.equals("0")) {
    curso = new Curso();
  }
  else {
    curso = CursoDAO.getInstance().getCurso(Long.parseLong(strCodigo));
  }
%>

<form name="form1" method="post" action="<%= request.getContextPath() + "/" %>cursos/formsave.jsp">
  <table width="100%" border="0" cellspacing="2" cellpadding="0">
    <tr> 
      <td width="23%" height="16" class="tituloCampo">C&oacute;digo Curso</td>
      <td width="77%" class="tituloCampo">Nome / Apelido</td>
    </tr>
    <tr> 
      <td class="Campo"> <input name="textCodigo" type="text" id="textCodigo" value="<%= curso.getCodigoCurso() %>" size="18" maxlength="12"></td>
      <td class="Campo"> <input name="textNome" type="text" id="textNome" value="<%= curso.getNome() %>" size="40" maxlength="255"> 
        <input name="textApelido" type="text" id="textApelido" value="<%= curso.getApelido() %>" size="20" maxlength="32"> 
      </td>
    </tr>
    <tr> 
      <td class="tituloCampo">Carga Hor&aacute;ria</td>
      <td class="tituloCampo">Descri&ccedil;&atilde;o</td>
    </tr>
    <tr> 
      <td class="Campo"><input name="textCargaHoraria" type="text" id="textCargaHoraria" value="<%= curso.getCargaHoraria() %>" size="18" maxlength="12"></td>
      <td class="Campo"><input name="textDescricao" type="text" id="textDescricao" value="<%= curso.getDescricao() %>" size="60" maxlength="255"></td>
    </tr>
    <tr> 
      <td colspan="2" class="Campo">&nbsp;</td>
    </tr>
    <tr> 
      <td colspan="2" class="Campo"> <input type="submit" name="Submit" value="Salvar"> 
        <input type="reset" name="Submit2" value="Desfazer altera&ccedil;&otilde;es">
        <input name="Submit3" type="button" onClick="history.back(1);" value="Voltar"> </td>
    </tr>
    <tr>
      <td colspan="2" class="Campo"><a href="<%= request.getContextPath() + "/cursos/formdelete.jsp?textCodigo=" +  curso.getCodigoCurso() %>"><font color="#FF0000">Excluir 
        este curso do sistema</font></a></td>
    </tr>
  </table>
</form>

