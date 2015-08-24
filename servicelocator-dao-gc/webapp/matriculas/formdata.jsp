<%@ page import="br.com.globalcode.idp.model.*" %>
<%@ page import="br.com.globalcode.idp.dao.*"%>
<%@ page import="br.com.globalcode.idp.util.Debug" %>

<%
  long codigoTurma = 0;
  long codigoMatricula = 0;
  Matricula matricula = null;
  if(request.getParameter("textCodigoTurma")!=null) codigoTurma = Long.parseLong(request.getParameter("textCodigoTurma"));
  if(request.getParameter("textCodigoMatricula")!=null) codigoMatricula = Long.parseLong(request.getParameter("textCodigoMatricula"));

  //Edição
  if(codigoMatricula!=0) {
  
    matricula = MatriculaDAO.getInstance().getMatricula(codigoMatricula);
  }
  else {
    matricula = new Matricula();
    matricula.setCodigoTurma(codigoTurma);
  }
%>
<form name="form1" method="post" action="<%= request.getContextPath() + "/matriculas/formsave.jsp" %>">
  <%
  /*No input hidden abaixo colacamos o código da turma condicionalmente:
     - Caso de nova matrícula, faz leitura do código no request
	 - Caso de uma edição de matrícula,

	*/
  %>
  <input type="hidden" name="textCodigoTurma" value="<%= matricula.getCodigoMatricula()==0 ? request.getParameter("textCodigoTurma") : "" + matricula.getCodigoTurma() %>">

  <table width="100%" border="0" cellspacing="2" cellpadding="0">
    <tr>
      <td width="31%" height="19" class="tituloCampo">C&oacute;digo Matr&iacute;cula</td>
      <td class="tituloCampo">Nome Aluno</td>
      <td class="tituloCampo">Data Matr&iacute;cula</td>
    </tr>
    <tr>
      <td class="Campo"> <input name="textCodigoMatricula" type="text" id="textCodigoMatricula" value="<%= matricula.getCodigoMatricula() %>" size="18" maxlength="12" readonly="true"></td>
      <td width="50%" class="Campo">
	  <%
	  //Se é uma nova matrícula, abre um combo para escolher o nome do membership / aluno
	  //Se é uma edição, apresenta o nome do membership e não permite edição
	  if(matricula.getCodigoMatricula()!=0) {
	  %>
	  		<%= matricula.getNomeMembership() %>
			<input type="hidden" name="comboMemberships" value="<%= matricula.getCodigoMembership() %>">
	  <%}
	  else {
        char aspas = '\"';
        Membership memberships[] = null;
        Debug.log("Lendo cursos do DAO para o ComboTag", 9);
        memberships = MembershipDAO.getInstance().getMemberships(true);
        Debug.log("Montando tag combo", 9);
        out.println("<select name=" + aspas + "comboMemberships"  + aspas +
                                 " class=" + aspas + "" + aspas + ">");
        boolean sel = false;
		String value = matricula!=null ? "" + matricula.getCodigoMembership() : "";
        for(int x=0;x<memberships.length;x++) {
          sel=(value!=null && value.equals("" + memberships[x].getCodigoMembership()));
          out.println("<option value=" + aspas + memberships[x].getCodigoMembership() + aspas +
                                     (sel ? " selected " : "") +
                                     ">" + memberships[x].getNome() + "</option>");
        }
        out.println("</select>");
	  }
	  %>
      </td>
      <td width="19%" class="Campo"><input name="textDataMatricula" type="text" id="textDataMatricula" value="<%= br.com.globalcode.idp.util.FormatHelper.getInstance().simpleDateFormat(matricula.getDataMatricula()) %>" size="18" maxlength="12"></td>
    </tr>
    <tr>
      <td colspan="3" class="Campo">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="3" class="Campo"> <div align="center">
          <input type="submit" name="Submit" value="Salvar">
          <input type="reset" name="Submit2" value="Desfazer altera&ccedil;&otilde;es">
          <input name="voltar" type="button" onClick="history.back(1);" value="Voltar">
        </div></td>
    </tr>
    <tr>
      <td colspan="3" class="Campo"><a href="<%= request.getContextPath() + "/matriculas/formdelete.jsp?textCodigoMatricula=" + matricula.getCodigoMatricula() %>"><font color="#FF0000">Excluir
        esta matr&iacute;cula do sistema</font></a></td>
    </tr>
  </table>
</form>
