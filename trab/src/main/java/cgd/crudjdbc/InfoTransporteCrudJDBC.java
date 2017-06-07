package cgd.crudjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cdp.classesAnemicas.InfoTransporte;
import cgd.conexao.ConectaPostgreSQL;

public class InfoTransporteCrudJDBC {
	/*
	 * Objetivo: M�todo que salva um as no banco de infoTransporte
	 */
	public static boolean salvar(InfoTransporte infoTransporte) {
		// abre a conexao com o banco de infoTransporte MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inser�ao
		String sqlInfoTransporte = "insert into InfoTransporte(qtransporte, transporte)"
				+ "values (?, ?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sqlInfoTransporte);

			// recebe o par�mtros do SQL insert
			insereSt.setString(1, infoTransporte.getQtransporte());
			insereSt.setBoolean(2, infoTransporte.isTransporte());
			

			// executa SQL insert
			insereSt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir as condi��es de moradia mensagem:" + e);
		} finally {
			try {
				// fecha conexao com o banco
				insereSt.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a opera�ao de inser�ao" + e);
			}
		}
	}

	/*
	 * Objetivo: M�todo que lista todos os ass do banco de infoTransporte
	 */
	public static InfoTransporte getInfoTransporte(int idInfoTransporte) {
		// abre conexao com o banco de infoTransporte
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de infoTransporte
		Statement consulta = null;
		// cont�m os infoTransporte consultado da tabela
		ResultSet resultado = null;
		// objeto as
		InfoTransporte infoTransporte = null;
		// consulta SQL
		String sql = "select distinct * from InfoTransporte where id=" + idInfoTransporte;
		try {
			// consulta => objeto que executa o SQL no banco de infoTransporte
			consulta = conexao.createStatement();
			// resultado => objeto que cont�m os infoTransporte consultado da tabela
			// InfoTransporte
			resultado = consulta.executeQuery(sql);
			// L� cada infoTransporte
			while (resultado.next()) {
				infoTransporte.setCartao(resultado.getString("cartao"));
				infoTransporte.setQtransporte(resultado.getString("qtransporte"));
				infoTransporte.setTransporte(resultado.getBoolean("transporte"));
				
				// insere o acesso a servi�o na lista
				return infoTransporte;

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar uma infoTransporte de acolhimento: " + e);
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
		return infoTransporte;
	}

	/*
	 * Objetivo: M�todo que lista todos os ass do banco de infoTransporte
	 */
	public static List<InfoTransporte> listar() {
		// abre conexao com o banco de infoTransporte
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de ass
		List<InfoTransporte> acessos = new ArrayList<InfoTransporte>();
		// executa o SQL no banco de infoTransporte
		Statement consulta = null;
		// cont�m os infoTransporte consultado da tabela
		ResultSet resultado = null;
		// objeto as
		// InfoTransporte as = null;
		// consulta SQL
		String sql = "select distinct * from InfoTransporte";
		try {
			// consulta => objeto que executa o SQL no banco de infoTransporte
			consulta = conexao.createStatement();
			// resultado => objeto que cont�m os infoTransporte consultado da tabela
			// InfoTransporte
			resultado = consulta.executeQuery(sql);
			// L� cada as

			while (resultado.next()) {
				InfoTransporte infoTransporte = new InfoTransporte();
				infoTransporte.setCartao(resultado.getString("cartao"));
				infoTransporte.setQtransporte(resultado.getString("qtransporte"));
				infoTransporte.setTransporte(resultado.getBoolean("transporte"));
				// insere o as na lista
				acessos.add(infoTransporte);

			}

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
		return acessos;
	}

	/*
	 * Objetivo: M�todo que exclui um acesso a servi�os no banco de infoTransporte
	 */
	public static boolean excluir(InfoTransporte as) {
		// abre a conexao com o banco de infoTransporte PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiPSt = null;
		PreparedStatement excluiSt = null;
		// SQL de exclusao do as
		String sql = "delete from InfoTransporte where id=?";
		// SQL de exclusao do as
		String presql = "delete from InfoTransporte where id=?";
		try {
			// recebe o SQL delete para endere�o
			excluiPSt = conexao.prepareStatement(presql);
			// recebe o par�mtros do SQL insert
			excluiPSt.setInt(1, as.getId());
			// executa SQL delete
			excluiPSt.executeUpdate();

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
				excluiPSt.close();
				excluiSt.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a opera�ao de exclusao" + e);
			}
		}
	}

	/*
	 * Objetivo: M�todo que altera um acesso a servi�os no banco de infoTransporte
	 */
	public static boolean alterar(InfoTransporte infoTransporte) {
		// abre a conexao com o banco de infoTransporte MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inser�ao
		String sql = "update InfoTransporte set cartao=?, qtransporte=?, transporte=?";
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);

			// recebe o par�mtros do SQL insert
			insereSt.setString(1, infoTransporte.getCartao());
			insereSt.setString(2, infoTransporte.getQtransporte());
			insereSt.setBoolean(3, infoTransporte.isTransporte());

			// executa SQL update
			insereSt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao alterar a situa�ao de acolhimento - mensagem:" + e);
		} finally {
			try {
				// fecha conexao com o banco
				insereSt.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a opera�ao de alteracao" + e);
			}
		}
	}

}
