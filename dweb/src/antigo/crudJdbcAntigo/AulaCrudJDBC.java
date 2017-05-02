package crudjdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classesAnemicasAntiga.Aula;
import conexao.ConectaPostgreSQL;

public class AulaCrudJDBC {
	/*
	 * Objetivo: Método que salva um usuario no banco de dados
	 */
	public void salvar(Aula aula) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "insert into usuario(dataAula, ensinado, horaAula) values(?,?,?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			insereSt.setDate(1, (Date) aula.getDataAula());
			insereSt.setString(2, aula.getEnsinado());
			insereSt.setTime(3, aula.getHoraAula());
			// executa SQL insert
			insereSt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir usuario. mensagem:" + e);
		} finally {
			try {
				// fecha conexao com o banco
				insereSt.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a operação de inserção" + e);
			}
		}
	}
	
	

	public static Aula getAula(Integer id) {
		Aula aula = new Aula();
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// consultas SQL
		String sqlAula = "select distinct * from aula where id = '" + id + "'";

		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// Aula
			resultado = consulta.executeQuery(sqlAula);
			// Lê o aula associado ao id
			// se o aula vinculado existir
			if (resultado.next()) {
				aula.setDataAula(resultado.getDate("dataAula"));
				aula.setEnsinado(resultado.getString("ensinado"));
				aula.setHoraAula(resultado.getTime("horaAula"));
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar um aula: " + e);
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a conexao " + e);
			}
		}
		// retorna aula com o determinado id
		return aula;
	}

	/*
	 * Objetivo: Método que salva um usuario no banco de dados
	 */
	public void excluir(Aula aula) {
		// abre a conexao com o banco de dados PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiSt = null;
		// SQL de inserção
		String sql = "delete from aula where id=?";
		try {
			// recebe o SQL delete
			excluiSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			excluiSt.setInt(1, aula.getId());
			// executa SQL delete
			excluiSt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao excluir aula.mensagem:" + e);
		} finally {
			try {
				// fecha conexao com o banco
				excluiSt.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a operação de exclusao" + e);
			}
		}
	}

	public void alterar(Aula aula) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "update aula set dataAula=?, ensinado=?, horaAula where id=?";
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL update
			insereSt.setDate(1, (Date) aula.getDataAula());
			insereSt.setString(2, aula.getEnsinado());
			insereSt.setTime(3, aula.getHoraAula());
			insereSt.setInt(4, aula.getId());
			// executa SQL update
			insereSt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao alterar usuario. mensagem:" + e);
		} finally {
			try {
				// fecha conexao com o banco
				insereSt.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a operação de alteracao" + e);
			}
		}
	}

	public List<Aula> listar() {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de aulas
		List<Aula> aulas = new ArrayList<Aula>();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// objeto aula
		Aula aula = null;
		// consulta SQL
		String sql = "select distinct * from aula";
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// Aula
			resultado = consulta.executeQuery(sql);
			// Lê cada aula
			while (resultado.next()) {
				aula = new Aula();
				aula.setDataAula(resultado.getDate("dataAula"));
				aula.setEnsinado(resultado.getString("ensinado"));
				aula.setHoraAula(resultado.getTime("horaAula"));
				
				// insere o aula na lista
				aulas.add(aula);

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar um aula: " + e);
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a conexao " + e);
			}
		}
		// retorna lista de aulas
		return aulas;
	}

}
