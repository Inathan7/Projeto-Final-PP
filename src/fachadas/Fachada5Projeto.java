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
	 * {@link #projetoParticipacao} Atributo que faz a persistência
	 */
	private static DAOXMLProjetoParticipacao projetoParticipacao = new DAOXMLProjetoParticipacao();
	
	/**
	 * Método que cria o projeto e adiciona na persistência
	 * @param projeto: esse parâmetro é o projeto que vai ser adicionado
	 */
	public void adicionarProjeto(Projeto projeto) { 
		projetoParticipacao.criar(projeto);
	}	
	/**
	 * Método que remove o projeto da persistência
	 * @param idProjeto: é o id do projeto para que possa achar o projeto e remove-lo
	 * @return: retorna true se for remover o projeto e false se não.
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
	 * Método que atualiza os dados do projeto.
	 * @param projeto: é o projeto que vai ser atualizado na persistência.
	 * @param idProjeto: é o id que onde o projeto vai ficar no HashMap da persistência.
	 * @return: retorna true se atualizar o projeto e false se não.
	 */
	public void atualizarProjeto(){
		projetoParticipacao.atualizar();
	}
	/**
	 * Método que adiciona o Membro no projeto.
	 * @param membro: é o membro que vai ser adicionado no projeto.
	 * @param idDoProjeto: é o id do projeto que vai ser adicionado o membro.
	 * @return: retorna true se o membro for adicionado e false se não.
	 * @throws ExceptionMembroDuplicado 
	 */
	public void adicionarMembroNoProjeto(Membro membro, int idDoProjeto) throws ExceptionMembroDuplicado {
		
			// adiciona o membro para o projeto
			Projeto projeto = pesquisarProjeto(idDoProjeto);
				projeto.adicionarMembro(membro);
			projetoParticipacao.atualizar();
		
	
		
	}
	/**
	 * Método que remove o membro do projeto.
	 * @param membro: o Membro que vai ser removido do projeto.
	 * @param idDoProjeto: o id do projeto que o membro vai ser removido.
	 * @return: retorna true se remover o membro do projeto e false se não.
	 */
	public void removerMembroNoProjeto(Membro membro, int idDoProjeto) {
		try{
			Projeto projeto = pesquisarProjeto(idDoProjeto);
			projeto.removerMembro(membro);
			projeto.setMembros(projeto.getMembros());
			projetoParticipacao.atualizar();
		}catch(Exception e){
		}
	}
	/**
	 * Método pesquisa por um projeto na persistência.
	 * @param idProjeto: o id do projeto que você quer pesquisar.
	 * @return: retorna o projeto que você pesquisou
	 */
	public Projeto pesquisarProjeto(int idProjeto){
		return projetoParticipacao.pesquisarProjeto(idProjeto);
	}
	
	public static ArrayList<Projeto> getProjetosPersistidos() {
		return projetoParticipacao.getPersistidos();
	}
}
