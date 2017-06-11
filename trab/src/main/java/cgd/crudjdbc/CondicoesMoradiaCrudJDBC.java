package cgd.crudjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cdp.classesAnemicas.CondicoesMoradia;
import cgd.conexao.ConectaPostgreSQL;

public class CondicoesMoradiaCrudJDBC {
	/*
	 * Objetivo: Método que salva um as no banco de dados
	 */
	public int salvar(CondicoesMoradia condicoes) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inserção
		
		String sqlCondicoesMoradia = "";
		try {
			int lastId=0;
			
			sqlCondicoesMoradia = "insert into condicoesMoradia(condicao, possuiagua, possuicoleta, possuienergia, possuiesgoto, possuirisco, qrisco)"
					+ "values (?, ?, ?, ?, ?, ?, ?)";
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sqlCondicoesMoradia, Statement.RETURN_GENERATED_KEYS);

			// recebe o parâmtros do SQL insert
			insereSt.setString(1, condicoes.getCondicao());
			insereSt.setBoolean(2, condicoes.isPossuiagua());
			insereSt.setBoolean(3, condicoes.isPossuicoleta());
			insereSt.setBoolean(4, condicoes.isPossuienergia());
			insereSt.setBoolean(5, condicoes.isPossuiesgoto());
			insereSt.setBoolean(6, condicoes.isPossuirisco());
			insereSt.setString(7, condicoes.getQrisco());

			// executa SQL insert
			insereSt.executeUpdate();
			
			ResultSet rs = insereSt.getGeneratedKeys();
			if (rs.next()) {
			   lastId = rs.getInt("id_condicaomoradia");
			   return lastId;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir as condições de moradia mensagem:" + e);
		} finally {
			try {
				// fecha conexao com o banco
				insereSt.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a operação de inserção" + e);
			}
		}
		return 0;
	}

	/*
	 * Objetivo: Método que lista todos os ass do banco de dados
	 */
	public static CondicoesMoradia getCondicoesMoradia(int idCondicoesMoradia) {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// objeto as
		CondicoesMoradia condicoes = null;
		// consulta SQL
		String sql = "select distinct * from CondicoesMoradia where id=" + idCondicoesMoradia;
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// CondicoesMoradia
			resultado = consulta.executeQuery(sql);
			// Lê cada condicoes
			while (resultado.next()) {
				condicoes.setCondicao(resultado.getString("condicao"));
				condicoes.setPossuiagua(resultado.getBoolean("possuiagua"));
				condicoes.setPossuicoleta(resultado.getBoolean("possuicoleta"));
				condicoes.setPossuienergia(resultado.getBoolean("possuienergia"));
				condicoes.setPossuiesgoto(resultado.getBoolean("possuiesgoto"));
				condicoes.setPossuirisco(resultado.getBoolean("possuirisco"));
				condicoes.setQrisco(resultado.getString("qrisco"));

				// insere o acesso a serviço na lista
				return condicoes;

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar uma condicoes de acolhimento: " + e);
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
		return condicoes;
	}

	/*
	 * Objetivo: Método que lista todos os ass do banco de dados
	 */
	public static List<CondicoesMoradia> listar() {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de ass
		List<CondicoesMoradia> acessos = new ArrayList<CondicoesMoradia>();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// objeto as
		// CondicoesMoradia as = null;
		// consulta SQL
		String sql = "select distinct * from CondicoesMoradia";
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// CondicoesMoradia
			resultado = consulta.executeQuery(sql);
			// Lê cada as

			while (resultado.next()) {
				CondicoesMoradia condicoes = new CondicoesMoradia();
				condicoes.setCondicao(resultado.getString("condicao"));
				condicoes.setPossuiagua(resultado.getBoolean("possuiagua"));
				condicoes.setPossuicoleta(resultado.getBoolean("possuicoleta"));
				condicoes.setPossuienergia(resultado.getBoolean("possuienergia"));
				condicoes.setPossuiesgoto(resultado.getBoolean("possuiesgoto"));
				condicoes.setPossuirisco(resultado.getBoolean("possuirisco"));
				condicoes.setQrisco(resultado.getString("qrisco"));
				// insere o as na lista
				acessos.add(condicoes);

			}

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
		return acessos;
	}

	/*
	 * Objetivo: Método que exclui um acesso a serviços no banco de dados
	 */
	public static boolean excluir(CondicoesMoradia as) {
		// abre a conexao com o banco de dados PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiPSt = null;
		PreparedStatement excluiSt = null;
		// SQL de exclusão do as
		String sql = "delete from CondicoesMoradia where id=?";
		// SQL de exclusão do as
		String presql = "delete from CondicoesMoradia where id=?";
		try {
			// recebe o SQL delete para endereço
			excluiPSt = conexao.prepareStatement(presql);
			// recebe o parâmtros do SQL insert
			excluiPSt.setInt(1, as.getId());
			// executa SQL delete
			excluiPSt.executeUpdate();

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
				excluiPSt.close();
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
	public static boolean alterar(CondicoesMoradia condicoes) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "update CondicoesMoradia set condicao=?, possuiagua=?, possuicoleta=?, possuienergia=?, "
				+ "	possuienergia=?, possuiesgoto=?, possuirisco=?, qrisco=?";
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);

			// recebe o parâmtros do SQL insert
			insereSt.setString(1, condicoes.getCondicao());
			insereSt.setBoolean(2, condicoes.isPossuiagua());
			insereSt.setBoolean(2, condicoes.isPossuicoleta());
			insereSt.setBoolean(2, condicoes.isPossuienergia());
			insereSt.setBoolean(2, condicoes.isPossuiesgoto());
			insereSt.setBoolean(2, condicoes.isPossuirisco());
			insereSt.setString(2, condicoes.getQrisco());

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
