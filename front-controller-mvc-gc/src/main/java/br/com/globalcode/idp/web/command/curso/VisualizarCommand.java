package br.com.globalcode.idp.web.command.curso;

import br.com.globalcode.idp.dao.CursoDAO;
import br.com.globalcode.idp.exception.GlobalcodeException;
import br.com.globalcode.idp.model.Curso;
import br.com.globalcode.idp.web.command.WebCommand;
import br.com.globalcode.idp.web.command.WebCommandException;
import javax.servlet.http.HttpServletRequest;

public class VisualizarCommand implements WebCommand{

    public void doAction(HttpServletRequest request) throws WebCommandException {
        try {
            Curso[] cursos = CursoDAO.getInstance().getCursos(true);
            request.setAttribute("cursos", cursos);
            request.setAttribute("destino", "cursos/grid.jsp");
            request.setAttribute("tipoNavegacao","forward");
        } catch (GlobalcodeException ex) {
            throw new WebCommandException(ex.getMessage(),ex);
        }
    }

}
