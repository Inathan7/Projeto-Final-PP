package view.projetos.relatorios;

import java.util.ArrayList;

import model.projetos.Edital;
import model.projetos.Grupo;
import model.projetos.Projeto;

public class DiretorRelatorio {

	private MontadorRelatorioProjeto montador;

	public DiretorRelatorio(MontadorRelatorioProjeto montadorRelatorioProjeto) {
		this.montador = montadorRelatorioProjeto;
	}

	//TODO Dividir os métodos em gerarRelatorioEdital, gerarRelatorioProjeto e gerarRelatorioGrupo
	//Colocar o construieInterface como uma etapa de montagem.
	//Retirar códigos HTML

	public void gerarRelatorioEdital(ArrayList<Edital> editais) {
		montador.gerarRelatorioEdital(editais);
	}

	public void gerarRelatorioGrupo(ArrayList<Grupo> grupos) {
		montador.gerarRelatorioGrupo(grupos);
	}

	public void gerarRelatorioProjeto(ArrayList<Projeto> projetos) {
		montador.gerarRelatorioProjeto(projetos);
	}
	
	public void gerarRelatorioParcialGrupo() {
		
	}
	
	public void gerarRelatorioParcialEdital() {
		
	}
	
	public void gerarRelatorioParcialProjeto() {
		
	}
	
	public void construirInterface() {
		montador.construirInterface();
	}
	
//	public void gerarRelatorioCompleto() {
//		gerarRelatorioEdital();
//		gerarRelatorioGrupo();
//		gerarRelatorioProjeto();
//	}
	

//	public void gerarRelatorioCompleto() {
//		String relatorio = "";
//		relatorio += montador.gerarRelatorioEdital() + "<br/>";
//		relatorio += montador.gerarRelatorioGrupo() + "<br/>";
//		relatorio += montador.gerarRelatorioProjeto() + "<br/>";
//
//		montador.contruirInterface(relatorio);
//	}

}
