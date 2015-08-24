<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.globalcode.com.br/jaref" prefix="jaref" %>
<form name="form1" method="post" action="${pageContext.servletContext.contextPath}/controller?command=turma.Salvar" >
    <table width="100%" border="0" cellspacing="2" cellpadding="0">
        <tr>
            <td width="40%" height="19" class="tituloCampo">C&oacute;digo Turma</td>
            <td class="tituloCampo">Descri&ccedil;&atilde;o</td>
            <td class="tituloCampo">Data In&iacute;cio</td>
        </tr>
        <tr>
            <td class="Campo"> <input name="textCodigoTurma" type="text" id="textCodigoTurma" value="${turma.codigoTurma}" size="18" maxlength="12" readonly="true"></td>
            <td width="41%" class="Campo"> <input name="textDescricao" type="text" id="textDescricao" value="${turma.descricao}" size="40" maxlength="255">
            </td>
            <td width="19%" class="Campo"><input name="textDataInicio" type="text" id="textDataInicio" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${turma.dataInicio}" />' size="18" maxlength="12"></td>
        </tr>
        <tr>
            <td class="tituloCampo">Curso</td>
            <td class="tituloCampo">Per&iacute;odo</td>
            <td class="tituloCampo">Data T&eacute;rmino</td>
        </tr>
        <tr>
            <td class="Campo">
                <jaref:ComboCursos name="comboCursos" value="${turma.curso.codigoCurso}"/>
            </td>
            <td class="Campo">
                <jaref:ComboPeriodos name="comboPeriodos" value="${turma.periodo}" />
            </td>
            <td class="Campo"><input name="textDataTermino" type="text" id="textDataTermino" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${turma.dataTermino}"/>' size="18" maxlength="12"></td>
        </tr>
        <tr>
            <td class="tituloCampo">N&uacute;mero Vagas</td>
            <td colspan="2" class="Campo"><input name="textNumeroVagas" type="text" id="textNumeroVagas" value="${turma.numeroVagas}" size="18" maxlength="12"></td>
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
    </table>
</form>
<jsp:include page="../matriculas/grid.jsp" flush="true" />
