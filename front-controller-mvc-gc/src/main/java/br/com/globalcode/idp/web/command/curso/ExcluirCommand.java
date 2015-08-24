package br.com.globalcode.idp.web.command.curso;

import br.com.globalcode.idp.dao.CursoDAO;
import br.com.globalcode.idp.exception.GlobalcodeException;
import br.com.globalcode.idp.model.Curso;
import br.com.globalcode.idp.web.command.WebCommand;
import br.com.globalcode.idp.web.command.WebCommandException;
import javax.servlet.http.HttpServletRequest;

public class ExcluirCommand implements WebCommand {

    public void doAction(HttpServletRequest request) throws WebCommandException {
        try {
            String strCodigo = request.getParameter("textCodigo");
            if (strCodigo == null || strCodigo.equals("") || strCodigo.equals("0")) {
                throw new GlobalcodeException("Parametro para execução do servlet textCodigo inválido ou inexistente.");
            }
            Curso curso = null;
            curso = new Curso(Long.parseLong(strCodigo), "", "");
            CursoDAO.getInstance().delete(curso);
            Curso[] cursos = CursoDAO.getInstance().getCursos(true);
            request.setAttribute("cursos", cursos);

            request.setAttribute("destino", "cursos/grid.jsp");
            request.setAttribute("tipoNavegacao", "forward");
        } catch (GlobalcodeException ex) {
            throw new WebCommandException(ex.getMessage(), ex);
        }
    }
}
