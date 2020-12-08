package view.projetos.relatorios;

public class DiretorRelatorio {
	
	private MontadorRelatorioProjeto montador;
	
	public DiretorRelatorio(MontadorRelatorioProjeto montadorRelatorioProjeto) {
		this.montador = montadorRelatorioProjeto;
	}
	
	public void gerarRelatorioCompleto() {
		String relatorio = "";
		relatorio += montador.gerarRelatorioEdital() + "<br/>";
		relatorio += montador.gerarRelatorioGrupo() + "<br/>";
		relatorio += montador.gerarRelatorioProjeto() + "<br/>";
		
		montador.contruirInterface(relatorio);
	}
}
