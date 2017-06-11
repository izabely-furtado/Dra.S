package cgd.crudjdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import cdp.classesAnemicas.AcessoServicos;
import cgd.conexao.ConectaPostgreSQL;

public class AcessoServicosCrudJDBC {
		/*
		 * Objetivo: Método que salva um as no banco de dados
		 */
		public static boolean salvar(AcessoServicos as) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sqlAcessoServicos 	  = "insert into acessoServicos(possuiacolhimento, possuicei, possuicras, possuicreas, possuiescola, possuiesf, possuisus, qacolhimento, qcei, qcras, qcreas, qescola, qesf, qsus)" +
									    "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sqlAcessoServicos);
			// recebe o parâmtros do SQL insert
			
			insereSt.setBoolean(1, as.isPossuiacolhimento());
			insereSt.setBoolean(2, as.isPossuicei());
			insereSt.setBoolean(3, as.isPossuicras());
			insereSt.setBoolean(4, as.isPossuicreas());
			insereSt.setBoolean(5, as.isPossuiescola());
			insereSt.setBoolean(6, as.isPossuiesf());
			insereSt.setBoolean(7, as.isPossuisus());
			insereSt.setString(8, as.getQacolhimento());
			insereSt.setString(9, as.getQcei());
			insereSt.setString(10, as.getQcras());
			insereSt.setString(11, as.getQcreas());
			insereSt.setString(12, as.getQescola());
			insereSt.setString(13, as.getQesf());
			insereSt.setString(14, as.getQsus());
			
