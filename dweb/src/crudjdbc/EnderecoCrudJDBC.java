package crudjdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
			String sql = "insert into usuario(bairro, cep, cidade, numero, rua) values(?,?,?,?,?)";
			try {
				// recebe o SQL insert
				insereSt = conexao.prepareStatement(sql);
				// recebe o parâmtros do SQL insert
				insereSt.setString(1, endereco.getNome());
				insereSt.setString(2, endereco.getBairro());
				insereSt.setString(3, endereco.getCep());
				insereSt.setString(4, endereco.getCidade());
				insereSt.setString(5, endereco.getEndereco());
				insereSt.setString(6, endereco.getEstado());
				insereSt.setString(7, endereco.getTelefone());
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
			String sqlEndereco = "select distinct * from endereco where idEndereco = '" + id + "'";

			try {
				// consulta => objeto que executa o SQL no banco de dados
				consulta = conexao.createStatement();
				// resultado => objeto que contém os dados consultado da tabela
				// Endereco
				resultado = consulta.executeQuery(sqlEndereco);
				// Lê o endereco associado ao id
				// se o endereco vinculado existir
				if (resultado.next()) {
					endereco.setNome(resultado.getString("nome"));
					endereco.setBairro(resultado.getString("bairro"));
					endereco.setCep(resultado.getString("cep"));
					endereco.setCidade(resultado.getString("cidade"));
					endereco.setEndereco(resultado.getString("endereco"));
					endereco.setEstado(resultado.getString("estado"));
					endereco.setIdEndereco(resultado.getInt("idEndereco"));
					endereco.setTelefone(resultado.getString("telefone"));
				}

			} catch (SQLException e) {
				throw new RuntimeException("Erro ao buscar um animal: " + e);
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
		
		public static Endereco getEndereco(String nome) {
			Endereco endereco = new Endereco();
			// abre conexao com o banco de dados
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// executa o SQL no banco de dados
			Statement consulta = null;
			// contém os dados consultado da tabela
			ResultSet resultado = null;
			// consultas SQL
			String sqlEndereco = "select distinct * from endereco where idEndereco like '%" + nome + "%'";

			try {
				// consulta => objeto que executa o SQL no banco de dados
				consulta = conexao.createStatement();
				// resultado => objeto que contém os dados consultado da tabela
				// Endereco
				resultado = consulta.executeQuery(sqlEndereco);
				// Lê o endereco associado ao id
				// se o endereco vinculado existir
				if (resultado.next()) {
					endereco.setNome(resultado.getString("nome"));
					endereco.setBairro(resultado.getString("bairro"));
					endereco.setCep(resultado.getString("cep"));
					endereco.setCidade(resultado.getString("cidade"));
					endereco.setEndereco(resultado.getString("endereco"));
					endereco.setEstado(resultado.getString("estado"));
					endereco.setIdEndereco(resultado.getInt("idEndereco"));
					endereco.setTelefone(resultado.getString("telefone"));
				}

			} catch (SQLException e) {
				throw new RuntimeException("Erro ao buscar um animal: " + e);
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
		 * Objetivo: Método que lista todos os usuarios do banco de dados
		 */
		public List<Endereco> listar() {
			// abre conexao com o banco de dados
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// variavel lista de usuarios
			List<Endereco> enderecos = new ArrayList<Endereco>();
			// executa o SQL no banco de dados
			Statement consulta = null;
			// contém os dados consultado da tabela
			ResultSet resultado = null;
			// objeto usuario
			Endereco endereco = null;
			// consulta SQL
			String sql = "select distinct * from endereco";
			try {
				// consulta => objeto que executa o SQL no banco de dados
				consulta = conexao.createStatement();
				// resultado => objeto que contém os dados consultado da tabela
				// Usuario
				resultado = consulta.executeQuery(sql);
				// Lê cada usuario
				while (resultado.next()) {
					endereco = new Endereco();
					endereco.setNome(resultado.getString("nome"));
					endereco.setBairro(resultado.getString("bairro"));
					endereco.setCep(resultado.getString("cep"));
					endereco.setCidade(resultado.getString("cidade"));
					endereco.setEndereco(resultado.getString("endereco"));
					endereco.setEstado(resultado.getString("estado"));
					endereco.setIdEndereco(resultado.getInt("idEndereco"));
					endereco.setTelefone(resultado.getString("telefone"));
					// insere o usuario na lista
					enderecos.add(endereco);
				}
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao buscar um usuario: " + e);
			} finally {
				try {
					consulta.close();
					resultado.close();
					conexao.close();
				} catch (Throwable e) {
					throw new RuntimeException("Erro ao fechar a conexao " + e);
				}
			}
			// retorna lista de usuarios
			return enderecos;
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
			String sql = "delete from endereco where idEndereco=?";
			try {
				// recebe o SQL delete
				excluiSt = conexao.prepareStatement(sql);
				// recebe o parâmtros do SQL insert
				excluiSt.setInt(1, endereco.getIdEndereco());
				// executa SQL delete
				excluiSt.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao excluir usuario.mensagem:" + e);
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
			String sql = "update usuario set nome=?, bairro=?, cep=?, cidade=?, endereco=?, estado=?, telefone=? where idEndereco=?";
			try {
				// recebe o SQL update
				insereSt = conexao.prepareStatement(sql);
				// recebe o parâmtros do SQL update
				insereSt.setString(1, endereco.getNome());
				insereSt.setString(2, endereco.getBairro());
				insereSt.setString(3, endereco.getCep());
				insereSt.setString(4, endereco.getCidade());
				insereSt.setString(5, endereco.getEndereco());
				insereSt.setString(6, endereco.getEstado());
				insereSt.setString(7, endereco.getTelefone());
				insereSt.setInt(8, endereco.getIdEndereco());
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
