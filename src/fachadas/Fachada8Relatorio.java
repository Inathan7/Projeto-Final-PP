package fachadas;

import java.io.File;

import view.projetos.relatorios.DiretorRelatorio;
import view.projetos.relatorios.RelatorioProjetoHTML;
import view.projetos.relatorios.RelatorioProjetoSwing;
import view.projetos.relatorios.StringBufferHTML;
import view.projetos.relatorios.SwingJPanel;
/**
 * @author PAULO E INATHAN - TATAKAE!
 * Essa fachada é utilizada para gerar relatório
 */

public class Fachada8Relatorio {
	
	Fachada5Projeto fachadaProjeto = new Fachada5Projeto();
	Fachada4Edital fachadaEdital = new Fachada4Edital();
	Fachada3Grupo fachadaGrupo = new Fachada3Grupo();
	
	public void relatorioEditalSwing() {
		RelatorioProjetoSwing relatorioSwing = new RelatorioProjetoSwing();
		DiretorRelatorio diretor = new DiretorRelatorio(relatorioSwing);
		diretor.gerarRelatorioParcialEdital(fachadaEdital.getEditais());
		diretor.construirInterface();
		SwingJPanel produtoSwing = relatorioSwing.getProduto();
		produtoSwing.mostrarJPanel();
	}
	
	public void relatorioGrupoSwing() {
		RelatorioProjetoSwing relatorioSwing = new RelatorioProjetoSwing();
		DiretorRelatorio diretor = new DiretorRelatorio(relatorioSwing);
		diretor.gerarRelatorioParcialGrupo(fachadaGrupo.getGrupos());
		diretor.construirInterface();
		SwingJPanel produtoSwing = relatorioSwing.getProduto();
		produtoSwing.mostrarJPanel();
	}
	
	public void relatorioProjetoSwing() {
		RelatorioProjetoSwing relatorioSwing = new RelatorioProjetoSwing();
		DiretorRelatorio diretor = new DiretorRelatorio(relatorioSwing);
		diretor.gerarRelatorioParcialProjeto(Fachada5Projeto.getProjetosPersistidos());
		diretor.construirInterface();
		SwingJPanel produtoSwing = relatorioSwing.getProduto();
		produtoSwing.mostrarJPanel();
	}
	

	public void relatorioEditalHTML() {
		RelatorioProjetoHTML relatorioHTML = new RelatorioProjetoHTML(new File("RelatorioEditalHTML.html"), "");
		DiretorRelatorio diretor = new DiretorRelatorio(relatorioHTML);
		diretor.gerarRelatorioParcialEdital(fachadaEdital.getEditais());
		diretor.construirInterface();
		StringBufferHTML produtoHTML = relatorioHTML.getProduto();
		produtoHTML.mostrarHTML();
	}
	
	public void relatorioGrupoHTML() {
		RelatorioProjetoHTML relatorioHTML = new RelatorioProjetoHTML(new File("RelatorioGrupoHTML.html"), "");
		DiretorRelatorio diretor = new DiretorRelatorio(relatorioHTML);
		diretor.gerarRelatorioParcialGrupo(fachadaGrupo.getGrupos());
		diretor.construirInterface();
		StringBufferHTML produtoHTML = relatorioHTML.getProduto();
		produtoHTML.mostrarHTML();
	}
	
	public void relatorioProjetoHTML() {
		RelatorioProjetoHTML relatorioHTML = new RelatorioProjetoHTML(new File("RelatorioProjetoHTML.html"), "");
		DiretorRelatorio diretor = new DiretorRelatorio(relatorioHTML);
		diretor.gerarRelatorioParcialProjeto(Fachada5Projeto.getProjetosPersistidos());
		diretor.construirInterface();
		StringBufferHTML produtoHTML = relatorioHTML.getProduto();
		produtoHTML.mostrarHTML();
	}
	
	
	
	public void relatorioEditalCompletoSwing() {
		RelatorioProjetoSwing relatorioSwing = new RelatorioProjetoSwing();
		DiretorRelatorio diretor = new DiretorRelatorio(relatorioSwing);
		diretor.gerarRelatorioCompletoEdital(fachadaEdital.getEditais());
		diretor.construirInterface();
		SwingJPanel produtoSwing = relatorioSwing.getProduto();
		produtoSwing.mostrarJPanel();
	}
	
	public void relatorioGrupoCompletoSwing() {
		RelatorioProjetoSwing relatorioSwing = new RelatorioProjetoSwing();
		DiretorRelatorio diretor = new DiretorRelatorio(relatorioSwing);
		diretor.gerarRelatorioCompletoGrupo(fachadaGrupo.getGrupos());
		diretor.construirInterface();
		SwingJPanel produtoSwing = relatorioSwing.getProduto();
		produtoSwing.mostrarJPanel();
	}
	
	public void relatorioProjetoCompletoSwing() {
		RelatorioProjetoSwing relatorioSwing = new RelatorioProjetoSwing();
		DiretorRelatorio diretor = new DiretorRelatorio(relatorioSwing);
		diretor.gerarRelatorioCompletoProjeto(Fachada5Projeto.getProjetosPersistidos());
		diretor.construirInterface();
		SwingJPanel produtoSwing = relatorioSwing.getProduto();
		produtoSwing.mostrarJPanel();
	}
	

	public void relatorioEditalCompletoHTML() {
		RelatorioProjetoHTML relatorioHTML = new RelatorioProjetoHTML(new File("RelatorioEditalHTML.html"), "");
		DiretorRelatorio diretor = new DiretorRelatorio(relatorioHTML);
		diretor.gerarRelatorioCompletoEdital(fachadaEdital.getEditais());
		diretor.construirInterface();
		StringBufferHTML produtoHTML = relatorioHTML.getProduto();
		produtoHTML.mostrarHTML();
	}
	
	public void relatorioGrupoCompletoHTML() {
		RelatorioProjetoHTML relatorioHTML = new RelatorioProjetoHTML(new File("RelatorioGrupoHTML.html"), "");
		DiretorRelatorio diretor = new DiretorRelatorio(relatorioHTML);
		diretor.gerarRelatorioCompletoGrupo(fachadaGrupo.getGrupos());
		diretor.construirInterface();
		StringBufferHTML produtoHTML = relatorioHTML.getProduto();
		produtoHTML.mostrarHTML();
	}
	
	public void relatorioProjetoCompletoHTML() {
		RelatorioProjetoHTML relatorioHTML = new RelatorioProjetoHTML(new File("RelatorioProjetoHTML.html"), "");
		DiretorRelatorio diretor = new DiretorRelatorio(relatorioHTML);
		diretor.gerarRelatorioCompletoProjeto(Fachada5Projeto.getProjetosPersistidos());
		diretor.construirInterface();
		StringBufferHTML produtoHTML = relatorioHTML.getProduto();
		produtoHTML.mostrarHTML();
	}

}
