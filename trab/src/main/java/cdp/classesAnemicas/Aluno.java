package cdp.classesAnemicas;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Aluno {
	private int id;
	private String foto;
	private int nivel;
	private Turma turma;
	private DadosPessoais dadosPessoais;
	private Endereco endereco;
	private AcompanhamentoEscolar acompanhamentoEscolar;
	private InfoMedicas InfoMedicas;
	private InfoTransporte infoTransporte;
	private ComposicaoFamiliar composicaoFamiliar;
	private Despesas despesas;
	private CondicoesMoradia condicoesMoradia;
	private AcessoServicos acessoServicos;
	private ProgramasBeneficios programasBeneficios;
	private PublicoPrioritario publicoPrioritario;
	private Parente parente = new Parente();
	public ArrayList<Parente> parentes = new ArrayList<Parente>();
	
	
	public Parente getParente() {
		return parente;
	}

	public void setParente(Parente parente) {
		this.parente = parente;
	}

	public void setParentes(ArrayList<Parente> parentes) {
		this.parentes = parentes;
	}

	
	private boolean edita;
	
	public void setParentes(Parente parente)
	{
		parentes.add(parente);
	}
	
	public ArrayList<Parente> getParentes()
	{
		return this.parentes;
		
	}

	public Aluno() {

		this.setId(-1);
		// this.aluno.setFap(null);
		this.setFoto("");
		this.setNivel(0);
		this.setTurma(new Turma());
		this.setAcessoServicos(new AcessoServicos());
		this.setAcompanhamentoEscolar(new AcompanhamentoEscolar());
		this.setEndereco(new Endereco());
		this.setComposicaoFamiliar(new ComposicaoFamiliar());
		this.setCondicoesMoradia(new CondicoesMoradia());
		this.setDadosPessoais(new DadosPessoais());
		this.setDespesas(new Despesas());
		this.setInfoMedicas(new InfoMedicas());
		this.setInfoTransporte(new InfoTransporte());
		this.setProgramasBeneficios(new ProgramasBeneficios());
		this.setPublicoPrioritario(new PublicoPrioritario());
		this.setEdita(false);

	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Turma getTurma() {
		if (this.turma == null){
			return new Turma();
		}
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}

	public void setDadosPessoais(DadosPessoais dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public AcompanhamentoEscolar getAcompanhamentoEscolar() {
		return acompanhamentoEscolar;
	}

	public void setAcompanhamentoEscolar(AcompanhamentoEscolar acompanhamentoEscolar) {
		this.acompanhamentoEscolar = acompanhamentoEscolar;
	}

	public InfoMedicas getInfoMedicas() {
		return InfoMedicas;
	}

	public void setInfoMedicas(InfoMedicas infoMedicas) {
		InfoMedicas = infoMedicas;
	}

	public InfoTransporte getInfoTransporte() {
		return infoTransporte;
	}

	public void setInfoTransporte(InfoTransporte infoTransporte) {
		this.infoTransporte = infoTransporte;
	}

	public ComposicaoFamiliar getComposicaoFamiliar() {
		return composicaoFamiliar;
	}

	public void setComposicaoFamiliar(ComposicaoFamiliar composicaoFamiliar) {
		this.composicaoFamiliar = composicaoFamiliar;
	}

	public Despesas getDespesas() {
		return despesas;
	}

	public void setDespesas(Despesas despesas) {
		this.despesas = despesas;
	}

	public CondicoesMoradia getCondicoesMoradia() {
		return condicoesMoradia;
	}

	public void setCondicoesMoradia(CondicoesMoradia condicoesMoradia) {
		this.condicoesMoradia = condicoesMoradia;
	}

	public AcessoServicos getAcessoServicos() {
		return acessoServicos;
	}

	public void setAcessoServicos(AcessoServicos acessoServicos) {
		this.acessoServicos = acessoServicos;
	}

	public ProgramasBeneficios getProgramasBeneficios() {
		return programasBeneficios;
	}

	public void setProgramasBeneficios(ProgramasBeneficios programasBeneficios) {
		this.programasBeneficios = programasBeneficios;
	}

	public PublicoPrioritario getPublicoPrioritario() {
		return publicoPrioritario;
	}

	public void setPublicoPrioritario(PublicoPrioritario publicoPrioritario) {
		this.publicoPrioritario = publicoPrioritario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isEdita() {
		return edita;
	}

	public void setEdita(boolean edita) {
		this.edita = edita;
	}

}
