package br.com.globalcode.idp.web.command.turma;

import br.com.globalcode.idp.dao.MatriculaDAO;
import br.com.globalcode.idp.dao.TurmaDAO;
import br.com.globalcode.idp.exception.GlobalcodeException;
import br.com.globalcode.idp.model.Matricula;
import br.com.globalcode.idp.model.Turma;
import br.com.globalcode.idp.web.command.WebCommand;
import br.com.globalcode.idp.web.command.WebCommandException;
import javax.servlet.http.HttpServletRequest;

public class EditarCommand implements WebCommand {

    public void doAction(HttpServletRequest request) throws WebCommandException {
        Turma turma = null;
        try {
            String strCodigo = request.getParameter("textCodigoTurma");
            if (strCodigo == null || strCodigo.equals("")) {
                throw new GlobalcodeException("Parametro para execução do jsp textCodigo inválido ou inexistente.");
            }
            Matricula matriculas[] = null;
            if (strCodigo.equals("0")) {
                turma = new Turma();
            } else {
                turma = TurmaDAO.getInstance().getTurma(Long.parseLong(strCodigo));
                matriculas = MatriculaDAO.getInstance().getMatriculas(turma.getCodigoTurma());

                request.setAttribute("matriculas", matriculas);
            }
        } catch (GlobalcodeException ex) {
            throw new WebCommandException(ex.getMessage(), ex);
        }

        request.setAttribute("turma", turma);
        request.setAttribute("destino", "turmas/formdata.jsp");
        request.setAttribute("tipoNavegacao", "forward");
    }
}
