package teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexao.ConectaPostgreSQL;

public class EspecieCrudJDBC {
	/*
	 * Objetivo: Método que salva um usuario no banco de dados
	 */
	public void salvar(Especie especie) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "insert into usuario(descricao) values(?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			insereSt.setString(1, especie.getDescricao());
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

	public static Especie getEspecie(Integer id) {
		Especie especie = new Especie();
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// consultas SQL
		String sqlEspecie = "select distinct * from especie where idEspecie = '" + id + "'";

		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// Especie
			resultado = consulta.executeQuery(sqlEspecie);
			// Lê o especie associado ao id
			// se o especie vinculado existir
			if (resultado.next()) {
				especie.setDescricao(resultado.getString("descricao"));
				especie.setIdEspecie(resultado.getInt("idEspecie"));
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar um animal: " + e);
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a conexao " + e);
			}
		}
		// retorna especie com o determinado id
		return especie;
	}
	
	public static Especie getEspecie(String desc) {
		Especie especie = new Especie();
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// consultas SQL
		String sqlEspecie = "select distinct * from especie where idEspecie like '%" + desc + "%'";

		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// Especie
			resultado = consulta.executeQuery(sqlEspecie);
			// Lê o especie associado ao id
			// se o especie vinculado existir
			if (resultado.next()) {
				especie.setDescricao(resultado.getString("descricao"));
				especie.setIdEspecie(resultado.getInt("idEspecie"));
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar um animal: " + e);
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a conexao " + e);
			}
		}
		// retorna especie com o determinado id
		return especie;
	}

	/*
	 * Objetivo: Método que lista todos os usuarios do banco de dados
	 */
	public List<Especie> listar() {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de usuarios
		List<Especie> especies = new ArrayList<Especie>();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// objeto usuario
		Especie especie = null;
		// consulta SQL
		String sql = "select distinct * from especie";
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// Usuario
			resultado = consulta.executeQuery(sql);
			// Lê cada usuario
			while (resultado.next()) {
				especie = new Especie();
				especie.setDescricao(resultado.getString("descricao"));
				especie.setIdEspecie(resultado.getInt("idEspecie"));
				// insere o usuario na lista
				especies.add(especie);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar a especie: " + e);
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a conexao " + e);
			}
		}
		// retorna lista de usuarios
		return especies;
	}

	/*
	 * Objetivo: Método que salva um usuario no banco de dados
	 */
	public void excluir(Especie especie) {
		// abre a conexao com o banco de dados PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiSt = null;
		// SQL de inserção
		String sql = "delete from especie where idEspecie=?";
		try {
			// recebe o SQL delete
			excluiSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			excluiSt.setInt(1, especie.getIdEspecie());
			// executa SQL delete
			excluiSt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao excluir usuario.mensagem:" + e);
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

	public void alterar(Especie especie) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "update usuario set descricao=? where idEspecie=?";
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL update
			insereSt.setString(1, especie.getDescricao());
			insereSt.setInt(7, especie.getIdEspecie());
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

}
