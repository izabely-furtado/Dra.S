package cgd.crudjdbc;
/*
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cdp.classesAnemicas.*;
import cgd.conexao.ConectaPostgreSQL;
*/
public class TermoDesligamentoCrudJDBC {
	
	/*
	 * Objetivo: Método que salva um termo de desligamento no banco de dados
	 */
	
	/*
	 * 
	 * FOI DECIDIDO NÂO REGISTRAR NO BANCO< ESTÀ AQUI CASO MUDE DE IDEIA
	 * 
	 * 
	 */
	
	/*
	public static boolean salvar(TermoDesligamento termoDesligamento) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		
		// SQL de inserção
		String sql = "insert into termoDesligamento(nomeUsuario, nomeResponsavel, nomeTecResponsavel, motivo, cpf)"
				+ "				    values (?,?,?,?,?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			insereSt.setString(1, termoDesligamento.getNomeUsuario());
			insereSt.setString(2, termoDesligamento.getNomeResponsavel());
			insereSt.setString(3, termoDesligamento.getNomeTecResponsavel());
			insereSt.setString(4, termoDesligamento.getMotivo());
			insereSt.setString(5, termoDesligamento.getCpf());
			
			// executa SQL insert
			insereSt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir termo de desligamento. mensagem:" + e);
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
	 *//*
	public static TermoDesligamento getTermoDesligamento(int idTermoDesligamento) {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// objeto as
		TermoDesligamento termoDesligamento = null;
		// consulta SQL
		String sql = "select distinct * from TermoDesligamento where id=" + idTermoDesligamento;
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// SituacaoAcolhimento
			resultado = consulta.executeQuery(sql);
			// Lê cada situacao
			while (resultado.next()) {
				termoDesligamento.setNomeUsuario(resultado.getString("nomeUsuario"));
				termoDesligamento.setNomeResponsavel(resultado.getString("nomeResponsavel"));
				termoDesligamento.setNomeTecResponsavel(resultado.getString("nomeTecResponsavel"));
				termoDesligamento.setMotivo(resultado.getString("motivo"));
				termoDesligamento.setCpf(resultado.getString("cpf"));
				
				// insere o acesso a serviço na lista
				return termoDesligamento;
				
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar uma termo de desligamento: " + e);
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
		return termoDesligamento;
	}

	
	/*
	 * Objetivo: Método que lista todos os termos de desligamento do banco de dados
	 */
	/*
	public static List<TermoDesligamento> listar() {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de termos
		List<TermoDesligamento> termos = new ArrayList<TermoDesligamento>();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// objeto termo
		TermoDesligamento termoDesligamento = null;
		// consulta SQL
		String sql = "select distinct * from termoDesligamento";
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// Termo de desligamento
			resultado = consulta.executeQuery(sql);
			// Lê cada termo
			while (resultado.next()) {
				termoDesligamento = new TermoDesligamento();
				termoDesligamento.setNomeUsuario(resultado.getString("nomeUsuario"));
				termoDesligamento.setNomeResponsavel(resultado.getString("nomeResponsavel"));
				termoDesligamento.setNomeTecResponsavel(resultado.getString("nomeTecResponsavel"));
				termoDesligamento.setMotivo(resultado.getString("motivo"));
				termoDesligamento.setCpf(resultado.getString("cpf"));
				
				// insere o termo de desligamento na lista
				termos.add(termoDesligamento);

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar um termo de desligamento: " + e);
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a conexao " + e);
			}
		}
		// retorna lista de termos
		return termos;
	}

	/*
	 * Objetivo: Método que exclui um termo de desligamento do banco de dados
	 */
	/*
	public static boolean excluir(TermoDesligamento termoDesligamento) {
		// abre a conexao com o banco de dados PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiSt = null;
		// SQL de exclusão do termo de desligamento
		String sql = "delete from termoDesligamento where id=?";
		
		try {
			// recebe o SQL delete para termo de desligamento
			excluiSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			excluiSt.setInt(1, termoDesligamento.getId());
			// executa SQL delete
			excluiSt.executeUpdate();
			return true;

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao excluir o termo de desligamento.mensagem:" + e);
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

	public static boolean alterar(TermoDesligamento termoDesligamento) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "update termoDesligamento set nomeUsuario=?, nomeResponsavel=?, nomeTecResponsavel=?, motivo=?, cpf=?";
		
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sql);
						
			// recebe o SQL update

			insereSt.setString(1, termoDesligamento.getNomeUsuario());
			insereSt.setString(2, termoDesligamento.getNomeResponsavel());
			insereSt.setString(3, termoDesligamento.getNomeTecResponsavel());
			insereSt.setString(4, termoDesligamento.getMotivo());
			insereSt.setString(5, termoDesligamento.getCpf());
			


			// executa SQL update
			insereSt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao alterar o termo de desligamento.mensagem:" + e);
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
