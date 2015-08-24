package br.com.globalcode.idp.web.command.turma;

import br.com.globalcode.idp.dao.TurmaDAO;
import br.com.globalcode.idp.model.Curso;
import br.com.globalcode.idp.model.Turma;
import br.com.globalcode.idp.util.FormatHelper;
import br.com.globalcode.idp.web.command.WebCommand;
import br.com.globalcode.idp.web.command.WebCommandException;
import javax.servlet.http.HttpServletRequest;

public class SalvarCommand implements WebCommand {

    public void doAction(HttpServletRequest request) throws WebCommandException {
        try {
            long codigo = 0;
            int numeroVagas = 0;
            if (request.getParameter("textCodigoTurma") != null) {
                codigo = Long.parseLong(request.getParameter("textCodigoTurma"));
            }
            String periodo = request.getParameter("comboPeriodos");
            String codigoCurso = request.getParameter("comboCursos");
            String descricao = request.getParameter("textDescricao");
            String dataInicio = request.getParameter("textDataInicio");

            String dataTermino = request.getParameter("textDataTermino");

            if (request.getParameter("textNumeroVagas") != null) {
                numeroVagas = Integer.parseInt(request.getParameter("textNumeroVagas"));
            }
            Turma turma = new Turma(codigo, descricao, periodo,
                    FormatHelper.getInstance().parseSimpleDate(dataInicio),
                    FormatHelper.getInstance().parseSimpleDate(dataTermino),
                    numeroVagas);
            turma.setCurso(new Curso(Long.parseLong(codigoCurso), "", ""));
            TurmaDAO.getInstance().save(turma);
            Turma[] turmas =TurmaDAO.getInstance().getTurmas(true);
            request.setAttribute("turmas", turmas);
            request.setAttribute("destino", "turmas/grid.jsp");
            request.setAttribute("tipoNavegacao", "forward");
        } catch (Exception ex) {
            throw new WebCommandException(ex.getMessage(), ex);
        }
    }
}
