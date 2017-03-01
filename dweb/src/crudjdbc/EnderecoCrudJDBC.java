package crudjdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import classesAnemicas.Endereco;
import conexao.ConectaPostgreSQL;

public class EnderecoCrudJDBC {
		/*
		 * Objetivo: Método que salva um usuario no banco de dados
		 */
		public void salvar(Endereco endereco) {
			// abre a conexao com o banco de dados MYSQL
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL insert
			PreparedStatement insereSt = null;
			// SQL de inserção
			String sql = "insert into usuario(bairro, cep, cidade, estado, numero, rua) values(?,?,?,?,?)";
			try {
				// recebe o SQL insert
				insereSt = conexao.prepareStatement(sql);
				// recebe o parâmtros do SQL insert
				insereSt.setString(1, endereco.getBairro());
				insereSt.setString(2, endereco.getCep());
				insereSt.setString(3, endereco.getCidade());
				insereSt.setString(4, endereco.getEstado());
				insereSt.setInt(5, endereco.getNumero());
				insereSt.setString(6, endereco.getRua());
				// executa SQL insert
				insereSt.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao incluir usuario. mensagem:" + e);
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

		public static Endereco getEndereco(Integer id) {
			Endereco endereco = new Endereco();
			// abre conexao com o banco de dados
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// executa o SQL no banco de dados
			Statement consulta = null;
			// contém os dados consultado da tabela
			ResultSet resultado = null;
			// consultas SQL
			String sqlEndereco = "select distinct * from endereco where id = '" + id + "'";

			try {
				// consulta => objeto que executa o SQL no banco de dados
				consulta = conexao.createStatement();
				// resultado => objeto que contém os dados consultado da tabela
				// Endereco
				resultado = consulta.executeQuery(sqlEndereco);
				// Lê o endereco associado ao id
				// se o endereco vinculado existir
				if (resultado.next()) {
					endereco.setBairro(resultado.getString("bairro"));
					endereco.setCep(resultado.getString("cep"));
					endereco.setCidade(resultado.getString("cidade"));
					endereco.setEstado(resultado.getString("estado"));
					endereco.setNumero(resultado.getInt("numero"));
					endereco.setRua(resultado.getString("rua"));
				}

			} catch (SQLException e) {
				throw new RuntimeException("Erro ao buscar um endereco: " + e);
			} finally {
				try {
					consulta.close();
					resultado.close();
					conexao.close();
				} catch (Throwable e) {
					throw new RuntimeException("Erro ao fechar a conexao " + e);
				}
			}
			// retorna endereco com o determinado id
			return endereco;
		}
		

		
		/*
		 * Objetivo: Método que salva um usuario no banco de dados
		 */
		public void excluir(Endereco endereco) {
			// abre a conexao com o banco de dados PostGresql
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL delete
			PreparedStatement excluiSt = null;
			// SQL de inserção
			String sql = "delete from endereco where id=?";
			try {
				// recebe o SQL delete
				excluiSt = conexao.prepareStatement(sql);
				// recebe o parâmtros do SQL insert
				excluiSt.setInt(1, endereco.getId());
				// executa SQL delete
				excluiSt.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao excluir endereco.mensagem:" + e);
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

		public void alterar(Endereco endereco) {
			// abre a conexao com o banco de dados MYSQL
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL update
			PreparedStatement insereSt = null;
			// SQL de inserção
			String sql = "update endereco set bairro=?, cep=?, cidade=?, estado=?, rua=?, numero=? where id=?";
			try {
				// recebe o SQL update
				insereSt = conexao.prepareStatement(sql);
				// recebe o parâmtros do SQL update
				insereSt.setString(1, endereco.getBairro());
				insereSt.setString(2, endereco.getCep());
				insereSt.setString(3, endereco.getCidade());
				insereSt.setString(4, endereco.getEstado());
				insereSt.setString(5, endereco.getRua());
				insereSt.setInt(6, endereco.getNumero());
				insereSt.setInt(7, endereco.getId());
				// executa SQL update
				insereSt.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao alterar usuario. mensagem:" + e);
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
