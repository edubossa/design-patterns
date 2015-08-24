package br.com.globalcode.idp.web.command.curso;

import br.com.globalcode.idp.dao.CursoDAO;
import br.com.globalcode.idp.exception.GlobalcodeException;
import br.com.globalcode.idp.model.Curso;
import br.com.globalcode.idp.web.command.WebCommand;
import br.com.globalcode.idp.web.command.WebCommandException;
import javax.servlet.http.HttpServletRequest;

public class SalvarCommand implements WebCommand {

    public void doAction(HttpServletRequest request) throws WebCommandException {
        try {
            long codigoCurso = 0;
            int cargaHoraria = 0;
            if (request.getParameter("textCodigo") != null) {
                codigoCurso = Long.parseLong(request.getParameter("textCodigo"));
            }
            String nome = request.getParameter("textNome");
            String descricao = request.getParameter("textDescricao").trim();
            String apelido = request.getParameter("textApelido").trim();
            if (request.getParameter("textCargaHoraria") != null) {
                cargaHoraria = Integer.parseInt(request.getParameter("textCargaHoraria"));
            }
            Curso curso = new Curso(codigoCurso, nome, apelido, descricao, cargaHoraria);
            CursoDAO.getInstance().save(curso);
            Curso[] cursos = CursoDAO.getInstance().getCursos(true);
            request.setAttribute("cursos", cursos);
            request.setAttribute("destino", "cursos/grid.jsp");
            request.setAttribute("tipoNavegacao", "forward");
        } catch (GlobalcodeException ex) {
            throw new WebCommandException(ex.getMessage(), ex);
        }
    }
}
