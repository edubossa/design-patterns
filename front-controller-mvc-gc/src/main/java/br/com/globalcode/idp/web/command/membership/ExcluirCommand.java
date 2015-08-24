package br.com.globalcode.idp.web.command.membership;

import br.com.globalcode.idp.dao.MembershipDAO;
import br.com.globalcode.idp.exception.GlobalcodeException;
import br.com.globalcode.idp.model.Membership;
import br.com.globalcode.idp.web.command.WebCommand;
import br.com.globalcode.idp.web.command.WebCommandException;
import javax.servlet.http.HttpServletRequest;

public class ExcluirCommand implements WebCommand {

    public void doAction(HttpServletRequest request) throws WebCommandException {
        try {
            String strCodigo = request.getParameter("textCodigo");
            if (strCodigo == null || strCodigo.equals("") || strCodigo.equals("0")) {
                throw new WebCommandException("Parametro para execução do servlet textCodigo inválido ou inexistente.");
            }
            Membership membership = new Membership(Long.parseLong(strCodigo), "");
            MembershipDAO.getInstance().delete(membership);
            Membership[] alunos = MembershipDAO.getInstance().getMemberships(true);
            request.setAttribute("alunos", alunos);

            request.setAttribute("destino", "membership/grid.jsp");
            request.setAttribute("tipoNavegacao", "forward");
        } catch (GlobalcodeException ex) {
            throw new WebCommandException(ex.getMessage(), ex);
        }
    }
    
}
