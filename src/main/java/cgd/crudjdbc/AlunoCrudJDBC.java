package main.java.cgd.crudjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.cdp.classesAnemicas.Aluno;
import main.java.cgd.conexao.ConectaPostgreSQL;

public class AlunoCrudJDBC {
	/*
	 * Objetivo: Método que salva uma aluno no banco de dados
	 */
	public static boolean salvar(Aluno aluno) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "insert into aluno(fap_id, foto, nivel, turma_id) values(?,?,?,?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			insereSt.setInt(1, aluno.getFap().getId());
			insereSt.setString(2, aluno.getFoto());
			insereSt.setInt(3, aluno.getNivel());
			insereSt.setInt(4, aluno.getTurma().getId());
			
			
			// executa SQL insert
			insereSt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir aluno. mensagem:" + e);
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
	
	

	public static Aluno getAluno(Integer id) {
		Aluno aluno = new Aluno();
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// consultas SQL
		String sqlAluno = "select distinct * from aluno where id = '" + id + "'";

		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// Aluno
			resultado = consulta.executeQuery(sqlAluno);
			// Lê o aluno associado ao id
			// se o aluno vinculado existir
			if (resultado.next()) {
				aluno.setFap(FAPCrudJDBC.getFormularioAcompanhamentoPsicossocial(resultado.getInt("fap_id")));
				aluno.setFoto(resultado.getString("foto"));
				aluno.setNivel(resultado.getInt("nivel"));
				aluno.setTurma(TurmaCrudJDBC.getTurma(resultado.getInt("turma_id")));
				
			}

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
		// retorna aluno com o determinado id
		return aluno;
	}

	/*
	 * Objetivo: Método que salva uma aluno no banco de dados
	 */
	public static boolean excluir(Aluno aluno) {
		// abre a conexao com o banco de dados PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiSt = null;
		// SQL de inserção
		String sql = "delete from aluno where id=?";
		try {
			// recebe o SQL delete
			excluiSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			excluiSt.setInt(1, aluno.getId());
			// executa SQL delete
			excluiSt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao excluir aluno.mensagem:" + e);
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

	public static boolean alterar(Aluno aluno) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "update aluno set fap_id=?, foto=?, nivel=?, turma_id=?"
				+ " where id=?";
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL update
			
			insereSt.setInt(1, aluno.getFap().getId());
			insereSt.setString(2, aluno.getFoto());
			insereSt.setInt(3, aluno.getNivel());
			insereSt.setInt(4, aluno.getTurma().getId());
			
			// executa SQL update
			insereSt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao alterar a aluno. mensagem:" + e);
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

	public static List<Aluno> listar() {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de alunos
		List<Aluno> alunos = new ArrayList<Aluno>();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// objeto aluno
		Aluno aluno = null;
		// consulta SQL
		String sql = "select distinct * from aluno";
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// Aluno
			resultado = consulta.executeQuery(sql);
			// Lê cada aluno
			while (resultado.next()) {
				aluno = new Aluno();
				
				aluno.setFap(FAPCrudJDBC.getFormularioAcompanhamentoPsicossocial(resultado.getInt("fap_id")));
				aluno.setFoto(resultado.getString("foto"));
				aluno.setNivel(resultado.getInt("nivel"));
				aluno.setTurma(TurmaCrudJDBC.getTurma(resultado.getInt("turma_id")));
				
				
				// insere o aluno na lista
				alunos.add(aluno);

			}
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
		return alunos;
	}

}
