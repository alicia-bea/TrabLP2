package conexao;

	import java.io.PrintWriter;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.sql.*;

	public class Conexao {
		
	private	Connection conectar;
		
		static String url = "jdbc:h2:~/test";
		static String user = "sa";
		static String password = "";
		
		
		Statement statement = null;
		
		String instrucaoSQL = "CREATE TABLE Usuario ( "
				
				+ "id int not null auto_increment, "
				+ "nome varchar(45) not null,"
				+ "senha varchar(15) not null,"
				+ "primary key (id)";

		
		public Conexao() {
			
			try {
				Class.forName("org.h2.Driver");
				conectar = DriverManager.getConnection(url, user, password);
				
				System.out.println("Gerando tabela Usuario");
				statement = conectar.createStatement();
				statement.executeUpdate(instrucaoSQL);
				
				System.out.println("Gerando tabela Usuario");
				
				statement.close();
				conectar.close();			
				}
			
			
			    catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		public Connection getConectar() {
			return conectar;
		}
		
		
		public void fecharConexao() {
			
			try {
				
				conectar.close();
			}
			
			catch (SQLException e) {
			}
		}

}
