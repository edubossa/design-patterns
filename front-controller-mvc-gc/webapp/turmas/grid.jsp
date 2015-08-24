<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<table width="100%" border="0" cellspacing="2" cellpadding="0">
  <tr>
    <td width="15%" class="gridTopico">C&oacute;digo</td>
    <td width="15%" class="gridTopico">Data In&iacute;cio</td>
    <td width="26%" class="gridTopico">Curso</td>
    <td width="44%" class="gridTopico">Descri&ccedil;&atilde;o</td>
  </tr>
  <c:forEach var="turma" items="${turmas}">
  <tr>
    <td class="gridCampo">${turma.codigoTurma}</td>
    <td class="gridCampo"><fmt:formatDate pattern="dd/MM/yyyy" value="${turma.dataInicio}" /></td>
    <td class="gridCampoComLink"> <a href="${pageContext.servletContext.contextPath}/controller?command=turma.Editar&textCodigoTurma=${turma.codigoTurma}">
      <font color="#FF0000">${turma.curso.nome}</font></a></td>
    <td class="gridCampoComLink">${turma.descricao}</td>
  </tr>
</c:forEach>
  </table>


