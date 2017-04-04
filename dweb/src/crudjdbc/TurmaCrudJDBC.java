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

public class TurmaCrudJDBC {

	/*
	 * Objetivo: Método que salva um turma no banco de dados
	 */
	/*
	public void salvar(Turma turma) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "insert into turma(dataNasc, descConvenio, idEndereco, nome, possuiConvenio, "
				+ "							telefone, tipoSangue, hrDisponivelFim, hrDisponivelInicio) "
				+ "				    values (?,?,?,?,?,?,?,?,?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			insereSt.setDate(1, (Date) turma.getDataNasc());
			insereSt.setString(2, turma.getDescConvenio());
			insereSt.setInt(3, turma.getEndereco().getId());
			insereSt.setString(4, turma.getNome());
			insereSt.setBoolean(5, turma.isPossuiConvenio());
			insereSt.setInt(6, turma.getTelefone());
			insereSt.setString(7, turma.getTipoSangue());
			insereSt.setTime(8, turma.getHrDisponivelFim());
			insereSt.setTime(9, turma.getHrDisponivelInicio());

			// executa SQL insert
			insereSt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir turma. mensagem:" + e);
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
	 * Objetivo: Método que lista todos os turmas do banco de dados
	 */
	/*
	public List<Turma> listar() {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de turmas
		List<Turma> turmas = new ArrayList<Turma>();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// objeto turma
		Turma turma = null;
		// consulta SQL
		String sql = "select distinct * from turma";
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// Turma
			resultado = consulta.executeQuery(sql);
			// Lê cada turma
			while (resultado.next()) {
				turma = new Turma();
				turma.setDataNasc(resultado.getDate("dataNasc"));
				turma.setDescConvenio(resultado.getString("descConvenio"));
				turma.setEndereco(EnderecoCrudJDBC.getEndereco(resultado.getInt("idEndereco")));
				turma.setNome(resultado.getString("nome"));
				turma.setPossuiConvenio(resultado.getBoolean("possuiConvenio"));
				turma.setTelefone(resultado.getInt("telefone"));
				turma.setTipoSangue(resultado.getString("tipoSangue"));
				turma.setHrDisponivelFim(resultado.getTime("hrDisponivelFim"));
				turma.setHrDisponivelInicio(resultado.getTime("hrDisponivelInicio"));

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
	 * Objetivo: Método que salva um turma no banco de dados
	 */
	/*
	public void excluir(Turma turma) {
		// abre a conexao com o banco de dados PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiPSt = null;
		PreparedStatement excluiSt = null;
		// SQL de exclusão do turma
		String sql = "delete from turma where id=?";
		// SQL de exclusão do turma
		String presql = "delete from endereco where id=?";
		try {
			// recebe o SQL delete para endereço
			excluiPSt = conexao.prepareStatement(presql);
			// recebe o parâmtros do SQL insert
			excluiPSt.setInt(1, turma.getEndereco().getId());
			// executa SQL delete
			excluiPSt.executeUpdate();

			// recebe o SQL delete para turma
			excluiSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			excluiSt.setInt(1, turma.getId());
			// executa SQL delete
			excluiSt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao excluir turma.mensagem:" + e);
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

	public void alterar(Turma turma) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "update turma set dataNasc=?, descConvenio=?, idEndereco=?, nome=?, possuiConvenio=?, "
				+ "					   telefone=?, tipoSangue=?, HrDisponivelFim=?, getHrDisponivelInicio=?";
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL update
			insereSt.setDate(1, (Date) turma.getDataNasc());
			insereSt.setString(2, turma.getDescConvenio());
			insereSt.setInt(3, turma.getEndereco().getId());
			insereSt.setString(4, turma.getNome());
			insereSt.setBoolean(5, turma.isPossuiConvenio());
			insereSt.setInt(6, turma.getTelefone());
			insereSt.setString(7, turma.getTipoSangue());
			insereSt.setTime(8, turma.getHrDisponivelFim());
			insereSt.setTime(9, turma.getHrDisponivelInicio());

			// executa SQL update
			insereSt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao alterar turma.mensagem:" + e);
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
*/
}
