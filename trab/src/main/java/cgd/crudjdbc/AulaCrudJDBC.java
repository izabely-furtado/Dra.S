package cgd.crudjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cdp.classesAnemicas.Aula;
import cgd.conexao.ConectaPostgreSQL;

public class AulaCrudJDBC {
	/*
	 * Objetivo: M�todo que salva uma aula no banco de dados
	 */
	public static boolean salvar(Aula aula) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inser��o
		String sql = "insert into aula(tipo, horario, data, conteudo, turma_id) values(?,?,?,?, ?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sql);
			// recebe o par�mtros do SQL insert
			insereSt.setString(1, aula.getTipo());
			insereSt.setString(2, aula.getHorario());
			insereSt.setString(3, aula.getData());
			insereSt.setString(4, aula.getConteudo());
			insereSt.setInt(5, aula.getTurma().getId());
			
			
			// executa SQL insert
			insereSt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir aula. mensagem:" + e);
		} finally {
			try {
				// fecha conexao com o banco
				insereSt.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a opera��o de inser��o" + e);
			}
		}
	}
	
	

	public static Aula getAula(Integer id) {
		Aula aula = new Aula();
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// cont�m os dados consultado da tabela
		ResultSet resultado = null;
		// consultas SQL
		String sqlAula = "select distinct * from aula where id = '" + id + "'";

		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que cont�m os dados consultado da tabela
			// Aula
			resultado = consulta.executeQuery(sqlAula);
			// L� o aula associado ao id
			// se o aula vinculado existir
			if (resultado.next()) {
				aula.setTipo(resultado.getString("tipo"));
				aula.setHorario(resultado.getString("horario"));
				aula.setData(resultado.getString("data"));
				aula.setConteudo(resultado.getString("conteudo"));
				aula.setTurma(TurmaCrudJDBC.getTurma(resultado.getInt("turma_id")));
				
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
	 * Objetivo: M�todo que salva uma aula no banco de dados
	 */
	public static boolean excluir(Aula aula) {
		// abre a conexao com o banco de dados PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiSt = null;
		// SQL de inser��o
		String sql = "delete from aula where id=?";
		try {
			// recebe o SQL delete
			excluiSt = conexao.prepareStatement(sql);
			// recebe o par�mtros do SQL insert
			excluiSt.setInt(1, aula.getId());
			// executa SQL delete
			excluiSt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao excluir aula.mensagem:" + e);
		} finally {
			try {
				// fecha conexao com o banco
				excluiSt.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a opera��o de exclusao" + e);
			}
		}
	}

	public static boolean alterar(Aula aula) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inser��o
		String sql = "update aula set tipo=?, horario=?, data=?, conteudo=?, turma_id=?"
				+ " where id=?";
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);
			// recebe o par�mtros do SQL update
			
			insereSt.setString(1, aula.getTipo());
			insereSt.setString(2, aula.getHorario());
			insereSt.setString(3, aula.getData());
			insereSt.setString(4, aula.getConteudo());
			insereSt.setInt(5, aula.getTurma().getId());
			
			// executa SQL update
			insereSt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao alterar a aula. mensagem:" + e);
		} finally {
			try {
				// fecha conexao com o banco
				insereSt.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a opera��o de alteracao" + e);
			}
		}
	}

	public static List<Aula> listar() {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de aulas
		List<Aula> aulas = new ArrayList<Aula>();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// cont�m os dados consultado da tabela
		ResultSet resultado = null;
		// objeto aula
		Aula aula = null;
		// consulta SQL
		String sql = "select distinct * from aula";
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que cont�m os dados consultado da tabela
			// Aula
			resultado = consulta.executeQuery(sql);
			// L� cada aula
			while (resultado.next()) {
				aula = new Aula();
				
				aula.setTipo(resultado.getString("tipo"));
				aula.setHorario(resultado.getString("horario"));
				aula.setData(resultado.getString("data"));
				aula.setConteudo(resultado.getString("conteudo"));
				aula.setTurma(TurmaCrudJDBC.getTurma(resultado.getInt("turma_id")));
				
				
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
