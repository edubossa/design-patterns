package br.com.globalcode.idp.helper.view;

import br.com.globalcode.idp.dao.MembershipDAO;
import br.com.globalcode.idp.exception.GlobalcodeException;
import br.com.globalcode.idp.model.Membership;
import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ComboMembershipsHelper extends SimpleTagSupport {

    private String cssClass;
    private String value;
    private String name;

    public void doTag() throws JspTagException {
        char aspas = '\"';
        Membership memberships[] = null;
        try {
            memberships = MembershipDAO.getInstance().getMemberships(true);
        } catch (GlobalcodeException ge) {
            throw new JspTagException("Erro Lendo cursos do DAO para o ComboTag!!!!");
        }

        try {
            JspContext context = getJspContext();
            context.getOut().write("<select name=" + aspas + name + aspas +
                    " class=" + aspas + cssClass + aspas + ">");
            boolean sel = false;
            for (int x = 0; x < memberships.length; x++) {
                sel = (value != null && value.equals("" + memberships[x].getCodigoMembership()));
                context.getOut().write("<option value=" + aspas + memberships[x].getCodigoMembership() + aspas +
                        (sel ? " selected " : "") +
                        ">" + memberships[x].getNome() + "</option>");
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
