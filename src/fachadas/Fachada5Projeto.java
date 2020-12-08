package fachadas;

import java.util.ArrayList;

import exception.ExceptionMembroDuplicado;
import model.autenticacao.Membro;
import model.projetos.Projeto;
import persistenciaXML.DAOXMLProjetoParticipacao;

/**
 * @author PAULO e INATHAN - TATAKAE!
 *Fachada para a classe Projeto
 */
public class Fachada5Projeto {
	
	/**
	 * {@link #projetoParticipacao} Atributo que faz a persist�ncia
	 */
	private static DAOXMLProjetoParticipacao projetoParticipacao = new DAOXMLProjetoParticipacao();
	
	/**
	 * M�todo que cria o projeto e adiciona na persist�ncia
	 * @param projeto: esse par�metro � o projeto que vai ser adicionado
	 */
	public void adicionarProjeto(Projeto projeto) { 
		projetoParticipacao.criar(projeto);
	}	
	/**
	 * M�todo que remove o projeto da persist�ncia
	 * @param idProjeto: � o id do projeto para que possa achar o projeto e remove-lo
	 * @return: retorna true se for remover o projeto e false se n�o.
	 */
	public boolean removerProjeto(int idProjeto) {
		Projeto projeto = pesquisarProjeto(idProjeto);
		if(projeto.getMembros().size()>0){
			return false;
		}
		projetoParticipacao.remover(idProjeto);
		return true;
	}
	/**
	 * M�todo que atualiza os dados do projeto.
	 * @param projeto: � o projeto que vai ser atualizado na persist�ncia.
	 * @param idProjeto: � o id que onde o projeto vai ficar no HashMap da persist�ncia.
	 * @return: retorna true se atualizar o projeto e false se n�o.
	 */
	public void atualizarProjeto(){
		projetoParticipacao.atualizar();
	}
	/**
	 * M�todo que adiciona o Membro no projeto.
	 * @param membro: � o membro que vai ser adicionado no projeto.
	 * @param idDoProjeto: � o id do projeto que vai ser adicionado o membro.
	 * @return: retorna true se o membro for adicionado e false se n�o.
	 * @throws ExceptionMembroDuplicado 
	 */
	public void adicionarMembroNoProjeto(Membro membro, int idDoProjeto) throws ExceptionMembroDuplicado {
		
			// adiciona o membro para o projeto
			Projeto projeto = pesquisarProjeto(idDoProjeto);
				projeto.adicionarMembro(membro);
			projetoParticipacao.atualizar();
		
	
		
	}
	/**
	 * M�todo que remove o membro do projeto.
	 * @param membro: o Membro que vai ser removido do projeto.
	 * @param idDoProjeto: o id do projeto que o membro vai ser removido.
	 * @return: retorna true se remover o membro do projeto e false se n�o.
	 */
	public void removerMembroNoProjeto(Membro membro, int idDoProjeto) {
		try{
			// remove o membro do projeto
			Projeto projeto = pesquisarProjeto(idDoProjeto);
			projeto.removerMembro(membro);
			projeto.setMembros(projeto.getMembros());
			projetoParticipacao.atualizar();
		}catch(Exception e){
			System.out.println("N�o foi possivel remover o membro");
		}
	}
	/**
	 * M�todo pesquisa por um projeto na persist�ncia.
	 * @param idProjeto: o id do projeto que voc� quer pesquisar.
	 * @return: retorna o projeto que voc� pesquisou
	 */
	public Projeto pesquisarProjeto(int idProjeto){
		return projetoParticipacao.pesquisarProjeto(idProjeto);
	}
	
	public static ArrayList<Projeto> getProjetosPersistidos() {
		return projetoParticipacao.getPersistidos();
	}
}
