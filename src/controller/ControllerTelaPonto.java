package controller;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.apache.commons.mail.EmailException;

import fachadas.Fachada11BaterPonto;
import fachadas.Fachada2Autenticacao;
import model.autenticacao.TipoProvedorAutenticacao;
import model.projetos.Participacao;
import model.projetos.Projeto;
import model.projetos.ponto.InterfaceAcessoRemotoPonto;
import model.projetos.ponto.PontoTrabalhado;
import model.projetos.ponto.RegistradorPontoCentral;

public class ControllerTelaPonto {

	private InterfaceAcessoRemotoPonto ponto;

	private Fachada2Autenticacao fachadaAutenticacao = new Fachada2Autenticacao();
	private Fachada11BaterPonto fachadaBaterPonto = new Fachada11BaterPonto();

	public void  registrarPonto(Projeto projeto, String login) {
		fachadaBaterPonto.registrarPonto(projeto, login);
	}

	public void baterPonto(Participacao participacao,long dataHoraEntrada, long dataHoraSaida) {
		fachadaBaterPonto.baterPonto(participacao, dataHoraEntrada, dataHoraSaida);
	}

	public void autenticarContaEmailProvedor(String login, String senha, TipoProvedorAutenticacao provedor) throws EmailException {
		fachadaAutenticacao.autenticarContaEmailProvedor(login, senha, provedor);
	}

	public void conectarProxy (Projeto projeto, String login) {
		try {
			ponto = (InterfaceAcessoRemotoPonto) Naming.lookup("rmi://"+InetAddress.getLocalHost().getHostAddress()+":1099/PontoService");
			ponto.registrarPonto(projeto, login);
		} catch (MalformedURLException | RemoteException | NotBoundException error) {
			error.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public float deficitHoras(long dataInicio, long dataTermino, String login) {
		float retorno = 0;
		try {
			ponto = new RegistradorPontoCentral();
			retorno = ponto.deficitHoras(dataInicio, dataTermino, login);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}

	public int pontosInvalidos(String login) {
		int count = 0;
		try {
			ponto = new RegistradorPontoCentral();

			for (int i = 0; i < ponto.getPontosInvalidos(login).size(); i++) {
				count ++;
			}

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}
