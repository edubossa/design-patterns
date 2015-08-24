<%@ page import="br.com.globalcode.idp.model.Curso" %>
<%@ page import="br.com.globalcode.idp.dao.CursoDAO"%>
 
<%
  long codigoCurso = 0;
  int cargaHoraria = 0;
  if(request.getParameter("textCodigo")!=null) codigoCurso = Long.parseLong(request.getParameter("textCodigo"));
  String nome        = request.getParameter("textNome");
  String descricao   = request.getParameter("textDescricao").trim();
  String apelido     = request.getParameter("textApelido").trim();
  if(request.getParameter("textCargaHoraria")!=null) cargaHoraria = Integer.parseInt(request.getParameter("textCargaHoraria"));
  Curso curso = new Curso(codigoCurso, nome, apelido, descricao, cargaHoraria);
  CursoDAO.getInstance().save(curso);
  response.sendRedirect(request.getContextPath() + "/index.jsp?page=cursos/grid.jsp");
%>


