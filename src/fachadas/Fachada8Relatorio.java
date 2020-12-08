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



	public void relatorioSwing() {
		RelatorioProjetoSwing relatorioSwing = new RelatorioProjetoSwing();
		DiretorRelatorio diretor = new DiretorRelatorio(relatorioSwing);
		diretor.gerarRelatorioCompleto();
		SwingJPanel produtoSwing = relatorioSwing.getProduto();
		produtoSwing.mostrarJPanel();
	}

	public void relatorioHTML() {
		RelatorioProjetoHTML relatorioHTML = new RelatorioProjetoHTML(new File("RelatorioHTML.html"), "");
		DiretorRelatorio diretor = new DiretorRelatorio(relatorioHTML);
		diretor.gerarRelatorioCompleto();
		StringBufferHTML produtoHTML = relatorioHTML.getProduto();
		produtoHTML.mostrarHTML();
	}

}
