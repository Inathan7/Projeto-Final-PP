package model.autenticacao;

import java.util.ArrayList;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import fachadas.Fachada1Membro;

public class ContaAutenticacaoProvedorEmailSMTP extends Conta{
	
	private String provedorHost;
	private String provedorPorta;

	@Override
	public Membro autenticar(String login, String senha) throws EmailException { 
		
		SimpleEmail email = new SimpleEmail();
		email.setHostName(provedorHost);
		email.setSslSmtpPort(provedorPorta);
		email.setAuthenticator( new DefaultAuthenticator(login, senha) );
			email.setFrom(login);
			ArrayList<Membro> membrosList = Fachada1Membro.getMembros();
				for(Membro m: membrosList){
					if(m.getLogin().equals(login)&&
							m.getSenha().equals(senha)){
						return m;
					}
				}
		return null;
	}

	public String getProvedorHost() {
		return provedorHost;
	}

	public void setProvedorHost(String provedorHost) {
		this.provedorHost = provedorHost;
	}

	public String getProvedorPorta() {
		return provedorPorta;
	}

	public void setProvedorPorta(String provedorPorta) {
		this.provedorPorta = provedorPorta;
	}

}
