<table width="100%" border="1" cellpadding="2" cellspacing="0" bordercolor="#FFFFFF" >
  <tr> 
    <td class="MenuTopico"><p>--&gt;Memberships</p></td>
  </tr>
  <tr> 
    <td class="MenuItem"><a href="<%= request.getContextPath() %>/index.jsp?page=membership/grid.jsp">Visualizar cadastro</a></td>
  </tr>
  <tr> 
    <td class="MenuItem"><a href="<%= request.getContextPath()%>/index.jsp?page=membership/formdata.jsp?textCodigo=0">Adicionar 
      membership</a></td>
  </tr>
  <tr> 
  </tr>
  <tr> 
    <td>&nbsp;</td>
  </tr>
  <tr> 
    <td class="MenuTopico">--&gt;Turmas</td>
  </tr>
  <tr> 
    <td class="MenuItem"><a href="<%= request.getContextPath()%>/index.jsp?page=turmas/grid.jsp">Visualizar turmas</a></td>
  </tr>
  <tr> 
    <td class="MenuItem"><a href="<%= request.getContextPath()%>/index.jsp?page=turmas/formdata.jsp&textCodigoTurma=0">Adicionar 
      nova turma</a></td>
  </tr>
  <tr> 
    <td class="MenuItem">
		<% if(request.getParameter("textCodigoTurma")!=null 
			&& !request.getParameter("textCodigoTurma").equals("")
			&& !request.getParameter("textCodigoTurma").equals("0") ) {
		    	out.println("<a href=\""+ request.getContextPath() + "/index.jsp?page=matriculas/formdata.jsp&textCodigoTurma=" + request.getParameter("textCodigoTurma") + "\">");
			}			
	 	%>
			Matricular aluno na turma</a></td>
  </tr>
  <tr> 
    <td class="MenuItem">
		<% if(request.getParameter("textCodigoTurma")!=null 
			&& !request.getParameter("textCodigoTurma").equals("")
			&& !request.getParameter("textCodigoTurma").equals("0") ) {
		    	out.println("<a href=\"" + request.getContextPath() + "/turmas/formdelete.jsp?textCodigoTurma=" + request.getParameter("textCodigoTurma") + "\">");
			}			
	 	%>
	Excluir turma do sistema</td>
  </tr>
  <tr> 
    <td height="25">&nbsp;</td>
  </tr>
  <tr> 
    <td class="MenuTopico">--&gt;Cursos</td>
  </tr>
  <tr> 
    <td class="MenuItem"><a href="<%= request.getContextPath()%>/index.jsp?page=cursos/grid.jsp">Visualizar cursos</a></td>
  </tr>
  <tr> 
    <td class="MenuItem"><a href="<%= request.getContextPath()%>/index.jsp?page=cursos/formdata.jsp&textCodigo=0">Criar 
      novo curso</a></td>
  </tr>
</table>

