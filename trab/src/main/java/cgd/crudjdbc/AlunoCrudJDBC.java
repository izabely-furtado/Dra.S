package cgd.crudjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cdp.classesAnemicas.Aluno;
import cgd.conexao.ConectaPostgreSQL;

public class AlunoCrudJDBC {
	/*
	 * Objetivo: Método que salva uma aluno no banco de dados
	 */
	public static boolean salvar(Aluno aluno) {
		// abre a conexao com o banco de dados MYSQL
		System.out.println("Passei aqui");
		Connection conexao = ConectaPostgreSQL.geraConexao();
		System.out.println("Passei aqui");
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inser��o
		String sql = "insert into aluno(dadospessoais_id, endereco_id, acompanhamentoescolar_id, infomedicas_id, infotransporte_id,"
				+ "despesas_id, condicoesmoradia_id, programasbeneficios_id, publicoprioritario_id, "
				+ "edita, foto, nivel) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			int lastId=0;
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// recebe o par�mtros do SQL insert
			
			int dpe = DadosPessoaisCrudJDBC.salvar(aluno.getDadosPessoais());
			insereSt.setInt(1, dpe);
			
			int ec = EnderecoCrudJDBC.salvar(aluno.getEndereco());
			
			insereSt.setInt(2, ec);
			
			
			int aco = AcompanhamentoEscolarCrudJDBC.salvar(aluno.getAcompanhamentoEscolar());
			insereSt.setInt(3, aco);
		
			int imo = InfoMedicasCrudJDBC.salvar(aluno.getInfoMedicas());
			insereSt.setInt(4, imo);
			
			int itp = InfoTransporteCrudJDBC.salvar(aluno.getInfoTransporte());
			insereSt.setInt(5, itp);
		
		
			//insereSt.setInt(6, aluno.getComposicaoFamiliar().getId());
			
			//ComposicaoFamiliarCrudJDBC.salvar(aluno.getComposicaoFamiliar());
			
			int despe = DespesasCrudJDBC.salvar(aluno.getDespesas());	
			insereSt.setInt(6, despe);
			
		
			int cmo = CondicoesMoradiaCrudJDBC.salvar(aluno.getCondicoesMoradia());
			
			insereSt.setInt(7, cmo);
			
			//insereSt.setInt(8, aluno.getAcessoServicos().getId());
			
			//AcessoServicosCrudJDBC.salvar(aluno.getAcessoServicos());
			
			int pbe = ProgramasBeneficiosCrudJDBC.salvar(aluno.getProgramasBeneficios());
			insereSt.setInt(8, pbe);
			
			int ppo = PublicoPrioritarioCrudJDBC.salvar(aluno.getPublicoPrioritario());
			insereSt.setInt(9, ppo);	
			
			insereSt.setBoolean(10, aluno.isEdita());
			
			insereSt.setString(11, aluno.getFoto());
			
			insereSt.setInt(12, aluno.getNivel());
			
			//insereSt.setInt(13, aluno.getTurma().getId());
			
			//TurmaCrudJDBC.salvar(aluno.getTurma());
			
			// executa SQL insert
			insereSt.executeUpdate();
			

			ResultSet rs = insereSt.getGeneratedKeys();
			if (rs.next()) {
			   lastId = rs.getInt("id_aluno");
			   aluno.setId(lastId);
			}
			
			
			
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir aluno. mensagem:" + e);
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
	

	public static Aluno getAluno(Integer id) {
		Aluno aluno = new Aluno();
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// consultas SQL
		String sqlAluno = "select distinct * from aluno where id_aluno = '" + id + "'";

		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// Aluno
			resultado = consulta.executeQuery(sqlAluno);
			// Lê o aluno associado ao id
			// se o aluno vinculado existir
			if (resultado.next()) {
				//aluno.setFap(FAPCrudJDBC.getFormularioAcompanhamentoPsicossocial(resultado.getInt("fap_id")));
				aluno.setFoto(resultado.getString("foto"));
				aluno.setNivel(resultado.getInt("nivel"));
				aluno.setTurma(TurmaCrudJDBC.getTurma(resultado.getInt("turma_id")));
				aluno.setAcessoServicos(AcessoServicosCrudJDBC.getAcessoServicos(resultado.getInt("acessoServicos_id")));
				aluno.setAcompanhamentoEscolar(AcompanhamentoEscolarCrudJDBC.getAcompanhamentoEscolar(resultado.getInt("acompanhamentoEscolar_id")));
				aluno.setComposicaoFamiliar(ComposicaoFamiliarCrudJDBC.getComposicaoFamiliar(resultado.getInt("composicaoFamiliar_id")));
				aluno.setCondicoesMoradia(CondicoesMoradiaCrudJDBC.getCondicoesMoradia(resultado.getInt("condicoesMoradia_id")));
				aluno.setDadosPessoais(DadosPessoaisCrudJDBC.getDadosPessoais(resultado.getInt("dadosPessoais_id")));
				aluno.setDespesas(DespesasCrudJDBC.getDespesas(resultado.getInt("despesas_id")));
				aluno.setEndereco(EnderecoCrudJDBC.getEndereco(resultado.getInt("endereco_id")));
				aluno.setInfoMedicas(InfoMedicasCrudJDBC.getInfoMedicas(resultado.getInt("infoMedicas_id")));
				aluno.setInfoTransporte(InfoTransporteCrudJDBC.getInfoTransporte(resultado.getInt("infoTransporte_id")));
				aluno.setProgramasBeneficios(ProgramasBeneficiosCrudJDBC.getProgramasBeneficios(resultado.getInt("programasBeneficios_id")));
				aluno.setPublicoPrioritario(PublicoPrioritarioCrudJDBC.getPublicoPrioritario(resultado.getInt("publicoPrioritario_id")));
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar um aluno: " + e);
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a conexao de aluno" + e);
			}
		}
		// retorna aluno com o determinado id
		return aluno;
	}

