package cgd.crudjdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import cdp.classesAnemicas.AcompanhamentoEscolar;
import cgd.conexao.ConectaPostgreSQL;

public class AcompanhamentoEscolarCrudJDBC {
		/*
		 * Objetivo: Método que salva um as no banco de dados
		 */
		public static void salvar(AcompanhamentoEscolar acompanhamento) {
			// abre a conexao com o banco de dados MYSQL
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL insert
			PreparedStatement insereSt = null;
			// SQL de inserção
			String sqlAcompanhamento	 = "insert into acompanhamentoescolar(escola) values(?)";
			try {
				// recebe o SQL insert
				insereSt = conexao.prepareStatement(sqlAcompanhamento);
				// recebe o parâmtros do SQL insert
				insereSt.setString(1, acompanhamento.getEscola());
				// executa SQL insert
				insereSt.executeUpdate();
				//pega o resto dos dados
				String sqlAcompanhamentoDados = "";
				List<Integer> anos = acompanhamento.getAnos();
				//List<Integer> series = acompanhamento.getSeries();
				for (int i = 0; i<=anos.size(); i++){
					sqlAcompanhamentoDados = "insert into acompanhamentoescolarDados(acompanhamentoescolar, ano, serie) values(?, ?, ?);";
					
					// recebe o SQL insert
					insereSt = conexao.prepareStatement(sqlAcompanhamentoDados);
					
					insereSt.setInt(1, acompanhamento.getId());
					insereSt.setInt(2, acompanhamento.getAnos().get(i));
					insereSt.setInt(3, acompanhamento.getSeries().get(i));
					
					// executa SQL insert
					insereSt.executeUpdate();
				}
				
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao incluir o acompnhamento escolar mensagem:" + e);
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
		public static AcompanhamentoEscolar getAcompanhamentoEscolar(int idAcompanhamentoEscolar) {
			// abre conexao com o banco de dados
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// executa o SQL no banco de dados
			Statement consulta = null;
			// contém os dados consultado da tabela
			ResultSet resultado = null;
			// objeto as
			AcompanhamentoEscolar situacao = null;
			// consulta SQL
			String sql = "select distinct * from AcompanhamentoEscolar where id=" + idAcompanhamentoEscolar;
			try {
				// consulta => objeto que executa o SQL no banco de dados
				consulta = conexao.createStatement();
				// resultado => objeto que contém os dados consultado da tabela
				// AcompanhamentoEscolar
				resultado = consulta.executeQuery(sql);
				// Lê cada situacao
				List<Integer> anos = new ArrayList<>();
				List<Integer> series = new ArrayList<>();
				
				while (resultado.next()) {
					situacao.setEscola(resultado.getString("escola"));
					for (int i = 1; i<7; i++) {
						Integer ano = resultado.getInt("anos" + i);
						Integer serie = resultado.getInt("serie"  + i);
						anos.add(ano);
						series.add(serie);	
					}
					situacao.setAnos(anos);
					situacao.setSeries(series);
					
					// insere o acesso a serviço na lista
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
		 * Objetivo: Método que lista todos os ass do banco de dados
		 */
		public static List<AcompanhamentoEscolar> listar() {
			// abre conexao com o banco de dados
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// variavel lista de ass
			List<AcompanhamentoEscolar> acessos = new ArrayList<AcompanhamentoEscolar>();
			// executa o SQL no banco de dados
			Statement consulta = null;
			// contém os dados consultado da tabela
			ResultSet resultado = null;
			// objeto as
			//AcompanhamentoEscolar as = null;
			// consulta SQL
			String sql = "select distinct * from AcompanhamentoEscolar";
			try {
				// consulta => objeto que executa o SQL no banco de dados
				consulta = conexao.createStatement();
				// resultado => objeto que contém os dados consultado da tabela
				// AcompanhamentoEscolar
				resultado = consulta.executeQuery(sql);
				// Lê cada as
				List<Integer> anos = new ArrayList<>();
				List<Integer> series = new ArrayList<>();
				
				while (resultado.next()) {
					AcompanhamentoEscolar situacao = new AcompanhamentoEscolar();
					situacao.setEscola(resultado.getString("escola"));
					for (int i = 1; i<7; i++) {
						Integer ano = resultado.getInt("anos" + i);
						Integer serie = resultado.getInt("serie"  + i);
						anos.add(ano);
						series.add(serie);	
					}
					situacao.setAnos(anos);
					situacao.setSeries(series);
					// insere o as na lista
					acessos.add(situacao);
						
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
		public static void excluir(AcompanhamentoEscolar as) {
			// abre a conexao com o banco de dados PostGresql
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL delete
			PreparedStatement excluiSt = null;
			// SQL de exclusão do as
			String sql = "delete from AcompanhamentoEscolar where id=?";
			try {
				// recebe o SQL delete para as
				excluiSt = conexao.prepareStatement(sql);
				// recebe o parâmtros do SQL insert
				excluiSt.setInt(1, as.getId());
				// executa SQL delete
				excluiSt.executeUpdate();
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

		/*
		 * Objetivo: Método que altera um acesso a serviços no banco de dados
		 */
		public static void alterar(AcompanhamentoEscolar acompanhamento) {
			// abre a conexao com o banco de dados MYSQL
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL update
			PreparedStatement insereSt = null;
			// SQL de inserção
			String sql = "update AcompanhamentoEscolar set escola=?";
			try {
				// recebe o SQL update
				insereSt = conexao.prepareStatement(sql);
				
				//pega o resto dos dados
				String sqlAcompanhamentoDados = "";
				List<Integer> anos = acompanhamento.getAnos();
				//List<Integer> series = acompanhamento.getSeries();
				for (int i = 0; i<=anos.size(); i++){
					sqlAcompanhamentoDados = "update acompanhamentoescolarDados set acompanhamentoescolar=?, ano=?, serie=?";
					
					// recebe o parâmtros do SQL update
					insereSt = conexao.prepareStatement(sqlAcompanhamentoDados);
					
					insereSt.setInt(1, acompanhamento.getId());
					insereSt.setInt(2, acompanhamento.getAnos().get(i));
					insereSt.setInt(3, acompanhamento.getSeries().get(i));
					
					// executa SQL insert
					insereSt.executeUpdate();
				}
				
				// executa SQL update
				insereSt.executeUpdate();
				
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
