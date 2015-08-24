<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<form name="form1" method="post" action="${pageContext.servletContext.contextPath}/controller?command=membership.Salvar">
  <table width="100%" border="0" cellspacing="2" cellpadding="0">
    <tr>
      <td width="23%" height="16" class="tituloCampo">C&oacute;digo Membership</td>
      <td width="77%" class="tituloCampo">Nome </td>
    </tr>
    <tr>
      <td class="Campo"> <input name="textCodigo" type="text" id="textCodigo" value="${aluno.codigoMembership}" size="18" maxlength="12"></td>
      <td class="Campo"> <input name="textNome" type="text" id="textNome" value="${aluno.nome}" size="40" maxlength="255">
      </td>
    </tr>
    <tr>
      <td class="tituloCampo">Cadastrado desde</td>
      <td class="tituloCampo">Endere&ccedil;o</td>
    </tr>
    <tr>
        <td class="Campo"><input name="textDataInclusao" type="text" id="textDataInclusao" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${aluno.dataInclusao}"/>' size="18" maxlength="12"></td>
      <td class="Campo"><input name="textEndereco" type="text" id="textEndereco" value="${aluno.endereco}" size="60" maxlength="255"></td>
    </tr>
    <tr>
      <td colspan="2" class="Campo">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2" class="Campo"> <div align="center">
          <input type="submit" name="Submit" value="Salvar">
          <input type="reset" name="Submit2" value="Desfazer altera&ccedil;&otilde;es">
          <input name="voltar" type="button" onClick="history.back(1);" value="Voltar">
        </div></td>
    </tr>
    <tr>
      <td colspan="2" class="Campo"><a href="${pageContext.servletContext.contextPath}/controller?command=membership.Excluir&textCodigo=${aluno.codigoMembership}"><font color="#FF0000">Excluir
        este membership do sistema</font></a></td>
    </tr>
  </table>
</form>