	public static Aluno getAluno(String nome) {
		Aluno aluno = new Aluno();
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// consultas SQL
		String sqlAluno = "select distinct * from aluno, dadospessoais where dadospessoais.id_dadospessoais = aluno.dadospessoais_id and dadospessoais.nome like '%" + nome + "%'";

		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// Aluno
			resultado = consulta.executeQuery(sqlAluno);
			// Lê o aluno associado ao id
			// se o aluno vinculado existir
			if (resultado.next()) {
				//aluno.setFap(FAPCrudJDBC.getFormularioAcompanhamentoPsicossocial(resultado.getInt("fap_id")));
				aluno.setFoto(resultado.getString("foto"));
				aluno.setNivel(resultado.getInt("nivel"));
				aluno.setTurma(TurmaCrudJDBC.getTurma(resultado.getInt("turma_id")));
				aluno.setAcessoServicos(AcessoServicosCrudJDBC.getAcessoServicos(resultado.getInt("acessoServicos_id")));
				aluno.setAcompanhamentoEscolar(AcompanhamentoEscolarCrudJDBC.getAcompanhamentoEscolar(resultado.getInt("acompanhamentoEscolar_id")));
				aluno.setComposicaoFamiliar(ComposicaoFamiliarCrudJDBC.getComposicaoFamiliar(resultado.getInt("composicaoFamiliar_id")));
				aluno.setCondicoesMoradia(CondicoesMoradiaCrudJDBC.getCondicoesMoradia(resultado.getInt("condicoesMoradia_id")));
				aluno.setDadosPessoais(DadosPessoaisCrudJDBC.getDadosPessoais(resultado.getInt("dadosPessoais_id")));
				aluno.setDespesas(DespesasCrudJDBC.getDespesas(resultado.getInt("despesas_id")));
				aluno.setEndereco(EnderecoCrudJDBC.getEndereco(resultado.getInt("endereco_id")));
				aluno.setInfoMedicas(InfoMedicasCrudJDBC.getInfoMedicas(resultado.getInt("infoMedicas_id")));
				aluno.setInfoTransporte(InfoTransporteCrudJDBC.getInfoTransporte(resultado.getInt("infoTransporte_id")));
				aluno.setProgramasBeneficios(ProgramasBeneficiosCrudJDBC.getProgramasBeneficios(resultado.getInt("programasBeneficios_id")));
				aluno.setPublicoPrioritario(PublicoPrioritarioCrudJDBC.getPublicoPrioritario(resultado.getInt("publicoPrioritario_id")));
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar um aluno: " + e);
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a conexao de aluno" + e);
			}
		}
		// retorna aluno com o determinado id
		return aluno;
	}
