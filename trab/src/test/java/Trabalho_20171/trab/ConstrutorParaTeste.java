package Trabalho_20171.trab;

import cdp.classesAnemicas.*;

public class ConstrutorParaTeste {
	public static AcessoServicos criaAcesso(){
		AcessoServicos acesso = new AcessoServicos();
		acesso.setId(1);
		acesso.setPossuiacolhimento(true);
		acesso.setPossuicei(true);
		acesso.setPossuicras(true);
		acesso.setPossuicreas(true);
		acesso.setPossuiescola(true);
		acesso.setPossuiesf(true);
		acesso.setPossuisus(true);
		return acesso;
	}
	public static AcompanhamentoEscolar criaAcompanhamento(){
		AcompanhamentoEscolar acompanhamento = new AcompanhamentoEscolar();
		acompanhamento.setId(1);
	//	acompanhamento.setAnos(null);
        acompanhamento.setEscola("Teste");
    //    acompanhamento.setSeries(null);
		return acompanhamento;
	}
	public static Aula criaAula(){
		Aula aula = new Aula();
		aula.setId(1);
		aula.setConteudo("Teste");
		aula.setData(null);
		aula.setId(1);
		aula.setHorario(null);
		aula.setPresentes(null);
		aula.setTipo("Teste");
		return aula;
	}
	public static ComposicaoFamiliar criaComposicao(){
		ComposicaoFamiliar composicao = new ComposicaoFamiliar();
        composicao.setId(1);
        composicao.setParentes(null);
		return composicao;
	}
	public static CondicoesMoradia criaCondicoes(){
		CondicoesMoradia condicoes = new CondicoesMoradia();
        condicoes.setId(1);
        condicoes.setCondicao("Teste");
        condicoes.setPossuiagua(true);
        condicoes.setPossuicoleta(true);
        condicoes.setPossuienergia(true);
        condicoes.setPossuiesgoto(true);
        condicoes.setPossuirisco(true);
        condicoes.setQrisco("Teste");
		return condicoes;
	}
	public static DadosAcesso criaDadosAcesso(){
		DadosAcesso dadosAcesso = new DadosAcesso();
		dadosAcesso.setId(1);
		dadosAcesso.setEmail("teste@teste.com");
		dadosAcesso.setLembrar("Teste");
		dadosAcesso.setLogin("Teste");
		dadosAcesso.setSenha("teste");
		return dadosAcesso;
	}
	public static DadosPessoais criaDadosPessoais(){
		DadosPessoais dadosPessoais = new DadosPessoais();
        dadosPessoais.setId(1);
        dadosPessoais.setContato("0000000000");
        dadosPessoais.setDatNasc(null);
        dadosPessoais.setNis("Teste");
        dadosPessoais.setNome("Teste");
        dadosPessoais.setParentesco("Teste");
        dadosPessoais.setResponsavel("Teste");
        dadosPessoais.setSexo(0);
		return dadosPessoais;
	}
	public static Despesas criaDespesas(){
		Despesas despesas = new Despesas();
        despesas.setId(1);
        despesas.setAgua(13);
        despesas.setAlimentacao(13);
        despesas.setAluguel(13);
        despesas.setGas(13);
        despesas.setLuz(13);
        despesas.setMedicamentos(13);
        despesas.setOutros(13);
        despesas.setRendaTotal(13);
        despesas.setTelefone(13);
        
		return despesas;
	}
	public static Endereco criaEndereco(){
		Endereco endereco = new Endereco();
        endereco.setId(1);
        endereco.setBairro("Teste");
        endereco.setCep("Teste");
        endereco.setCidade("Teste");
        endereco.setEstado("Teste");
        endereco.setNumero(13);
        endereco.setReferencia("Teste");
        endereco.setRua("Teste");
		return endereco;
	}
	public static Aluno criaAluno(){
		Aluno aluno = new Aluno();
		aluno.setAcessoServicos(ConstrutorParaTeste.criaAcesso());
		aluno.setAcompanhamentoEscolar(ConstrutorParaTeste.criaAcompanhamento());
		aluno.setFoto("Teste");
		aluno.setComposicaoFamiliar(ConstrutorParaTeste.criaComposicao());
		aluno.setCondicoesMoradia(ConstrutorParaTeste.criaCondicoes());
		aluno.setDadosPessoais(ConstrutorParaTeste.criaDadosPessoais());
		aluno.setDespesas(ConstrutorParaTeste.criaDespesas());
		aluno.setEndereco(ConstrutorParaTeste.criaEndereco());
		aluno.setNivel(0);
		aluno.setId(1);
		aluno.setInfoMedicas(ConstrutorParaTeste.criaInfoMedicas());
		aluno.setInfoTransporte(ConstrutorParaTeste.criaInfoTransporte());
		aluno.setProgramasBeneficios(ConstrutorParaTeste.criaProgramasBeneficios());
		aluno.setPublicoPrioritario(ConstrutorParaTeste.criaPublicoPrioritario());
		aluno.setTurma(ConstrutorParaTeste.criaTurma());
		
		return aluno;
	}
	public static InfoMedicas criaInfoMedicas(){
		InfoMedicas infoMedicas = new InfoMedicas();
        infoMedicas.setId(1);
        infoMedicas.setAlergia(true);
        infoMedicas.setContatoSOS("0000000000");
        infoMedicas.setMedicacao(true);
        infoMedicas.setQalergia("Teste");
        infoMedicas.setQmedicacao("Teste");
        infoMedicas.setTipoSangue("Teste");
		return infoMedicas;
	}
	public static InfoTransporte criaInfoTransporte(){
		InfoTransporte infoTransporte = new InfoTransporte();
        infoTransporte.setId(1);
        infoTransporte.setCartao("Teste");
        infoTransporte.setQtransporte("Teste");
        infoTransporte.setTransporte(true);
		return infoTransporte;
	}
	public static ProgramasBeneficios criaProgramasBeneficios(){
		ProgramasBeneficios programasBeneficios = new ProgramasBeneficios();
        programasBeneficios.setBeneficioHabitacional("Teste");
        programasBeneficios.setId(1);
        programasBeneficios.setOutro("Teste");
        programasBeneficios.setPossuiar(true);
        programasBeneficios.setPossuibp(true);
        programasBeneficios.setPossuipbc(true);
        programasBeneficios.setPossuipbf(true);
        programasBeneficios.setPossuipibc(true);
		return programasBeneficios;
	}
	public static PublicoPrioritario criaPublicoPrioritario(){
		PublicoPrioritario publicoPrioritario = new PublicoPrioritario();
        publicoPrioritario.setAbuso(true);
        publicoPrioritario.setAcolimento(true);
        publicoPrioritario.setDefasagem(true);
        publicoPrioritario.setEca(true);
        publicoPrioritario.setEgressos(true);
        publicoPrioritario.setId(1);
        publicoPrioritario.setIsolamento(true);
        publicoPrioritario.setMse(true);
        publicoPrioritario.setRua(true);
        publicoPrioritario.setTrabInfantil(true);
        publicoPrioritario.setVivencia(true);
        publicoPrioritario.setVulnerabilidade(true);
		return publicoPrioritario;
	}
	
