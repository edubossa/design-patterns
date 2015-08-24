<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="br.com.globalcode.idp.model.Curso" %>
<html>
<head>
<title>Academia do Arquiteto - AA1 - Lab 01</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link href="../aa.css" rel="stylesheet" type="text/css">
</head>

<body>
<table width="100%" border="1" cellpadding="2" cellspacing="0" bordercolor="#CCCCCC">
  <tr> 
    <td colspan="2"><jsp:include page="../top.jsp" flush="true" /></td>
  </tr>
  <tr> 
    <td width="27%">
	<jsp:include page="/menu.jsp" flush="true" /></td>
    <td width="73%" valign="top"><p class="Campo">Aluno j&aacute; matriculado 
        na turma.</p>
		<p></p>
      <p>
        <input name="voltar" type="button" onClick="history.back(1);" value="Voltar">
      </p></td>
  </tr>
  <tr> 
    <td colspan="2"><jsp:include page="../bottom.jsp" flush="true" /></td>
  </tr>
</table>
</body>
</html>
