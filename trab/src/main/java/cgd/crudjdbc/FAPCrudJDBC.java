package cgd.crudjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cdp.classesAnemicas.*;
import cgd.conexao.ConectaPostgreSQL;

public class FAPCrudJDBC {
	/*
	 * Objetivo: Método que salva um fap no banco de dados
	 */
	public static boolean salvar(FormularioAcompanhamentoPsicossocial fap) {
		// abre a conexao com o banco de dados MYSQL
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "insert into fap(acessoservicos, acompanhamentoescolar, ano, composicaofamiliar, "
				+ "condicoesmoradia, dadospessoais, despesas, endereco, formaacesso, infomedicas, "
				+ "infotransporte, programasbeneficios, publicoprioritario, rematricula, tipo) "
				+ "				values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert

			insereSt.setInt(1, fap.getAcessoServicos().getId());
			AcessoServicosCrudJDBC.salvar(fap.getAcessoServicos());
			insereSt.setInt(2, fap.getAcompanhamentoEscolar().getId());
			AcompanhamentoEscolarCrudJDBC.salvar(fap.getAcompanhamentoEscolar());
			insereSt.setInt(3, fap.getAno());
			insereSt.setInt(4, fap.getComposicaoFamiliar().getId());
			ComposicaoFamiliarCrudJDBC.salvar(fap.getComposicaoFamiliar());
			insereSt.setInt(5, fap.getCondicoesMoradia().getId());
			CondicoesMoradiaCrudJDBC.salvar(fap.getCondicoesMoradia());
			insereSt.setInt(6, fap.getDadosPessoais().getId());
			DadosPessoaisCrudJDBC.salvar(fap.getDadosPessoais());
			insereSt.setInt(7, fap.getDespesas().getId());
			DespesasCrudJDBC.salvar(fap.getDespesas());
			insereSt.setInt(8, fap.getEndereco().getId());
			EnderecoCrudJDBC.salvar(fap.getEndereco());
			insereSt.setInt(9, fap.getFormaAcesso());
			insereSt.setInt(10, fap.getInfoMedicas().getId());
			InfoMedicasCrudJDBC.salvar(fap.getInfoMedicas());
			insereSt.setInt(11, fap.getInfoTransporte().getId());
			InfoTransporteCrudJDBC.salvar(fap.getInfoTransporte());
			insereSt.setInt(12, fap.getProgramasBeneficios().getId());
			ProgramasBeneficiosCrudJDBC.salvar(fap.getProgramasBeneficios());
			insereSt.setInt(13, fap.getPublicoPrioritario().getId());
			PublicoPrioritarioCrudJDBC.salvar(fap.getPublicoPrioritario());
			insereSt.setString(14, fap.getRematricula());
			insereSt.setInt(15, fap.getTipo());

			// executa SQL insert
			insereSt.executeUpdate();
			return true;

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao incluir fap. mensagem:" + e);
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
	 * Objetivo: Método que lista todos os faps do banco de dados
	 */
	public static FormularioAcompanhamentoPsicossocial getFormularioAcompanhamentoPsicossocial(
			int idFormularioAcompanhamentoPsicossocial) {
		// abre conexao com o banco de dados
		Connection conexao = ConectaPostgreSQL.geraConexao();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		// objeto fap
		FormularioAcompanhamentoPsicossocial fap = null;
		// consulta SQL
		String sql = "select distinct * from fap where id=" + idFormularioAcompanhamentoPsicossocial;
		try {
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			// resultado => objeto que contém os dados consultado da tabela
			// FormularioAcompanhamentoPsicossocial
			resultado = consulta.executeQuery(sql);
			// Lê cada fap
			while (resultado.next()) {
				fap.setAcessoServicos(AcessoServicosCrudJDBC.getAcessoServicos(resultado.getInt("idAcessoServicos")));
				fap.setAcompanhamentoEscolar(AcompanhamentoEscolarCrudJDBC
						.getAcompanhamentoEscolar(resultado.getInt("idAcompanhamentoEscolar")));
				fap.setAno(resultado.getInt("ano"));
				fap.setComposicaoFamiliar(
						ComposicaoFamiliarCrudJDBC.getComposicaoFamiliar(resultado.getInt("idComposicaoFamiliar")));
				fap.setCondicoesMoradia(
						CondicoesMoradiaCrudJDBC.getCondicoesMoradia(resultado.getInt("idCondicoesMoradia")));
				fap.setDadosPessoais(DadosPessoaisCrudJDBC.getDadosPessoais(resultado.getInt("idDadosPessoais")));
				fap.setDespesas(DespesasCrudJDBC.getDespesas(resultado.getInt("idDespesas")));
				fap.setEndereco(EnderecoCrudJDBC.getEndereco(resultado.getInt("idEndereco")));
				fap.setFormaAcesso(resultado.getInt("formaAcesso"));
				fap.setInfoMedicas(InfoMedicasCrudJDBC.getInfoMedicas(resultado.getInt("idInfoMedicas")));
				fap.setInfoTransporte(InfoTransporteCrudJDBC.getInfoTransporte(resultado.getInt("idInfoTransporte")));
				fap.setProgramasBeneficios(
						ProgramasBeneficiosCrudJDBC.getProgramasBeneficios(resultado.getInt("idProgramasBeneficios")));
				fap.setPublicoPrioritario(
						PublicoPrioritarioCrudJDBC.getPublicoPrioritario(resultado.getInt("idPublicoPrioritario")));
				fap.setRematricula(resultado.getString("rematricula"));
				fap.setTipo(resultado.getInt("tipo"));
				// insere o fap na lista
				return fap;

			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar um fap: " + e);
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a conexao " + e);
			}
		}
		// retorna lista de faps
		return fap;
	}

	/*
	 * Objetivo: Método que lista todos os faps do banco de dados
	 */
	public static List<FormularioAcompanhamentoPsicossocial> listar() {
			// abre conexao com o banco de dados
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// variavel lista de faps
			List<FormularioAcompanhamentoPsicossocial> faps = new ArrayList<FormularioAcompanhamentoPsicossocial>();
			// executa o SQL no banco de dados
			Statement consulta = null;
			// contém os dados consultado da tabela
			ResultSet resultado = null;
			// objeto fap
			//FormularioAcompanhamentoPsicossocial fap = null;
			// consulta SQL
			String sql = "select distinct * from fap";
			try {
				// consulta => objeto que executa o SQL no banco de dados
				consulta = conexao.createStatement();
				// resultado => objeto que contém os dados consultado da tabela
				// FormularioAcompanhamentoPsicossocial
				resultado = consulta.executeQuery(sql);
				// Lê cada fap
				while (resultado.next()) {
					FormularioAcompanhamentoPsicossocial fap = new FormularioAcompanhamentoPsicossocial();
					fap.setAcessoServicos(AcessoServicosCrudJDBC.getAcessoServicos(resultado.getInt("idAcessoServicos")));
					fap.setAcompanhamentoEscolar(AcompanhamentoEscolarCrudJDBC.getAcompanhamentoEscolar(resultado.getInt("idAcompanhamentoEscolar")));
					fap.setAno(resultado.getInt("ano"));
					fap.setComposicaoFamiliar(ComposicaoFamiliarCrudJDBC.getComposicaoFamiliar(resultado.getInt("idComposicaoFamiliar")));
					fap.setCondicoesMoradia(CondicoesMoradiaCrudJDBC.getCondicoesMoradia(resultado.getInt("idCondicoesMoradia")));
					fap.setDadosPessoais(DadosPessoaisCrudJDBC.getDadosPessoais(resultado.getInt("idDadosPessoais")));
					fap.setDespesas(DespesasCrudJDBC.getDespesas(resultado.getInt("idDespesas")));
					fap.setEndereco(EnderecoCrudJDBC.getEndereco(resultado.getInt("idEndereco")));
					fap.setFormaAcesso(resultado.getInt("formaAcesso"));
					fap.setInfoMedicas(InfoMedicasCrudJDBC.getInfoMedicas(resultado.getInt("idInfoMedicas")));
					fap.setInfoTransporte(InfoTransporteCrudJDBC.getInfoTransporte(resultado.getInt("idInfoTransporte")));
					fap.setProgramasBeneficios(ProgramasBeneficiosCrudJDBC.getProgramasBeneficios(resultado.getInt("idProgramasBeneficios")));
					fap.setPublicoPrioritario(PublicoPrioritarioCrudJDBC.getPublicoPrioritario(resultado.getInt("idPublicoPrioritario")));
					fap.setRematricula(resultado.getString("rematricula"));
					fap.setTipo(resultado.getInt("tipo"));
					// insere o fap na lista
					faps.add(fap);
					
				}
			}catch(

	SQLException e)
	{
		throw new RuntimeException("Erro ao buscar um fap: " + e);
	}finally
	{
		try {
			consulta.close();
			resultado.close();
			conexao.close();
		} catch (Throwable e) {
			throw new RuntimeException("Erro ao fechar a conexao " + e);
		}
	}
	// retorna lista de faps
	return faps;
	}

	/*
	 * Objetivo: Método que salva um fap no banco de dados
	 */
	public static boolean excluir(FormularioAcompanhamentoPsicossocial fap) {
			// abre a conexao com o banco de dados PostGresql
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL delete
			PreparedStatement excluiPSt = null;
			PreparedStatement excluiSt = null;
			// SQL de exclusão do fap
			String sql = "delete from fap where id=?";
			// SQL de exclusão do fap
			String presql = "delete from endereco where id=?";
			try {
				// recebe o SQL delete para endereço
				excluiPSt = conexao.prepareStatement(presql);
				// recebe o parâmtros do SQL insert
				excluiPSt.setInt(1, fap.getEndereco().getId());
				// executa SQL delete
				excluiPSt.executeUpdate();
				
				// recebe o SQL delete para fap
				excluiSt = conexao.prepareStatement(sql);
				// recebe o parâmtros do SQL insert
				excluiSt.setInt(1, fap.getId());
				// executa SQL delete
				excluiSt.executeUpdate();
				return true;
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao excluir fap.mensagem:" + e);
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

	public static boolean alterar(FormularioAcompanhamentoPsicossocial fap) {
			// abre a conexao com o banco de dados MYSQL
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL update
			PreparedStatement insereSt = null;
			// SQL de inserção
			String sql = "update fap set acessoservicos=?, acompanhamentoescolar=?, ano=?, composicaofamiliar=?, "
					+ "					   condicoesmoradia=?, dadospessoais=?, despesas=?, endereco=?, "
					+ "					   formaAcesso=?, infoMedicas=?, infoTransporte=?, programasbeneficios=?, "
					+ "					   publicoprioritario=?, rematricula=?, tipo=?";
			try {
				// recebe o SQL update
				insereSt = conexao.prepareStatement(sql);
				// recebe o parâmtros do SQL update
				insereSt.setInt(1, fap.getAcessoServicos().getId());
				AcessoServicosCrudJDBC.salvar(fap.getAcessoServicos());
				insereSt.setInt(2, fap.getAcompanhamentoEscolar().getId());
				AcompanhamentoEscolarCrudJDBC.salvar(fap.getAcompanhamentoEscolar());
				insereSt.setInt(3, fap.getAno());
				insereSt.setInt(4, fap.getComposicaoFamiliar().getId());
				ComposicaoFamiliarCrudJDBC.salvar(fap.getComposicaoFamiliar());
				insereSt.setInt(5, fap.getCondicoesMoradia().getId());
				CondicoesMoradiaCrudJDBC.salvar(fap.getCondicoesMoradia());
				insereSt.setInt(6, fap.getDadosPessoais().getId());
				DadosPessoaisCrudJDBC.salvar(fap.getDadosPessoais());
				insereSt.setInt(7, fap.getDespesas().getId());
				DespesasCrudJDBC.salvar(fap.getDespesas());
				insereSt.setInt(8, fap.getEndereco().getId());
				EnderecoCrudJDBC.salvar(fap.getEndereco());
				insereSt.setInt(9, fap.getFormaAcesso());
				insereSt.setInt(10, fap.getInfoMedicas().getId());
				InfoMedicasCrudJDBC.salvar(fap.getInfoMedicas());
				insereSt.setInt(11, fap.getInfoTransporte().getId());
				InfoTransporteCrudJDBC.salvar(fap.getInfoTransporte());
				insereSt.setInt(12, fap.getProgramasBeneficios().getId());
				ProgramasBeneficiosCrudJDBC.salvar(fap.getProgramasBeneficios());
				insereSt.setInt(13, fap.getPublicoPrioritario().getId());
				PublicoPrioritarioCrudJDBC.salvar(fap.getPublicoPrioritario());
				insereSt.setString(14, fap.getRematricula());
				insereSt.setInt(15, fap.getTipo());
				// executa SQL update
				insereSt.executeUpdate();
				return true;
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao alterar fap.mensagem:" + e);
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
