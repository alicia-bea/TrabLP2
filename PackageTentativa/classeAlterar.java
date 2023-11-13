package Tentativa;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexao.UsuarioDAO;
import models.Usuario;

@WebServlet("/AlterarUsuario")

public class Alterar extends HttpServlet{
	
private static final long serialVersionUID = 1L;
    
    public Alterar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
	     }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String nome = request.getParameter("nome");
		
		String senha = request.getParameter("senha");
		
		
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		
		UsuarioDAO erro = new UsuarioDAO();
		String retorno = erro .alterar(usuario);
		
		if(retorno.equals("A alteração foi feita corretamente")){
			response.sendRedirect("Index1.jsp");
		}
		
		else 
		{
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<a> Erro na alteração do usuario</a>");

			out.print("<a href = 'Index1.jsp'> inicio </a>");
			out.print("</html>");;
		}
	}


}
