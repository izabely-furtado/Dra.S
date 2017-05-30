package cgd.crudjdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import cdp.classesAnemicas.DadosAcesso;
import cgd.conexao.ConectaPostgreSQL;

public class DadosAcessoCrudJDBC {
		/*
		 * Objetivo: Método que salva um as no banco de dados
		 */
		public static boolean salvar(DadosAcesso as) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sqlDadosAcesso 	  = "insert into dadosAcesso(email, lembrar, login, senha)" +
									    "values(?, ?, ?, ?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sqlDadosAcesso);
			// recebe o parâmtros do SQL insert
			
			insereSt.setString(1, as.getEmail());
			insereSt.setString(2, as.getLembrar());
			insereSt.setString(3, as.getLogin());
			insereSt.setString(4, as.getSenha());
			
			// executa SQL insert
			insereSt.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir as. mensagem:" + e);
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
		public static DadosAcesso getDadosAcesso(int idDadosAcesso) {
			// abre conexao com o banco de dados
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// executa o SQL no banco de dados
			Statement consulta = null;
			// contém os dados consultado da tabela
			ResultSet resultado = null;
			// objeto as
			DadosAcesso as = null;
			// consulta SQL
			String sql = "select distinct * from dadosAcesso where id=" + idDadosAcesso;
			try {
				// consulta => objeto que executa o SQL no banco de dados
				consulta = conexao.createStatement();
				// resultado => objeto que contém os dados consultado da tabela
				// DadosAcesso
				resultado = consulta.executeQuery(sql);
				// Lê cada as
				while (resultado.next()) {
					as.setEmail(resultado.getString("email"));
					as.setLembrar(resultado.getString("lembrar"));
					as.setLogin(resultado.getString("login"));
					as.setSenha(resultado.getString("senha"));
					// insere o acesso a serviço na lista
					return as;
						
					
				}
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao buscar um dado de acesso: " + e);
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
			return as;
		}
		
		public static DadosAcesso getDadosAcesso(String login, String senha) {
			// abre conexao com o banco de dados
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// executa o SQL no banco de dados
			Statement consulta = null;
			// contém os dados consultado da tabela
			ResultSet resultado = null;
			// objeto as
			DadosAcesso as = new DadosAcesso();
			// consulta SQL
			String sql = "select distinct * from dadosAcesso where login='" + login + "' and senha='" + senha + "'";
			
			try {
				// consulta => objeto que executa o SQL no banco de dados
				consulta = conexao.createStatement();
				// resultado => objeto que contém os dados consultado da tabela
				// DadosAcesso
				resultado = consulta.executeQuery(sql);
				// Lê cada as
				while (resultado.next()) {
					as.setEmail(resultado.getString("email"));
					as.setLembrar(resultado.getString("lembrar"));
					as.setLogin(resultado.getString("login"));
					as.setSenha(resultado.getString("senha"));
					
					// insere o acesso a serviço na lista
					return as;
						
					
				}
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao buscar um dado de acesso: " + e);
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
			return as;
		}

		/*
		 * Objetivo: Método que lista todos os ass do banco de dados
		 */
		public static List<DadosAcesso> listar() {
			// abre conexao com o banco de dados
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// variavel lista de ass
			List<DadosAcesso> acessos = new ArrayList<DadosAcesso>();
			// executa o SQL no banco de dados
			Statement consulta = null;
			// contém os dados consultado da tabela
			ResultSet resultado = null;
			// objeto as
			//DadosAcesso as = null;
			// consulta SQL
			String sql = "select distinct * from dadosAcesso";
			try {
				// consulta => objeto que executa o SQL no banco de dados
				consulta = conexao.createStatement();
				// resultado => objeto que contém os dados consultado da tabela
				// DadosAcesso
				resultado = consulta.executeQuery(sql);
				// Lê cada as
				
				while (resultado.next()) {
					DadosAcesso as = new DadosAcesso();
					as.setEmail(resultado.getString("email"));
					as.setLembrar(resultado.getString("lembrar"));
					as.setLogin(resultado.getString("login"));
					as.setSenha(resultado.getString("senha"));
					// insere o as na lista
					acessos.add(as);
						
				}
				
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao buscar um dado de acesso: " + e);
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
		 * Objetivo: Método que salva um acesso a serviços no banco de dados
		 */
		public static boolean excluir(DadosAcesso as) {
			// abre a conexao com o banco de dados PostGresql
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL delete
			PreparedStatement excluiSt = null;
			// SQL de exclusão do as
			String sql = "delete from dadosAcesso where id=?";
			// SQL de exclusão do as
			try {
				// recebe o SQL delete para endereço
				excluiSt = conexao.prepareStatement(sql);
				// executa SQL delete
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
					excluiSt.close();
					conexao.close();
				} catch (Throwable e) {
					throw new RuntimeException("Erro ao fechar a operação de exclusao" + e);
				}
			}
		}

		public static boolean alterar(DadosAcesso as) {
			// abre a conexao com o banco de dados MYSQL
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL update
			PreparedStatement insereSt = null;
			// SQL de inserção
			String sql = "update dadosAcesso set email=?, lembrar=?, login=?, senha=?";
			try {
				// recebe o SQL update
				insereSt = conexao.prepareStatement(sql);
				// recebe o parâmtros do SQL update
				insereSt.setString(1, as.getEmail());
				insereSt.setString(2, as.getLembrar());
				insereSt.setString(3, as.getLogin());
				insereSt.setString(4, as.getSenha());
				
				
				// executa SQL update
				insereSt.executeUpdate();
				return true;
				
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao alterar os dados de acesso - mensagem:" + e);
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
