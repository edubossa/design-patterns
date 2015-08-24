<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table width="100%" border="0" cellspacing="2" cellpadding="0">
<tr>
    <td width="20%" class="gridTopico">C&oacute;digo</td>
    <td width="60%" class="gridTopico">Nome</td>
</tr>
<c:forEach var="aluno" items="${alunos}">
    <tr>
    <td class="gridCampo">${aluno.codigoMembership}</td>
    <td class="gridCampoComLink">
    <a href="${pageContext.servletContext.contextPath}/controller?command=membership.Editar&textCodigo=${aluno.codigoMembership}">
       <font color="#FF0000">${aluno.nome}</font></a></td>
    </tr>
</c:forEach>
</table>