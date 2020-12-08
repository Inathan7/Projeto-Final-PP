package view.projetos.relatorios;

import java.io.File;

import fachadas.Fachada3Grupo;
import fachadas.Fachada4Edital;
import fachadas.Fachada5Projeto;
import model.projetos.Edital;
import model.projetos.Grupo;
import model.projetos.Projeto;

public class RelatorioProjetoHTML extends File implements MontadorRelatorioProjeto {

//	private String relatorio;
	
	Fachada4Edital fachadaEdital = new Fachada4Edital();
	Fachada3Grupo fachadaGrupo = new Fachada3Grupo();
	

	public RelatorioProjetoHTML(File arquivo, String caminho) {
		super(arquivo, caminho);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;



	public StringBufferHTML getProduto() {
		StringBufferHTML stringHtml = new StringBufferHTML();
		stringHtml.setHTML(this);
		return stringHtml;
	}



//	@Override
//	public void gerarRelatorio() {
//			Fachada8Relatorio fachada = new Fachada8Relatorio();
//			relatorio = fachada.gerarRelatorioGeral();
//	}
//
//
//
//	@Override
//	public void contruirInterface() {
//		try {
//			FileWriter fw = new FileWriter(this);
//			fw.write(relatorio);
//			fw.flush();
//			fw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}

//Nova Vers�o

	@Override
	public String gerarRelatorioEdital() {
		//Usa tags HTML
				String relatorio = "";
				relatorio += "<body Style='text-align: center'>";
				for(Edital edital : fachadaEdital.getEditais()){
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



	@Override
	public String gerarRelatorioGrupo() {
		//Usa tags HTML
				String relatorio = "";
				relatorio += "<body Style='text-align: center'>";
				for(Grupo grupo : fachadaGrupo.getGrupos()){
					relatorio += "<h3 Style='text-align: center; font: 21px verdana;'>[Grupo ID: "+grupo.getId()+"]</h3>";
					relatorio += "[LINK CNPq] - "+grupo.getLinkCNPq()+"<br>";
					relatorio += "[DATA CRIA��O] - "+grupo.getDataCriacao()+"<br>";
					relatorio += "[GRUPO ATIVO] - "+grupo.getAtivo()+"<br>";
					relatorio += "</body>";
				}
				return relatorio;
		
	}



	@Override
	public String gerarRelatorioProjeto() {
		//Usa tags HTML
				String relatorio = "";
				relatorio += "<body Style='text-align: center'>";
				for(Projeto p: Fachada5Projeto.getProjetosPersistidos()){
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

}
