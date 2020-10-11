package model.projetos;

import java.util.ArrayList;
/**
 * @author PAULO E INATHAN - TATAKAE!
 * Essa � a classe Edital do projeto
 */
public class Edital extends InterfaceComum{
	/**
	 * {@link #projetos} Esse atributo � a lista de de interfaceComum que pode adicionar projetos ou qualquer tipo comum
	 * {@link #grupos} Esse atributo � uma lista de interfaceComum que pode adicionar grupos ou qualquer tipo comum
	 */
	private ArrayList<InterfaceComum> projetos = new ArrayList<>();
	private ArrayList<InterfaceComum> grupos = new ArrayList<>();
	
	/**
	 * Esse m�todo adiciona projetos na lista de interfaceComum
	 * @param composite: � o projeto qe vai ser adicionado
	 */
	public void adicionar(Projeto composite) {
		projetos.add(composite);
	}
	/**
	 * Esse m�todo adiciona grupos na lista de interfaceComum
	 * @param composite: � o grupo que vai ser adicionado
	 */
	public void adicionar(Grupo composite){
		grupos.add(composite);
	}
	/**
	 * Esse m�todo seta o atributo ativo como true
	 */
	public void ativar() {
		setAtivo(true);
		
	}
	/**
	 * Esse m�todo seta o atributo ativo como false
	 */
	public void desativar() {
		setAtivo(false);
	}
	/**
	 * Esse m�todo calcula o valor total do custo
	 *@return: retorna o valor total em float do custo 
	 */
	public float getCustoTotal() {
		float custoTotal = 0;
		for(InterfaceComum p: projetos){
			custoTotal+= p.getCustoTotal();
		}
		for(InterfaceComum g: grupos){
			custoTotal+= g.getCustoTotal();
		}
		return custoTotal;
	}

	/**
	 * Esse m�todo cacula o custeio total n�o gasto
	 * @return: retorna o custeio n�o gasto total em float
	 */
	public float getCusteioReaisNaoGastoTotal() {
		float custeio = 0;
		for(InterfaceComum c: projetos){
			custeio+= c.getCusteioReaisNaoGastoTotal();
		}
		return custeio;
	}

	/**
	 * Esse m�todo calcula o capital total n�o gasto
	 * @return: retorna o capital total n�o gasto em float
	 */
	public float getCapitalReaisNaoGastoTotal() {
		float capital = 0;
		for(InterfaceComum c: projetos){
			capital+=c.getCapitalReaisNaoGastoTotal();
		}
		return capital;
	}
	/**
	 * Esse m�todo pega a lista de projetos
	 * @return: retorna a lista de interfaceComum
	 */
	public ArrayList<InterfaceComum> getProjetos() {
		return projetos;
	}
	/**
	 * Esse m�todo seta uma lista de projetos
	 * @param projetos: � a lista de projetos que vai ser configurada
	 */
	public void setProjetos(ArrayList<InterfaceComum> projetos) {
		this.projetos = projetos;
	}
	/**
	 * Esse m�todo pega uma lista de grupos
	 * @return: retorna uma lista de interfaceComum
	 */
	public ArrayList<InterfaceComum> getGrupos() {
		return grupos;
	}
	/**
	 * Esse m�todo seta uma lista de grupos
	 * @param grupos: � a lista de grupos que vai ser configurada
	 */
	public void setGrupos(ArrayList<InterfaceComum> grupos) {
		this.grupos = grupos;
	}
}
