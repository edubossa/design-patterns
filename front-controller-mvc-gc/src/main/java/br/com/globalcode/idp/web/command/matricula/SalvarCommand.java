package br.com.globalcode.idp.web.command.matricula;

import br.com.globalcode.idp.dao.MatriculaDAO;
import br.com.globalcode.idp.dao.TurmaDAO;
import br.com.globalcode.idp.model.Matricula;
import br.com.globalcode.idp.model.Turma;
import br.com.globalcode.idp.util.FormatHelper;
import br.com.globalcode.idp.web.command.WebCommand;
import br.com.globalcode.idp.web.command.WebCommandException;
import javax.servlet.http.HttpServletRequest;

public class SalvarCommand implements WebCommand {

    public void doAction(HttpServletRequest request) throws WebCommandException {
        try {
            long codigo = 0;
            Matricula matricula = null;
            if (request.getParameter("textCodigoMatricula") != null) {
                codigo = Long.parseLong(request.getParameter("textCodigoMatricula"));
            }
            String dataMatricula = null;
            String codigoTurma = null;
            String codigoMembership = null;
            java.util.Date dateMatricula = null;
            codigoMembership = request.getParameter("comboMemberships");
            dataMatricula = request.getParameter("textDataMatricula");
            dateMatricula = FormatHelper.getInstance().parseSimpleDate(dataMatricula);
            codigoTurma = request.getParameter("textCodigoTurma");
            long longCodigoMember = Long.parseLong(codigoMembership);
            long longCodigoTurma = Long.parseLong(codigoTurma);
            matricula = new Matricula(codigo, dateMatricula, longCodigoTurma, longCodigoMember);
            MatriculaDAO.getInstance().save(matricula);
            Turma turma = TurmaDAO.getInstance().getTurma(longCodigoTurma);
            Matricula[] matriculas = MatriculaDAO.getInstance().getMatriculas(longCodigoTurma);

            request.setAttribute("matriculas", matriculas);
            request.setAttribute("turma", turma);
            request.setAttribute("destino", "turmas/formdata.jsp&textCodigoTurma=" + codigoTurma);
            request.setAttribute("tipoNavegacao", "forward");
        } catch (Exception ex) {
            throw new WebCommandException(ex.getMessage(), ex);
        }
    }
}