/*
	 * Objetivo: Método que salva uma aluno no banco de dados
	 */
	public static boolean excluir(Aluno aluno) {
		// abre a conexao com o banco de dados PostGresql
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL delete
		PreparedStatement excluiSt = null;
		// SQL de inserção
		String sql = "delete from aluno where id=?";
		try {
			// recebe o SQL delete
			excluiSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			excluiSt.setInt(1, aluno.getId());
			// executa SQL delete
			excluiSt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao excluir aluno.mensagem:" + e);
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

	/*public static boolean alterar(Aluno aluno) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL update
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "update aluno set fap_id=?, foto=?, nivel=?, turma_id=?"
				+ " where id=?";
		try {
			// recebe o SQL update
			insereSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL update
			
			insereSt.setString(1, aluno.getFoto());
			insereSt.setInt(2, aluno.getNivel());
			insereSt.setInt(3, aluno.getTurma().getId());
			insereSt.setInt(4, aluno.getAcessoServicos().getId());
			AcessoServicosCrudJDBC.salvar(aluno.getAcessoServicos());
			insereSt.setInt(5, aluno.getAcompanhamentoEscolar().getId());
			AcompanhamentoEscolarCrudJDBC.salvar(aluno.getAcompanhamentoEscolar());
			insereSt.setInt(6, aluno.getComposicaoFamiliar().getId());
			ComposicaoFamiliarCrudJDBC.salvar(aluno.getComposicaoFamiliar());
			insereSt.setInt(7, aluno.getCondicoesMoradia().getId());
			CondicoesMoradiaCrudJDBC.salvar(aluno.getCondicoesMoradia());
			insereSt.setInt(8, aluno.getDadosPessoais().getId());
			DadosPessoaisCrudJDBC.salvar(aluno.getDadosPessoais());
			insereSt.setInt(8, aluno.getDespesas().getId());
			DespesasCrudJDBC.salvar(aluno.getDespesas());
			insereSt.setInt(9, aluno.getEndereco().getId());
			EnderecoCrudJDBC.salvar(aluno.getEndereco());
			insereSt.setInt(10, aluno.getInfoMedicas().getId());
			InfoMedicasCrudJDBC.salvar(aluno.getInfoMedicas());
			insereSt.setInt(11, aluno.getInfoTransporte().getId());
			InfoTransporteCrudJDBC.salvar(aluno.getInfoTransporte());
			insereSt.setInt(12, aluno.getProgramasBeneficios().getId());
			ProgramasBeneficiosCrudJDBC.salvar(aluno.getProgramasBeneficios());
			insereSt.setInt(13, aluno.getPublicoPrioritario().getId());
			PublicoPrioritarioCrudJDBC.salvar(aluno.getPublicoPrioritario());
			
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
				throw new RuntimeException("Erro ao fechar a operação de alteracao" + e);
			}
		}
	}*/

	//antes era static, apenas retirei isso
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
		Aluno aluno = new Aluno();
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
				aluno = new Aluno();
				
				aluno.setFoto(resultado.getString("foto"));
				aluno.setNivel(resultado.getInt("nivel"));
				aluno.setTurma(TurmaCrudJDBC.getTurma(resultado.getInt("turma_id")));
				aluno.setAcessoServicos(AcessoServicosCrudJDBC.getAcessoServicos(resultado.getInt("acessoServicos_id")));
				aluno.setAcompanhamentoEscolar(AcompanhamentoEscolarCrudJDBC.getAcompanhamentoEscolar(resultado.getInt("acompanhamentoescolar_id")));
				aluno.setComposicaoFamiliar(ComposicaoFamiliarCrudJDBC.getComposicaoFamiliar(resultado.getInt("composicaofamiliar_id")));
				aluno.setCondicoesMoradia(CondicoesMoradiaCrudJDBC.getCondicoesMoradia(resultado.getInt("condicoesmoradia_id")));
				aluno.setDadosPessoais(DadosPessoaisCrudJDBC.getDadosPessoais(resultado.getInt("dadosPessoais_id")));
				aluno.setDespesas(DespesasCrudJDBC.getDespesas(resultado.getInt("despesas_id")));
				aluno.setEndereco(EnderecoCrudJDBC.getEndereco(resultado.getInt("endereco_id")));
				aluno.setInfoMedicas(InfoMedicasCrudJDBC.getInfoMedicas(resultado.getInt("infomedicas_id")));
				aluno.setInfoTransporte(InfoTransporteCrudJDBC.getInfoTransporte(resultado.getInt("infotransporte_id")));
				aluno.setProgramasBeneficios(ProgramasBeneficiosCrudJDBC.getProgramasBeneficios(resultado.getInt("programasbeneficios_id")));
				aluno.setPublicoPrioritario(PublicoPrioritarioCrudJDBC.getPublicoPrioritario(resultado.getInt("publicoprioritario_id")));
				// insere o aluno na lista
				alunos.add(aluno);

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar um aluno: " + e);
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a conexao - Listar" + e);
			}
		}
		// retorna lista de alunos
		return alunos;
	}

	public static List<Aluno> getAlunoPorNome(String nome) {
			// abre conexao com o banco de dados
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// variavel lista de alunos
			List<Aluno> alunos = new ArrayList<Aluno>();
			// executa o SQL no banco de dados
			Statement consulta = null;
			// contém os dados consultado da tabela
			ResultSet resultado = null;
			// objeto aluno
			Aluno aluno = new Aluno();
			// consulta SQL
			String sql = "select distinct * from aluno, dadospessoais where dadospessoais.id_dadospessoais = aluno.dadospessoais_id and dadospessoais.nome like '%" + nome + "%'";
			try {
				// consulta => objeto que executa o SQL no banco de dados
				consulta = conexao.createStatement();
				// resultado => objeto que contém os dados consultado da tabela
				// Aluno
				resultado = consulta.executeQuery(sql);
				// Lê cada aluno
				while (resultado.next()) {
					aluno = new Aluno();
					
					aluno.setFoto(resultado.getString("foto"));
					aluno.setNivel(resultado.getInt("nivel"));
					aluno.setTurma(TurmaCrudJDBC.getTurma(resultado.getInt("turma_id")));
					aluno.setAcessoServicos(AcessoServicosCrudJDBC.getAcessoServicos(resultado.getInt("acessoServicos_id")));
					aluno.setAcompanhamentoEscolar(AcompanhamentoEscolarCrudJDBC.getAcompanhamentoEscolar(resultado.getInt("acompanhamentoescolar_id")));
					aluno.setComposicaoFamiliar(ComposicaoFamiliarCrudJDBC.getComposicaoFamiliar(resultado.getInt("composicaofamiliar_id")));
					aluno.setCondicoesMoradia(CondicoesMoradiaCrudJDBC.getCondicoesMoradia(resultado.getInt("condicoesmoradia_id")));
					aluno.setDadosPessoais(DadosPessoaisCrudJDBC.getDadosPessoais(resultado.getInt("dadosPessoais_id")));
					aluno.setDespesas(DespesasCrudJDBC.getDespesas(resultado.getInt("despesas_id")));
					aluno.setEndereco(EnderecoCrudJDBC.getEndereco(resultado.getInt("endereco_id")));
					aluno.setInfoMedicas(InfoMedicasCrudJDBC.getInfoMedicas(resultado.getInt("infomedicas_id")));
					aluno.setInfoTransporte(InfoTransporteCrudJDBC.getInfoTransporte(resultado.getInt("infotransporte_id")));
					aluno.setProgramasBeneficios(ProgramasBeneficiosCrudJDBC.getProgramasBeneficios(resultado.getInt("programasbeneficios_id")));
					aluno.setPublicoPrioritario(PublicoPrioritarioCrudJDBC.getPublicoPrioritario(resultado.getInt("publicoprioritario_id")));
					// insere o aluno na lista
					alunos.add(aluno);


				}
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao buscar um aluno: " + e);
			} finally {
				try {
					consulta.close();
					resultado.close();
					conexao.close();
				} catch (Throwable e) {
					throw new RuntimeException("Erro ao fechar a conexao - Listar" + e);
				}
			}
			// retorna lista de alunos
			return alunos;
		}

	
	public Aluno getAlunoPorNome2(String nome) {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de alunos
		//List<Aluno> alunos = new ArrayList<Aluno>();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// cont�m os dados consultado da tabela
		ResultSet resultado = null;
		// objeto aluno
		Aluno aluno = null;
		// consulta SQL
		String sql = "select distinct * from aluno, dadospessoais where dadospessoais.id_dadospessoais = aluno.dadospessoais_id and dadospessoais.nome like '" + nome + "'";
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que cont�m os dados consultado da tabela
			// Aluno
			resultado = consulta.executeQuery(sql);
			// L� cada aluno
			if (resultado.next()) {
				aluno = new Aluno();
				
				//aluno.setFap(FAPCrudJDBC.getFormularioAcompanhamentoPsicossocial(resultado.getInt("fap_id")));
				aluno.setId(resultado.getInt("id_aluno"));
				aluno.setFoto(resultado.getString("foto"));
				aluno.setNivel(resultado.getInt("nivel"));
				aluno.setAcessoServicos(AcessoServicosCrudJDBC.getAcessoServicos(resultado.getInt("acessoServicos_id")));
				aluno.setAcompanhamentoEscolar(AcompanhamentoEscolarCrudJDBC.getAcompanhamentoEscolar(resultado.getInt("acompanhamentoEscolar_id")));
				aluno.setComposicaoFamiliar(ComposicaoFamiliarCrudJDBC.getComposicaoFamiliar(resultado.getInt("composicaoFamiliar_id")));
				aluno.setCondicoesMoradia(CondicoesMoradiaCrudJDBC.getCondicoesMoradia(resultado.getInt("condicoesMoradia_id")));
				aluno.setDadosPessoais(DadosPessoaisCrudJDBC.getDadosPessoais(resultado.getInt("dadosPessoais_id")));
				aluno.setDespesas(DespesasCrudJDBC.getDespesas(resultado.getInt("despesas_id")));
				aluno.setEndereco(EnderecoCrudJDBC.getEndereco(resultado.getInt("endereco_id")));
				aluno.setInfoMedicas(InfoMedicasCrudJDBC.getInfoMedicas(resultado.getInt("infoMedicas_id")));
				aluno.setInfoTransporte(InfoTransporteCrudJDBC.getInfoTransporte(resultado.getInt("infoTransporte_id")));
				aluno.setProgramasBeneficios(ProgramasBeneficiosCrudJDBC.getProgramasBeneficios(resultado.getInt("programasBeneficios_id")));
				aluno.setPublicoPrioritario(PublicoPrioritarioCrudJDBC.getPublicoPrioritario(resultado.getInt("publicoPrioritario_id")));
					
				// insere o aluno na lista
				return aluno;

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar um aluno: " + e);
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a conexao - Listar" + e);
			}
		}
		// retorna lista de alunos
		return aluno;
	
	}

	
	public static List<Aluno> getAlunoPorTurma(String turma) {
				// abre conexao com o banco de dados
				Connection conexao = ConectaPostgreSQL.geraConexao();
				// variavel lista de alunos
				List<Aluno> alunos = new ArrayList<Aluno>();
				// executa o SQL no banco de dados
				Statement consulta = null;
				// contém os dados consultado da tabela
				ResultSet resultado = null;
				// objeto aluno
				Aluno aluno = new Aluno();
				// consulta SQL
				String sql = "select distinct * from aluno, turma where turma.id_turma = aluno.turma_id and turma.codigo like '%" + turma + "%'";
				try {
					// consulta => objeto que executa o SQL no banco de dados
					consulta = conexao.createStatement();
					// resultado => objeto que contém os dados consultado da tabela
					// Aluno
					resultado = consulta.executeQuery(sql);
					// Lê cada aluno
					while (resultado.next()) {
						aluno = new Aluno();
						
						aluno.setFoto(resultado.getString("foto"));
						aluno.setNivel(resultado.getInt("nivel"));
						aluno.setTurma(TurmaCrudJDBC.getTurma(resultado.getInt("turma_id")));
						aluno.setAcessoServicos(AcessoServicosCrudJDBC.getAcessoServicos(resultado.getInt("acessoServicos_id")));
						aluno.setAcompanhamentoEscolar(AcompanhamentoEscolarCrudJDBC.getAcompanhamentoEscolar(resultado.getInt("acompanhamentoescolar_id")));
						aluno.setComposicaoFamiliar(ComposicaoFamiliarCrudJDBC.getComposicaoFamiliar(resultado.getInt("composicaofamiliar_id")));
						aluno.setCondicoesMoradia(CondicoesMoradiaCrudJDBC.getCondicoesMoradia(resultado.getInt("condicoesmoradia_id")));
						aluno.setDadosPessoais(DadosPessoaisCrudJDBC.getDadosPessoais(resultado.getInt("dadosPessoais_id")));
						aluno.setDespesas(DespesasCrudJDBC.getDespesas(resultado.getInt("despesas_id")));
						aluno.setEndereco(EnderecoCrudJDBC.getEndereco(resultado.getInt("endereco_id")));
						aluno.setInfoMedicas(InfoMedicasCrudJDBC.getInfoMedicas(resultado.getInt("infomedicas_id")));
						aluno.setInfoTransporte(InfoTransporteCrudJDBC.getInfoTransporte(resultado.getInt("infotransporte_id")));
						aluno.setProgramasBeneficios(ProgramasBeneficiosCrudJDBC.getProgramasBeneficios(resultado.getInt("programasbeneficios_id")));
						aluno.setPublicoPrioritario(PublicoPrioritarioCrudJDBC.getPublicoPrioritario(resultado.getInt("publicoprioritario_id")));
						// insere o aluno na lista
						alunos.add(aluno);

					}
				} catch (SQLException e) {
					throw new RuntimeException("Erro ao buscar um aluno: " + e);
				} finally {
					try {
						consulta.close();
						resultado.close();
						conexao.close();
					} catch (Throwable e) {
						throw new RuntimeException("Erro ao fechar a conexao - Listar" + e);
					}
				}
				// retorna lista de alunos
				return alunos;
			}

	public static List<Aluno> getAlunoPorNomeTurma(String nome, String turma) {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// variavel lista de alunos
		List<Aluno> alunos = new ArrayList<Aluno>();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// objeto aluno
		Aluno aluno = new Aluno();
		// consulta SQL
		String sql = "select * from aluno, turma, dadospessoais "
				   + "where turma.id_turma = aluno.turma_id and "
				   + "		dadospessoais.id_dadospessoais = aluno.dadospessoais_id and "
				   + "		turma.codigo like '%" + turma + "%' and "
				   + "		dadospessoais.nome like '%" + nome + "%';";
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// Aluno
			resultado = consulta.executeQuery(sql);
			// Lê cada aluno
			while (resultado.next()) {
				aluno = new Aluno();
				//aluno.setFap(FAPCrudJDBC.getFormularioAcompanhamentoPsicossocial(resultado.getInt("fap_id")));
				aluno.setFoto(resultado.getString("foto"));
				aluno.setNivel(resultado.getInt("nivel"));
				aluno.setTurma(TurmaCrudJDBC.getTurma(resultado.getInt("turma_id")));
				aluno.setAcessoServicos(AcessoServicosCrudJDBC.getAcessoServicos(resultado.getInt("acessoServicos_id")));
				aluno.setAcompanhamentoEscolar(AcompanhamentoEscolarCrudJDBC.getAcompanhamentoEscolar(resultado.getInt("acompanhamentoescolar_id")));
				aluno.setComposicaoFamiliar(ComposicaoFamiliarCrudJDBC.getComposicaoFamiliar(resultado.getInt("composicaofamiliar_id")));
				aluno.setCondicoesMoradia(CondicoesMoradiaCrudJDBC.getCondicoesMoradia(resultado.getInt("condicoesmoradia_id")));
				aluno.setDadosPessoais(DadosPessoaisCrudJDBC.getDadosPessoais(resultado.getInt("dadosPessoais_id")));
				aluno.setDespesas(DespesasCrudJDBC.getDespesas(resultado.getInt("despesas_id")));
				aluno.setEndereco(EnderecoCrudJDBC.getEndereco(resultado.getInt("endereco_id")));
				aluno.setInfoMedicas(InfoMedicasCrudJDBC.getInfoMedicas(resultado.getInt("infomedicas_id")));
				aluno.setInfoTransporte(InfoTransporteCrudJDBC.getInfoTransporte(resultado.getInt("infotransporte_id")));
				aluno.setProgramasBeneficios(ProgramasBeneficiosCrudJDBC.getProgramasBeneficios(resultado.getInt("programasbeneficios_id")));
				aluno.setPublicoPrioritario(PublicoPrioritarioCrudJDBC.getPublicoPrioritario(resultado.getInt("publicoprioritario_id")));
				// insere o aluno na lista
				alunos.add(aluno);
				
			}
			return alunos;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar um aluno: " + e);
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a conexao - Listar" + e);
			}
		}
		// retorna lista de alunos
		//return alunos;
	}



	
}
