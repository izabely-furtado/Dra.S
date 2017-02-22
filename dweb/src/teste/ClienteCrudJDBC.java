package teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexao.ConectaPostgreSQL;

public class ClienteCrudJDBC {
	/*
	 * Objetivo: Método que salva um usuario no banco de dados
	 */
	public void salvar(Cliente cliente) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "insert into usuario(nome, bairro, cep, cidade, endereco, estado, telefone) values(?,?,?,?,?,?,?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			insereSt.setString(1, cliente.getNome());
			insereSt.setString(2, cliente.getBairro());
			insereSt.setString(3, cliente.getCep());
			insereSt.setString(4, cliente.getCidade());
			insereSt.setString(5, cliente.getEndereco());
			insereSt.setString(6, cliente.getEstado());
			insereSt.setString(7, cliente.getTelefone());
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

	public static Cliente getCliente(Integer id) {
		Cliente cliente = new Cliente();
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// consultas SQL
		String sqlCliente = "select distinct * from cliente where idCliente = '" + id + "'";

		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// Cliente
			resultado = consulta.executeQuery(sqlCliente);
			// Lê o cliente associado ao id
			// se o cliente vinculado existir
			if (resultado.next()) {
				cliente.setNome(resultado.getString("nome"));
				cliente.setBairro(resultado.getString("bairro"));
				cliente.setCep(resultado.getString("cep"));
				cliente.setCidade(resultado.getString("cidade"));
				cliente.setEndereco(resultado.getString("endereco"));
				cliente.setEstado(resultado.getString("estado"));
				cliente.setIdCliente(resultado.getInt("idCliente"));
				cliente.setTelefone(resultado.getString("telefone"));
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
		// retorna cliente com o determinado id
		return cliente;
	}
	
	public static Cliente getCliente(String nome) {
		Cliente cliente = new Cliente();
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// consultas SQL
		String sqlCliente = "select distinct * from cliente where idCliente like '%" + nome + "%'";

		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// Cliente
			resultado = consulta.executeQuery(sqlCliente);
			// Lê o cliente associado ao id
			// se o cliente vinculado existir
			if (resultado.next()) {
				cliente.setNome(resultado.getString("nome"));
				cliente.setBairro(resultado.getString("bairro"));
				cliente.setCep(resultado.getString("cep"));
				cliente.setCidade(resultado.getString("cidade"));
				cliente.setEndereco(resultado.getString("endereco"));
				cliente.setEstado(resultado.getString("estado"));
				cliente.setIdCliente(resultado.getInt("idCliente"));
				cliente.setTelefone(resultado.getString("telefone"));
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
		// retorna cliente com o determinado id
		return cliente;
	}

	/*
	 * Objetivo: Método que lista todos os usuarios do banco de dados
	 */
	public List<Cliente> listar() {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de usuarios
		List<Cliente> clientes = new ArrayList<Cliente>();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// objeto usuario
		Cliente cliente = null;
		// consulta SQL
		String sql = "select distinct * from cliente";
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// Usuario
			resultado = consulta.executeQuery(sql);
			// Lê cada usuario
			while (resultado.next()) {
				cliente = new Cliente();
				cliente.setNome(resultado.getString("nome"));
				cliente.setBairro(resultado.getString("bairro"));
				cliente.setCep(resultado.getString("cep"));
				cliente.setCidade(resultado.getString("cidade"));
				cliente.setEndereco(resultado.getString("endereco"));
				cliente.setEstado(resultado.getString("estado"));
				cliente.setIdCliente(resultado.getInt("idCliente"));
				cliente.setTelefone(resultado.getString("telefone"));
				// insere o usuario na lista
				clientes.add(cliente);
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
		return clientes;
	}

	/*
	 * Objetivo: Método que salva um usuario no banco de dados
	 */
	public void excluir(Cliente cliente) {
		// abre a conexao com o banco de dados PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiSt = null;
		// SQL de inserção
		String sql = "delete from cliente where idCliente=?";
		try {
			// recebe o SQL delete
			excluiSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			excluiSt.setInt(1, cliente.getIdCliente());
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

	public void alterar(Cliente cliente) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "update usuario set nome=?, bairro=?, cep=?, cidade=?, endereco=?, estado=?, telefone=? where idCliente=?";
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL update
			insereSt.setString(1, cliente.getNome());
			insereSt.setString(2, cliente.getBairro());
			insereSt.setString(3, cliente.getCep());
			insereSt.setString(4, cliente.getCidade());
			insereSt.setString(5, cliente.getEndereco());
			insereSt.setString(6, cliente.getEstado());
			insereSt.setString(7, cliente.getTelefone());
			insereSt.setInt(8, cliente.getIdCliente());
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
