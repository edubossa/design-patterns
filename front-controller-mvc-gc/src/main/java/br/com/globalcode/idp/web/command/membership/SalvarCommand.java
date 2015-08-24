package br.com.globalcode.idp.web.command.membership;

import br.com.globalcode.idp.dao.MembershipDAO;
import br.com.globalcode.idp.exception.GlobalcodeException;
import br.com.globalcode.idp.model.Membership;
import br.com.globalcode.idp.web.command.WebCommand;
import br.com.globalcode.idp.web.command.WebCommandException;
import javax.servlet.http.HttpServletRequest;

public class SalvarCommand implements WebCommand {

    public void doAction(HttpServletRequest request) throws WebCommandException {
        try {
            long codigo = 0;
            if (request.getParameter("textCodigo") != null) {
                codigo = Long.parseLong(request.getParameter("textCodigo"));
            }
            String nome = request.getParameter("textNome");
            String endereco = request.getParameter("textEndereco");
            Membership membership = new Membership(codigo, nome, endereco);
            MembershipDAO.getInstance().save(membership);
            Membership[] alunos = MembershipDAO.getInstance().getMemberships(true);
            request.setAttribute("alunos", alunos);
            request.setAttribute("destino", "membership/grid.jsp");
            request.setAttribute("tipoNavegacao", "forward");
        } catch (GlobalcodeException ex) {
                throw new WebCommandException(ex.getMessage(), ex);
        }
    }
}
