package br.com.globalcode.idp.web.command.turma;

import br.com.globalcode.idp.dao.TurmaDAO;
import br.com.globalcode.idp.exception.GlobalcodeException;
import br.com.globalcode.idp.model.Turma;
import br.com.globalcode.idp.web.command.WebCommand;
import br.com.globalcode.idp.web.command.WebCommandException;
import javax.servlet.http.HttpServletRequest;

public class VisualizarCommand implements WebCommand{

    public void doAction(HttpServletRequest request) throws WebCommandException {
        try {
            Turma[] turmas = TurmaDAO.getInstance().getTurmas(true);
            request.setAttribute("turmas", turmas);
            request.setAttribute("destino", "turmas/grid.jsp");
            request.setAttribute("tipoNavegacao","forward");
        } catch (GlobalcodeException ex) {
            throw new WebCommandException(ex.getMessage(),ex);
        }
    }

}
