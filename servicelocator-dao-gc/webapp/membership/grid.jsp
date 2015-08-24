<%@ page import="br.com.globalcode.idp.model.Membership" %>
<%@ page import="br.com.globalcode.idp.dao.MembershipDAO"%>


<%
    Membership memberships[] = MembershipDAO.getInstance().getMemberships(true);
%>
  <table width="100%" border="0" cellspacing="2" cellpadding="0">
    <tr>
      <td width="20%" class="gridTopico">C&oacute;digo</td>
      <td width="60%" class="gridTopico">Nome</td>
    </tr>
	<%
	if(memberships!=null) {
		for(int x=0;x<memberships.length;x++) {
	%>
	    <tr>
	      <td class="gridCampo"><%= memberships[x].getCodigoMembership() %></td>
	      <td class="gridCampoComLink">
		  	<a href="<%= request.getContextPath() + "/index.jsp?page=membership/formdata.jsp&textCodigo=" + memberships[x].getCodigoMembership() %>">
			<font color="#FF0000"><%= memberships[x].getNome() %></font></a></td>
	    </tr>
	<%
		} //término laço for
	} //término if(cursos!=null)
	%>
  </table>