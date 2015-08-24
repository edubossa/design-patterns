<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.servletContext.contextPath}" />

<table width="100%" border="1" cellpadding="2" cellspacing="0" bordercolor="#FFFFFF" >
    <tr> 
        <td class="MenuTopico"><p>--&gt;Memberships</p></td>
    </tr>
    <tr> 
        <td class="MenuItem"><a href="${context}/controller?command=membership.Visualizar">Visualizar cadastro</a></td>
    </tr>
    <tr> 
        <td class="MenuItem"><a href="${context}/controller?command=membership.Editar&textCodigo=0">Adicionar 
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
        <td class="MenuItem"><a href="${context}/controller?command=turma.Visualizar">Visualizar turmas</a></td>
    </tr>
    <tr> 
        <td class="MenuItem"><a href="${context}/controller?command=turma.Editar&textCodigoTurma=0">Adicionar 
        nova turma</a></td>
    </tr>
    <tr> 
        <td class="MenuItem">
            <c:if test='${(not empty param.textCodigoTurma) && (param.textCodigoTurma!="0")}' var="habilitaMenu"/>
            <c:if test="${habilitaMenu}" >
                <a href="${context}/controller?command=matricula.Editar&textCodigoTurma=${param.textCodigoTurma}">
            </c:if>
                Matricular aluno na turma</a></td>
    </tr>
    <tr> 
        <td class="MenuItem">
            <c:if test="${habilitaMenu}" >
                <a href="${context}/controller?command=turma.Excluir&textCodigoTurma=${param.textCodigoTurma}">
            </c:if>
            Excluir turma do sistema</a></td>
    </tr>
    <tr> 
        <td height="25">&nbsp;</td>
    </tr>
    <tr> 
        <td class="MenuTopico">--&gt;Cursos</td>
    </tr>
    <tr> 
        <td class="MenuItem"><a href="${context}/controller?command=curso.Visualizar">Visualizar cursos</a></td>
    </tr>
    <tr> 
        <td class="MenuItem"><a href="${context}/controller?command=curso.Editar&textCodigo=0">Criar 
        novo curso</a></td>
    </tr>
</table>

