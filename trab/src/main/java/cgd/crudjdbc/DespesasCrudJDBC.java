package cgd.crudjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cdp.classesAnemicas.Despesas;
import cgd.conexao.ConectaPostgreSQL;

public class DespesasCrudJDBC {
	/*
	 * Objetivo: Método que salva um as no banco de despesas
	 */
	public static int salvar(Despesas despesas) {
		// abre a conexao com o banco de despesas MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inserção
		
		String sqlDespesas = "";
		
		try {
			int lastId=0;
			
			sqlDespesas = "insert into Despesas(agua, alimentacao, aluguel, despesatotal, "
					+ "gas, luz, medicamentos, outros, rendapercapta, rendatotal, telefone)"
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sqlDespesas, Statement.RETURN_GENERATED_KEYS);

			// recebe o parâmtros do SQL insert
			insereSt.setFloat(1, despesas.getAgua());
			insereSt.setFloat(2, despesas.getAlimentacao());
			insereSt.setFloat(3, despesas.getAluguel());
			insereSt.setFloat(4, despesas.getDespesaTotal());
			insereSt.setFloat(5, despesas.getGas());
			insereSt.setFloat(6, despesas.getLuz());
			insereSt.setFloat(7, despesas.getMedicamentos());
			insereSt.setFloat(8, despesas.getOutros());
			insereSt.setFloat(9, despesas.getRendaPerCapta());
			insereSt.setFloat(10, despesas.getRendaTotal());
			insereSt.setFloat(11, despesas.getTelefone());

			// executa SQL insert
			insereSt.executeUpdate();
			
			ResultSet rs = insereSt.getGeneratedKeys();
			if (rs.next()) {
			   lastId = rs.getInt("id_despesas");
			   return lastId;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir as despesas mensagem:" + e);
		} finally {
			try {
				// fecha conexao com o banco
				insereSt.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a operação de inserção" + e);
			}
		}
		return 0;
	}

	/*
	 * Objetivo: Método que lista todos os ass do banco de despesas
	 */
	public static Despesas getDespesas(int idDespesas) {
		// abre conexao com o banco de despesas
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de despesas
		Statement consulta = null;
		// contém os despesas consultado da tabela
		ResultSet resultado = null;
		// objeto as
		Despesas despesas = null;
		// consulta SQL
		String sql = "select distinct * from Despesas where id=" + idDespesas;
		try {
			// consulta => objeto que executa o SQL no banco de despesas
			consulta = conexao.createStatement();
			// resultado => objeto que contém os despesas consultado da tabela
			// Despesas
			resultado = consulta.executeQuery(sql);
			// Lê cada despesas
			while (resultado.next()) {
				despesas.setAgua(resultado.getFloat("agua"));
				despesas.setAlimentacao(resultado.getFloat("alimentacao"));
				despesas.setAluguel(resultado.getFloat("aluguel"));
				despesas.setGas(resultado.getFloat("gas"));
				despesas.setLuz(resultado.getFloat("luz"));
				despesas.setMedicamentos(resultado.getFloat("medicamentos"));
				despesas.setOutros(resultado.getFloat("outros"));
				despesas.setRendaPerCapta(resultado.getFloat("rendaPerCapta"));
				despesas.setRendaTotal(resultado.getFloat("rendaTotal"));
				despesas.setTelefone(resultado.getFloat("telefone"));
				// insere o acesso a serviço na lista
				return despesas;

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar uma despesas de acolhimento: " + e);
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
		return despesas;
	}

	/*
	 * Objetivo: Método que lista todos os ass do banco de despesas
	 */
	public static List<Despesas> listar() {
		// abre conexao com o banco de despesas
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de ass
		List<Despesas> acessos = new ArrayList<Despesas>();
		// executa o SQL no banco de despesas
		Statement consulta = null;
		// contém os despesas consultado da tabela
		ResultSet resultado = null;
		// objeto as
		// Despesas as = null;
		// consulta SQL
		String sql = "select distinct * from Despesas";
		try {
			// consulta => objeto que executa o SQL no banco de despesas
			consulta = conexao.createStatement();
			// resultado => objeto que contém os despesas consultado da tabela
			// Despesas
			resultado = consulta.executeQuery(sql);
			// Lê cada as

			while (resultado.next()) {
				Despesas despesas = new Despesas();
				despesas.setAgua(resultado.getFloat("agua"));
				despesas.setAlimentacao(resultado.getFloat("alimentacao"));
				despesas.setAluguel(resultado.getFloat("aluguel"));
				despesas.setGas(resultado.getFloat("gas"));
				despesas.setLuz(resultado.getFloat("luz"));
				despesas.setMedicamentos(resultado.getFloat("medicamentos"));
				despesas.setOutros(resultado.getFloat("outros"));
				despesas.setRendaPerCapta(resultado.getFloat("rendaPerCapta"));
				despesas.setRendaTotal(resultado.getFloat("rendaTotal"));
				despesas.setTelefone(resultado.getFloat("telefone"));
				
				// insere o as na lista
				acessos.add(despesas);

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
	 * Objetivo: Método que exclui um acesso a serviços no banco de despesas
	 */
	public static boolean excluir(Despesas as) {
		// abre a conexao com o banco de despesas PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiPSt = null;
		PreparedStatement excluiSt = null;
		// SQL de exclusão do as
		String sql = "delete from Despesas where id=?";
		// SQL de exclusão do as
		String presql = "delete from Despesas where id=?";
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
	 * Objetivo: Método que altera um acesso a serviços no banco de despesas
	 */
	public static boolean alterar(Despesas despesas) {
		// abre a conexao com o banco de despesas MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "update Despesas set contato=?, datNasc=?, nis=?, nome=?, "
				+ "	parentesco=?, responsavel=?, sexo=?";
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);

			// recebe o parâmtros do SQL insert
			insereSt.setFloat(1, despesas.getAgua());
			insereSt.setFloat(2, despesas.getAlimentacao());
			insereSt.setFloat(2, despesas.getAluguel());
			insereSt.setFloat(2, despesas.getDespesaTotal());
			insereSt.setFloat(2, despesas.getGas());
			insereSt.setFloat(2, despesas.getLuz());
			insereSt.setFloat(2, despesas.getMedicamentos());
			insereSt.setFloat(2, despesas.getOutros());
			insereSt.setFloat(2, despesas.getRendaPerCapta());
			insereSt.setFloat(2, despesas.getRendaTotal());
			insereSt.setFloat(2, despesas.getTelefone());
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
