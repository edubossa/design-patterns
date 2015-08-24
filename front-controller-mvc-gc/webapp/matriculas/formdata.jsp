<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.globalcode.com.br/jaref" prefix="jaref" %>

<form name="form1" method="post" action="${pageContext.servletContext.contextPath}/controller?command=matricula.Salvar">
    <input type="hidden" name="textCodigoTurma" value="${matricula.codigoMatricula==0 ? param.textCodigoTurma : matricula.codigoTurma}">
    
    <table width="100%" border="0" cellspacing="2" cellpadding="0">
        <tr>
            <td width="31%" height="19" class="tituloCampo">C&oacute;digo Matr&iacute;cula</td>
            <td class="tituloCampo">Nome Aluno</td>
            <td class="tituloCampo">Data Matr&iacute;cula</td>
        </tr>
        <tr>
            <td class="Campo"> <input name="textCodigoMatricula" type="text" id="textCodigoMatricula" value="${matricula.codigoMatricula}" size="18" maxlength="12" readonly="true"></td>
            <td width="50%" class="Campo">
                <c:choose>
                    <c:when test="${matricula.codigoMatricula != 0}">
                    ${matricula.nomeMembership}
                        <input type="hidden" name="comboMemberships" value="${matricula.codigoMembership}">
                    </c:when>
                    <c:otherwise>
                        <jaref:ComboMemberships name="comboMemberships" value="${matricula.codigoMembership}"/>
                    </c:otherwise>
                </c:choose>
            </td>
            <td width="19%" class="Campo"><input name="textDataMatricula" type="text" id="textDataMatricula" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${matricula.dataMatricula}" />' size="18" maxlength="12"></td>
        </tr>
        <tr>
            <td colspan="3" class="Campo">&nbsp;</td>
        </tr>
        <tr>
            <td colspan="3" class="Campo"> <div align="center">
                    <input type="submit" name="Submit" value="Salvar">
                    <input type="reset" name="Submit2" value="Desfazer altera&ccedil;&otilde;es">
                    <input name="voltar" type="button" onClick="history.back(1);" value="Voltar">
            </div></td>
        </tr>
        <tr>
            <td colspan="3" class="Campo"><a href="${pageContext.servletContext.contextPath}/controller?command=matricula.Excluir&textCodigoMatricula=${matricula.codigoMatricula}"><font color="#FF0000">Excluir
            esta matr&iacute;cula do sistema</font></a></td>
        </tr>
    </table>
</form>
