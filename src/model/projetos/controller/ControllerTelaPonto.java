package model.projetos.controller;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import model.projetos.Projeto;
import model.projetos.ponto.InterfaceAcessoRemotoPonto;

public class ControllerTelaPonto {
	
	public void conectarProxy (Projeto projeto, String login) {
		//TODO t� dando erro nessa parte do RMI do IP, ser� que � 
		//melhor deixar autom�tico igual ao RegistradorPontoCentral/Server?
		//Eu coloquei, mas n�o testei
		try {
			InterfaceAcessoRemotoPonto ponto = (InterfaceAcessoRemotoPonto) Naming.lookup("rmi://"+InetAddress.getLocalHost().getHostAddress()+":1090/PontoService");
			ponto.registrarPonto(projeto, login);
		} catch (MalformedURLException | RemoteException | NotBoundException error) {
			error.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
