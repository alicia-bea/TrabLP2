<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ page import="conexao.UsuarioDAO"%>
<%@ page import="java.util.List"%>
<%@ page import="models.Usuario"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Adicionar usuario</h1>
	<a href="InserirUsuario.jsp"> Adicionar usuario</a>
	<%
		UsuarioDAO erro = new UsuarioDAO();
		List<Usuario> usuarios = erro.listar();
	%>
	<hr>
	
	<h1>Lista de Usuario:</h1>
	<table border="1" rules="all">
		<td><b>Id:</b></td>
		<td><b>Nome:</b></td>
		<td><b>Senha:</b></td>
		
			<%for(int i = 0; i<usuarios.size(); i++){
				Usuario usuario = usuarios.get(i);
			    %>
			    
		<tr>
			<td><%=usuario.getId()%></td>
			<td><%=usuario.getNome()%></td>
			<td><%=usuario.getSenha()%></td>
			<td><a href="AlterarUsuario.jsp?id=<%=usuario.getId()%>">Alterar</a></td>
			<td><a href="RemoverUsuario.jsp?id=<%=usuario.getId()%>">Remover</a></td>
		</tr>
			<%} %>

	</table>

</body>
</html>
