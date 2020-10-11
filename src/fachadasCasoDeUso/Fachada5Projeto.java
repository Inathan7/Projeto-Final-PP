package fachadasCasoDeUso;

import model.autenticacao.Membro;
import model.projetos.Projeto;
import persistencia.xml.DAOXMLProjetoParticipacao;

/**
 * @author PAULO e INATHAN - TATAKAE!
 *Fachada para a classe Projeto
 */
public class Fachada5Projeto {
	
	/**
	 * {@link #projetoParticipacao} Atributo que faz a persist�ncia
	 */
	private DAOXMLProjetoParticipacao projetoParticipacao = new DAOXMLProjetoParticipacao();
	
	/**
	 * M�todo que cria o projeto e adiciona na persist�ncia
	 * @param projeto: esse par�metro � o projeto que vai ser adicionado
	 */
	public void criarProjeto(Projeto projeto) { 
		projetoParticipacao.criar(projeto);
	}	
	/**
	 * M�todo que remove o projeto da persist�ncia
	 * @param idProjeto: � o id do projeto para que possa achar o projeto e remove-lo
	 * @return: retorna true se for remover o projeto e false se n�o.
	 */
	public boolean removerProjeto(long idProjeto) {
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
	public boolean atualizarProjeto(Projeto projeto,long idProjeto){
		return projetoParticipacao.atualizar(idProjeto, projeto);
	}
	/**
	 * M�todo que adiciona o Membro no projeto.
	 * @param membro: � o membro que vai ser adicionado no projeto.
	 * @param idDoProjeto: � o id do projeto que vai ser adicionado o membro.
	 * @return: retorna true se o membro for adicionado e false se n�o.
	 */
	public boolean adicionarMembroNoProjeto(Membro membro,long idDoProjeto){
		try{
			// adiciona o membro para o projeto
			Projeto projeto = pesquisarProjeto(idDoProjeto);
			projeto.adicionar(membro);
			return projetoParticipacao.atualizar(idDoProjeto, projeto);
		}catch(Exception e){
			System.out.println("N�o existe Projeto com este ID");
		}
		return false;
	}
	/**
	 * M�todo que remove o membro do projeto.
	 * @param membro: o Membro que vai ser removido do projeto.
	 * @param idDoProjeto: o id do projeto que o membro vai ser removido.
	 * @return: retorna true se remover o membro do projeto e false se n�o.
	 */
	public boolean removerMembroNoProjeto(Membro membro,long idDoProjeto){
		try{
			// remove o membro do projeto
			Projeto projeto = pesquisarProjeto(idDoProjeto);
			projeto.remover(membro);
			return projetoParticipacao.atualizar(idDoProjeto, projeto);
		}catch(Exception e){
			System.out.println("N�o foi possivel remover o membro");
		}
		return false;
	}
	/**
	 * M�todo pesquisa por um projeto na persist�ncia.
	 * @param idProjeto: o id do projeto que voc� quer pesquisar.
	 * @return: retorna o projeto que voc� pesquisou
	 */
	public Projeto pesquisarProjeto(long idProjeto){
		return projetoParticipacao.pesquisarProjeto(idProjeto);
	}
}
