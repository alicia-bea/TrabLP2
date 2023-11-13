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

@WebServlet("/Inserir")


public class Inserir extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	public Inserir() {
	    super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	    		throws ServletException, IOException{
	    	
		String nome = request.getParameter("nome");
		
		String senha = request.getParameter("senha");
			
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSenha(senha);
			
		UsuarioDAO erro = new UsuarioDAO();
		String retorno = erro.inserir(usuario);
		
		if(retorno.equals("O processo de inserir foi realizado com sucesso"))
		{
			response.sendRedirect("Index1.jsp");
		}
		
		else 
		{
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<a> Erro ao inserir o usuario</a>");
		
			out.print("<a href = 'Index1.jsp'> Voltar </a>");
			out.print("</html>");;
		}
	}

}
