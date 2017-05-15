package main.java.cgd.crudjdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.cdp.classesAnemicas.ComposicaoFamiliar;
import main.java.cdp.classesAnemicas.Parente;
import main.java.cgd.conexao.ConectaPostgreSQL;

public class ComposicaoFamiliarCrudJDBC {
	/*
	 * Objetivo: M�todo que salva um as no banco de dados
	 */
	public static boolean salvar(ComposicaoFamiliar composicao) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inser��o
		String sqlComposicaoFamiliar = "";
		try {
			// pega o resto dos dados
			List<Parente> parentes = composicao.getParentes();
			for (Parente p : parentes) {
				sqlComposicaoFamiliar += "insert into parente(dataNasc, escolaridade, idade, nome, parentesco, renda, scfv, situacaoOcupacional)"
						+ "values (?, ?, ?, ?, ?, ?, ?, ?);";
				// recebe o SQL insert
				insereSt = conexao.prepareStatement(sqlComposicaoFamiliar);
				insereSt.setDate(1, (Date) p.getDataNasc());
				insereSt.setString(2, p.getEscolaridade());
				insereSt.setInt(3, p.getIdade());
				insereSt.setString(4, p.getNome());
				insereSt.setInt(5, p.getParentesco());
				insereSt.setFloat(6, p.getRenda());
				insereSt.setString(7, p.getScfv());
				insereSt.setString(8, p.getSituacaoOcupacional());

				// executa SQL insert
				insereSt.executeUpdate();
			}
			return true;

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir composi��o familiar mensagem:" + e);
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

	/*
	 * Objetivo: M�todo que lista todos os ass do banco de dados
	 */
	public static ComposicaoFamiliar getComposicaoFamiliar(int idComposicaoFamiliar) {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// cont�m os dados consultado da tabela
		ResultSet resultado = null;
		// objeto as
		ComposicaoFamiliar composicao = null;
		// consulta SQL
		String sql = "select distinct * from ComposicaoFamiliar, Parente where ComposicaoFamiliar.id=" 
					 + idComposicaoFamiliar + "and Parente.idComposicao=" + idComposicaoFamiliar ;
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que cont�m os dados consultado da tabela
			// ComposicaoFamiliar
			resultado = consulta.executeQuery(sql);
			// L� cada composicao
			List<Parente> parentes = new ArrayList<Parente>();

			while (resultado.next()) {
				//for (int i = 1; i < 7; i++) {
				Parente parente = new Parente();
				parente.setDataNasc(resultado.getDate("dataNasc"));
				parente.setEscolaridade(resultado.getString("escolaridade"));
				parente.setIdade(resultado.getInt("idade"));
				parente.setNome(resultado.getString("nome"));
				parente.setParentesco(resultado.getInt("parentesco"));
				parente.setRenda(resultado.getFloat("renda"));
				parente.setScfv(resultado.getString("scfv"));
				parente.setSituacaoOcupacional(resultado.getString("situacaoOcupacional"));
				parentes.add(parente);	
				//}
				composicao.setParentes(parentes);
				
				// insere o acesso a servi�o na lista
				return composicao;

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar uma composicao de acolhimento: " + e);
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
		return composicao;
	}

	/*
	 * Objetivo: M�todo que lista todos os ass do banco de dados
	 */
	@SuppressWarnings("null")
	public static List<ComposicaoFamiliar> listar() {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de ass
		//List<ComposicaoFamiliar> acessos = new ArrayList<ComposicaoFamiliar>();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// cont�m os dados consultado da tabela
		ResultSet resultado = null;
		ComposicaoFamiliar composicao = null;
		// objeto as
		// ComposicaoFamiliar as = null;
		// consulta SQL
		List<ComposicaoFamiliar> composicoes = new ArrayList<ComposicaoFamiliar>();
		String sql = "select distinct * from ComposicaoFamiliar";
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que cont�m os dados consultado da tabela
			// ComposicaoFamiliar
			resultado = consulta.executeQuery(sql);
			// L� cada as
			List<Parente> parentes = new ArrayList<Parente>();

			while (resultado.next()) {
				//for (int i = 1; i < 7; i++) {
				Parente parente = new Parente();
				parente.setDataNasc(resultado.getDate("dataNasc"));
				parente.setEscolaridade(resultado.getString("escolaridade"));
				parente.setIdade(resultado.getInt("idade"));
				parente.setNome(resultado.getString("nome"));
				parente.setParentesco(resultado.getInt("parentesco"));
				parente.setRenda(resultado.getFloat("renda"));
				parente.setScfv(resultado.getString("scfv"));
				parente.setSituacaoOcupacional(resultado.getString("situacaoOcupacional"));
				parentes.add(parente);	
				//}
				composicao.setParentes(parentes);
				
				// insere o acesso a servi�o na lista
				composicoes.add(composicao);

			}
			return composicoes;

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar um acesso a servi�os: " + e);
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
	 * Objetivo: M�todo que exclui um acesso a servi�os no banco de dados
	 */
	public static boolean excluir(ComposicaoFamiliar as) {
		// abre a conexao com o banco de dados PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiSt = null;
		// SQL de exclus�o do as
		String sql = "delete from ComposicaoFamiliar where id=?";
		try {
			// recebe o SQL delete para as
			excluiSt = conexao.prepareStatement(sql);
			// recebe o par�mtros do SQL insert
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
				throw new RuntimeException("Erro ao fechar a opera��o de exclusao" + e);
			}
		}
	}

	/*
	 * Objetivo: M�todo que altera um acesso a servi�os no banco de dados
	 */
	public static boolean alterar(ComposicaoFamiliar composicao) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inser��o
		String sql = "update ComposicaoFamiliar set escola=?";
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);

			// pega o resto dos dados
			List<Parente> parentes = composicao.getParentes();
			for (Parente p : parentes) {
				String sqlComposicaoFamiliar = "update parente set composicaoFamiliar=?, dataNasc=?, escolaridade=?,"
									 	     + "idade=?, nome=?, parentesco=?, renda=?, scfv=?, situacaoOcupacional=?)";
				// recebe o SQL insert
				insereSt = conexao.prepareStatement(sqlComposicaoFamiliar);
				insereSt.setDate(1, (Date) p.getDataNasc());
				insereSt.setString(2, p.getEscolaridade());
				insereSt.setInt(3, p.getIdade());
				insereSt.setString(4, p.getNome());
				insereSt.setInt(5, p.getParentesco());
				insereSt.setFloat(6, p.getRenda());
				insereSt.setString(7, p.getScfv());
				insereSt.setString(8, p.getSituacaoOcupacional());

				// executa SQL insert
				insereSt.executeUpdate();
			}
			

			// executa SQL update
			insereSt.executeUpdate();
			return true;

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao alterar a situa��o de acolhimento - mensagem:" + e);
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

}
