<%@ page import="br.com.globalcode.idp.model.*" %>
<%@ page import="br.com.globalcode.idp.dao.TurmaDAO"%>
<%@ page import="br.com.globalcode.idp.exception.GlobalcodeException"%>
<%@ page import="br.com.globalcode.idp.util.*"%>

<%
    Turma turmas[] = TurmaDAO.getInstance().getTurmas(true);
%>

<table width="100%" border="0" cellspacing="2" cellpadding="0">
  <tr>
    <td width="15%" class="gridTopico">C&oacute;digo</td>
    <td width="15%" class="gridTopico">Data In&iacute;cio</td>
    <td width="26%" class="gridTopico">Curso</td>
    <td width="44%" class="gridTopico">Descri&ccedil;&atilde;o</td>
  </tr>
  <%
	if(turmas!=null) {
		for(int x=0;x<turmas.length;x++) {
	%>
  <tr>
    <td class="gridCampo"><%= turmas[x].getCodigoTurma() %></td>
    <td class="gridCampo"><%= br.com.globalcode.idp.util.FormatHelper.getInstance().simpleDateFormat(turmas[x].getDataInicio()) %></td>
    <td class="gridCampoComLink"> <a href="<%= request.getContextPath() + "/index.jsp?page=turmas/formdata.jsp&textCodigoTurma=" + turmas[x].getCodigoTurma() %>">
      <font color="#FF0000"><%= turmas[x].getCurso().getNome() %></font></a></td>
    <td class="gridCampoComLink"><%= turmas[x].getDescricao() %></td>
  </tr>
  <%
		} //término laço for
	} //término if(cursos!=null)
	%>
</table>


