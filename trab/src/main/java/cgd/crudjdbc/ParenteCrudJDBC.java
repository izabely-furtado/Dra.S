package cgd.crudjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cdp.classesAnemicas.Parente;
import cgd.conexao.ConectaPostgreSQL;

public class ParenteCrudJDBC {
	/*
	 * Objetivo: Método que salva um as no banco de dados
	 */
	public int salvar(Parente parente) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
	
		

		// SQL de inserção
		String sqlParente = "";
		try {
			int lastId=0;
			// pega o resto dos dados
			sqlParente = "insert into parente(dataNasc, escolaridade, idade, nome, parentesco, renda, scfv, situacaoOcupacional)"
					+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sqlParente, Statement.RETURN_GENERATED_KEYS);
			insereSt.setString(1, parente.getDataNasc());
			insereSt.setString(2, parente.getEscolaridade());
			insereSt.setInt(3, parente.getIdade());
			insereSt.setString(4, parente.getNome());
			insereSt.setString(5, parente.getParentesco());
			insereSt.setFloat(6, parente.getRenda());
			insereSt.setString(7, parente.getScfv());
			insereSt.setString(8, parente.getSituacaoOcupacional());

			// executa SQL insert
			insereSt.executeUpdate();
			
			ResultSet rs = insereSt.getGeneratedKeys();
			if (rs.next()) {
			   lastId = rs.getInt("id_parente");
			   return lastId;
			}

			

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir parente mensagem:" + e);
		} finally {
			try {
				// fecha conexao com o banco
				insereSt.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a operação de inserção" + e);
			}
		}
		return 1;
		
		
		
	}

	/*
	 * Objetivo: Método que lista todos os ass do banco de dados
	 */
	public static Parente getParente(int idParente) {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// objeto as
		Parente parente = null;
		// consulta SQL
		String sql = "select distinct * from Parente, Parente where Parente.id=" + idParente;
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// Parente
			resultado = consulta.executeQuery(sql);
			// Lê cada parente

			while (resultado.next()) {
				parente.setDataNasc(resultado.getString("dataNasc"));
				parente.setEscolaridade(resultado.getString("escolaridade"));
				parente.setIdade(resultado.getInt("idade"));
				parente.setNome(resultado.getString("nome"));
				parente.setParentesco(resultado.getString("parentesco"));
				parente.setRenda(resultado.getFloat("renda"));
				parente.setScfv(resultado.getString("scfv"));
				parente.setSituacaoOcupacional(resultado.getString("situacaoOcupacional"));

				// insere o acesso a serviço na lista
				return parente;

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar uma parente de acolhimento: " + e);
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a conexao " + e);
			}
		}
		// retorna lista de ass
		return parente;
	}

	/*
	 * Objetivo: Método que lista todos os ass do banco de dados
	 */
	@SuppressWarnings("null")
	public static List<Parente> listar() {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de ass
		// List<Parente> acessos = new ArrayList<Parente>();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		Parente parente = null;
		// objeto as
		// Parente as = null;
		// consulta SQL
		String sql = "select distinct * from Parente";
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// Parente
			resultado = consulta.executeQuery(sql);
			// Lê cada as
			List<Parente> parentes = new ArrayList<Parente>();

			while (resultado.next()) {
				parente.setDataNasc(resultado.getString("dataNasc"));
				parente.setEscolaridade(resultado.getString("escolaridade"));
				parente.setIdade(resultado.getInt("idade"));
				parente.setNome(resultado.getString("nome"));
				parente.setParentesco(resultado.getString("parentesco"));
				parente.setRenda(resultado.getFloat("renda"));
				parente.setScfv(resultado.getString("scfv"));
				parente.setSituacaoOcupacional(resultado.getString("situacaoOcupacional"));
				parentes.add(parente);

			}
			return parentes;

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar um acesso a serviços: " + e);
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a conexao " + e);
			}
		}
		// retorna lista de ass
	}

	/*
	 * Objetivo: Método que exclui um acesso a serviços no banco de dados
	 */
	public static boolean excluir(Parente as) {
		// abre a conexao com o banco de dados PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiSt = null;
		// SQL de exclusão do as
		String sql = "delete from Parente where id=?";
		try {
			// recebe o SQL delete para as
			excluiSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			excluiSt.setInt(1, as.getId());
			// executa SQL delete
			excluiSt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao excluir as.mensagem:" + e);
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

	/*
	 * Objetivo: Método que altera um acesso a serviços no banco de dados
	 */
	public static boolean alterar(Parente parente) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "update parente set parente=?, dataNasc=?, escolaridade=?,"
				+ "idade=?, nome=?, parentesco=?, renda=?, scfv=?, situacaoOcupacional=?)";
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);
			insereSt.setString(1, parente.getDataNasc());
			insereSt.setString(2, parente.getEscolaridade());
			insereSt.setInt(3, parente.getIdade());
			insereSt.setString(4, parente.getNome());
			insereSt.setString(5, parente.getParentesco());
			insereSt.setFloat(6, parente.getRenda());
			insereSt.setString(7, parente.getScfv());
			insereSt.setString(8, parente.getSituacaoOcupacional());

			// executa SQL insert
			insereSt.executeUpdate();

			return true;

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao alterar o parente mensagem:" + e);
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
