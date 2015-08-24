package br.com.globalcode.idp.web.command.membership;

import br.com.globalcode.idp.dao.MembershipDAO;
import br.com.globalcode.idp.exception.GlobalcodeException;
import br.com.globalcode.idp.model.Membership;
import br.com.globalcode.idp.web.command.WebCommand;
import br.com.globalcode.idp.web.command.WebCommandException;
import javax.servlet.http.HttpServletRequest;

public class VisualizarCommand implements WebCommand{

    public void doAction(HttpServletRequest request) throws WebCommandException {
        try {
            Membership[] alunos = MembershipDAO.getInstance().getMemberships(true);
            request.setAttribute("alunos", alunos);
            request.setAttribute("destino", "membership/grid.jsp");
            request.setAttribute("tipoNavegacao","forward");
        } catch (GlobalcodeException ex) {
            throw new WebCommandException(ex.getMessage(),ex);
        }
    }

}
