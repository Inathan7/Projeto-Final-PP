package view.projetos.relatorios;

public class DiretorRelatorio {
	
	private MontadorRelatorioProjeto montador;
	
	public DiretorRelatorio(MontadorRelatorioProjeto montadorRelatorioProjeto) {
		this.montador = montadorRelatorioProjeto;
	}
	
//	public void montar() {
//		montador.gerarRelatorio();
//		montador.contruirInterface();
//		
//	}
	
//	public StringBufferHTML getProdutoHTML(){
//		RelatorioProjetoHTML relatorio = null;
//		if(montador instanceof RelatorioProjetoHTML){
//			relatorio = (RelatorioProjetoHTML) montador;
//		}
//		return relatorio.getProduto();
//	}
//	public SwingJPanel getProdutoSwing(){
//		RelatorioProjetoSwing relatorio = null;
//		if(montador instanceof RelatorioProjetoSwing){
//			relatorio = (RelatorioProjetoSwing) montador;
//		}
//		return relatorio.getProduto();
//	}
	
	// Nova Versão
	
	public void gerarRelatorioCompleto() {
		montador.gerarRelatorioEdital();
		montador.gerarRelatorioGrupo();
		montador.gerarRelatorioProjeto();
	}
}
