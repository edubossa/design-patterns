<%@ page import="br.com.globalcode.idp.model.Membership" %>
<%@ page import="br.com.globalcode.idp.dao.MembershipDAO"%>
<%@ page import="br.com.globalcode.idp.exception.GlobalcodeException"%>

<%
    String strCodigo = request.getParameter("textCodigo");
    if(strCodigo == null || strCodigo.equals("")) {
      throw new GlobalcodeException("Parametro para execução do servlet textCodigo inválido ou inexistente.");
    }
    Membership membership = null;
    if(strCodigo.equals("0")) {
      membership = new Membership();
    }
    else {
      membership = MembershipDAO.getInstance().getMembership(Long.parseLong(strCodigo), false);
    }
%>
<form name="form1" method="post" action="<%= request.getContextPath() + "/membership/formsave.jsp?" %>">
  <table width="100%" border="0" cellspacing="2" cellpadding="0">
    <tr>
      <td width="23%" height="16" class="tituloCampo">C&oacute;digo Membership</td>
      <td width="77%" class="tituloCampo">Nome </td>
    </tr>
    <tr>
      <td class="Campo"> <input name="textCodigo" type="text" id="textCodigo" value="<%= membership.getCodigoMembership() %>" size="18" maxlength="12"></td>
      <td class="Campo"> <input name="textNome" type="text" id="textNome" value="<%= membership.getNome() %>" size="40" maxlength="255">
      </td>
    </tr>
    <tr>
      <td class="tituloCampo">Cadastrado desde</td>
      <td class="tituloCampo">Endere&ccedil;o</td>
    </tr>
    <tr>
      <td class="Campo"><input name="textDataInclusao" type="text" id="textDataInclusao" value="<%= br.com.globalcode.idp.util.FormatHelper.getInstance().fullDateFormat(membership.getDataInclusao()) %>" size="18" maxlength="12"></td>
      <td class="Campo"><input name="textEndereco" type="text" id="textEndereco" value="<%= membership.getEndereco() %>" size="60" maxlength="255"></td>
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
      <td colspan="2" class="Campo"><a href="<%= request.getContextPath() + "/membership/formdelete.jsp?textCodigo=" + membership.getCodigoMembership()%>"><font color="#FF0000">Excluir
        este membership do sistema</font></a></td>
    </tr>
  </table>
</form>

