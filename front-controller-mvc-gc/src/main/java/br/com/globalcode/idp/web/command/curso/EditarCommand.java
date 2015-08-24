package br.com.globalcode.idp.web.command.curso;

import br.com.globalcode.idp.dao.CursoDAO;
import br.com.globalcode.idp.exception.GlobalcodeException;
import br.com.globalcode.idp.model.Curso;
import br.com.globalcode.idp.web.command.WebCommand;
import br.com.globalcode.idp.web.command.WebCommandException;
import javax.servlet.http.HttpServletRequest;

public class EditarCommand implements WebCommand {

    public void doAction(HttpServletRequest request) throws WebCommandException {
        String strCodigo = request.getParameter("textCodigo");
        if (strCodigo == null || strCodigo.equals("")) {
            throw new WebCommandException("Parametro para execução do servlet textCodigo inválido ou inexistente.");
        }
        Curso curso = null;
        if (strCodigo.equals("0")) {
            curso = new Curso();
        } else {
            try {
                curso = CursoDAO.getInstance().getCurso(Long.parseLong(strCodigo));
            } catch (GlobalcodeException ex) {
                throw new WebCommandException(ex.getMessage(), ex);
            }
        }

        request.setAttribute("curso",curso);

        request.setAttribute("destino", "cursos/formdata.jsp");
        request.setAttribute("tipoNavegacao", "forward");
    }
}
