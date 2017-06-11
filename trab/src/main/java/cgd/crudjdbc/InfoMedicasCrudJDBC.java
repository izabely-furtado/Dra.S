package cgd.crudjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cdp.classesAnemicas.InfoMedicas;
import cgd.conexao.ConectaPostgreSQL;

public class InfoMedicasCrudJDBC {
	/*
	 * Objetivo: M�todo que salva um as no banco de infoMedicas
	 */
	public int salvar(InfoMedicas infoMedicas) {
		// abre a conexao com o banco de infoMedicas MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
<<<<<<< HEAD
		
		String sqlInfoMedicas = "";
		
=======
		// SQL de inser��o
		String sqlInfoMedicas = "insert into InfoMedicas(medicacao, qmedicacao, tiposangue, alergia, qalergia, contatoSOS)"
				+ "values (?, ?, ?, ?, ?, ?)";
>>>>>>> origin/master
		try {
			int lastId=0;
			
			// SQL de inser��o
			sqlInfoMedicas = "insert into InfoMedicas(medicacao, qmedicacao, tiposangue, alergia, qalergia, contatoSOS)"
					+ "values (?, ?, ?, ?, ?, ?)";
			
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sqlInfoMedicas, Statement.RETURN_GENERATED_KEYS);

			// recebe o par�mtros do SQL insert
			insereSt.setBoolean(1, infoMedicas.isMedicacao());
			insereSt.setString(2, infoMedicas.getQmedicacao());
			insereSt.setString(3, infoMedicas.getTipoSangue());
			insereSt.setBoolean(4, infoMedicas.isAlergia());
			insereSt.setString(5, infoMedicas.getQalergia());
			insereSt.setString(6, infoMedicas.getContatoSOS());
			

			// executa SQL insert
			insereSt.executeUpdate();
			
			ResultSet rs = insereSt.getGeneratedKeys();
			if (rs.next()) {
			   lastId = rs.getInt("id_infomedicas");
			   return lastId;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir as informa��es m�dicas,  mensagem:" + e);
		} finally {
			try {
				// fecha conexao com o banco
				insereSt.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a opera��o de inser��o" + e);
			}
		}
		return 0;
	}

	/*
	 * Objetivo: M�todo que lista todos os ass do banco de infoMedicas
	 */
	public static InfoMedicas getInfoMedicas(int idInfoMedicas) {
		// abre conexao com o banco de infoMedicas
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de infoMedicas
		Statement consulta = null;
		// cont�m os infoMedicas consultado da tabela
		ResultSet resultado = null;
		// objeto as
		InfoMedicas infoMedicas = null;
		// consulta SQL
		String sql = "select distinct * from InfoMedicas where id=" + idInfoMedicas;
		try {
			// consulta => objeto que executa o SQL no banco de infoMedicas
			consulta = conexao.createStatement();
			// resultado => objeto que cont�m os infoMedicas consultado da tabela
			// InfoMedicas
			resultado = consulta.executeQuery(sql);
			// L� cada infoMedicas
			while (resultado.next()) {
				infoMedicas.setAlergia(resultado.getBoolean("alergia"));
				infoMedicas.setContatoSOS(resultado.getString("contatoSOS"));
				infoMedicas.setMedicacao(resultado.getBoolean("medicacao"));
				infoMedicas.setQalergia(resultado.getString("qalergia"));
				infoMedicas.setQmedicacao(resultado.getString("qmedicacao"));
				infoMedicas.setTipoSangue(resultado.getString("tipoSangue"));
				
				// insere o acesso a servi�o na lista
				return infoMedicas;

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar uma infoMedicas de acolhimento: " + e);
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
		return infoMedicas;
	}

	/*
	 * Objetivo: M�todo que lista todos os ass do banco de infoMedicas
	 */
	public static List<InfoMedicas> listar() {
		// abre conexao com o banco de infoMedicas
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de ass
		List<InfoMedicas> acessos = new ArrayList<InfoMedicas>();
		// executa o SQL no banco de infoMedicas
		Statement consulta = null;
		// cont�m os infoMedicas consultado da tabela
		ResultSet resultado = null;
		// objeto as
		// InfoMedicas as = null;
		// consulta SQL
		String sql = "select distinct * from InfoMedicas";
		try {
			// consulta => objeto que executa o SQL no banco de infoMedicas
			consulta = conexao.createStatement();
			// resultado => objeto que cont�m os infoMedicas consultado da tabela
			// InfoMedicas
			resultado = consulta.executeQuery(sql);
			// L� cada as

			while (resultado.next()) {
				InfoMedicas infoMedicas = new InfoMedicas();
				infoMedicas.setAlergia(resultado.getBoolean("alergia"));
				infoMedicas.setContatoSOS(resultado.getString("contatoSOS"));
				infoMedicas.setMedicacao(resultado.getBoolean("medicacao"));
				infoMedicas.setQalergia(resultado.getString("qalergia"));
				infoMedicas.setQmedicacao(resultado.getString("qmedicacao"));
				infoMedicas.setTipoSangue(resultado.getString("tipoSangue"));
				// insere o as na lista
				acessos.add(infoMedicas);

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
	 * Objetivo: M�todo que exclui um acesso a servi�os no banco de infoMedicas
	 */
	public static boolean excluir(InfoMedicas as) {
		// abre a conexao com o banco de infoMedicas PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiPSt = null;
		PreparedStatement excluiSt = null;
		// SQL de exclus�o do as
		String sql = "delete from InfoMedicas where id=?";
		// SQL de exclus�o do as
		String presql = "delete from InfoMedicas where id=?";
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
				throw new RuntimeException("Erro ao fechar a opera��o de exclusao" + e);
			}
		}
	}

	/*
	 * Objetivo: M�todo que altera um acesso a servi�os no banco de infoMedicas
	 */
	public static boolean alterar(InfoMedicas infoMedicas) {
		// abre a conexao com o banco de infoMedicas MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inser��o
		String sql = "update InfoMedicas set contatoSOS=?, qalergia=?, qmedicacao=?, tiposangue=?, alergia=?, medicacao=?";
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);

			// recebe o par�mtros do SQL insert
			insereSt.setString(1, infoMedicas.getContatoSOS());
			insereSt.setString(2, infoMedicas.getQalergia());
			insereSt.setString(2, infoMedicas.getQmedicacao());
			insereSt.setString(2, infoMedicas.getTipoSangue());
			insereSt.setBoolean(6, infoMedicas.isAlergia());
			insereSt.setBoolean(7, infoMedicas.isMedicacao());

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
