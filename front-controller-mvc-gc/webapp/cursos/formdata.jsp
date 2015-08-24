<%@ page import="br.com.globalcode.idp.model.Curso" %>
<%@ page import="br.com.globalcode.idp.dao.CursoDAO"%>
<%@ page import="br.com.globalcode.idp.exception.GlobalcodeException"%>


<form name="form1" method="post" action="${pageContext.servletContext.contextPath}/controller?command=curso.Salvar">
  <table width="100%" border="0" cellspacing="2" cellpadding="0">
    <tr> 
      <td width="23%" height="16" class="tituloCampo">C&oacute;digo Curso</td>
      <td width="77%" class="tituloCampo">Nome / Apelido</td>
    </tr>
    <tr> 
      <td class="Campo"> <input name="textCodigo" type="text" id="textCodigo" value="${curso.codigoCurso}" size="18" maxlength="12"></td>
      <td class="Campo"> <input name="textNome" type="text" id="textNome" value="${curso.nome}" size="40" maxlength="255"> 
        <input name="textApelido" type="text" id="textApelido" value="${curso.apelido}" size="20" maxlength="32"> 
      </td>
    </tr>
    <tr> 
      <td class="tituloCampo">Carga Hor&aacute;ria</td>
      <td class="tituloCampo">Descri&ccedil;&atilde;o</td>
    </tr>
    <tr> 
      <td class="Campo"><input name="textCargaHoraria" type="text" id="textCargaHoraria" value="${curso.cargaHoraria}" size="18" maxlength="12"></td>
      <td class="Campo"><input name="textDescricao" type="text" id="textDescricao" value="${curso.descricao}" size="60" maxlength="255"></td>
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
      <td colspan="2" class="Campo"><a href="${pageContext.servletContext.contextPath}/controller?command=curso.Excluir&textCodigo=${curso.codigoCurso}"><font color="#FF0000">Excluir 
        este curso do sistema</font></a></td>
    </tr>
  </table>
</form>

