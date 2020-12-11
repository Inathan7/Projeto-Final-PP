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

	public void gerarRelatorioCompletoEdital(ArrayList<Edital> editais) {
		montador.gerarRelatorioCompletoEdital(editais);
	}

	public void gerarRelatorioCompletoGrupo(ArrayList<Grupo> grupos) {
		montador.gerarRelatorioCompletoGrupo(grupos);
	}

	public void gerarRelatorioCompletoProjeto(ArrayList<Projeto> projetos) {
		montador.gerarRelatorioCompletoProjeto(projetos);
	}
	
	public void gerarRelatorioParcialGrupo(ArrayList<Grupo> grupos) {
		montador.gerarRelatorioParcialGrupo(grupos);
	}
	
	public void gerarRelatorioParcialEdital(ArrayList<Edital> editais) {
		montador.gerarRelatorioParcialEdital(editais);
	}
	
	public void gerarRelatorioParcialProjeto(ArrayList<Projeto> projetos) {
		montador.gerarRelatorioParcialProjeto(projetos);
	}
	
	public void construirInterface() {
		montador.construirInterface();
	}

}
