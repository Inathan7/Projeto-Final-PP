package model.projetos.ponto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import model.projetos.Projeto;

public interface InterfaceAcessoRemotoPonto extends Remote {
	
	public boolean registrarPonto(Projeto projeto, String login) throws RemoteException;
	
	public ArrayList<Projeto> getProjetosAtivos();
	
	public int horasTrabalhadasValidas(long dataInicio, long dataTermino, String login);
	
	public float deficitHoras(long dataInicio, long dataTermino, char[] login);
	
	public Set<PontoTrabalhado> getPontosInvalidos(char[] login);

	void justificarPontoInvalido(PontoTrabalhado ponto, HorarioPrevisto horario, ArrayList<TratadorDePontoIvalido> tratadores);
	//TODO Paulo - fiz algumas altera��es nos m�todos

}
