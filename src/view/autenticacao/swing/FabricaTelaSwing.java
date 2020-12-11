package view.autenticacao.swing;

import view.autenticacao.FabricaTela;
import view.autenticacao.TelaAutenticacao;
import view.autenticacao.TelaConfiguracaoAdmin;
import view.autenticacao.TelaCriarConta;
import view.projetos.TelaCadastroEditais;
import view.projetos.TelaCadastroGrupos;
import view.projetos.TelaCadastroProjetos;
import view.projetos.TelaEscolherTipoRelatorio;
import view.projetos.TelaJustificativaPonto;
import view.projetos.TelaPonto;
import view.projetos.TelaPrincipal;
import view.projetos.swing.TelaEscolherTipoRelatorioSwing;
import view.projetos.swing.TelaJustificativaPontoSwing;
import view.projetos.swing.TelaPontoSwing;
import view.projetos.swing.TelaPrincipalSwing;
import view.projetos.swing.edital.TelaCadastrarEditaisSwing;
import view.projetos.swing.grupo.TelaCadastroGruposSwing;
import view.projetos.swing.projeto.TelaCadastrarProjetosSwing;

public class FabricaTelaSwing implements FabricaTela {

	@Override
	public TelaAutenticacao fabricarTelaAutenticacao() {
		return new TelaAutenticacaoSwing();
	}

	@Override
	public TelaCriarConta fabricarTelaCriarConta() {
		return new TelaCriarContaSwing();
	}

	@Override
	public TelaConfiguracaoAdmin fabricarTelaConfiguracaoAdmin() {
		return new TelaConfiguracaoAdminSwing();
	}

	@Override
	public TelaJustificativaPonto fabricarTelaJustificativaPonto() {
		return new TelaJustificativaPontoSwing();
	}

	@Override
	public TelaCadastroEditais fabricarTelaCadastrarEditais() {
		return new TelaCadastrarEditaisSwing();
	}

	@Override
	public TelaCadastroGrupos fabricarTelaCadastroGrupos() {
		return new TelaCadastroGruposSwing();
	}

	@Override
	public TelaCadastroProjetos fabricarTelaCadastroProjetos() {
		return new TelaCadastrarProjetosSwing();
	}

	@Override
	public TelaPonto fabricarTelaPonto() {
		return new TelaPontoSwing();
	}

	@Override
	public TelaPrincipal fabricarTelaPrincipal() {
		return new TelaPrincipalSwing();
	}

	@Override
	public TelaEscolherTipoRelatorio fabricarTelaEscolherTipoRelatorio() {
		return new TelaEscolherTipoRelatorioSwing();
	}

}
