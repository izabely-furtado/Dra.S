package crudjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classesAnemicas.*;
import classesAnemicasAntiga.Aluno;
import classesAnemicasAntiga.AlunoNaAula;
import classesAnemicasAntiga.Aula;
import conexao.ConectaPostgreSQL;

public class AlunoNaAulaCrudJDBC {

	/*
	 * Objetivo: M�todo que salva um alunoNaAula no banco de dados
	 */
	public void salvar(AlunoNaAula alunoNaAula) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inser��o
		String sql = "insert into alunoNaAula(idAula, idAluno) " + "values (?,?)";
		try {
			for (Aluno a : alunoNaAula.getAlunos()) {
				// recebe o SQL insert
				insereSt = conexao.prepareStatement(sql);
				// recebe o par�mtros do SQL insert
				insereSt.setInt(1, alunoNaAula.getAula().getId());
				insereSt.setInt(2, a.getId());
				// executa SQL insert
				insereSt.executeUpdate();
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir alunoNaAula. mensagem:" + e);
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
	 * Objetivo: M�todo que exclui todas as presen�as de uma aula um alunoNaAula
	 * no banco de dados
	 */
	public void excluir(Aula aula) {
		// abre a conexao com o banco de dados PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiSt = null;
		// SQL de exclus�o do alunoNaAula
		String sql = "delete from alunoNaAula where idAula=?";
		try {
			// recebe o SQL delete para alunoNaAula
			excluiSt = conexao.prepareStatement(sql);
			// recebe o par�mtros do SQL insert
			excluiSt.setInt(1, aula.getId());
			// executa SQL delete
			excluiSt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao excluir alunoNaAula.mensagem:" + e);
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
		// SQL de exclus�o do alunoNaAula
		String sql = "delete from alunoNaAula where idAula=" + aula.getId() + " and idAluno=" + a.getId();
		try {
			// recebe o SQL delete para alunoNaAula
			excluiSt = conexao.prepareStatement(sql);
			// executa SQL delete
			excluiSt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao excluir alunoNaAula.mensagem:" + e);
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
		String sql = "update alunoNaAula set idAula=?, idAluno=?";
		try {
			for (Aluno a : alunoNaAula.getAlunos()) {
				// recebe o SQL update
				insereSt = conexao.prepareStatement(sql);
				// recebe o par�mtros do SQL update
				insereSt.setInt(1, alunoNaAula.getAula().getId());
				insereSt.setInt(2, a.getId());
				// executa SQL update
				insereSt.executeUpdate();
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao alterar alunoNaAula.mensagem:" + e);
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

	/*
	 * Objetivo: M�todo que lista todos os alunos de uma aula do banco de dados
	 */
	public List<AlunoNaAula> listar(Aula aula) {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de alunos
		List<AlunoNaAula> alunosNaAula = new ArrayList<AlunoNaAula>();
		AlunoNaAula alunoNaAula = new AlunoNaAula();
		List<Aluno> alunos = new ArrayList<Aluno>();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// cont�m os dados consultado da tabela
		ResultSet resultado = null;
		// objeto aluno
		// Aluno aluno = null;
		// consulta SQL
		String sql = "select distinct * from alunoNaAula where idAula=" + aula.getId();
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que cont�m os dados consultado da tabela
			// Aluno
			resultado = consulta.executeQuery(sql);
			// L� cada aluno
			alunoNaAula.setAula(aula);
			while (resultado.next()) {
				AlunoCrudJDBC alunoCrud = new AlunoCrudJDBC();
				Aluno aluno = alunoCrud.getAluno(resultado.getInt("idAluno"));
				alunos.add(aluno);
				
			}
			alunoNaAula.setAlunos(alunos);
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar um aluno: " + e);
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a conexao " + e);
			}
		}
		// retorna lista de alunos
		return alunosNaAula;
	}

}
