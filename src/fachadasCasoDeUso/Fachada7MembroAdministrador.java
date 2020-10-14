package fachadasCasoDeUso;

import model.autenticacao.Membro;
import persistencia.xml.DAOXMLMembroConta;
/**
 * @author PAULO E INATHAN - TATAKAE!
 * Essa classe � uma fachada da membro administrador
 */
public class Fachada7MembroAdministrador {
	/**
	 * {@link #membroAdministrador}Esse atributo � o membro que vai ser administrador
	 */
	private Membro membroAdministrador;
	/**
	 * Esse � o construtor que seta o membro que vai ser administrador
	 * @param membroAdministrador: � o membro que vai ser o administrador
	 */
	public Fachada7MembroAdministrador(Membro membroAdministrador) {
		this.membroAdministrador = membroAdministrador;
	}
	/**
	 * Esse m�todo torna o membro como administrador
	 * @param membro: � o membro que vai se tornar administrador
	 */
	public void tornarMembroAdministrador(Membro membro) {
		if(membroAdministrador.getAdministrador() == true) {
			membro.setAdministrador(true);
		}
	}

}
