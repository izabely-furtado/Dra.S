package main.test.java.onda;

import main.java.cdp.classesAnemicas.*;

public class ConstrutorParaTeste {
	public static AcessoServicos criaAcesso(){
		AcessoServicos acesso = new AcessoServicos();
		acesso.setId(0);
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
		acompanhamento.setId(0);
	//	acompanhamento.setAnos(null);
        acompanhamento.setEscola("Teste");
    //    acompanhamento.setSeries(null);
		return acompanhamento;
	}
	public static Aula criaAula(){
		Aula aula = new Aula();
		aula.setId(0);
		aula.setConteudo("Teste");
		aula.setData(null);
		aula.setId(0);
		aula.setHorario(null);
		aula.setPresentes(null);
		aula.setTipo("Teste");
		return aula;
	}
	public static ComposicaoFamiliar criaComposicao(){
		ComposicaoFamiliar composicao = new ComposicaoFamiliar();
        composicao.setId(0);
        composicao.setParentes(null);
		return composicao;
	}
	public static CondicoesMoradia criaCondicoes(){
		CondicoesMoradia condicoes = new CondicoesMoradia();
        condicoes.setId(0);
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
		dadosAcesso.setId(0);
		dadosAcesso.setEmail("teste@teste.com");
		dadosAcesso.setLembrar("Teste");
		dadosAcesso.setLogin("Teste");
		dadosAcesso.setSenha("teste");
		return dadosAcesso;
	}
	public static DadosPessoais criaDadosPessoais(){
		DadosPessoais dadosPessoais = new DadosPessoais();
        dadosPessoais.setId(0);
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
        despesas.setId(0);
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
        endereco.setId(0);
        endereco.setBairro("Teste");
        endereco.setCep("Teste");
        endereco.setCidade("Teste");
        endereco.setEstado("Teste");
        endereco.setNumero(13);
        endereco.setReferencia("Teste");
        endereco.setRua("Teste");
		return endereco;
	}
	public static FormularioAcompanhamentoPsicossocial criaFAP(){
		FormularioAcompanhamentoPsicossocial fap = new FormularioAcompanhamentoPsicossocial();
        fap.setAcessoServicos(ConstrutorParaTeste.criaAcesso());
        fap.setAcompanhamentoEscolar(ConstrutorParaTeste.criaAcompanhamento());
        fap.setAno(0);
        fap.setComposicaoFamiliar(ConstrutorParaTeste.criaComposicao());
        fap.setCondicoesMoradia(ConstrutorParaTeste.criaCondicoes());
        fap.setDadosPessoais(ConstrutorParaTeste.criaDadosPessoais());
        fap.setDespesas(ConstrutorParaTeste.criaDespesas());
        fap.setEndereco(ConstrutorParaTeste.criaEndereco());
        fap.setFormaAcesso(0);
        fap.setId(0);
        fap.setInfoMedicas(ConstrutorParaTeste.criaInfoMedicas());
        fap.setInfoTransporte(ConstrutorParaTeste.criaInfoTransporte());
        fap.setProgramasBeneficios(ConstrutorParaTeste.criaProgramasBeneficios());
        fap.setPublicoPrioritario(ConstrutorParaTeste.criaPublicoPrioritario());
        fap.setRematricula(null);
        fap.setTipo(0);
		
		return fap;
	}
	public static InfoMedicas criaInfoMedicas(){
		InfoMedicas infoMedicas = new InfoMedicas();
        infoMedicas.setId(0);
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
        infoTransporte.setId(0);
        infoTransporte.setCartão("Teste");
        infoTransporte.setQtransporte("Teste");
        infoTransporte.setTransporte(true);
		return infoTransporte;
	}
	public static ProgramasBeneficios criaProgramasBeneficios(){
		ProgramasBeneficios programasBeneficios = new ProgramasBeneficios();
        programasBeneficios.setBeneficioHabitacional("Teste");
        programasBeneficios.setId(0);
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
        publicoPrioritario.setId(0);
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
		turma.setAlunos(null);
		turma.setAulas(null);
		turma.setCodigo("Teste");
		turma.setId(0);
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
		termo.setId(0);
		termo.setMotivo("Teste");
		termo.setNomeResponsavel("Teste");
		termo.setNomeTecResponsavel("Teste");
		termo.setNomeUsuario("Teste");
		return termo;
	}
	public static Rematricula criaRematricula(){
		Rematricula rematricula = new Rematricula();
		rematricula.setId(0);
		rematricula.setNomeResponsavel("Teste");
		rematricula.setNomeTecResponsavel("Teste");
		return rematricula;
	}
	public static SituacaoAcolhimento criaSituacaoAcolhimento() {
		SituacaoAcolhimento situacao = new SituacaoAcolhimento();
		situacao.setContato("0000000000");
		situacao.setId(0);
		situacao.setMotivo("Teste");
		situacao.setNomeAcolhido("Teste");
		situacao.setNomeInstituicao("Teste");
		situacao.setResponsavelInstituicao("Teste");
		return situacao;
	}

}
