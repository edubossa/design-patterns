<%@ page import="br.com.globalcode.idp.model.*" %>
<%@ page import="br.com.globalcode.idp.dao.*"%>
<%@ page import="br.com.globalcode.idp.exception.GlobalcodeException"%>
<%@ page import="br.com.globalcode.idp.util.Debug"%>

<%
    String strCodigo = request.getParameter("textCodigoTurma");
    if(strCodigo == null || strCodigo.equals("")) {
      throw new GlobalcodeException("Parametro para execução do jsp textCodigo inválido ou inexistente.");
    }
    Turma turma = null;
    Matricula matriculas[] = null;
    if(strCodigo.equals("0")) {
      turma = new Turma();
    }
    else {
      turma = TurmaDAO.getInstance().getTurma(Long.parseLong(strCodigo));
      matriculas = MatriculaDAO.getInstance().getMatriculas(turma.getCodigoTurma());
      request.setAttribute("matriculas", matriculas);
    }
	
%>
<form name="form1" method="post" action="<%= request.getContextPath() + "/turmas/formsave.jsp" %>">
  <table width="100%" border="0" cellspacing="2" cellpadding="0">
    <tr>
      <td width="40%" height="19" class="tituloCampo">C&oacute;digo Turma</td>
      <td class="tituloCampo">Descri&ccedil;&atilde;o</td>
      <td class="tituloCampo">Data In&iacute;cio</td>
    </tr>
    <tr>
      <td class="Campo"> <input name="textCodigoTurma" type="text" id="textCodigoTurma" value="<%= turma.getCodigoTurma() %>" size="18" maxlength="12" readonly="true"></td>
      <td width="41%" class="Campo"> <input name="textDescricao" type="text" id="textDescricao" value="<%= turma.getDescricao() %>" size="40" maxlength="255">
      </td>
      <td width="19%" class="Campo"><input name="textDataInicio" type="text" id="textDataInicio" value="<%= br.com.globalcode.idp.util.FormatHelper.getInstance().simpleDateFormat(turma.getDataInicio()) %>" size="18" maxlength="12"></td>
    </tr>
    <tr>
      <td class="tituloCampo">Curso</td>
      <td class="tituloCampo">Per&iacute;odo</td>
      <td class="tituloCampo">Data T&eacute;rmino</td>
    </tr>
    <tr>
      <td class="Campo">	  
	  <%
      char aspas = '\"';
      Curso cursos[] = null;
      Debug.log("Lendo cursos do DAO para o ComboTag", 9);
      cursos = CursoDAO.getInstance().getCursos(true);
      Debug.log("Montando tag combo", 9);
      out.println("<select name=" + aspas + "comboCursos"  + aspas +
                                 " class=" + aspas + "" + aspas + ">");
      boolean sel = false;
	  String value = turma!=null ? ("" + turma.getCurso().getCodigoCurso()) : "";
      for(int x=0;x<cursos.length;x++) {
        sel=(value!=null && value.equals("" + cursos[x].getCodigoCurso()));
        out.println("<option value=" + aspas + cursos[x].getCodigoCurso() + aspas +
                                   (sel ? " selected " : "") +
                                   ">" + cursos[x].getNome() + "</option>");
      }
      out.println("</select>");
	  %>
	  </td>
      <td class="Campo">
	  <%
      out.println("<select name=" + aspas + "comboPeriodos" + aspas +
                                 " class=" + aspas + "" + aspas + ">");
      sel = false;
	  value = turma!=null ? turma.getPeriodo() : "";
	  
      for(int x=0;x<periodos.length;x++) {
        sel=(value!=null && value.equals("" + periodos[x].getDescricao()));
        out.println("<option value=" + aspas + periodos[x].getDescricao() + aspas +
                                   (sel ? " selected " : "") +
                                   ">" + periodos[x].getDescricao() + "</option>");
      }
      out.println("</select>");
	  %>
	  </td>
      <td class="Campo"><input name="textDataTermino" type="text" id="textDataTermino" value="<%= br.com.globalcode.idp.util.FormatHelper.getInstance().simpleDateFormat(turma.getDataTermino()) %>" size="18" maxlength="12"></td>
    </tr>
    <tr>
      <td class="tituloCampo">N&uacute;mero Vagas</td>
      <td colspan="2" class="Campo"><input name="textNumeroVagas" type="text" id="textNumeroVagas" value="<%= turma.getNumeroVagas() %>" size="18" maxlength="12"></td>
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
  </table>
</form>
<jsp:include page="../matriculas/grid.jsp" flush="true" />

<%!
  private Periodo[] periodos={
      new Periodo("2a e 4a Noturno"),
      new Periodo("3a e 5a Noturno"),
      new Periodo("Sábado integral"),
      new Periodo("Domingo integral"),
      new Periodo("Especial")};
  class Periodo {
    String descricao;
    Periodo(String s2) {
      this.descricao=s2;
    }
    String getDescricao() { return descricao; }
  }	  

%>