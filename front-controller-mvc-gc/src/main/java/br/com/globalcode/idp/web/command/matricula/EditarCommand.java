package br.com.globalcode.idp.web.command.matricula;

import br.com.globalcode.idp.dao.MatriculaDAO;
import br.com.globalcode.idp.exception.GlobalcodeException;
import br.com.globalcode.idp.model.Matricula;
import br.com.globalcode.idp.web.command.WebCommand;
import br.com.globalcode.idp.web.command.WebCommandException;
import javax.servlet.http.HttpServletRequest;

public class EditarCommand implements WebCommand {

    public void doAction(HttpServletRequest request) throws WebCommandException {
        long codigoTurma = 0;
        long codigoMatricula = 0;
        Matricula matricula = null;
        if (request.getParameter("textCodigoTurma") != null) {
            codigoTurma = Long.parseLong(request.getParameter("textCodigoTurma"));
        }
        if (request.getParameter("textCodigoMatricula") != null) {
            codigoMatricula = Long.parseLong(request.getParameter("textCodigoMatricula"));
        }

        try {
            //Edição
            if (codigoMatricula != 0) {

                matricula = MatriculaDAO.getInstance().getMatricula(codigoMatricula);
            } else {
                matricula = new Matricula();
                matricula.setCodigoTurma(codigoTurma);
            }
        } catch (GlobalcodeException ex) {
            throw new WebCommandException(ex.getMessage(), ex);
        }
        request.setAttribute("matricula", matricula);
        request.setAttribute("destino", "matriculas/formdata.jsp");
        request.setAttribute("tipoNavegacao", "forward");
    }
}
