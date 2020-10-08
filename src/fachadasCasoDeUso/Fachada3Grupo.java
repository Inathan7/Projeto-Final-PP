package fachadasCasoDeUso;

import model.autenticacao.Membro;
import model.projetos.Grupo;
import persistencia.xml.DAOXMLGrupo;
/**
 * @author PAULO e INATHAN
 *Fachada para a classe Grupo
 */
public class Fachada3Grupo {
	/**
	 * Atributo que faz a persist�ncia.
	 */
	private DAOXMLGrupo grupoXML = new DAOXMLGrupo();
	
	/**
	 * M�todo que adiciona o grupo na persist�ncia.
	 * @param grupo: � o grupo que vai ser adicionado na persist�ncia. 
	 */
	public void adicionarGrupo(Grupo grupo) {
		grupoXML.criar(grupo);
	}
	/**
	 * M�todo que remove o grupo da persist�ncia.
	 * @param id: � o id do grupo para que possa remover da persist�ncia.
	 * @return: retorna true se remover o grupo da persist�ncia e false se n�o.
	 */
	public boolean removerGrupo(long id) {
		Grupo grupo = pesquisarGrupo(id);
		if(grupo.getProjetos().size() > 0) {
			return false;
		}
		grupoXML.remover(id);
		return true;
	}
	/**
	 * M�todo que atualiza o grupo na persist�ncia.
	 * @param grupo: � o grupo que vai ser atualizado.
	 * @param id: � o id onde grupo vai ficar no HashMap da persist�ncia.
	 * @return: retorna true se o grupo atualizar e false se n�o.
	 */
	public boolean atualizarGrupo(Grupo grupo, long id) {
		return grupoXML.atualizar(id, grupo);
	}
	
	
	public boolean adicionarMembroNoGrupo(Membro membro,long idDoGrupo){
		try{
			// adiciona o membro para o grupo
			Grupo grupo = pesquisarGrupo(idDoGrupo);
			grupo.adicionar(membro);
			return grupoXML.atualizar(idDoGrupo, grupo);
		}catch(Exception e){
			System.out.println("N�o existe Grupo com este ID");
		}
		return false;
	}
	public boolean removerMembro(Membro membro,long idDoGrupo){
		try{
			//remove o membro do grupo
			Grupo grupo = pesquisarGrupo(idDoGrupo);
			grupo.remover(membro);
			return grupoXML.atualizar(idDoGrupo, grupo);
		}catch(Exception e){
			System.out.println("N�o foi possivel remover o membro");
		}
		return false;
	}
	public Grupo pesquisarGrupo(long id){
		return grupoXML.pesquisarGrupo(id);
	}
}
