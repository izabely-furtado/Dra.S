package cgd.crudjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cdp.classesAnemicas.Aluno;
import cdp.classesAnemicas.AlunosTurma;
import cdp.classesAnemicas.Turma;
import cgd.conexao.ConectaPostgreSQL;

public class AlunoTurmaCrudJDBC {

	public boolean salvar(int alunosturma, int turma) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;

		// SQL de inserção
		String sql = "insert into alunosturma(turma_id, aluno_id)"
				
				+ "values (?,?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			insereSt.setInt(1,alunosturma );
			insereSt.setInt(2, turma);
			
			// executa SQL insert
			insereSt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir turma. mensagem:" + e);
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
}
