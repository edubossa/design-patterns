package br.com.globalcode.idp.helper.view;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ComboPeriodosHelper extends SimpleTagSupport {

    private String cssClass;
    private String value;
    private String name;

    enum Periodo {
        
        SEG_QUA("2a e 4a Noturno"),
        TER_QUI("3a e 5a Noturno"),
        SABADO("Sabado integral"),
        DOMINGO("Domingo integral"),
        ESPECIAL("Especial");

        String descricao;

        Periodo(String descricao) {
            this.descricao = descricao;
        }

        String getDescricao() {
            return descricao;
        }
    }

    public void doTag() throws JspTagException {
        char aspas = '\"';

        try {
            JspContext context = getJspContext();
            context.getOut().write("<select name=" + aspas + name + aspas +
                    " class=" + aspas + cssClass + aspas + ">");
            boolean sel = false;
            for (Periodo periodo: Periodo.values()) {
                sel = (value != null && value.equals("" + periodo.getDescricao()));
                context.getOut().write("<option value=" + aspas + periodo.getDescricao() + aspas +
                        (sel ? " selected " : "") +
                        ">" + periodo.getDescricao() + "</option>");
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
