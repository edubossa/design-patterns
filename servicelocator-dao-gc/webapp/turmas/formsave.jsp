<%@ page import="br.com.globalcode.idp.model.*" %>
<%@ page import="br.com.globalcode.idp.dao.TurmaDAO"%>
<%@ page import="br.com.globalcode.idp.exception.GlobalcodeException"%>
<%@ page import="br.com.globalcode.idp.util.*"%>

<%

    long codigo = 0;
    int numeroVagas = 0;
    if(request.getParameter("textCodigoTurma")!=null) codigo = Long.parseLong(request.getParameter("textCodigoTurma"));
    String periodo     = request.getParameter("comboPeriodos");
    String codigoCurso = request.getParameter("comboCursos");
    String descricao   = request.getParameter("textDescricao");
    String dataInicio  = request.getParameter("textDataInicio");

    String dataTermino = request.getParameter("textDataTermino");

    if(request.getParameter("textNumeroVagas")!=null) numeroVagas = Integer.parseInt(request.getParameter("textNumeroVagas"));
    Turma turma= new Turma(codigo, descricao, periodo,
                           FormatHelper.getInstance().parseSimpleDate(dataInicio),
                           FormatHelper.getInstance().parseSimpleDate(dataTermino),
                           numeroVagas);
    turma.setCurso(new Curso(Long.parseLong(codigoCurso), "", ""));
    TurmaDAO.getInstance().save(turma);
    response.sendRedirect(request.getContextPath() + "/index.jsp?page=turmas/grid.jsp");
%>

