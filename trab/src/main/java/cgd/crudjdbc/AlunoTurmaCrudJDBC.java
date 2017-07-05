package cgd.crudjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cgd.conexao.ConectaPostgreSQL;

public class AlunoTurmaCrudJDBC {

	public static boolean salvar(int turma_id, int aluno_id) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;

		// SQL de inser��o
		String sql = "insert into alunosturma(turma_id, aluno_id)"
				
				+ "values (?,?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sql);
			// recebe o par�mtros do SQL insert
			insereSt.setInt(1, turma_id);
			insereSt.setInt(2, aluno_id);
			
			// executa SQL insert
			insereSt.executeUpdate();
			alterarIdTurmaAluno(aluno_id, turma_id);
			
			
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir Alunoturma. mensagem:" + e);
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
	
	public static boolean alterarIdTurmaAluno(int idAluno, int idTurma) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inser��o
		String sql = "update aluno set turma_id=?"
				+ " where id_aluno=" + idAluno;
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);
			// recebe o par�mtros do SQL update
			
			insereSt.setInt(1, idTurma);
	
			
			// executa SQL update
			insereSt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao alterar a aluno. mensagem:" + e);
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
