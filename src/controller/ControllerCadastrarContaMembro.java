package controller;

import fachadas.Fachada1Membro;
import model.autenticacao.Conta;
import model.autenticacao.ContaAutenticacaoProvedorEmailSMTP;
import model.autenticacao.ContaAutenticacaoProvedorInterno;
import model.autenticacao.ContaEmail;
import model.autenticacao.ContaEmailIFPB;
import model.autenticacao.ContaEmailLivre;
import model.autenticacao.Membro;
import model.projetos.Participacao;
import model.projetos.Projeto;

public class ControllerCadastrarContaMembro {
	
	private Fachada1Membro fachadaMembro = new Fachada1Membro();
	private Membro membro;
	private Participacao participacao;
	private ContaEmail contaEmail;
	private Conta conta;
	
	public void addMembro(String email, long matricula, String nome, String login, String senha, String tipoConta) {
		
		membro = new Membro();
		membro.setAtivo(true);
		membro.setEmail(email);
		membro.setMatricula(matricula);
		membro.setNome(nome);
		membro.setParticipacao(participacao);
		
		if(tipoConta.equals("Livre")) {
			conta = new ContaAutenticacaoProvedorInterno();
			contaEmail = new ContaEmailLivre(conta);
		}else if(tipoConta.equals("IFPB")) {
			conta = new ContaAutenticacaoProvedorEmailSMTP();
			contaEmail = new ContaEmailIFPB(conta);
		}

		contaEmail.setLogin(login);
		contaEmail.setSenha(senha);
		
		fachadaMembro.adicionarMembroNoSistema(membro, contaEmail);

	}
	
	public void addParticipacao(Projeto projeto, float aporteCusteioMensalReais, short qtdMesesCusteados, short qtdMesesPagos) {
		participacao = new Participacao();
		participacao.setAporteCusteioMensalReais(aporteCusteioMensalReais);
		participacao.setAtivo(true);
		participacao.setCoordenador(membro.getAdministrador());
		participacao.setDataInicio(projeto.getDataInicio());
		participacao.setDataTermino(projeto.getDataTermino());
		participacao.setId(Fachada1Membro.getMembros().size()+1);
		participacao.setNome(membro.getNome());
		participacao.setQtdMesesCusteados(qtdMesesCusteados);
		participacao.setQtdMesesPagos(qtdMesesPagos);
		membro.setParticipacao(participacao);
		participacao.adicionar(projeto);
		fachadaMembro.atualizarMembro();
	}
	public Membro getMembro(){
		return membro;
	}
}
