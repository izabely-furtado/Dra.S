package cgd.crudjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cdp.classesAnemicas.*;
import cgd.conexao.ConectaPostgreSQL;

public class TurmaCrudJDBC {

	/*
	 * Objetivo: M�todo que salva um turma no banco de dados
	 */

	public static boolean salvar(Turma turma) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;

		// SQL de inser��o
		String sql = "insert into turma(codigo, maximo, turno, nivel, "
				+ "segunda, terca, quarta, quinta, sexta) "
				+ "				    values (?,?,?,?,?,?,?,?,?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sql);
			// recebe o par�mtros do SQL insert
			insereSt.setString(1, turma.getCodigo());
			insereSt.setInt(2, turma.getMaximo());
			insereSt.setString(3, turma.getTurno());
			insereSt.setInt(4, turma.getNivel());
			insereSt.setBoolean(5, turma.isSegunda());
			insereSt.setBoolean(6, turma.isTerca());
			insereSt.setBoolean(7, turma.isQuarta());
			insereSt.setBoolean(8, turma.isQuinta());
			insereSt.setBoolean(9, turma.isSexta());

			// executa SQL insert
			insereSt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir turma. mensagem:" + e);
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
	public static Turma getTurma(int idTurma) {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// cont�m os dados consultado da tabela
		ResultSet resultado = null;
		// objeto as
		Turma turma = null;
		// consulta SQL
		String sql = "select distinct * from Turma where id=" + idTurma;
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que cont�m os dados consultado da tabela
			// SituacaoAcolhimento
			resultado = consulta.executeQuery(sql);
			// L� cada situacao
			while (resultado.next()) {
				turma.setId(resultado.getInt("id_turma"));
				turma.setCodigo(resultado.getString("codigo"));
				turma.setMaximo(resultado.getInt("maximo"));
				turma.setTurno(resultado.getString("turno"));
				turma.setNivel(resultado.getInt("nivel"));
				turma.setSegunda(resultado.getBoolean("segunda"));
				turma.setTerca(resultado.getBoolean("terca"));
				turma.setQuarta(resultado.getBoolean("quarta"));
				turma.setQuinta(resultado.getBoolean("quinta"));
				turma.setSexta(resultado.getBoolean("sexta"));
				
				// insere o acesso a servi�o na lista
				return turma;
				
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar uma situacao de acolhimento: " + e);
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
		return turma;
	}

	/*
	 * Objetivo: M�todo que lista todos os turmas do banco de dados
	 */

	public static List<Turma> listar() {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de turmas
		List<Turma> turmas = new ArrayList<Turma>();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// cont�m os dados consultado da tabela
		ResultSet resultado = null;
		// objeto turma
		Turma turma = null;
		// consulta SQL
		String sql = "select distinct * from turma";
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que cont�m os dados consultado da tabela
			// Turma
			resultado = consulta.executeQuery(sql);
			// L� cada turma
			while (resultado.next()) {
				turma = new Turma();
				turma.setId(resultado.getInt("id_turma"));
				turma.setCodigo(resultado.getString("codigo"));
				turma.setMaximo(resultado.getInt("maximo"));
				turma.setTurno(resultado.getString("turno"));
				turma.setNivel(resultado.getInt("nivel"));
				turma.setSegunda(resultado.getBoolean("segunda"));
				turma.setTerca(resultado.getBoolean("terca"));
				turma.setQuarta(resultado.getBoolean("quarta"));
				turma.setQuinta(resultado.getBoolean("quinta"));
				turma.setSexta(resultado.getBoolean("sexta"));

				// insere o turma na lista
				turmas.add(turma);

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar um turma: " + e);
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a conexao " + e);
			}
		}
		// retorna lista de turmas
		return turmas;
	}

	/*
	 * Objetivo: M�todo que salva um turma no banco de dados
	 */

	public static boolean excluir(Turma turma) {
		// abre a conexao com o banco de dados PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiSt1 = null;
		PreparedStatement excluiSt2 = null;
		PreparedStatement excluiSt3 = null;
		// SQL de exclus�o do turma
		String sql = "delete from turma where id=?";
		// SQL de exclus�o das aulas da turma
		String sql2 = "delete from aulsdTurma where id=?";

		// SQL de exclus�o dos alunos da turma
		String sql3 = "delete from alunosTurma where id=?";

		try {
			//Queria deletar em cascata mas esqueci como faz
			
			// recebe o SQL delete para alunos da turma
			excluiSt3 = conexao.prepareStatement(sql3);
			// recebe o par�mtros do SQL insert
			
			for(int i=0; i<turma.getAlunos().size(); i++)
			{
				excluiSt3.setInt(1, turma.getAlunos().get(i).getId());
				// executa SQL delete
				excluiSt3.executeUpdate();

			}
			
			// recebe o SQL delete para aulas da turma
			excluiSt2 = conexao.prepareStatement(sql2);
			
			for(int j=0; j<turma.getAulas().size(); j++)
			{
				// recebe o par�mtros do SQL insert
				excluiSt2.setInt(1, turma.getAulas().get(j).getId());
				// executa SQL delete
				excluiSt2.executeUpdate();
			}
			
			

			// recebe o SQL delete para turma
			excluiSt1 = conexao.prepareStatement(sql);
			// recebe o par�mtros do SQL insert
			excluiSt1.setInt(1, turma.getId());
			// executa SQL delete
			excluiSt1.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao excluir turma.mensagem:" + e);
		} finally {
			try {
				// fecha conexao com o banco
				excluiSt1.close();
				excluiSt2.close();
				excluiSt3.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a opera��o de exclusao" + e);
			}
		}
	}

	public static boolean alterar(Turma turma) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inser��o
		String sql = "update turma set codigo=?, maximo=?, turno=?, nivel=?, nivel=?, "
				+ "					   segunda=?, terca=?, quarta=?, quinta=?, sexta=?";
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);
			// recebe o SQL update

			insereSt.setString(1, turma.getCodigo());
			insereSt.setInt(2, turma.getMaximo());
			insereSt.setString(3, turma.getTurno());
			insereSt.setInt(4, turma.getNivel());
			insereSt.setBoolean(5, turma.isSegunda());
			insereSt.setBoolean(6, turma.isTerca());
			insereSt.setBoolean(7, turma.isQuarta());
			insereSt.setBoolean(8, turma.isQuinta());
			insereSt.setBoolean(9, turma.isSexta());


			// executa SQL update
			insereSt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao alterar turma.mensagem:" + e);
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
