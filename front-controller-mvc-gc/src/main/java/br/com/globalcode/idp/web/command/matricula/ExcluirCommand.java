package br.com.globalcode.idp.web.command.matricula;

import br.com.globalcode.idp.dao.MatriculaDAO;
import br.com.globalcode.idp.dao.TurmaDAO;
import br.com.globalcode.idp.exception.GlobalcodeException;
import br.com.globalcode.idp.model.Matricula;
import br.com.globalcode.idp.model.Turma;
import br.com.globalcode.idp.web.command.WebCommand;
import br.com.globalcode.idp.web.command.WebCommandException;
import javax.servlet.http.HttpServletRequest;

public class ExcluirCommand implements WebCommand {

    public void doAction(HttpServletRequest request) throws WebCommandException {


        try {
            String strCodigo = request.getParameter("textCodigoMatricula");
            if (strCodigo == null || strCodigo.equals("") || strCodigo.equals("0")) {
                throw new GlobalcodeException("Parametro para execução do jsp textCodigo inválido ou inexistente.");
            }
            Matricula matricula = null;
            matricula = MatriculaDAO.getInstance().getMatricula(Long.parseLong(strCodigo));
            MatriculaDAO.getInstance().delete(matricula);
            long codigoTurma = matricula.getCodigoTurma();
            Turma turma = TurmaDAO.getInstance().getTurma(codigoTurma);
            Matricula[] matriculas = MatriculaDAO.getInstance().getMatriculas(codigoTurma);

            request.setAttribute("matriculas", matriculas);
            request.setAttribute("turma", turma);
            request.setAttribute("destino", "turmas/formdata.jsp&textCodigoTurma=" + codigoTurma);
            request.setAttribute("tipoNavegacao", "forward");
        } catch (GlobalcodeException ex) {
            throw new WebCommandException(ex.getMessage(), ex);
        }
    }
}
