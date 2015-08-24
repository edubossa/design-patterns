<%@ page import="br.com.globalcode.idp.model.*" %>
<%@ page import="br.com.globalcode.idp.util.FormatHelper"%>

<%
Matricula matriculas[] = (Matricula[]) request.getAttribute("matriculas");
%>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="MenuTopico">Matriculas</td>
  </tr>
</table>

<table width="100%" border="0" cellspacing="2" cellpadding="0">
  <tr>
    <td width="17%" class="gridTopico">Data Matr&iacute;cula</td>
    <td width="83%" class="gridTopico">Nome Aluno</td>
  </tr>
  <%
	if(matriculas!=null) {
		for(int x=0;x<matriculas.length;x++) {
	%>
  <tr>
    <td class="gridCampo"><%= FormatHelper.getInstance().simpleDateFormat(matriculas[x].getDataMatricula()) %></td>
    <td class="gridCampo"><a href="<%= request.getContextPath() + "/index.jsp?page=matriculas/formdata.jsp&textCodigoMatricula=" + matriculas[x].getCodigoMatricula() %>">
      <font color="#FF0000"><%= matriculas[x].getAluno().getNome() %></font></a></td>
  </tr>
  <%
		} //término laço for
	} //término if(cursos!=null)
	%>
</table>

