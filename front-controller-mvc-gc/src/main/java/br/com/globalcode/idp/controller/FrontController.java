package br.com.globalcode.idp.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.globalcode.idp.web.command.CommandFactory;
import br.com.globalcode.idp.web.command.WebCommand;

public class FrontController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
        WebCommand aCommand = null;
        String command = request.getParameter("command");
        try {
            aCommand = CommandFactory.createWebCommand(command);
            aCommand.doAction(request);
        } catch(Exception e) {
            throw new ServletException(e);
        }
        String destino = (String) request.getAttribute("destino");
        String navegacao = (String) request.getAttribute("tipoNavegacao");
        if (destino != null && !destino.equals("")) {
            if(navegacao.equalsIgnoreCase("forward")) {
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp?page="+destino);
                rd.forward(request,response);
            } else {
                response.sendRedirect(request.getContextPath()+"/index.jsp?page="+destino);
            }
        }else{
                response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
    }
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}