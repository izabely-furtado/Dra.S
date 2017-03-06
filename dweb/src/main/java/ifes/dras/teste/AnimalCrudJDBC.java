package teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexao.ConectaPostgreSQL;

public class AnimalCrudJDBC {
	/*
	 * Objetivo: Método que salva um animal no banco de dados
	 */
	public void salvar(Animal animal) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "insert into animal(nome, idade, idCliente, idEspecie) values(?,?,?,?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			insereSt.setString(1, animal.getNome());
			insereSt.setInt(2, animal.getIdade());
			insereSt.setInt(3, animal.getCliente().getIdCliente());
			insereSt.setInt(4, animal.getEspecie().getIdEspecie());
			// insereSt.setString(5, "Animal criado");
			// executa SQL insert
			insereSt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir animal. mensagem:" + e);
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
	 * Objetivo: Método que lista todos os animals do banco de dados
	 */
	public List<Animal> listar() {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de animals
		List<Animal> animals = new ArrayList<Animal>();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// objeto animal
		Animal animal = null;
		// consulta SQL
		String sql = "select distinct * from animal";
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// Animal
			resultado = consulta.executeQuery(sql);
			// Lê cada animal
			while (resultado.next()) {
				animal = new Animal();
				animal.setNome(resultado.getString("nome"));
				animal.setIdade(resultado.getInt("idade"));
				animal.setCliente(ClienteCrudJDBC.getCliente(resultado.getInt("idCliente")));
				animal.setEspecie(EspecieCrudJDBC.getEspecie(resultado.getInt("idEspecie")));
				// insere o animal na lista
				animals.add(animal);
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
		// retorna lista de animals
		return animals;
	}

	/*
	 * Objetivo: Método que salva um animal no banco de dados
	 */
	public void excluir(Animal animal) {
		// abre a conexao com o banco de dados PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiSt = null;
		// SQL de inserção
		String sql = "delete from animal where idAnimal=?";
		try {
			// recebe o SQL delete
			excluiSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			excluiSt.setInt(1, animal.getIdAnimal());
			// executa SQL delete
			excluiSt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao excluir animal.mensagem:" + e);
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

	public void alterar(Animal animal) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "update animal set nome=?, idade=?, idCliente=?, idEspecie=? where idAnimal=?";
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);
			// recebe o parâmetros do SQL update
			insereSt.setString(1, animal.getNome());
			insereSt.setInt(2, animal.getIdade());
			insereSt.setInt(3, animal.getCliente().getIdCliente());
			insereSt.setInt(4, animal.getEspecie().getIdEspecie());
			insereSt.setInt(5, animal.getIdAnimal());
			// executa SQL update
			insereSt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao alterar animal.mensagem:" + e);
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
