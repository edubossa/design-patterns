package br.com.globalcode.idp.web.command.turma;

import br.com.globalcode.idp.dao.TurmaDAO;
import br.com.globalcode.idp.exception.GlobalcodeException;
import br.com.globalcode.idp.model.Turma;
import br.com.globalcode.idp.web.command.WebCommand;
import br.com.globalcode.idp.web.command.WebCommandException;
import javax.servlet.http.HttpServletRequest;

public class ExcluirCommand implements WebCommand {

    public void doAction(HttpServletRequest request) throws WebCommandException {

        String strCodigo = request.getParameter("textCodigoTurma");
        if (strCodigo == null || strCodigo.equals("") || strCodigo.equals("0")) {
            throw new WebCommandException("Parametro para execu��o do jsp textCodigo inv�lido ou inexistente.");
        }

        try {
            Turma turma = null;
            turma = new Turma(Long.parseLong(strCodigo), null, null, null);
            TurmaDAO.getInstance().delete(turma);
            Turma[] turmas = TurmaDAO.getInstance().getTurmas(true);
            request.setAttribute("turmas", turmas);

            request.setAttribute("destino", "turmas/grid.jsp");
            request.setAttribute("tipoNavegacao", "redirect");
        } catch (GlobalcodeException ex) {
            throw new WebCommandException(ex.getMessage(), ex);
        }
    }
}
