<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table width="100%" border="0" cellspacing="2" cellpadding="0">
    <tr>
        <td width="20%" class="gridTopico">C&oacute;digo</td>
        <td width="60%" class="gridTopico">Nome</td>
        <td width="20%" class="gridTopico">Apelido</td>
    </tr>
    <c:forEach var="curso" items="${cursos}">
               <tr>
                   <td class="gridCampo">${curso.codigoCurso}</td>
                   <td class="gridCampoComLink">
                       <a href="${pageContext.servletContext.contextPath}/controller?command=curso.Editar&textCodigo=${curso.codigoCurso}">
                   <font color="#FF0000">${curso.nome}</font></a></td>
                   <td class="gridCampo">${curso.apelido}</td>
               </tr>
    </c:forEach>
</table>

