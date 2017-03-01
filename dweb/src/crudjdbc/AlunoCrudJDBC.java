package crudjdbc;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import classesAnemicas.*;
import conexao.ConectaPostgreSQL;

public class AlunoCrudJDBC {
	/*
		 * Objetivo: Método que salva um aluno no banco de dados
		 */
		public void salvar(Aluno aluno) {
			// abre a conexao com o banco de dados MYSQL
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL insert
			PreparedStatement insereSt = null;
			// SQL de inserção
			String sql = "insert into aluno(dataNasc, descConvenio, idEndereco, nome, "
					+ "						possuiConvenio, telefone, tipoSangue, nivelAluno, "
					+ "						obs, tipoAluno, matriculaEscola, nivelEscolaridade, "
					+ "						nomeResponsavel, telefoneEscola, diaDePagamento, tipoPacote) "
					+ "				values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				// recebe o SQL insert
				insereSt = conexao.prepareStatement(sql);
				if(aluno.getTipoAluno()== Tipo.AlunoInstitucional){
					AlunoInstituicao alunoI= (AlunoInstituicao) aluno;
					// recebe o parâmtros do SQL insert
					insereSt.setDate(1, (Date) alunoI.getDataNasc());
					insereSt.setString(2, alunoI.getDescConvenio());
					insereSt.setInt(3, alunoI.getEndereco().getId());
					insereSt.setString(4, alunoI.getNome());
					insereSt.setBoolean(5, alunoI.isPossuiConvenio());
					insereSt.setInt(6, alunoI.getTelefone());
					insereSt.setString(7, alunoI.getTipoSangue());
					insereSt.setInt(8, alunoI.getNivelAluno());
					insereSt.setString(9, alunoI.getObs());
					insereSt.setInt(10, Integer.parseInt(Tipo.AlunoInstitucional + ""));
					insereSt.setString(11, alunoI.getMatriculaEscola());
					insereSt.setInt(12, alunoI.getNivelEscolaridade());
					insereSt.setString(13, alunoI.getNomeResponsavel());
					insereSt.setString(14, alunoI.getTelefoneEscola());
					insereSt.setObject(15, null);
					insereSt.setObject(16, null);
					
				}
				else if (aluno.getTipoAluno()== Tipo.AlunoPago){
					AlunoPago alunoP= (AlunoPago) aluno;
					// recebe o parâmtros do SQL insert
					insereSt.setDate(1, (Date) alunoP.getDataNasc());
					insereSt.setString(2, alunoP.getDescConvenio());
					insereSt.setInt(3, alunoP.getEndereco().getId());
					insereSt.setString(4, alunoP.getNome());
					insereSt.setBoolean(5, alunoP.isPossuiConvenio());
					insereSt.setInt(6, alunoP.getTelefone());
					insereSt.setString(7, alunoP.getTipoSangue());
					insereSt.setInt(8, alunoP.getNivelAluno());
					insereSt.setString(9, alunoP.getObs());
					insereSt.setInt(10, Integer.parseInt(Tipo.AlunoPago + ""));
					insereSt.setObject(11, null);
					insereSt.setObject(12, null);
					insereSt.setObject(13, null);
					insereSt.setObject(14, null);
					insereSt.setInt(15, alunoP.getDiaDePagamento());
					insereSt.setInt(16, alunoP.getPacote());
				}
				// executa SQL insert
				insereSt.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao incluir aluno. mensagem:" + e);
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
		 * Objetivo: Método que lista todos os alunos do banco de dados
		 */
		public List<Aluno> listar() {
			// abre conexao com o banco de dados
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// variavel lista de alunos
			List<Aluno> alunos = new ArrayList<Aluno>();
			// executa o SQL no banco de dados
			Statement consulta = null;
			// contém os dados consultado da tabela
			ResultSet resultado = null;
			// objeto aluno
			//Aluno aluno = null;
			// consulta SQL
			String sql = "select distinct * from aluno";
			try {
				// consulta => objeto que executa o SQL no banco de dados
				consulta = conexao.createStatement();
				// resultado => objeto que contém os dados consultado da tabela
				// Aluno
				resultado = consulta.executeQuery(sql);
				// Lê cada aluno
				while (resultado.next()) {
					if (resultado.getInt("tipoAluno")==Integer.parseInt(Tipo.AlunoInstitucional + "")){
						AlunoInstituicao aluno = new AlunoInstituicao();
						aluno.setDataNasc(resultado.getDate("dataNasc"));
						aluno.setDescConvenio(resultado.getString("descConvenio"));
						aluno.setEndereco(EnderecoCrudJDBC.getEndereco(resultado.getInt("idEndereco")));
						aluno.setNome(resultado.getString("nome"));
						aluno.setPossuiConvenio(resultado.getBoolean("possuiConvenio"));
						aluno.setTelefone(resultado.getInt("telefone"));
						aluno.setTipoSangue(resultado.getString("tipoSangue"));
						aluno.setNivelAluno(resultado.getInt("nivelAluno"));
						aluno.setObs(resultado.getString("obs"));
						Integer.parseInt(Tipo.AlunoInstitucional + "");
						aluno.setMatriculaEscola(resultado.getString("matriculaEscola"));
						aluno.setNivelEscolaridade(resultado.getInt("nivelEscolaridade"));
						aluno.setNomeResponsavel(resultado.getString("nomeResponsavel"));
						aluno.setTelefoneEscola(resultado.getString("telefoneEscola"));
						// insere o aluno na lista
						alunos.add(aluno);
						
					}
					else if (resultado.getInt("tipoAluno")==Integer.parseInt(Tipo.AlunoPago + "")){
						AlunoPago aluno = new AlunoPago();
						aluno.setDataNasc(resultado.getDate("dataNasc"));
						aluno.setDescConvenio(resultado.getString("descConvenio"));
						aluno.setEndereco(EnderecoCrudJDBC.getEndereco(resultado.getInt("idEndereco")));
						aluno.setNome(resultado.getString("nome"));
						aluno.setPossuiConvenio(resultado.getBoolean("possuiConvenio"));
						aluno.setTelefone(resultado.getInt("telefone"));
						aluno.setTipoSangue(resultado.getString("tipoSangue"));
						aluno.setNivelAluno(resultado.getInt("nivelAluno"));
						aluno.setObs(resultado.getString("obs"));
						Integer.parseInt(Tipo.AlunoInstitucional + "");
						aluno.setDiaDePagamento(resultado.getInt("diaDePagamento"));
						aluno.setPacote(resultado.getInt("tipoPacote"));
						// insere o aluno na lista
						alunos.add(aluno);
						
					}

				}
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao buscar um aluno: " + e);
			} finally {
				try {
					consulta.close();
					resultado.close();
					conexao.close();
				} catch (Throwable e) {
					throw new RuntimeException("Erro ao fechar a conexao " + e);
				}
			}
			// retorna lista de alunos
			return alunos;
		}
		
		
		/*
		 * Objetivo: Método que lista todos os alunos que pagam do banco de dados
		 */
		public List<AlunoPago> listarPago() {
			// abre conexao com o banco de dados
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// variavel lista de alunos
			List<AlunoPago> alunos = new ArrayList<AlunoPago>();
			// executa o SQL no banco de dados
			Statement consulta = null;
			// contém os dados consultado da tabela
			ResultSet resultado = null;
			// objeto aluno
			//Aluno aluno = null;
			// consulta SQL
			String sql = "select distinct * from aluno";
			try {
				// consulta => objeto que executa o SQL no banco de dados
				consulta = conexao.createStatement();
				// resultado => objeto que contém os dados consultado da tabela
				// Aluno
				resultado = consulta.executeQuery(sql);
				// Lê cada aluno
				while (resultado.next()) {
					if (resultado.getInt("tipoAluno")==Integer.parseInt(Tipo.AlunoPago + "")){
						AlunoPago aluno = new AlunoPago();
						aluno.setDataNasc(resultado.getDate("dataNasc"));
						aluno.setDescConvenio(resultado.getString("descConvenio"));
						aluno.setEndereco(EnderecoCrudJDBC.getEndereco(resultado.getInt("idEndereco")));
						aluno.setNome(resultado.getString("nome"));
						aluno.setPossuiConvenio(resultado.getBoolean("possuiConvenio"));
						aluno.setTelefone(resultado.getInt("telefone"));
						aluno.setTipoSangue(resultado.getString("tipoSangue"));
						aluno.setNivelAluno(resultado.getInt("nivelAluno"));
						aluno.setObs(resultado.getString("obs"));
						Integer.parseInt(Tipo.AlunoInstitucional + "");
						aluno.setDiaDePagamento(resultado.getInt("diaDePagamento"));
						aluno.setPacote(resultado.getInt("tipoPacote"));
						// insere o aluno na lista
						alunos.add(aluno);
						
					}
					
				}
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao buscar um aluno: " + e);
			} finally {
				try {
					consulta.close();
					resultado.close();
					conexao.close();
				} catch (Throwable e) {
					throw new RuntimeException("Erro ao fechar a conexao " + e);
				}
			}
			// retorna lista de alunos
			return alunos;
		}

		/*
		 * Objetivo: Método que lista todos os alunos institucionais do banco de dados
		 */
		public List<AlunoInstituicao> listarInstituicao() {
			// abre conexao com o banco de dados
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// variavel lista de alunos
			List<AlunoInstituicao> alunos = new ArrayList<AlunoInstituicao>();
			// executa o SQL no banco de dados
			Statement consulta = null;
			// contém os dados consultado da tabela
			ResultSet resultado = null;
			// objeto aluno
			//Aluno aluno = null;
			// consulta SQL
			String sql = "select distinct * from aluno";
			try {
				// consulta => objeto que executa o SQL no banco de dados
				consulta = conexao.createStatement();
				// resultado => objeto que contém os dados consultado da tabela
				// Aluno
				resultado = consulta.executeQuery(sql);
				// Lê cada aluno
				while (resultado.next()) {
					if (resultado.getInt("tipoAluno")==Integer.parseInt(Tipo.AlunoInstitucional+"")){
						AlunoInstituicao aluno = new AlunoInstituicao();
						aluno.setDataNasc(resultado.getDate("dataNasc"));
						aluno.setDescConvenio(resultado.getString("descConvenio"));
						aluno.setEndereco(EnderecoCrudJDBC.getEndereco(resultado.getInt("idEndereco")));
						aluno.setNome(resultado.getString("nome"));
						aluno.setPossuiConvenio(resultado.getBoolean("possuiConvenio"));
						aluno.setTelefone(resultado.getInt("telefone"));
						aluno.setTipoSangue(resultado.getString("tipoSangue"));
						aluno.setNivelAluno(resultado.getInt("nivelAluno"));
						aluno.setObs(resultado.getString("obs"));
						Integer.parseInt(Tipo.AlunoInstitucional + "");
						aluno.setMatriculaEscola(resultado.getString("matriculaEscola"));
						aluno.setNivelEscolaridade(resultado.getInt("nivelEscolaridade"));
						aluno.setNomeResponsavel(resultado.getString("nomeResponsavel"));
						aluno.setTelefoneEscola(resultado.getString("telefoneEscola"));
						// insere o aluno na lista
						alunos.add(aluno);
						
					}
					
				}
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao buscar um aluno: " + e);
			} finally {
				try {
					consulta.close();
					resultado.close();
					conexao.close();
				} catch (Throwable e) {
					throw new RuntimeException("Erro ao fechar a conexao " + e);
				}
			}
			// retorna lista de alunos
			return alunos;
		}

		/*
		 * Objetivo: Método que salva um aluno no banco de dados
		 */
		public void excluir(Aluno aluno) {
			// abre a conexao com o banco de dados PostGresql
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL delete
			PreparedStatement excluiPSt = null;
			PreparedStatement excluiSt = null;
			// SQL de exclusão do aluno
			String sql = "delete from aluno where id=?";
			// SQL de exclusão do aluno
			String presql = "delete from endereco where id=?";
			try {
				// recebe o SQL delete para endereço
				excluiPSt = conexao.prepareStatement(presql);
				// recebe o parâmtros do SQL insert
				excluiPSt.setInt(1, aluno.getEndereco().getId());
				// executa SQL delete
				excluiPSt.executeUpdate();
				
				// recebe o SQL delete para aluno
				excluiSt = conexao.prepareStatement(sql);
				// recebe o parâmtros do SQL insert
				excluiSt.setInt(1, aluno.getId());
				// executa SQL delete
				excluiSt.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao excluir aluno.mensagem:" + e);
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

		public void alterar(Aluno aluno) {
			// abre a conexao com o banco de dados MYSQL
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL update
			PreparedStatement insereSt = null;
			// SQL de inserção
			String sql = "update aluno set dataNasc=?, descConvenio=?, idEndereco=?, nome=?, "
					+ "					   possuiConvenio=?, telefone=?, tipoSangue=?, nivelAluno=?, "
					+ "					   obs=?, tipoAluno=?, matriculaEscola=?, nivelEscolaridade=?, "
					+ "					   nomeResponsavel=?, telefoneEscola=?, diaDePagamento=?, tipoPacote=?";
			try {
				// recebe o SQL update
				insereSt = conexao.prepareStatement(sql);
				if(aluno.getTipoAluno()== Tipo.AlunoInstitucional){
					AlunoInstituicao alunoI= (AlunoInstituicao) aluno;
					// recebe o parâmtros do SQL update
					insereSt.setDate(1, (Date) alunoI.getDataNasc());
					insereSt.setString(2, alunoI.getDescConvenio());
					insereSt.setInt(3, alunoI.getEndereco().getId());
					insereSt.setString(4, alunoI.getNome());
					insereSt.setBoolean(5, alunoI.isPossuiConvenio());
					insereSt.setInt(6, alunoI.getTelefone());
					insereSt.setString(7, alunoI.getTipoSangue());
					insereSt.setInt(8, alunoI.getNivelAluno());
					insereSt.setString(9, alunoI.getObs());
					insereSt.setInt(10, Integer.parseInt(Tipo.AlunoInstitucional + ""));
					insereSt.setString(11, alunoI.getMatriculaEscola());
					insereSt.setInt(12, alunoI.getNivelEscolaridade());
					insereSt.setString(13, alunoI.getNomeResponsavel());
					insereSt.setString(14, alunoI.getTelefoneEscola());
					insereSt.setObject(15, null);
					insereSt.setObject(16, null);
					
				}
				else if (aluno.getTipoAluno()== Tipo.AlunoPago){
					AlunoPago alunoP= (AlunoPago) aluno;
					// recebe o parâmtros do SQL update
					insereSt.setDate(1, (Date) alunoP.getDataNasc());
					insereSt.setString(2, alunoP.getDescConvenio());
					insereSt.setInt(3, alunoP.getEndereco().getId());
					insereSt.setString(4, alunoP.getNome());
					insereSt.setBoolean(5, alunoP.isPossuiConvenio());
					insereSt.setInt(6, alunoP.getTelefone());
					insereSt.setString(7, alunoP.getTipoSangue());
					insereSt.setInt(8, alunoP.getNivelAluno());
					insereSt.setString(9, alunoP.getObs());
					insereSt.setInt(10, Integer.parseInt(Tipo.AlunoPago + ""));
					insereSt.setObject(11, null);
					insereSt.setObject(12, null);
					insereSt.setObject(13, null);
					insereSt.setObject(14, null);
					insereSt.setInt(15, alunoP.getDiaDePagamento());
					insereSt.setInt(16, alunoP.getPacote());
				}
				// executa SQL update
				insereSt.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao alterar aluno.mensagem:" + e);
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