	public static Turma criaTurma(){
		Turma turma = new Turma();
		//turma.setAlunos(null);
		//turma.setAulas(null);
		turma.setCodigo("Teste");
		turma.setId(1);
		turma.setMaximo(13);
		turma.setNivel(0);
		turma.setSegunda(true);
		turma.setTerca(true);
		turma.setQuarta(true);
		turma.setQuinta(true);
		turma.setSexta(true);
		turma.setTurno("Teste");
		return turma;
	}
	
	public static TermoDesligamento criaTermoDesligamento(){
		TermoDesligamento termo = new TermoDesligamento();
		termo.setCpf("00000000000");
		termo.setId(1);
		termo.setMotivo("Teste");
		termo.setNomeResponsavel("Teste");
		termo.setNomeTecResponsavel("Teste");
		termo.setNomeUsuario("Teste");
		return termo;
	}
	public static Rematricula criaRematricula(){
		Rematricula rematricula = new Rematricula();
		rematricula.setId(1);
		rematricula.setNomeResponsavel("Teste");
		rematricula.setNomeTecResponsavel("Teste");
		return rematricula;
	}
	public static SituacaoAcolhimento criaSituacaoAcolhimento() {
		SituacaoAcolhimento situacao = new SituacaoAcolhimento();
		situacao.setContato("0000000000");
		situacao.setId(1);
		situacao.setMotivo("Teste");
		situacao.setNomeAcolhido("Teste");
		situacao.setNomeInstituicao("Teste");
		situacao.setResponsavelInstituicao("Teste");
		return situacao;
	}
	

}
