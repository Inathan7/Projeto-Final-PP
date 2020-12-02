package fachadas;

import java.util.ArrayList;

import model.projetos.Edital;
import model.projetos.Grupo;
import model.projetos.Projeto;
/**
 * @author PAULO E INATHAN - TATAKAE!
 * Essa fachada � utilizada para gerar relat�rio
 */
public class Fachada8Relatorio {
	/**
	 * {@link #editais} Esse atributo guarda a lista de editais
	 * {@link #grupos} Esse atributo guarda a lista de grupos
	 */
	private ArrayList<Edital> editais;
	private ArrayList<Grupo> grupos;
	private ArrayList<Projeto> projetos;
	
	/**
	 * Esse � construtor que inicializa os atributos
	 */
	public Fachada8Relatorio() {
		Fachada4Edital fachada = new Fachada4Edital();
		Fachada3Grupo fachadaGrupo = new Fachada3Grupo();
		this.editais = fachada.getEditais();
		this.grupos = fachadaGrupo.getGrupos();
		this.projetos = Fachada5Projeto.getProjetosPersistidos();
	}
	/**
	 * Esse m�todo gera o relat�rio de todos os editais
	 *
	 */
	public String gerarRelatorioEdital(){
		//Usa tags HTML
		String relatorio = "";
		relatorio += "<body Style='text-align: center'>";
		for(Edital edital : editais){
			relatorio += "<h3 Style='text-align: center; font: 21px verdana;'>[Edital ID: "+edital.getId()+"]</h3>";
			relatorio += "[NOME] - "+edital.getNome()+"<br>";
			relatorio += "[DATA INICIO] - "+edital.getDataInicio()+"<br>";
			relatorio += "[DATA TERMINO] - "+edital.getDataTermino()+"<br>";
			relatorio += "[CUSTO TOTAL] - "+edital.getCustoTotal()+"<br>";
			relatorio += "[CAPITAL N�O GASTO] - "+edital.getCapitalReaisNaoGastoTotal()+"<br>";
			relatorio += "[CUSTEIO N�O GASTO] - "+edital.getCusteioReaisNaoGastoTotal()+"<br>";
			relatorio +="[EDITAL ATIVO] - "+edital.getAtivo()+"<br>";
			relatorio += "</body>";
		}
		return relatorio;
	}
	/**
	 * Esse m�todo gera o relat�rio do todos os grupos
	 */
	public String gerarRelatorioGrupo(){
		//Usa tags HTML
		String relatorio = "";
		relatorio += "<body Style='text-align: center'>";
		for(Grupo grupo : grupos){
			relatorio += "<h3 Style='text-align: center; font: 21px verdana;'>[Grupo ID: "+grupo.getId()+"]</h3>";
			relatorio += "[LINK CNPq] - "+grupo.getLinkCNPq()+"<br>";
			relatorio += "[DATA CRIA��O] - "+grupo.getDataCriacao()+"<br>";
			relatorio += "[GRUPO ATIVO] - "+grupo.getAtivo()+"<br>";
			relatorio += "</body>";
		}
		return relatorio;
	}
	public String gerarRelatorioProjeto(){
		//Usa tags HTML
		String relatorio = "";
		relatorio += "<body Style='text-align: center'>";
		for(Projeto p: projetos){
			relatorio += "<h3 Style='text-align: center; font: 21px verdana;'>[Projeto ID: "+p.getId()+"]</h3>";
			relatorio += "Nome do projeto: "+p.getNome()+"<br>";
			relatorio += "Gastos executados capital: "+p.getGastoExecutadoCapitalReais()+"<br>";
			relatorio += "Gastos executados custeio: "+p.getGastoExecutadoCusteioReais()+"<br>";
			relatorio += "Aporte capital: "+p.getAporteCapitalReais()+"<br>";
			relatorio += "Aporte custeio: "+p.getAporteCusteioReais()+"<br>";
			relatorio += "Data inicio: "+p.getDataInicio()+"<br>";
			relatorio += "Data termino: "+p.getDataTermino()+"<br>";
			relatorio += "Custo Total: "+p.getCustoTotal()+"<br>";
			relatorio += "</body>";
		}
		return relatorio;
	}
	public String gerarRelatorioGeral(){
		//Usa tags HTML
		String relatorio = "";
		relatorio += gerarRelatorioEdital()+"<br>";
		relatorio += gerarRelatorioGrupo()+"<br>";
		relatorio += gerarRelatorioProjeto()+"<br>";
		return relatorio;
	}
}
