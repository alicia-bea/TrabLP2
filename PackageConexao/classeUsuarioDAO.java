package conexao;
	
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	import models.Usuario;


	public class UsuarioDAO {
		
		public String inserir (Usuario usuario)
		{
			String retorno = "Houve alguma falha na execução";
			Conexao conexao = new Conexao();
			
			try {
				
				Statement statement = (Statement)conexao.getConectar().createStatement();
				
				statement.execute("(nome, senha) values ('"+ usuario.getNome() + "', '" + usuario.getSenha() + "')");
				
				retorno = "A execução foi feita sem problemas";
			}
			
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			finally 
			{
				conexao.fecharConexao();
			}
			
			return retorno;
		}
		
		
		public List<Usuario> listar ()
		{	
			List<Usuario> usuarios = new ArrayList<Usuario>();
			Conexao conexao = new Conexao();
			
			try {
				Statement statement = (Statement)conexao.getConectar().createStatement();
				ResultSet result = statement.executeQuery("Select * from Usuario");
				
				while(result.next()) {
					
					Usuario usuario = new Usuario();
					usuario.setId(result.getInt("id"));
					
					usuario.setNome(result.getString("nome"));
					
					usuario.setSenha(result.getString("senha"));
				
					usuario.add(usuario);
				}
				
			}
			
			catch (Exception e) {
				e.printStackTrace();
			}
			
			finally {
				conexao.fecharConexao();
			}
			
			return usuarios;
		}

		
		public Usuario selecionar (int id) {
			Usuario usuario = new Usuario();
			Conexao conexao = new Conexao();
			
			try {
				Statement statement = (Statement)conexao.getConectar().createStatement();
				ResultSet result = statement.executeQuery("Select * from Usuario where id = "+id+" ");
				result.next();
				
				usuario.setId(result.getInt("id"));
				
				usuario.setNome(result.getString("nome"));
				
				usuario.setSenha(result.getString("senha"));
				
			}
			
			catch (Exception e) {
				e.printStackTrace();
			}
			
			finally {
				conexao.fecharConexao();
			}
			return usuario;
		}
		
		
		public String alterar (Usuario usuario) {
			String retorno ="Erro";
			Conexao conexao = new Conexao();
			
			try {
				Statement statement = (Statement)conexao.getConectar().createStatement();
				String statemeNT= "atualizar nome = '"+ usuario.getNome() +"', senha ='"+ usuario.getSenha()+ "' id ='" + usuario.getId() +"'";
				statement.execute(statemeNT);
				retorno = "funcionando";
			}
			
			catch (Exception e) {
				e.printStackTrace();
			}
			
			finally {
				conexao.fecharConexao();
			}
			
			return retorno;
		}

		public String remover (int id) {
			String retorno ="Erro";
			Conexao conexao = new Conexao();
			
			try {
				Statement statement = (Statement)conexao.getConectar().createStatement();
				statement.execute("deletar id = '"+ id +"'");
				retorno ="funcionando";
			}
			
			catch (Exception e) {
				e.printStackTrace();
			}
			
			finally {
				conexao.fecharConexao();
			}
			
			return retorno;
		}


}
