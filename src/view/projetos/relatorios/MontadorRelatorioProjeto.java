package view.projetos.relatorios;

import java.util.ArrayList;

import model.projetos.Edital;
import model.projetos.Grupo;
import model.projetos.Projeto;

public interface MontadorRelatorioProjeto {
	
	public String gerarRelatorioEdital(ArrayList<Edital> editais);
	
	public String gerarRelatorioGrupo(ArrayList<Grupo> grupos);
	
	public String gerarRelatorioProjeto(ArrayList<Projeto> projetos);
	
	public void construirInterface();
	
}
