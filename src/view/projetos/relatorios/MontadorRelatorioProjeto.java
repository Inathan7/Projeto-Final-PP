package view.projetos.relatorios;

import java.util.ArrayList;

import model.projetos.Edital;
import model.projetos.Grupo;
import model.projetos.Projeto;

public interface MontadorRelatorioProjeto {

	public String gerarRelatorioCompletoEdital(ArrayList<Edital> editais);

	public String gerarRelatorioCompletoGrupo(ArrayList<Grupo> grupos);

	public String gerarRelatorioCompletoProjeto(ArrayList<Projeto> projetos);

	public String gerarRelatorioParcialEdital(ArrayList<Edital> editais);

	public String gerarRelatorioParcialGrupo(ArrayList<Grupo> grupos);

	public String gerarRelatorioParcialProjeto(ArrayList<Projeto> projetos);

	public void construirInterface();

}
