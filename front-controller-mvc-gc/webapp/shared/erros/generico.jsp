<%@ page isErrorPage="true" %>
<link href="<%= request.getContextPath() %>/shared/aa.css" rel="stylesheet" type="text/css">


<p class="MenuItem">Erro ao acessar funcionalidade!</p>
<p class="Campo"><%= exception!=null ? exception.toString()  : "Sem mensagem ou exception" %></p>
<p class="Campo">Verifique logs do container e contate a equipe de desenvolvimento.</p>
