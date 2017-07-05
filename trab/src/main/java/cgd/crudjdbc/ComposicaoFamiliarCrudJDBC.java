package cgd.crudjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cdp.classesAnemicas.ComposicaoFamiliar;
import cdp.classesAnemicas.Parente;
import cgd.conexao.ConectaPostgreSQL;

public class ComposicaoFamiliarCrudJDBC {
	/*
	 * Objetivo: Método que salva um as no banco de dados
	 */
	public static boolean salvar(ComposicaoFamiliar composicao) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sqlComposicaoFamiliar = "insert into composicaoFamiliar(parente1, parente2, parente3, parente4, parente5, parente6, parente7, parente8, parente9, parente10, parente11, parente12, parente13)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sqlComposicaoFamiliar);
			ParenteCrudJDBC parente = new ParenteCrudJDBC();
			
			int parente1 =  parente.salvar(composicao.getParente1());
			insereSt.setInt(1,parente1);
			
			int parente2 =   parente.salvar(composicao.getParente2());
			insereSt.setInt(2, parente2);
			
			int parente3 =   parente.salvar(composicao.getParente3());
			insereSt.setInt(3, parente3);
			
			int parente4 =   parente.salvar(composicao.getParente1());
			insereSt.setInt(4, parente4);
			
			int parente5 =   parente.salvar(composicao.getParente5());
			insereSt.setInt(5, parente5);
			
			int parente6 =  parente.salvar(composicao.getParente6());
			insereSt.setInt(6, parente6);
			
			int parente7 =   parente.salvar(composicao.getParente7());
			insereSt.setInt(7, parente7);
			
			int parente8 =    parente.salvar(composicao.getParente8());
			insereSt.setInt(8, parente8);
			
			int parente9 =   parente.salvar(composicao.getParente9());
			insereSt.setInt(9,parente9);
			
			int parente10 =   parente.salvar(composicao.getParente10());
			insereSt.setInt(10, parente10);
			
			int parente11 =  parente.salvar(composicao.getParente11());
			insereSt.setInt(11, parente11);
			
			int parente12 =   parente.salvar(composicao.getParente12());
			insereSt.setInt(12, parente12);
			
			int parente13 =   parente.salvar(composicao.getParente13());
			insereSt.setInt(13, parente13);
			// executa SQL insert
			insereSt.executeUpdate();

			return true;

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir composição familiar mensagem:" + e);
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
	
	

	/*
	 * Objetivo: Método que lista todos os ass do banco de dados
	 */
	public static ComposicaoFamiliar getComposicaoFamiliar(int idComposicaoFamiliar) {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// objeto as
		ComposicaoFamiliar composicao = new ComposicaoFamiliar();
		// consulta SQL
		String sql = "select distinct * from ComposicaoFamiliar where id_composicaofamiliar=" + idComposicaoFamiliar;
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// ComposicaoFamiliar
			resultado = consulta.executeQuery(sql);
			// Lê cada composicao
			List<Parente> parentes = new ArrayList<Parente>();

			while (resultado.next()) {
				// for (int i = 1; i < 7; i++) {
				Parente parente = ParenteCrudJDBC.getParente(resultado.getInt("parente_id"));
				parentes.add(parente);
				// }
				composicao.setParentes(parentes);

				// insere o acesso a serviço na lista
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
	 * Objetivo: Método que lista todos os ass do banco de dados
	 */
	//@SuppressWarnings("null")
	public static List<ComposicaoFamiliar> listar() {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de ass
		// List<ComposicaoFamiliar> acessos = new
		// ArrayList<ComposicaoFamiliar>();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		ComposicaoFamiliar composicao = new ComposicaoFamiliar();
		// objeto as
		// ComposicaoFamiliar as = null;
		// consulta SQL
		List<ComposicaoFamiliar> composicoes = new ArrayList<ComposicaoFamiliar>();
		String sql = "select distinct * from ComposicaoFamiliar";
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// ComposicaoFamiliar
			resultado = consulta.executeQuery(sql);
			// Lê cada as
			List<Parente> parentes = new ArrayList<Parente>();

			while (resultado.next()) {
				Parente parente = ParenteCrudJDBC.getParente(resultado.getInt("parente_id"));
				parentes.add(parente);

				composicao.setParentes(parentes);

				// insere o acesso a serviço na lista
				composicoes.add(composicao);

			}
			return composicoes;

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
	public static boolean excluir(ComposicaoFamiliar as) {
		// abre a conexao com o banco de dados PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiSt = null;
		// SQL de exclusão do as
		String sql = "delete from ComposicaoFamiliar where id=?";
		try {
			// recebe o SQL delete para as
			excluiSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			for (Parente p : as.getParentes()) {
				ParenteCrudJDBC.excluir(p);
			}
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
	public static boolean alterar(ComposicaoFamiliar composicao) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "update ComposicaoFamiliar set escola=?";
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);

			// pega o resto dos dados
			List<Parente> parentes = composicao.getParentes();
			for (Parente p : parentes) {
				String sqlComposicaoFamiliar = "update parente set parente_id=?)";
				// recebe o SQL insert
				insereSt = conexao.prepareStatement(sqlComposicaoFamiliar);
				insereSt.setInt(1, p.getId());

				// executa SQL insert
				insereSt.executeUpdate();
			}

			// executa SQL update
			insereSt.executeUpdate();
			return true;

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao alterar a situação de acolhimento - mensagem:" + e);
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
