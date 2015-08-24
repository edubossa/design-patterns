<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
    <c:forEach var="matricula" items="${matriculas}" >
        <tr>
            <td class="gridCampo"><fmt:formatDate pattern="dd/MM/yyyy" value="${matricula.dataMatricula}" /></td>
            <td class="gridCampo"><a href="${pageContext.servletContext.contextPath}/controller?command=matricula.Editar&textCodigoMatricula=${matricula.codigoMatricula}">
            <font color="#FF0000">${matricula.aluno.nome}</font></a></td>
        </tr>
    </c:forEach>
</table>

