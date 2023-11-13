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

@WebServlet("/Remover")

public class Remover extends HttpServlet{
	
private static final long serialVersionUID = 1L;
    
    public Remover() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		UsuarioDAO erro = new UsuarioDAO();
		String retorno = erro.remover(id);
		
		if(retorno.equals("O processo de remover foi realizado sucesso")) {
			response.sendRedirect("Index1.jsp");
		}
		
		else 
		{
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<a> Erro ao tentar remover o usuario</a>");

			out.print("<a href = 'Index1.jsp'> Inicio </a>");
			out.print("</html>");
		}
	}

}
