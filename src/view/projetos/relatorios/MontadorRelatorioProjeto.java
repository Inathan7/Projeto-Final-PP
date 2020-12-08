package view.projetos.relatorios;

import model.projetos.Edital;
import model.projetos.Grupo;
import model.projetos.Projeto;

public interface MontadorRelatorioProjeto {
	
//	public void gerarRelatorio();
//
//	public void contruirInterface();
	
	// Nova Versão
	
	public String gerarRelatorioEdital();
	
	public String gerarRelatorioGrupo();
	
	public String gerarRelatorioProjeto();
	
}
