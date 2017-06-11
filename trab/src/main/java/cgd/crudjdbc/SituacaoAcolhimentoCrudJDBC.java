package cgd.crudjdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import cdp.classesAnemicas.SituacaoAcolhimento;
import cgd.conexao.ConectaPostgreSQL;

public class SituacaoAcolhimentoCrudJDBC {
		/*
		 * Objetivo: M�todo que salva um as no banco de dados
		 */
		public static int salvar(SituacaoAcolhimento situacao) {
			// abre a conexao com o banco de dados MYSQL
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL insert
			PreparedStatement insereSt = null;
	
			
			

			// SQL de inser��o
			String sqlSituacaoAcolhimento = "insert into situacaoAcolhimento (contato, motivo, nomeAcolhido, nomeInstituicao, responsavelInstituicao)" +
										    "values (?, ?, ?, ?, ?)";
			try {
				int lastId=0;
				// recebe o SQL insert
				insereSt = conexao.prepareStatement(sqlSituacaoAcolhimento);
				// recebe o par�mtros do SQL insert
				
				insereSt.setString(1, situacao.getContato());
				insereSt.setString(2, situacao.getMotivo());
				insereSt.setString(3, situacao.getNomeAcolhido());
				insereSt.setString(4, situacao.getNomeInstituicao());
				insereSt.setString(5, situacao.getResponsavelInstituicao());
				
				// executa SQL insert
				insereSt.executeUpdate();
				
				// executa SQL insert
				insereSt.executeUpdate();
				ResultSet rs = insereSt.getGeneratedKeys();
				if (rs.next()) {
				   lastId = rs.getInt("id_situcaoacolhimento");
				}
				
				return lastId;
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao incluir situa��o de acolhimento mensagem:" + e);
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
		public static SituacaoAcolhimento getSituacaoAcolhimento(int idSituacaoAcolhimento) {
			// abre conexao com o banco de dados
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// executa o SQL no banco de dados
			Statement consulta = null;
			// cont�m os dados consultado da tabela
			ResultSet resultado = null;
			// objeto as
			SituacaoAcolhimento situacao = null;
			// consulta SQL
			String sql = "select distinct * from SituacaoAcolhimento where id=" + idSituacaoAcolhimento;
			try {
				// consulta => objeto que executa o SQL no banco de dados
				consulta = conexao.createStatement();
				// resultado => objeto que cont�m os dados consultado da tabela
				// SituacaoAcolhimento
				resultado = consulta.executeQuery(sql);
				// L� cada situacao
				while (resultado.next()) {
					situacao.setContato(resultado.getString("contato"));
					situacao.setMotivo(resultado.getString("motivo"));
					situacao.setNomeAcolhido(resultado.getString("nomeAcolhido"));
					situacao.setNomeInstituicao(resultado.getString("nomeInstituicao"));
					situacao.setResponsavelInstituicao(resultado.getString("responsavelInstituicao"));
					
					// insere o acesso a servi�o na lista
					return situacao;
					
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
			return situacao;
		}

		/*
		 * Objetivo: M�todo que lista todos os ass do banco de dados
		 */
		public static List<SituacaoAcolhimento> listar() {
			// abre conexao com o banco de dados
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// variavel lista de ass
			List<SituacaoAcolhimento> acessos = new ArrayList<SituacaoAcolhimento>();
			// executa o SQL no banco de dados
			Statement consulta = null;
			// cont�m os dados consultado da tabela
			ResultSet resultado = null;
			// objeto as
			//SituacaoAcolhimento as = null;
			// consulta SQL
			String sql = "select distinct * from SituacaoAcolhimento";
			try {
				// consulta => objeto que executa o SQL no banco de dados
				consulta = conexao.createStatement();
				// resultado => objeto que cont�m os dados consultado da tabela
				// SituacaoAcolhimento
				resultado = consulta.executeQuery(sql);
				// L� cada as
				
				while (resultado.next()) {
					SituacaoAcolhimento situacao = new SituacaoAcolhimento();
					situacao.setContato(resultado.getString("contato"));
					situacao.setMotivo(resultado.getString("motivo"));
					situacao.setNomeAcolhido(resultado.getString("nomeAcolhido"));
					situacao.setNomeInstituicao(resultado.getString("nomeInstituicao"));
					situacao.setResponsavelInstituicao(resultado.getString("responsavelInstituicao"));
					// insere o as na lista
					acessos.add(situacao);
						
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
		 * Objetivo: M�todo que exclui um acesso a servi�os no banco de dados
		 */
		public static boolean excluir(SituacaoAcolhimento as) {
			// abre a conexao com o banco de dados PostGresql
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL delete
			PreparedStatement excluiPSt = null;
			PreparedStatement excluiSt = null;
			// SQL de exclus�o do as
			String sql = "delete from SituacaoAcolhimento where id=?";
			// SQL de exclus�o do as
			String presql = "delete from situacaoacolhimento where id=?";
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
					throw new RuntimeException("Erro ao fechar a opera��o de exclusao" + e);
				}
			}
		}

		/*
		 * Objetivo: M�todo que altera um acesso a servi�os no banco de dados
		 */
		public static boolean alterar(SituacaoAcolhimento situacao) {
			// abre a conexao com o banco de dados MYSQL
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL update
			PreparedStatement insereSt = null;
			// SQL de inser��o
			String sql = "update SituacaoAcolhimento set contato=?, motivo=?, nomeacolhido=?, nomeinstituicao=?, "
					+ "							    responsavelinstituicao=?";
			try {
				// recebe o SQL update
				insereSt = conexao.prepareStatement(sql);
				// recebe o par�mtros do SQL update
				insereSt.setString(1, situacao.getContato());
				insereSt.setString(2, situacao.getMotivo());
				insereSt.setString(3, situacao.getNomeAcolhido());
				insereSt.setString(4, situacao.getNomeInstituicao());
				insereSt.setString(5, situacao.getResponsavelInstituicao());
				
				// executa SQL update
				insereSt.executeUpdate();
				return true;
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
