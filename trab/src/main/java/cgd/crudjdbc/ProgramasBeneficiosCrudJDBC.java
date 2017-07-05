package cgd.crudjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cdp.classesAnemicas.ProgramasBeneficios;
import cgd.conexao.ConectaPostgreSQL;

public class ProgramasBeneficiosCrudJDBC {
	/*
	 * Objetivo: Método que salva um as no banco de programasBeneficios
	 */
	public static int salvar(ProgramasBeneficios programasBeneficios) {
		// abre a conexao com o banco de programasBeneficios MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		
		String sqlProgramasBeneficios = "";
		
		try {
			
			int lastId=0;
			
			// SQL de inserção
			sqlProgramasBeneficios = "insert into ProgramasBeneficios(beneficiohabitacional, outro, possuiar, possuibp, possuibpc, possuipbc, possuipbf, possuipibc)"
					+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
			
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sqlProgramasBeneficios, Statement.RETURN_GENERATED_KEYS);

			// recebe o parâmtros do SQL insert
			insereSt.setString(1, programasBeneficios.getBeneficioHabitacional());
			insereSt.setString(2, programasBeneficios.getOutro());
			insereSt.setBoolean(3, programasBeneficios.isPossuiar());
			insereSt.setBoolean(4, programasBeneficios.isPossuibp());
			insereSt.setBoolean(5, programasBeneficios.isPossuibpc());
			insereSt.setBoolean(6, programasBeneficios.isPossuipbc());
			insereSt.setBoolean(7, programasBeneficios.isPossuipbf());
			insereSt.setBoolean(8, programasBeneficios.isPossuipibc());

			// executa SQL insert
			insereSt.executeUpdate();
			
			ResultSet rs = insereSt.getGeneratedKeys();
			if (rs.next()) {
			   lastId = rs.getInt("id_programabeneficios");
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
	 * Objetivo: Método que lista todos os ass do banco de programasBeneficios
	 */
	public static ProgramasBeneficios getProgramasBeneficios(int idProgramasBeneficios) {
		// abre conexao com o banco de programasBeneficios
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de programasBeneficios
		Statement consulta = null;
		// contém os programasBeneficios consultado da tabela
		ResultSet resultado = null;
		// objeto as
		ProgramasBeneficios programasBeneficios = new ProgramasBeneficios();
		// consulta SQL
		String sql = "select distinct * from ProgramasBeneficios where id_programabeneficios=" + idProgramasBeneficios;
		try {
			// consulta => objeto que executa o SQL no banco de programasBeneficios
			consulta = conexao.createStatement();
			// resultado => objeto que contém os programasBeneficios consultado da tabela
			// ProgramasBeneficios
			resultado = consulta.executeQuery(sql);
			// Lê cada programasBeneficios
			while (resultado.next()) {
				programasBeneficios.setBeneficioHabitacional(resultado.getString("beneficioHabitacional"));
				programasBeneficios.setOutro(resultado.getString("outro"));
				programasBeneficios.setPossuiar(resultado.getBoolean("possuiar"));
				programasBeneficios.setPossuibp(resultado.getBoolean("possuibp"));
				programasBeneficios.setPossuipbc(resultado.getBoolean("possuipbc"));
				programasBeneficios.setPossuipbf(resultado.getBoolean("possuipbf"));
				programasBeneficios.setPossuipibc(resultado.getBoolean("possuipibc"));
				
				// insere o acesso a serviço na lista
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
	 * Objetivo: Método que lista todos os ass do banco de programasBeneficios
	 */
	public static List<ProgramasBeneficios> listar() {
		// abre conexao com o banco de programasBeneficios
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de ass
		List<ProgramasBeneficios> acessos = new ArrayList<ProgramasBeneficios>();
		// executa o SQL no banco de programasBeneficios
		Statement consulta = null;
		// contém os programasBeneficios consultado da tabela
		ResultSet resultado = null;
		// objeto as
		// ProgramasBeneficios as = null;
		// consulta SQL
		String sql = "select distinct * from ProgramasBeneficios";
		try {
			// consulta => objeto que executa o SQL no banco de programasBeneficios
			consulta = conexao.createStatement();
			// resultado => objeto que contém os programasBeneficios consultado da tabela
			// ProgramasBeneficios
			resultado = consulta.executeQuery(sql);
			// Lê cada as

			while (resultado.next()) {
				ProgramasBeneficios programasBeneficios = new ProgramasBeneficios();
				programasBeneficios.setBeneficioHabitacional(resultado.getString("beneficioHabitacional"));
				programasBeneficios.setOutro(resultado.getString("outro"));
				programasBeneficios.setPossuiar(resultado.getBoolean("possuiar"));
				programasBeneficios.setPossuibp(resultado.getBoolean("possuibp"));
				programasBeneficios.setPossuibpc(resultado.getBoolean("possuibpc"));
				programasBeneficios.setPossuipbc(resultado.getBoolean("possuipbc"));
				programasBeneficios.setPossuipbf(resultado.getBoolean("possuipbf"));
				programasBeneficios.setPossuipibc(resultado.getBoolean("possuipibc"));
				
				// insere o as na lista
				acessos.add(programasBeneficios);

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
	 * Objetivo: Método que exclui um acesso a serviços no banco de programasBeneficios
	 */
	public static boolean excluir(ProgramasBeneficios as) {
		// abre a conexao com o banco de programasBeneficios PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiPSt = null;
		PreparedStatement excluiSt = null;
		// SQL de exclusão do as
		String sql = "delete from ProgramasBeneficios where id=?";
		// SQL de exclusão do as
		String presql = "delete from ProgramasBeneficios where id=?";
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
	 * Objetivo: Método que altera um acesso a serviços no banco de programasBeneficios
	 */
	public static boolean alterar(ProgramasBeneficios programasBeneficios) {
		// abre a conexao com o banco de programasBeneficios MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "update ProgramasBeneficios set beneficiohabitacional=?, outro=?, possuiar=?, possuibp=?, possuibpc=?, possuipbc=?, possuibpf=?, possuipibic=?";
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);

			// recebe o parâmtros do SQL insert
			insereSt.setString(1, programasBeneficios.getBeneficioHabitacional());
			insereSt.setString(2, programasBeneficios.getOutro());
			insereSt.setBoolean(3, programasBeneficios.isPossuiar());
			insereSt.setBoolean(4, programasBeneficios.isPossuibp());
			insereSt.setBoolean(5, programasBeneficios.isPossuibpc());
			insereSt.setBoolean(5, programasBeneficios.isPossuipbc());
			insereSt.setBoolean(6, programasBeneficios.isPossuipbf());
			insereSt.setBoolean(7, programasBeneficios.isPossuipibc());

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