			// executa SQL insert
			insereSt.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir o acesso serviços mensagem:" + e);
		} finally {
			try {
				// fecha conexao com o banco
				insereSt.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a operação de inserção - acesso serviços" + e);
			}
		}
	}
	
		/*
		 * Objetivo: Método que lista todos os ass do banco de dados
		 */
		public static AcessoServicos getAcessoServicos(int idAcessoServicos) {
			// abre conexao com o banco de dados
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// executa o SQL no banco de dados
			Statement consulta = null;
			// contém os dados consultado da tabela
			ResultSet resultado = null;
			// objeto as
			AcessoServicos as = null;
			// consulta SQL
			String sql = "select distinct * from acessoservicos where id=" + idAcessoServicos;
			try {
				// consulta => objeto que executa o SQL no banco de dados
				consulta = conexao.createStatement();
				// resultado => objeto que contém os dados consultado da tabela
				// AcessoServicos
				resultado = consulta.executeQuery(sql);
				// Lê cada as
				while (resultado.next()) {
					as.setPossuiacolhimento(resultado.getBoolean("possuiacolhimento"));
					as.setPossuicei(resultado.getBoolean("possuicei"));
					as.setPossuicras(resultado.getBoolean("possuicras"));
					as.setPossuicras(resultado.getBoolean("possuicras"));
					as.setPossuicreas(resultado.getBoolean("possuicreas"));
					as.setPossuicreas(resultado.getBoolean("possuicreas"));
					as.setPossuiescola(resultado.getBoolean("possuiescola"));
					as.setPossuiesf(resultado.getBoolean("possuiesf"));
					as.setPossuisus(resultado.getBoolean("possuisus"));
					as.setQacolhimento(resultado.getString("qacolhimento"));
					as.setQcei(resultado.getString("qcei"));
					as.setQcras(resultado.getString("qcras"));
					as.setQcreas(resultado.getString("qcreas"));
					as.setQescola(resultado.getString("qescola"));
					as.setQesf(resultado.getString("qescola"));
					as.setQsus(resultado.getString("qsus"));
					as.setSituacaoacolhimento(SituacaoAcolhimentoCrudJDBC.getSituacaoAcolhimento(resultado.getInt("situacaoacolhimento_id")));
					// insere o acesso a serviço na lista
					return as;
						
					
				}
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao buscar um acesso a serviço: " + e);
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
		public static List<AcessoServicos> listar() {
			// abre conexao com o banco de dados
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// variavel lista de ass
			List<AcessoServicos> acessos = new ArrayList<AcessoServicos>();
			// executa o SQL no banco de dados
			Statement consulta = null;
			// contém os dados consultado da tabela
			ResultSet resultado = null;
			// objeto as
			//AcessoServicos as = null;
			// consulta SQL
			String sql = "select distinct * from acessoservicos";
			try {
				// consulta => objeto que executa o SQL no banco de dados
				consulta = conexao.createStatement();
				// resultado => objeto que contém os dados consultado da tabela
				// AcessoServicos
				resultado = consulta.executeQuery(sql);
				// Lê cada as
				
				while (resultado.next()) {
					AcessoServicos as = new AcessoServicos();
					as.setPossuiacolhimento(resultado.getBoolean("possuiacolhimento"));
					as.setPossuicei(resultado.getBoolean("possuicei"));
					as.setPossuicras(resultado.getBoolean("possuicras"));
					as.setPossuicras(resultado.getBoolean("possuicras"));
					as.setPossuicreas(resultado.getBoolean("possuicreas"));
					as.setPossuicreas(resultado.getBoolean("possuicreas"));
					as.setPossuiescola(resultado.getBoolean("possuiescola"));
					as.setPossuiesf(resultado.getBoolean("possuiesf"));
					as.setPossuisus(resultado.getBoolean("possuisus"));
					as.setQacolhimento(resultado.getString("qacolhimento"));
					as.setQcei(resultado.getString("qcei"));
					as.setQcras(resultado.getString("qcras"));
					as.setQcreas(resultado.getString("qcreas"));
					as.setQescola(resultado.getString("qescola"));
					as.setQesf(resultado.getString("qescola"));
					as.setQsus(resultado.getString("qsus"));
					as.setSituacaoacolhimento(SituacaoAcolhimentoCrudJDBC.getSituacaoAcolhimento(resultado.getInt("situacaoacolhimento_id")));
					// insere o as na lista
					acessos.add(as);
						
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
		 * Objetivo: Método que salva um acesso a serviços no banco de dados
		 */
		public static boolean excluir(AcessoServicos as) {
			// abre a conexao com o banco de dados PostGresql
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL delete
			PreparedStatement excluiPSt = null;
			PreparedStatement excluiSt = null;
			// SQL de exclusão do as
			String sql = "delete from acessoservicos where id=?";
			// SQL de exclusão do as
			String presql = "delete from situacaoacolhimento where id=?";
			try {
				// recebe o SQL delete para endereço
				excluiPSt = conexao.prepareStatement(presql);
				// recebe o parâmtros do SQL insert
				excluiPSt.setInt(1, as.getSituacaoacolhimento().getId());
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

		public static boolean alterar(AcessoServicos as) {
			// abre a conexao com o banco de dados MYSQL
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL update
			PreparedStatement insereSt = null;
			// SQL de inserção
			String sql = "update acessoservicos set possuiacolhimento=?, possuicei=?, possuicras=?, possuicreas=?, "
					+ "							    possuiescola=?, possuiesf=?, possuisus=?, qacolhimento=?, qcei=?, "
					+ "							    qcras=?, qcreas=?, qescola=?, qesf=?, qsus=?, situacaoAcolhimento_id";
			try {
				// recebe o SQL update
				insereSt = conexao.prepareStatement(sql);
				// recebe o parâmtros do SQL update
				insereSt.setBoolean(1, as.isPossuiacolhimento());
				insereSt.setBoolean(2, as.isPossuicei());
				insereSt.setBoolean(3, as.isPossuicras());
				insereSt.setBoolean(4, as.isPossuicras());
				insereSt.setBoolean(5, as.isPossuicreas());
				insereSt.setBoolean(6, as.isPossuiescola());
				insereSt.setBoolean(7, as.isPossuiesf());
				insereSt.setBoolean(8, as.isPossuisus());
				insereSt.setString(9, as.getQacolhimento());
				insereSt.setString(10, as.getQcei());
				insereSt.setString(11, as.getQcras());
				insereSt.setString(12, as.getQcreas());
				insereSt.setString(13, as.getQescola());
				insereSt.setString(14, as.getQesf());
				insereSt.setString(15, as.getQsus());
				insereSt.setInt(9, as.getSituacaoacolhimento().getId());
				
				// executa SQL update
				insereSt.executeUpdate();
				SituacaoAcolhimentoCrudJDBC.alterar(as.getSituacaoacolhimento());
				return true;
				
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao alterar o acesso a servicos - mensagem:" + e);
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
