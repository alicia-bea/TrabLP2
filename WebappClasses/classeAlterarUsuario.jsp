<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="conexao.UsuarioDAO"%>
<%@page import="models.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

        <% 
		int id = Integer.parseInt(request.getParameter("id"));
        
		UsuarioDAO erro = new UsuarioDAO();
		Usuario usuario = erro.selecionar(id);
	    %>
	
	
	<form action= 'Alterar' method ='POST'>
		Nome: <input type='text' name='nome' value="<%=usuario.getNome()%>"><br><hr>
		
		Senha: <input type='text' name='senha' value="<%=usuario.getSenha()%>"><br><hr>
		
		<input type="hidden" name="id" value="<%=usuario.getId()%>"><br><hr>
		
		<input type='submit' value='Alterar'>
	</form>
	
	<a href="Index1.jsp">Inicio</a>

</body>
</html>
