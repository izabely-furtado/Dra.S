package main.test.java.onda;

import main.java.cdp.classesAnemicas.*;

public class ConstrutorParaTeste {
	
	
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
	

}
