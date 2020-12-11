package controller;

import fachadas.Fachada8Relatorio;

public class ControllerRelatorio {
	
	Fachada8Relatorio fachadaRelatorio = new Fachada8Relatorio();
	
	public void gerarRelatorioEditalSwing() {
		fachadaRelatorio.relatorioEditalSwing();
	}
	
	public void gerarRelatorioGrupoSwing() {
		fachadaRelatorio.relatorioGrupoSwing();
	}
	
	public void gerarRelatorioProjetoSwing() {
		fachadaRelatorio.relatorioProjetoSwing();
	}
	

	public void gerarRelatorioEditalHTML() {
		fachadaRelatorio.relatorioEditalHTML();
	}
	
	public void gerarRelatorioGrupoHTML() {
		fachadaRelatorio.relatorioGrupoHTML();
	}
	
	public void gerarRelatorioProjetoHTML() {
		fachadaRelatorio.relatorioProjetoHTML();
	}
	
	
	public void gerarRelatorioEditalCompletoSwing() {
		fachadaRelatorio.relatorioEditalCompletoSwing();
	}
	
	public void gerarRelatorioGrupoCompletoSwing() {
		fachadaRelatorio.relatorioGrupoCompletoSwing();
	}
	
	public void gerarRelatorioProjetoCompletoSwing() {
		fachadaRelatorio.relatorioProjetoCompletoSwing();
	}
	

	public void gerarRelatorioEditalCompletoHTML() {
		fachadaRelatorio.relatorioEditalCompletoHTML();
	}
	
	public void gerarRelatorioGrupoCompletoHTML() {
		fachadaRelatorio.relatorioGrupoCompletoHTML();
	}
	
	public void gerarRelatorioProjetoCompletoHTML() {
		fachadaRelatorio.relatorioProjetoCompletoHTML();
	}
	
	

}
