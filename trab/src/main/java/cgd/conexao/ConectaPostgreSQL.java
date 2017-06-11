package cgd.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaPostgreSQL {
	public static Connection geraConexao() {
		Connection conexao = null;
		try {
			// carrega o drive de comunica��o com o banco de dados
			Class.forName("org.postgresql.Driver");
			// N�o esqueca de mudar o usuario e senha do banco de dados.
			String url = "jdbc:postgresql://localhost:5432/moulin";
			String usuario = "postgres";
			String senha = "ifes";
			conexao = DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro de SQL. Erro: " + e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return conexao;
	}

}
