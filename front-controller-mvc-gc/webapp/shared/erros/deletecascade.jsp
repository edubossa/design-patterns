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
    <td width="73%" valign="top"><p class="Campo">Erro ao excluir dado do sistema.</p>
      <p class="Campo">Este erro ocorre tipicamente quando:</p>
      <ol>
        <li class="Campo">Voc&ecirc; tenta exlcuir um membership que est&aacute; 
          matriculado em algum curso. Neste caso exclua as matr&iacute;culas antes.</li>
        <li class="Campo">Voc&ecirc; tenta exlcuir um curso possu&iacute; turmas. 
          Neste caso exclua as turmas antes.</li>
        <li class="Campo">Voc&ecirc; tenta exlcuir uma turma que possu&iacute; 
          matr&iacute;culas. Neste caso exclua as matr&iacute;culas antes.</li>
      </ol>
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
