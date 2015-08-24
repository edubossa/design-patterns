<%@ page errorPage="/shared/erros/generico.jsp"%>
<html>
<head>
<title>33 Design Patterns com Java - Globalcode</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link href="<%= request.getContextPath() %>/shared/aa.css" rel="stylesheet" type="text/css">
</head>
<%
String pagedata = request.getParameter("page");
if(pagedata==null || pagedata.equals("")) pagedata="welcome.jsp";
%>
<body link="#FFFFFF">
<table width="100%" border="1" cellpadding="2" cellspacing="0" bordercolor="#CCCCCC">
  <tr>
    <td colspan="2"><jsp:include page="shared/top.jsp" flush="true" /></td>
  </tr>
  <tr valign="top"> 
    <td width="24%"> 
      <jsp:include page="menu.jsp" flush="true" /></td>
    <td width="76%"> 
      <jsp:include page="<%= pagedata %>" flush="true" /> 
	</td>
  </tr>
  <tr>
    <td colspan="2"><jsp:include page="shared/bottom.jsp" flush="true" /></td>
  </tr>
</table>
</body>
</html>
