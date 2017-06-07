package cgd.crudjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cdp.classesAnemicas.PublicoPrioritario;
import cgd.conexao.ConectaPostgreSQL;

public class PublicoPrioritarioCrudJDBC {
	/*
	 * Objetivo: Método que salva um as no banco de publicoPrioritario
	 */
	public static boolean salvar(PublicoPrioritario publicoPrioritario) {
		// abre a conexao com o banco de publicoPrioritario MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sqlPublicoPrioritario = "insert into PublicoPrioritario(abuso, acolhimento, defasagem, eca, egressos, isolamento, mse, rua, trabInfantil, vivencia, vulnerabilidade)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sqlPublicoPrioritario);

			// recebe o parâmtros do SQL insert
			insereSt.setBoolean(1, publicoPrioritario.isAbuso());
			insereSt.setBoolean(2, publicoPrioritario.isAcolimento());
			insereSt.setBoolean(3, publicoPrioritario.isDefasagem());
			insereSt.setBoolean(4, publicoPrioritario.isEca());
			insereSt.setBoolean(5, publicoPrioritario.isEgressos());
			insereSt.setBoolean(6, publicoPrioritario.isIsolamento());
			insereSt.setBoolean(7, publicoPrioritario.isMse());
			insereSt.setBoolean(8, publicoPrioritario.isRua());
			insereSt.setBoolean(9, publicoPrioritario.isTrabInfantil());
			insereSt.setBoolean(10, publicoPrioritario.isVivencia());
			insereSt.setBoolean(11, publicoPrioritario.isVulnerabilidade());

			// executa SQL insert
			insereSt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir o público prioritário mensagem:" + e);
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
	 * Objetivo: Método que lista todos os ass do banco de publicoPrioritario
	 */
	public static PublicoPrioritario getPublicoPrioritario(int idPublicoPrioritario) {
		// abre conexao com o banco de publicoPrioritario
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de publicoPrioritario
		Statement consulta = null;
		// contém os publicoPrioritario consultado da tabela
		ResultSet resultado = null;
		// objeto as
		PublicoPrioritario publicoPrioritario = null;
		// consulta SQL
		String sql = "select distinct * from PublicoPrioritario where id=" + idPublicoPrioritario;
		try {
			// consulta => objeto que executa o SQL no banco de publicoPrioritario
			consulta = conexao.createStatement();
			// resultado => objeto que contém os publicoPrioritario consultado da tabela
			// PublicoPrioritario
			resultado = consulta.executeQuery(sql);
			// Lê cada publicoPrioritario
			while (resultado.next()) {
				publicoPrioritario.setAbuso(resultado.getBoolean("abuso"));
				publicoPrioritario.setAcolimento(resultado.getBoolean("acolimento"));
				publicoPrioritario.setDefasagem(resultado.getBoolean("defasagem"));
				publicoPrioritario.setEca(resultado.getBoolean("eca"));
				publicoPrioritario.setEgressos(resultado.getBoolean("egressos"));
				publicoPrioritario.setIsolamento(resultado.getBoolean("isolamento"));
				publicoPrioritario.setMse(resultado.getBoolean("mse"));
				publicoPrioritario.setRua(resultado.getBoolean("rua"));
				publicoPrioritario.setTrabInfantil(resultado.getBoolean("trabInfantil"));
				publicoPrioritario.setVivencia(resultado.getBoolean("vivencia"));
				publicoPrioritario.setVulnerabilidade(resultado.getBoolean("vulnerabilidade"));
				
				// insere o acesso a serviço na lista
				return publicoPrioritario;

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar uma publicoPrioritario de acolhimento: " + e);
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
		return publicoPrioritario;
	}

	/*
	 * Objetivo: Método que lista todos os ass do banco de publicoPrioritario
	 */
	public static List<PublicoPrioritario> listar() {
		// abre conexao com o banco de publicoPrioritario
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de ass
		List<PublicoPrioritario> acessos = new ArrayList<PublicoPrioritario>();
		// executa o SQL no banco de publicoPrioritario
		Statement consulta = null;
		// contém os publicoPrioritario consultado da tabela
		ResultSet resultado = null;
		// objeto as
		// PublicoPrioritario as = null;
		// consulta SQL
		String sql = "select distinct * from PublicoPrioritario";
		try {
			// consulta => objeto que executa o SQL no banco de publicoPrioritario
			consulta = conexao.createStatement();
			// resultado => objeto que contém os publicoPrioritario consultado da tabela
			// PublicoPrioritario
			resultado = consulta.executeQuery(sql);
			// Lê cada as

			while (resultado.next()) {
				PublicoPrioritario publicoPrioritario = new PublicoPrioritario();
				publicoPrioritario.setAbuso(resultado.getBoolean("abuso"));
				publicoPrioritario.setAcolimento(resultado.getBoolean("acolimento"));
				publicoPrioritario.setDefasagem(resultado.getBoolean("defasagem"));
				publicoPrioritario.setEca(resultado.getBoolean("eca"));
				publicoPrioritario.setEgressos(resultado.getBoolean("egressos"));
				publicoPrioritario.setIsolamento(resultado.getBoolean("isolamento"));
				publicoPrioritario.setMse(resultado.getBoolean("mse"));
				publicoPrioritario.setRua(resultado.getBoolean("rua"));
				publicoPrioritario.setTrabInfantil(resultado.getBoolean("trabInfantil"));
				publicoPrioritario.setVivencia(resultado.getBoolean("vivencia"));
				publicoPrioritario.setVulnerabilidade(resultado.getBoolean("vulnerabilidade"));
				
				
				// insere o as na lista
				acessos.add(publicoPrioritario);

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
	 * Objetivo: Método que exclui um acesso a serviços no banco de publicoPrioritario
	 */
	public static boolean excluir(PublicoPrioritario as) {
		// abre a conexao com o banco de publicoPrioritario PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiPSt = null;
		PreparedStatement excluiSt = null;
		// SQL de exclusão do as
		String sql = "delete from PublicoPrioritario where id=?";
		// SQL de exclusão do as
		String presql = "delete from PublicoPrioritario where id=?";
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
	 * Objetivo: Método que altera um acesso a serviços no banco de publicoPrioritario
	 */
	public static boolean alterar(PublicoPrioritario publicoPrioritario) {
		// abre a conexao com o banco de publicoPrioritario MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "update PublicoPrioritario set abuso=?, acolhimento=?, desafasamento=?, eca=?, egressos=?, isolamento=?, mse=?, rua=?, trabinfantil=?, vivencia=?, vulnerabilidade=?";
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);

			// recebe o parâmtros do SQL insert
			insereSt.setBoolean(1, publicoPrioritario.isAbuso());
			insereSt.setBoolean(2, publicoPrioritario.isAcolimento());
			insereSt.setBoolean(3, publicoPrioritario.isDefasagem());
			insereSt.setBoolean(4, publicoPrioritario.isEca());
			insereSt.setBoolean(5, publicoPrioritario.isEgressos());
			insereSt.setBoolean(6, publicoPrioritario.isIsolamento());
			insereSt.setBoolean(7, publicoPrioritario.isMse());
			insereSt.setBoolean(8, publicoPrioritario.isRua());
			insereSt.setBoolean(9, publicoPrioritario.isTrabInfantil());
			insereSt.setBoolean(10, publicoPrioritario.isVivencia());
			insereSt.setBoolean(11, publicoPrioritario.isVulnerabilidade());
			
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
