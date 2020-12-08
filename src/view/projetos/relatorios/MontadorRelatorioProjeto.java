package view.projetos.relatorios;

public interface MontadorRelatorioProjeto {
	
	public String gerarRelatorioEdital();
	
	public String gerarRelatorioGrupo();
	
	public String gerarRelatorioProjeto();
	
	public void contruirInterface(String relatorio);
	
}
