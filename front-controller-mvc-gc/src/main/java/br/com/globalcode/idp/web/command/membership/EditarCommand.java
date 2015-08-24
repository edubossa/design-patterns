package br.com.globalcode.idp.web.command.membership;

import br.com.globalcode.idp.dao.MembershipDAO;
import br.com.globalcode.idp.exception.GlobalcodeException;
import br.com.globalcode.idp.model.Membership;
import br.com.globalcode.idp.web.command.WebCommand;
import br.com.globalcode.idp.web.command.WebCommandException;
import javax.servlet.http.HttpServletRequest;

public class EditarCommand implements WebCommand {

    public void doAction(HttpServletRequest request) throws WebCommandException {
        String strCodigo = request.getParameter("textCodigo");
        if (strCodigo == null || strCodigo.equals("")) {
            throw new WebCommandException("Parametro para execução do servlet textCodigo inválido ou inexistente.");
        }
        Membership aluno = null;
        if (strCodigo.equals("0")) {
            aluno = new Membership();
        } else {
            try {
                aluno = MembershipDAO.getInstance().getMembership(Long.parseLong(strCodigo), false);
            } catch (GlobalcodeException ex) {
                throw new WebCommandException(ex.getMessage(), ex);
            }
        }

        request.setAttribute("aluno",aluno);

        request.setAttribute("destino", "membership/formdata.jsp");
        request.setAttribute("tipoNavegacao", "forward");
    }
}
