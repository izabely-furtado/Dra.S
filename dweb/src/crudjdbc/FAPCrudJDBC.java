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

public class FAPCrudJDBC {
	/*
		 * Objetivo: Método que salva um fap no banco de dados
		 */
		public void salvar(FormularioAcompanhamentoPsicossocial fap) {
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
				this.salvarInfoTransporte(fap);
				insereSt.setInt(12, fap.getProgramasBeneficios().getId());
				this.salvarProgramasBeneficios(fap);
				insereSt.setInt(13, fap.getPublicoPrioritario().getId());
				this.salvarPublicoPrioritario(fap);
				insereSt.setInt(14, fap.getRematricula().getId());
				this.salvarRematricula(fap);
				insereSt.setInt(15, fap.getTipo());
			
				// executa SQL insert
				insereSt.executeUpdate();
				
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
		 * Objetivo: Métodos que salvam cada parte de um fap no banco de dados
		 */
		public void salvarEndereco(FormularioAcompanhamentoPsicossocial fap) {
			// abre a conexao com o banco de dados MYSQL
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL insert
			PreparedStatement insereSt = null;
			// SQL de inserção
			String sqlEndereco 		     = "insert into endereco(bairro, cep, cidade, estado, numero, referencia, rua)" +
										   "values (?, ?, ?, ?, ?, ?, ?)";
			try {
				// recebe o SQL insert
				insereSt = conexao.prepareStatement(sqlEndereco);
				// recebe o parâmtros do SQL insert
				
				insereSt.setString(1, fap.getEndereco().getBairro());
				insereSt.setString(2, fap.getEndereco().getCep());
				insereSt.setString(3, fap.getEndereco().getCidade());
				insereSt.setString(4, fap.getEndereco().getEstado());
				insereSt.setInt(5, fap.getEndereco().getNumero());
				insereSt.setString(6, fap.getEndereco().getReferencia());
				insereSt.setString(7, fap.getEndereco().getRua());
				insereSt.setString(8, fap.getAcessoServicos().getQsus());
				
				// executa SQL insert
				insereSt.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao incluir o endereço mensagem:" + e);
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
		
		public void salvarInfoMedicas(FormularioAcompanhamentoPsicossocial fap) {
			// abre a conexao com o banco de dados MYSQL
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL insert
			PreparedStatement insereSt = null;
			// SQL de inserção
			String sqlInfoMedicas		 = "insert into infomedicas(alergia, contatoSOS, qalergia, qmedicacao, tipoSangue)" +
			 	       					   "values (?, ?, ?, ?, ?, ?)";
			try {
				// recebe o SQL insert
				insereSt = conexao.prepareStatement(sqlInfoMedicas);
				// recebe o parâmtros do SQL insert
				
				insereSt.setBoolean(1, fap.getInfoMedicas().isAlergia());
				insereSt.setString(2, fap.getInfoMedicas().getContatoSOS());
				insereSt.setString(3, fap.getInfoMedicas().getQalergia());
				insereSt.setString(4, fap.getInfoMedicas().getQmedicacao());
				insereSt.setString(5, fap.getInfoMedicas().getTipoSangue());
				
				// executa SQL insert
				insereSt.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao incluir informações medicas mensagem:" + e);
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
		
		public void salvarInfoTransporte(FormularioAcompanhamentoPsicossocial fap) {
			// abre a conexao com o banco de dados MYSQL
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL insert
			PreparedStatement insereSt = null;
			// SQL de inserção
			String sqlInfoTransporte 	 = "insert into infotransporte(cartao, transporte, qtransporte)" +
										   "values (?, ?, ?)";
			try {
				// recebe o SQL insert
				insereSt = conexao.prepareStatement(sqlInfoTransporte);
				// recebe o parâmtros do SQL insert
				
				insereSt.setString(1, fap.getInfoTransporte().getCartão());
				insereSt.setBoolean(2, fap.getInfoTransporte().isTransporte());
				insereSt.setString(3, fap.getInfoTransporte().getQtransporte());
				
				// executa SQL insert
				insereSt.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao incluir informaçõe de transporte mensagem:" + e);
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
		
		public void salvarProgramasBeneficios(FormularioAcompanhamentoPsicossocial fap) {
			// abre a conexao com o banco de dados MYSQL
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL insert
			PreparedStatement insereSt = null;
			// SQL de inserção
			String sqlProgramasBeneficios= "insert into programasbeneficios(beneficiohabitacional, outro, possuiar, possuibp, possui pbc, possui pbf, possuipibc)" +
					   					   "values (?, ?, ?, ?, ?, ?, ?)";
			try {
				// recebe o SQL insert
				insereSt = conexao.prepareStatement(sqlProgramasBeneficios);
				// recebe o parâmtros do SQL insert
				
				insereSt.setString(1, fap.getProgramasBeneficios().getBeneficioHabitacional());
				insereSt.setString(2, fap.getProgramasBeneficios().getOutro());
				insereSt.setBoolean(3, fap.getProgramasBeneficios().isPossuiar());
				insereSt.setBoolean(4, fap.getProgramasBeneficios().isPossuibp());
				insereSt.setBoolean(5, fap.getProgramasBeneficios().isPossuipbc());
				insereSt.setBoolean(6, fap.getProgramasBeneficios().isPossuipbf());
				insereSt.setBoolean(7, fap.getProgramasBeneficios().isPossuipibc());
				
				// executa SQL insert
				insereSt.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao incluir programas e beneficios mensagem:" + e);
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
		
		public void salvarPublicoPrioritario(FormularioAcompanhamentoPsicossocial fap) {
			// abre a conexao com o banco de dados MYSQL
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL insert
			PreparedStatement insereSt = null;
			// SQL de inserção
			String sqlPublicoPrioritario = "insert into publicoprioritario(abuso, acolhimento, defasagem, eca, egressos, isolamento, mse, rua, trabinfatil, vivencia, vulnerabilidade)" +
										   "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				// recebe o SQL insert
				insereSt = conexao.prepareStatement(sqlPublicoPrioritario);
				// recebe o parâmtros do SQL insert
				
				insereSt.setBoolean(1, fap.getPublicoPrioritario().isAbuso());
				insereSt.setBoolean(2, fap.getPublicoPrioritario().isAcolimento());
				insereSt.setBoolean(3, fap.getPublicoPrioritario().isDefasagem());
				insereSt.setBoolean(4, fap.getPublicoPrioritario().isEca());
				insereSt.setBoolean(5, fap.getPublicoPrioritario().isEgressos());
				insereSt.setBoolean(6, fap.getPublicoPrioritario().isIsolamento());
				insereSt.setBoolean(7, fap.getPublicoPrioritario().isMse());
				insereSt.setBoolean(8, fap.getPublicoPrioritario().isRua());
				insereSt.setBoolean(9, fap.getPublicoPrioritario().isTrabInfantil());
				insereSt.setBoolean(10, fap.getPublicoPrioritario().isVivencia());
				insereSt.setBoolean(11, fap.getPublicoPrioritario().isVulnerabilidade());
				
				// executa SQL insert
				insereSt.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao incluir publico prioritario mensagem:" + e);
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
		
		public void salvarRematricula(FormularioAcompanhamentoPsicossocial fap) {
			// abre a conexao com o banco de dados MYSQL
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL insert
			PreparedStatement insereSt = null;
			// SQL de inserção
			String sqlRematricula = "insert into rematricula(familiarresponsavel, tecnicoresponsavel) value (? ?);";
			try {
				insereSt.setString(1, fap.getRematricula().getFamiliarResponsavel());
				insereSt.setString(2, fap.getRematricula().getTecnicoResponsavel());

				// executa SQL insert
				insereSt.executeUpdate();
				
				//pega o resto dos dados
				List<Integer> anosR = fap.getRematricula().getAnos();
				List<java.util.Date> datas = fap.getRematricula().getDatas();
				List<String> responsaveis = fap.getRematricula().getResponsaveis();
				for (int i = 0; i<=anosR.size(); i++){
					sqlRematricula = "insert into rematricula(ano, data, responsavel) values(?, ?, ?);";
					// recebe o SQL insert
					insereSt = conexao.prepareStatement(sqlRematricula);
					
					insereSt.setInt(1, fap.getRematricula().getAnos().get(i));
					insereSt.setDate(1, (Date) fap.getRematricula().getDatas().get(i));
					insereSt.setString(1, fap.getRematricula().getResponsaveis().get(i));

					// executa SQL insert
					insereSt.executeUpdate();
				}
				
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao incluir rematricula mensagem:" + e);
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
		public FormularioAcompanhamentoPsicossocial getFormularioAcompanhamentoPsicossocial(int idFormularioAcompanhamentoPsicossocial) {
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
					fap.setDataNasc(resultado.getDate("dataNasc"));
					fap.setDescConvenio(resultado.getString("descConvenio"));
					fap.setEndereco(EnderecoCrudJDBC.getEndereco(resultado.getInt("idEndereco")));
					fap.setNome(resultado.getString("nome"));
					fap.setPossuiConvenio(resultado.getBoolean("possuiConvenio"));
					fap.setTelefone(resultado.getInt("telefone"));
					fap.setTipoSangue(resultado.getString("tipoSangue"));
					fap.setNivelFormularioAcompanhamentoPsicossocial(resultado.getInt("nivelFormularioAcompanhamentoPsicossocial"));
					fap.setObs(resultado.getString("obs"));
					fap.setMatriculaEscola(resultado.getString("matriculaEscola"));
					fap.setNivelEscolaridade(resultado.getInt("nivelEscolaridade"));
					fap.setNomeResponsavel(resultado.getString("nomeResponsavel"));
					fap.setTelefoneEscola(resultado.getString("telefoneEscola"));
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
			return fapo;
		}

		/*
		 * Objetivo: Método que lista todos os faps do banco de dados
		 */
		public List<FormularioAcompanhamentoPsicossocial> listar() {
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
					if (resultado.getInt("tipoFormularioAcompanhamentoPsicossocial")==Integer.parseInt(Tipo.FormularioAcompanhamentoPsicossocialInstitucional + "")){
						FormularioAcompanhamentoPsicossocialInstituicao fap = new FormularioAcompanhamentoPsicossocialInstituicao();
						fap.setDataNasc(resultado.getDate("dataNasc"));
						fap.setDescConvenio(resultado.getString("descConvenio"));
						fap.setEndereco(EnderecoCrudJDBC.getEndereco(resultado.getInt("idEndereco")));
						fap.setNome(resultado.getString("nome"));
						fap.setPossuiConvenio(resultado.getBoolean("possuiConvenio"));
						fap.setTelefone(resultado.getInt("telefone"));
						fap.setTipoSangue(resultado.getString("tipoSangue"));
						fap.setNivelFormularioAcompanhamentoPsicossocial(resultado.getInt("nivelFormularioAcompanhamentoPsicossocial"));
						fap.setObs(resultado.getString("obs"));
						Integer.parseInt(Tipo.FormularioAcompanhamentoPsicossocialInstitucional + "");
						fap.setMatriculaEscola(resultado.getString("matriculaEscola"));
						fap.setNivelEscolaridade(resultado.getInt("nivelEscolaridade"));
						fap.setNomeResponsavel(resultado.getString("nomeResponsavel"));
						fap.setTelefoneEscola(resultado.getString("telefoneEscola"));
						// insere o fap na lista
						faps.add(fap);
						
					}
					else if (resultado.getInt("tipoFormularioAcompanhamentoPsicossocial")==Integer.parseInt(Tipo.FormularioAcompanhamentoPsicossocialPago + "")){
						FormularioAcompanhamentoPsicossocialPago fap = new FormularioAcompanhamentoPsicossocialPago();
						fap.setDataNasc(resultado.getDate("dataNasc"));
						fap.setDescConvenio(resultado.getString("descConvenio"));
						fap.setEndereco(EnderecoCrudJDBC.getEndereco(resultado.getInt("idEndereco")));
						fap.setNome(resultado.getString("nome"));
						fap.setPossuiConvenio(resultado.getBoolean("possuiConvenio"));
						fap.setTelefone(resultado.getInt("telefone"));
						fap.setTipoSangue(resultado.getString("tipoSangue"));
						fap.setNivelFormularioAcompanhamentoPsicossocial(resultado.getInt("nivelFormularioAcompanhamentoPsicossocial"));
						fap.setObs(resultado.getString("obs"));
						Integer.parseInt(Tipo.FormularioAcompanhamentoPsicossocialInstitucional + "");
						fap.setDiaDePagamento(resultado.getInt("diaDePagamento"));
						fap.setPacote(resultado.getInt("tipoPacote"));
						// insere o fap na lista
						faps.add(fap);
						
					}

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
			return faps;
		}
		
		
		/*
		 * Objetivo: Método que lista todos os faps que pagam do banco de dados
		 */
		public List<FormularioAcompanhamentoPsicossocialPago> listarPago() {
			// abre conexao com o banco de dados
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// variavel lista de faps
			List<FormularioAcompanhamentoPsicossocialPago> faps = new ArrayList<FormularioAcompanhamentoPsicossocialPago>();
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
					if (resultado.getInt("tipoFormularioAcompanhamentoPsicossocial")==Integer.parseInt(Tipo.FormularioAcompanhamentoPsicossocialPago + "")){
						FormularioAcompanhamentoPsicossocialPago fap = new FormularioAcompanhamentoPsicossocialPago();
						fap.setDataNasc(resultado.getDate("dataNasc"));
						fap.setDescConvenio(resultado.getString("descConvenio"));
						fap.setEndereco(EnderecoCrudJDBC.getEndereco(resultado.getInt("idEndereco")));
						fap.setNome(resultado.getString("nome"));
						fap.setPossuiConvenio(resultado.getBoolean("possuiConvenio"));
						fap.setTelefone(resultado.getInt("telefone"));
						fap.setTipoSangue(resultado.getString("tipoSangue"));
						fap.setNivelFormularioAcompanhamentoPsicossocial(resultado.getInt("nivelFormularioAcompanhamentoPsicossocial"));
						fap.setObs(resultado.getString("obs"));
						Integer.parseInt(Tipo.FormularioAcompanhamentoPsicossocialInstitucional + "");
						fap.setDiaDePagamento(resultado.getInt("diaDePagamento"));
						fap.setPacote(resultado.getInt("tipoPacote"));
						// insere o fap na lista
						faps.add(fap);
						
					}
					
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
			return faps;
		}

		/*
		 * Objetivo: Método que lista todos os faps institucionais do banco de dados
		 */
		public List<FormularioAcompanhamentoPsicossocialInstituicao> listarInstituicao() {
			// abre conexao com o banco de dados
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// variavel lista de faps
			List<FormularioAcompanhamentoPsicossocialInstituicao> faps = new ArrayList<FormularioAcompanhamentoPsicossocialInstituicao>();
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
					if (resultado.getInt("tipoFormularioAcompanhamentoPsicossocial")==Integer.parseInt(Tipo.FormularioAcompanhamentoPsicossocialInstitucional+"")){
						FormularioAcompanhamentoPsicossocialInstituicao fap = new FormularioAcompanhamentoPsicossocialInstituicao();
						fap.setDataNasc(resultado.getDate("dataNasc"));
						fap.setDescConvenio(resultado.getString("descConvenio"));
						fap.setEndereco(EnderecoCrudJDBC.getEndereco(resultado.getInt("idEndereco")));
						fap.setNome(resultado.getString("nome"));
						fap.setPossuiConvenio(resultado.getBoolean("possuiConvenio"));
						fap.setTelefone(resultado.getInt("telefone"));
						fap.setTipoSangue(resultado.getString("tipoSangue"));
						fap.setNivelFormularioAcompanhamentoPsicossocial(resultado.getInt("nivelFormularioAcompanhamentoPsicossocial"));
						fap.setObs(resultado.getString("obs"));
						Integer.parseInt(Tipo.FormularioAcompanhamentoPsicossocialInstitucional + "");
						fap.setMatriculaEscola(resultado.getString("matriculaEscola"));
						fap.setNivelEscolaridade(resultado.getInt("nivelEscolaridade"));
						fap.setNomeResponsavel(resultado.getString("nomeResponsavel"));
						fap.setTelefoneEscola(resultado.getString("telefoneEscola"));
						// insere o fap na lista
						faps.add(fap);
						
					}
					
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
			return faps;
		}

		/*
		 * Objetivo: Método que salva um fap no banco de dados
		 */
		public void excluir(FormularioAcompanhamentoPsicossocial fap) {
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

		public void alterar(FormularioAcompanhamentoPsicossocial fap) {
			// abre a conexao com o banco de dados MYSQL
			Connection conexao = ConectaPostgreSQL.geraConexao();
			// Objeto para executar o SQL update
			PreparedStatement insereSt = null;
			// SQL de inserção
			String sql = "update fap set dataNasc=?, descConvenio=?, idEndereco=?, nome=?, "
					+ "					   possuiConvenio=?, telefone=?, tipoSangue=?, nivelFormularioAcompanhamentoPsicossocial=?, "
					+ "					   obs=?, tipoFormularioAcompanhamentoPsicossocial=?, matriculaEscola=?, nivelEscolaridade=?, "
					+ "					   nomeResponsavel=?, telefoneEscola=?, diaDePagamento=?, tipoPacote=?";
			try {
				// recebe o SQL update
				insereSt = conexao.prepareStatement(sql);
				if(fap.getTipoFormularioAcompanhamentoPsicossocial()== Tipo.FormularioAcompanhamentoPsicossocialInstitucional){
					FormularioAcompanhamentoPsicossocialInstituicao fap= (FormularioAcompanhamentoPsicossocialInstituicao) fap;
					// recebe o parâmtros do SQL update
					insereSt.setDate(1, (Date) fap.getDataNasc());
					insereSt.setString(2, fap.getDescConvenio());
					insereSt.setInt(3, fap.getEndereco().getId());
					insereSt.setString(4, fap.getNome());
					insereSt.setBoolean(5, fap.isPossuiConvenio());
					insereSt.setInt(6, fap.getTelefone());
					insereSt.setString(7, fap.getTipoSangue());
					insereSt.setInt(8, fap.getNivelFormularioAcompanhamentoPsicossocial());
					insereSt.setString(9, fap.getObs());
					insereSt.setInt(10, Integer.parseInt(Tipo.FormularioAcompanhamentoPsicossocialInstitucional + ""));
					insereSt.setString(11, fap.getMatriculaEscola());
					insereSt.setInt(12, fap.getNivelEscolaridade());
					insereSt.setString(13, fap.getNomeResponsavel());
					insereSt.setString(14, fap.getTelefoneEscola());
					insereSt.setObject(15, null);
					insereSt.setObject(16, null);
					
				}
				else if (fap.getTipoFormularioAcompanhamentoPsicossocial()== Tipo.FormularioAcompanhamentoPsicossocialPago){
					FormularioAcompanhamentoPsicossocialPago fapP= (FormularioAcompanhamentoPsicossocialPago) fap;
					// recebe o parâmtros do SQL update
					insereSt.setDate(1, (Date) fapP.getDataNasc());
					insereSt.setString(2, fapP.getDescConvenio());
					insereSt.setInt(3, fapP.getEndereco().getId());
					insereSt.setString(4, fapP.getNome());
					insereSt.setBoolean(5, fapP.isPossuiConvenio());
					insereSt.setInt(6, fapP.getTelefone());
					insereSt.setString(7, fapP.getTipoSangue());
					insereSt.setInt(8, fapP.getNivelFormularioAcompanhamentoPsicossocial());
					insereSt.setString(9, fapP.getObs());
					insereSt.setInt(10, Integer.parseInt(Tipo.FormularioAcompanhamentoPsicossocialPago + ""));
					insereSt.setObject(11, null);
					insereSt.setObject(12, null);
					insereSt.setObject(13, null);
					insereSt.setObject(14, null);
					insereSt.setInt(15, fapP.getDiaDePagamento());
					insereSt.setInt(16, fapP.getPacote());
				}
				// executa SQL update
				insereSt.executeUpdate();
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
