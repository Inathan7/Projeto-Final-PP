package fachadas;

import java.util.ArrayList;

import model.autenticacao.Membro;
import model.projetos.CompositorProjeto;
import model.projetos.Grupo;
import persistenciaXML.DAOXMLGrupo;
/**
 * @author PAULO e INATHAN - TATAKAE!
 *Fachada para a classe Grupo
 */
public class Fachada3Grupo {
	/**
	 * {@link #grupoXML} Atributo que faz a persist�ncia.
	 */
	private DAOXMLGrupo grupoXML = new DAOXMLGrupo();
	
	/**
	 * Metodo que adiciona o grupo na persistencia.
	 * @param grupo: e o grupo que vai ser adicionado na persistencia. 
	 */
	public void adicionarGrupo(Grupo grupo) {
		grupoXML.criar(grupo);
	}
	/**
	 * Metodo que remove o grupo da persistencia.
	 * @param id: e o id do grupo para que possa remover da persistencia.
	 * @return: retorna true se remover o grupo da persistencia e false se nao.
	 */
	public boolean removerGrupo(int id) {
		try {
			grupoXML.remover(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * M�todo que atualiza o grupo na persist�ncia.
	 * @param grupo: � o grupo que vai ser atualizado.
	 * @param id: � o id onde grupo vai ficar no HashMap da persist�ncia.
	 * @return: retorna true se o grupo atualizar e false se n�o.
	 */
	public void atualizarGrupo() {
		grupoXML.atualizar();
	}
	/**
	 * Esse m�todo adiciona um membro no grupo selecionado
	 * @param membro: � o Membro que vai ser adicionado
	 * @param idDoGrupo: � o id do grupo que vai ser adicionado
	 * @return: retorna true se adicionar o membro no grupo e false se n�o
	 */
	public void adicionarMembroNoGrupo(Membro membro, int idDoGrupo){
		try{
			// adiciona o membro para o grupo
			Grupo grupo = pesquisarGrupo(idDoGrupo);
			grupo.adicionarMembro(membro);
			grupoXML.atualizar();
		}catch(Exception e){
			System.out.println("Nao existe Grupo com este ID");
		}
	}
	/**
	 * Esse m�todo remove um Membro do Grupo selecionado
	 * @param membro: � o membro que vai ser removido do grupo
	 * @param idDoGrupo: � o id do Grupo que vai ser removido o membro
	 * @return: retorna true se for removido e false se n�o
	 */
	public void removerMembroDoGrupo(Membro membro, int idDoGrupo){
		try{
			//remove o membro do grupo
			Grupo grupo = pesquisarGrupo(idDoGrupo);
			grupo.removerMembro(membro);
			grupoXML.atualizar();
		}catch(Exception e){
			System.out.println("Nao foi possivel remover o membro");
		}
	}
	/**
	 * Esse m�todo pesquisa um grupo na persist�ncia grupoXML
	 * @param id: � o id do grupo que voc� quer pesquisar na persist�ncia grupoXML
	 * @return: retorna o Grupo se achar e null se n�o achar o grupo
	 * @throws Exception 
	 */
	public Grupo pesquisarGrupo(int id) throws Exception{
		return grupoXML.pesquisarGrupo(id);
	}
	
	public void adicionarComponentesComposite(Grupo grupo, CompositorProjeto compositor) {
		grupo.adicionar(compositor);
		grupoXML.atualizar();
	}
	
	/**
	 * Esse m�todo retorna uma lista de grupo
	 * @return: retorna uma lista de grupo de existir se n�o ele retorna uma lista vazia
	 */
	public ArrayList<Grupo> getGrupos(){
		return grupoXML.getPersistidos();
	}
}
