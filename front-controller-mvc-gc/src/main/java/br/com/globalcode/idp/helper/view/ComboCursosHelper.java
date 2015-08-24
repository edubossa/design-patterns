package br.com.globalcode.idp.helper.view;

import br.com.globalcode.idp.dao.CursoDAO;
import br.com.globalcode.idp.exception.GlobalcodeException;
import br.com.globalcode.idp.model.Curso;
import java.io.IOException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ComboCursosHelper extends SimpleTagSupport {
	private String cssClass;
	private String value;
	private String name;

	public void doTag() throws JspTagException {
		char aspas = '\"';
		Curso cursos[] = null;
		try {
			cursos = CursoDAO.getInstance().getCursos(true);
		} catch (GlobalcodeException ge) {

		}
		JspContext context = getJspContext();
		try {
			context.getOut().write("<select name=" + aspas + name + aspas + " class=" + aspas + cssClass + aspas + ">");
			boolean sel = false;
			for (int x = 0; x < cursos.length; x++) {
				sel = (value != null && value.equals("" + cursos[x].getCodigoCurso()));
				context.getOut().write("<option value=" + aspas + cursos[x].getCodigoCurso() + aspas
						+ (sel ? " selected " : "") + ">" + cursos[x].getNome() + "</option>");
			}
			context.getOut().write("</select>");
			context.getOut().write("");
		} catch (IOException ex) {
			throw new JspTagException("Erro...");
		}
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
