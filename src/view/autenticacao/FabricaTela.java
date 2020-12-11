package view.autenticacao;

import view.projetos.TelaCadastroEditais;
import view.projetos.TelaCadastroGrupos;
import view.projetos.TelaCadastroProjetos;
import view.projetos.TelaEscolherTipoRelatorio;
import view.projetos.TelaJustificativaPonto;
import view.projetos.TelaPonto;
import view.projetos.TelaPrincipal;

public interface FabricaTela {
	
	public TelaAutenticacao fabricarTelaAutenticacao();
	
	public TelaCriarConta fabricarTelaCriarConta();
	
	public TelaConfiguracaoAdmin fabricarTelaConfiguracaoAdmin(); 
	
	public TelaJustificativaPonto fabricarTelaJustificativaPonto();
	
	public TelaCadastroEditais fabricarTelaCadastrarEditais();
	
	public TelaCadastroGrupos fabricarTelaCadastroGrupos(); 
	
	public TelaCadastroProjetos fabricarTelaCadastroProjetos();
	
	public TelaPonto fabricarTelaPonto();
	
	public TelaPrincipal fabricarTelaPrincipal();
	
	public TelaEscolherTipoRelatorio fabricarTelaEscolherTipoRelatorio();

}
