package crudjdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classesAnemicas.*;
import conexao.ConectaPostgreSQL;

public class ProfessorCrudJDBC {

	/*
	 * Objetivo: Método que salva um professor no banco de dados
	 */
	public void salvar(Professor professor) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "insert into professor(dataNasc, descConvenio, idEndereco, nome, possuiConvenio, "
				+ "							telefone, tipoSangue, hrDisponivelFim, hrDisponivelInicio) "
				+ "				    values (?,?,?,?,?,?,?,?,?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			insereSt.setDate(1, (Date) professor.getDataNasc());
			insereSt.setString(2, professor.getDescConvenio());
			insereSt.setInt(3, professor.getEndereco().getId());
			insereSt.setString(4, professor.getNome());
			insereSt.setBoolean(5, professor.isPossuiConvenio());
			insereSt.setInt(6, professor.getTelefone());
			insereSt.setString(7, professor.getTipoSangue());
			insereSt.setTime(8, professor.getHrDisponivelFim());
			insereSt.setTime(9, professor.getHrDisponivelInicio());

			// executa SQL insert
			insereSt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir professor. mensagem:" + e);
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
	 * Objetivo: Método que lista todos os professors do banco de dados
	 */
	public List<Professor> listar() {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de professors
		List<Professor> professors = new ArrayList<Professor>();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// objeto professor
		Professor professor = null;
		// consulta SQL
		String sql = "select distinct * from professor";
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// Professor
			resultado = consulta.executeQuery(sql);
			// Lê cada professor
			while (resultado.next()) {
				professor = new Professor();
				professor.setDataNasc(resultado.getDate("dataNasc"));
				professor.setDescConvenio(resultado.getString("descConvenio"));
				professor.setEndereco(EnderecoCrudJDBC.getEndereco(resultado.getInt("idEndereco")));
				professor.setNome(resultado.getString("nome"));
				professor.setPossuiConvenio(resultado.getBoolean("possuiConvenio"));
				professor.setTelefone(resultado.getInt("telefone"));
				professor.setTipoSangue(resultado.getString("tipoSangue"));
				professor.setHrDisponivelFim(resultado.getTime("hrDisponivelFim"));
				professor.setHrDisponivelInicio(resultado.getTime("hrDisponivelInicio"));
				
				// insere o professor na lista
				professors.add(professor);

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar um professor: " + e);
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a conexao " + e);
			}
		}
		// retorna lista de professors
		return professors;
	}

	
	/*
	 * Objetivo: Método que salva um professor no banco de dados
	 */
	public void excluir(Professor professor) {
		// abre a conexao com o banco de dados PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiPSt = null;
		PreparedStatement excluiSt = null;
		// SQL de exclusão do professor
		String sql = "delete from professor where id=?";
		// SQL de exclusão do professor
		String presql = "delete from endereco where id=?";
		try {
			// recebe o SQL delete para endereço
			excluiPSt = conexao.prepareStatement(presql);
			// recebe o parâmtros do SQL insert
			excluiPSt.setInt(1, professor.getEndereco().getId());
			// executa SQL delete
			excluiPSt.executeUpdate();

			// recebe o SQL delete para professor
			excluiSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			excluiSt.setInt(1, professor.getId());
			// executa SQL delete
			excluiSt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao excluir professor.mensagem:" + e);
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

	public void alterar(Professor professor) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "update professor set dataNasc=?, descConvenio=?, idEndereco=?, nome=?, possuiConvenio=?, "
				+ "					   telefone=?, tipoSangue=?, HrDisponivelFim=?, getHrDisponivelInicio=?";
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL update
			insereSt.setDate(1, (Date) professor.getDataNasc());
			insereSt.setString(2, professor.getDescConvenio());
			insereSt.setInt(3, professor.getEndereco().getId());
			insereSt.setString(4, professor.getNome());
			insereSt.setBoolean(5, professor.isPossuiConvenio());
			insereSt.setInt(6, professor.getTelefone());
			insereSt.setString(7, professor.getTipoSangue());
			insereSt.setTime(8, professor.getHrDisponivelFim());
			insereSt.setTime(9, professor.getHrDisponivelInicio());

			
			// executa SQL update
			insereSt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao alterar professor.mensagem:" + e);
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
