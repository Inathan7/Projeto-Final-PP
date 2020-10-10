package fachadasCasoDeUso;

import model.projetos.Edital;
import persistencia.xml.DAOXMLEdital;
/**
 * 
 * @author PAULO E INATHAN
 *A classe � uma fachada de edital, para facilitar o uso dela
 */
public class Fachada4Edital {
/**
 * Atributo que vai persistir os editais	
 */
private DAOXMLEdital editalXML = new DAOXMLEdital();
	
	/**
	 * Esse m�todo adiciona editais na persist�ncia editalXML
	 * @param edital: � o edital que vai ser adicionado
	 */
	public void adicionarEdital(Edital edital) {
		editalXML.criar(edital);
	}
	/**
	 * Esse m�todo remove o edital da persist�ncia editalXML
	 * @param id: � o id onde se encontra o edital
	 * @return: retorna true se for excluido o edital e false se n�o
	 */
	public boolean removerEdital(long id) {
		Edital edital = pesquisarEdital(id);
		if(edital.getProjetos().size() > 0) {
			return false;
		}
		editalXML.remover(id);
		return true;
	}
	/**
	 * Esse m�todo atualiza o edital na persist�ncia
	 * @param edital: � o edital atualizado que vai ser salvo na persist�ncia
	 * @param id: � o id onde o edital atualizado vai ficar
	 */
	public void atualizarEdital(Edital edital, long id) {
		editalXML.atualizar(id, edital);
	}
	/**
	 * Esse m�todo pesquisa o edital de acordo com o id passado
	 * @param idEdital: � o id do edital que voc� quer pesquisar
	 * @return: retorna o Edital se achar e null se n�o achar
	 */
	public Edital pesquisarEdital(long idEdital){
		return editalXML.pesquisarEdital(idEdital);
	}

}
