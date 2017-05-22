package main.java.cgd.crudjdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.cdp.classesAnemicas.DadosPessoais;
import main.java.cgd.conexao.ConectaPostgreSQL;

public class DadosPessoaisCrudJDBC {
	/*
	 * Objetivo: Método que salva um as no banco de dados
	 */
	public static boolean salvar(DadosPessoais dados) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sqlDadosPessoais = "insert into DadosPessoais(contato, datanasc, nis, nome, parentesco, responsavel, sexo)"
				+ "values (?, ?, ?, ?, ?, ?, ?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sqlDadosPessoais);

			// recebe o parâmtros do SQL insert
			insereSt.setString(1, dados.getContato());
			insereSt.setDate(2, (Date) dados.getDatNasc());
			insereSt.setString(2, dados.getNis());
			insereSt.setString(2, dados.getNome());
			insereSt.setString(2, dados.getParentesco());
			insereSt.setString(2, dados.getResponsavel());
			insereSt.setInt(2, dados.getSexo());

			// executa SQL insert
			insereSt.executeUpdate();
			return true;
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
	}

	/*
	 * Objetivo: Método que lista todos os ass do banco de dados
	 */
	public static DadosPessoais getDadosPessoais(int idDadosPessoais) {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// objeto as
		DadosPessoais dados = null;
		// consulta SQL
		String sql = "select distinct * from DadosPessoais where id=" + idDadosPessoais;
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// DadosPessoais
			resultado = consulta.executeQuery(sql);
			// Lê cada dados
			while (resultado.next()) {
				dados.setContato(resultado.getString("contato"));
				dados.setDatNasc(resultado.getDate("datNasc"));
				dados.setNis(resultado.getString("nis"));
				dados.setNome(resultado.getString("nome"));
				dados.setParentesco(resultado.getString("parentesco"));
				dados.setResponsavel(resultado.getString("responsavel"));
				dados.setSexo(resultado.getInt("sexo"));
				
				// insere o acesso a serviço na lista
				return dados;

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar uma dados de acolhimento: " + e);
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
		return dados;
	}

	/*
	 * Objetivo: Método que lista todos os ass do banco de dados
	 */
	public static List<DadosPessoais> listar() {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de ass
		List<DadosPessoais> acessos = new ArrayList<DadosPessoais>();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// objeto as
		// DadosPessoais as = null;
		// consulta SQL
		String sql = "select distinct * from DadosPessoais";
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// DadosPessoais
			resultado = consulta.executeQuery(sql);
			// Lê cada as

			while (resultado.next()) {
				DadosPessoais dados = new DadosPessoais();
				dados.setContato(resultado.getString("contato"));
				dados.setDatNasc(resultado.getDate("datNasc"));
				dados.setNis(resultado.getString("nis"));
				dados.setNome(resultado.getString("nome"));
				dados.setParentesco(resultado.getString("parentesco"));
				dados.setResponsavel(resultado.getString("responsavel"));
				dados.setSexo(resultado.getInt("sexo"));
				// insere o as na lista
				acessos.add(dados);

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
	 * Objetivo: Método que exclui um acesso a serviços no banco de dados
	 */
	public static boolean excluir(DadosPessoais as) {
		// abre a conexao com o banco de dados PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiPSt = null;
		PreparedStatement excluiSt = null;
		// SQL de exclusão do as
		String sql = "delete from DadosPessoais where id=?";
		// SQL de exclusão do as
		String presql = "delete from DadosPessoais where id=?";
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
	 * Objetivo: Método que altera um acesso a serviços no banco de dados
	 */
	public static boolean alterar(DadosPessoais dados) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "update DadosPessoais set contato=?, datNasc=?, nis=?, nome=?, "
				+ "	parentesco=?, responsavel=?, sexo=?";
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);

			// recebe o parâmtros do SQL insert
			insereSt.setString(1, dados.getContato());
			insereSt.setDate(2, (Date) dados.getDatNasc());
			insereSt.setString(2, dados.getNis());
			insereSt.setString(2, dados.getNome());
			insereSt.setString(2, dados.getParentesco());
			insereSt.setString(2, dados.getResponsavel());
			insereSt.setInt(2, dados.getSexo());
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
