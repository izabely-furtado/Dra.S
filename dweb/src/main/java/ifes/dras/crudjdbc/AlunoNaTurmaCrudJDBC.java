package crudjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import classesAnemicas.*;
import conexao.ConectaPostgreSQL;

public class AlunoNaTurmaCrudJDBC {

	/*
	 * Objetivo: M�todo que salva um presenca no banco de dados
	 */
	public void salvar(AlunoNaAula alunoNaAula) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inser��o
		String sql = "insert into presenca(idAula, idAluno) "
				+ "				    values (?,?)";
		try {
			for (Aluno a : alunoNaAula.getAlunos()){
				// recebe o SQL insert
				insereSt = conexao.prepareStatement(sql);
				// recebe o par�mtros do SQL insert
				insereSt.setInt(1, alunoNaAula.getAula().getId());
				insereSt.setInt(2, a.getId());
				// executa SQL insert
				insereSt.executeUpdate();
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir presenca. mensagem:" + e);
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
	 * Objetivo: M�todo que exclui todas as presen�as de uma aula um presenca no banco de dados
	 */
	public void excluir(Aula aula) {
		// abre a conexao com o banco de dados PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiSt = null;
		// SQL de exclus�o do presenca
		String sql = "delete from presenca where idAula=?";
		try {
			// recebe o SQL delete para presenca
			excluiSt = conexao.prepareStatement(sql);
			// recebe o par�mtros do SQL insert
			excluiSt.setInt(1, aula.getId());
			// executa SQL delete
			excluiSt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao excluir presenca.mensagem:" + e);
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
	 * Objetivo: M�todo que exclui presen�a de um aluno em uma aula
	 */
	public void excluir(Aula aula, Aluno a) {
		// abre a conexao com o banco de dados PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiSt = null;
		// SQL de exclus�o do presenca
		String sql = "delete from presenca where idAula=" + aula.getId() + " and idAluno=" + a.getId();
		try {
			// recebe o SQL delete para presenca
			excluiSt = conexao.prepareStatement(sql);
			// executa SQL delete
			excluiSt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao excluir presenca.mensagem:" + e);
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
	
	
	
	public void alterar(AlunoNaAula alunoNaAula) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inser��o
		String sql = "update presenca set idAula=?, idAluno=?";
		try {
			for (Aluno a : alunoNaAula.getAlunos()){
				// recebe o SQL update
				insereSt = conexao.prepareStatement(sql);
				// recebe o par�mtros do SQL update
				insereSt.setInt(1, alunoNaAula.getAula().getId());
				insereSt.setInt(2, a.getId());
				// executa SQL update
				insereSt.executeUpdate();
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao alterar presenca.mensagem:" + e);
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
