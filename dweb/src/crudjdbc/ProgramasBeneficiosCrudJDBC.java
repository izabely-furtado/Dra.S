package crudjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classesAnemicas.ProgramasBeneficios;
import conexao.ConectaPostgreSQL;

public class ProgramasBeneficiosCrudJDBC {
	/*
	 * Objetivo: M�todo que salva um as no banco de programasBeneficios
	 */
	public static void salvar(ProgramasBeneficios programasBeneficios) {
		// abre a conexao com o banco de programasBeneficios MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inser��o
		String sqlProgramasBeneficios = "insert into ProgramasBeneficios(beneficiohabitacional, outro, possuiar, possuibp, possuipbc, possuipbf, possuipibc)"
				+ "values (?, ?, ?, ?, ?, ?, ?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sqlProgramasBeneficios);

			// recebe o par�mtros do SQL insert
			insereSt.setString(1, programasBeneficios.getBeneficioHabitacional());
			insereSt.setString(2, programasBeneficios.getOutro());
			insereSt.setBoolean(3, programasBeneficios.isPossuiar());
			insereSt.setBoolean(4, programasBeneficios.isPossuibp());
			insereSt.setBoolean(5, programasBeneficios.isPossuipbc());
			insereSt.setBoolean(6, programasBeneficios.isPossuipbf());
			insereSt.setBoolean(7, programasBeneficios.isPossuipibc());

			// executa SQL insert
			insereSt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir as condi��es de moradia mensagem:" + e);
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
	 * Objetivo: M�todo que lista todos os ass do banco de programasBeneficios
	 */
	public static ProgramasBeneficios getProgramasBeneficios(int idProgramasBeneficios) {
		// abre conexao com o banco de programasBeneficios
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de programasBeneficios
		Statement consulta = null;
		// cont�m os programasBeneficios consultado da tabela
		ResultSet resultado = null;
		// objeto as
		ProgramasBeneficios programasBeneficios = null;
		// consulta SQL
		String sql = "select distinct * from ProgramasBeneficios where id=" + idProgramasBeneficios;
		try {
			// consulta => objeto que executa o SQL no banco de programasBeneficios
			consulta = conexao.createStatement();
			// resultado => objeto que cont�m os programasBeneficios consultado da tabela
			// ProgramasBeneficios
			resultado = consulta.executeQuery(sql);
			// L� cada programasBeneficios
			while (resultado.next()) {
				programasBeneficios.setBeneficioHabitacional(resultado.getString("beneficioHabitacional"));
				programasBeneficios.setOutro(resultado.getString("outro"));
				programasBeneficios.setPossuiar(resultado.getBoolean("possuiar"));
				programasBeneficios.setPossuibp(resultado.getBoolean("possuibp"));
				programasBeneficios.setPossuipbc(resultado.getBoolean("possuipbc"));
				programasBeneficios.setPossuipbf(resultado.getBoolean("possuipbf"));
				programasBeneficios.setPossuipibc(resultado.getBoolean("possuipibc"));
				
				// insere o acesso a servi�o na lista
				return programasBeneficios;

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar uma programasBeneficios de acolhimento: " + e);
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
		return programasBeneficios;
	}

	/*
	 * Objetivo: M�todo que lista todos os ass do banco de programasBeneficios
	 */
	public static List<ProgramasBeneficios> listar() {
		// abre conexao com o banco de programasBeneficios
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de ass
		List<ProgramasBeneficios> acessos = new ArrayList<ProgramasBeneficios>();
		// executa o SQL no banco de programasBeneficios
		Statement consulta = null;
		// cont�m os programasBeneficios consultado da tabela
		ResultSet resultado = null;
		// objeto as
		// ProgramasBeneficios as = null;
		// consulta SQL
		String sql = "select distinct * from ProgramasBeneficios";
		try {
			// consulta => objeto que executa o SQL no banco de programasBeneficios
			consulta = conexao.createStatement();
			// resultado => objeto que cont�m os programasBeneficios consultado da tabela
			// ProgramasBeneficios
			resultado = consulta.executeQuery(sql);
			// L� cada as

			while (resultado.next()) {
				ProgramasBeneficios programasBeneficios = new ProgramasBeneficios();
				programasBeneficios.setBeneficioHabitacional(resultado.getString("beneficioHabitacional"));
				programasBeneficios.setOutro(resultado.getString("outro"));
				programasBeneficios.setPossuiar(resultado.getBoolean("possuiar"));
				programasBeneficios.setPossuibp(resultado.getBoolean("possuibp"));
				programasBeneficios.setPossuipbc(resultado.getBoolean("possuipbc"));
				programasBeneficios.setPossuipbf(resultado.getBoolean("possuipbf"));
				programasBeneficios.setPossuipibc(resultado.getBoolean("possuipibc"));
				
				// insere o as na lista
				acessos.add(programasBeneficios);

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
	 * Objetivo: M�todo que exclui um acesso a servi�os no banco de programasBeneficios
	 */
	public static void excluir(ProgramasBeneficios as) {
		// abre a conexao com o banco de programasBeneficios PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiPSt = null;
		PreparedStatement excluiSt = null;
		// SQL de exclus�o do as
		String sql = "delete from ProgramasBeneficios where id=?";
		// SQL de exclus�o do as
		String presql = "delete from ProgramasBeneficios where id=?";
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
	 * Objetivo: M�todo que altera um acesso a servi�os no banco de programasBeneficios
	 */
	public static void alterar(ProgramasBeneficios programasBeneficios) {
		// abre a conexao com o banco de programasBeneficios MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inser��o
		String sql = "update ProgramasBeneficios set beneficiohabitacional=?, outro=?, possuiar=?, possuibp=?, possuipbc=?, possuibpf=?, possuipibic=?";
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);

			// recebe o par�mtros do SQL insert
			insereSt.setString(1, programasBeneficios.getBeneficioHabitacional());
			insereSt.setString(2, programasBeneficios.getOutro());
			insereSt.setBoolean(3, programasBeneficios.isPossuiar());
			insereSt.setBoolean(4, programasBeneficios.isPossuibp());
			insereSt.setBoolean(5, programasBeneficios.isPossuipbc());
			insereSt.setBoolean(6, programasBeneficios.isPossuipbf());
			insereSt.setBoolean(7, programasBeneficios.isPossuipibc());

			// executa SQL update
			insereSt.executeUpdate();

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
