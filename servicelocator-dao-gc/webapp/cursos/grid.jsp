<%@ page import="br.com.globalcode.idp.model.Curso" %>
<%@ page import="br.com.globalcode.idp.dao.CursoDAO"%>


<%
    Curso[] cursos = CursoDAO.getInstance().getCursos(true);
%>
  <table width="100%" border="0" cellspacing="2" cellpadding="0">
    <tr>
      <td width="20%" class="gridTopico">C&oacute;digo</td>
      <td width="60%" class="gridTopico">Nome</td>
      <td width="20%" class="gridTopico">Apelido</td>
    </tr>
	<%
	if(cursos!=null) {
		for(int x=0;x<cursos.length;x++) {
	%>
	    <tr>
	      <td class="gridCampo"><%= cursos[x].getCodigoCurso() %></td>
	      <td class="gridCampoComLink">
		  	<a href="<%= request.getContextPath() + "/index.jsp?page=cursos/formdata.jsp&textCodigo=" + cursos[x].getCodigoCurso() %>">
			<font color="#FF0000"><%= cursos[x].getNome() %></font></a></td>
	      <td class="gridCampo"><%= cursos[x].getApelido() %></td>
	    </tr>
	<%
		} //término laço for
	} //término if(cursos!=null)
	%>

  </table>

