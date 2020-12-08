package view.projetos.relatorios;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import fachadas.Fachada3Grupo;
import fachadas.Fachada4Edital;
import fachadas.Fachada5Projeto;
import model.projetos.Edital;
import model.projetos.Grupo;
import model.projetos.Projeto;

public class RelatorioProjetoSwing extends JFrame implements MontadorRelatorioProjeto {
	
	private String relatorio;
	
	Fachada4Edital fachadaEdital = new Fachada4Edital();
	Fachada3Grupo fachadaGrupo = new Fachada3Grupo();

	
	public SwingJPanel getProduto() {
		SwingJPanel swing = new SwingJPanel();
		swing.setJPanel(this);
		return swing;
	}

	@Override
	public void contruirInterface(String relatorio) {
		HTMLEditorKit htmlEdKit = new HTMLEditorKit();
		HTMLDocument htmlDoc = (HTMLDocument) htmlEdKit.createDefaultDocument();
		HTML html = new HTML();
		
		try{
			htmlEdKit.insertHTML(htmlDoc,0,toString(),0,0,html.getTag("html"));
		}
		catch(IOException ioe){
			JOptionPane.showMessageDialog(null,"Exception: ioe");
		}
		catch(BadLocationException ble){
			JOptionPane.showMessageDialog(null,"Exception: ble");
		};
		
		JEditorPane edPane = new JEditorPane();
		edPane.setBorder(BorderFactory.createLineBorder(Color.yellow));
		edPane.setContentType("text/html");
		edPane.setEditable(false);
		edPane.setEditorKit(htmlEdKit);
		edPane.setDocument(htmlDoc);
		htmlEdKit.install(edPane);
		edPane.setText(relatorio);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(1,1));
		this.add(new JScrollPane(edPane));
		this.setSize(800,570);
		this.setLocation(0,0);
		
	}
	
	//Nova versão

	@Override
	public String gerarRelatorioEdital() {
		//Usa tags HTML
		relatorio += "<body Style='text-align: center'>";
		for(Edital edital : fachadaEdital.getEditais()){
			relatorio += "<h3 Style='text-align: center; font: 21px verdana;'>[Edital ID: "+edital.getId()+"]</h3>";
			relatorio += "[NOME] - "+edital.getNome()+"<br>";
			relatorio += "[DATA INICIO] - "+edital.getDataInicio()+"<br>";
			relatorio += "[DATA TERMINO] - "+edital.getDataTermino()+"<br>";
			relatorio += "[CUSTO TOTAL] - "+edital.getCustoTotal()+"<br>";
			relatorio += "[CAPITAL NÃO GASTO] - "+edital.getCapitalReaisNaoGastoTotal()+"<br>";
			relatorio += "[CUSTEIO NÃO GASTO] - "+edital.getCusteioReaisNaoGastoTotal()+"<br>";
			relatorio +="[EDITAL ATIVO] - "+edital.getAtivo()+"<br>";
			relatorio += "</body>";
		}
		return relatorio;
		
	}

	@Override
	public String gerarRelatorioGrupo() {
		//Usa tags HTML
		relatorio += "<body Style='text-align: center'>";
		for(Grupo grupo : fachadaGrupo.getGrupos()){
			relatorio += "<h3 Style='text-align: center; font: 21px verdana;'>[Grupo ID: "+grupo.getId()+"]</h3>";
			relatorio += "[LINK CNPq] - "+grupo.getLinkCNPq()+"<br/>";
			relatorio += "[DATA CRIAÇÂO] - "+grupo.getDataCriacao()+"<br/>";
			relatorio += "[GRUPO ATIVO] - "+grupo.getAtivo()+"<br/>";
			relatorio += "</body>";
		}
		return relatorio;
	}

	@Override
	public String gerarRelatorioProjeto() {
		//Usa tags HTML
		relatorio += "<body Style='text-align: center'>";
		for(Projeto p: Fachada5Projeto.getProjetosPersistidos()){
			relatorio += "<h3 Style='text-align: center; font: 21px verdana;'>[Projeto ID: "+p.getId()+"]</h3>";
			relatorio += "Nome do projeto: "+p.getNome()+"<br/>";
			relatorio += "Gastos executados capital: "+p.getGastoExecutadoCapitalReais()+"<br/>";
			relatorio += "Gastos executados custeio: "+p.getGastoExecutadoCusteioReais()+"<br/>";
			relatorio += "Aporte capital: "+p.getAporteCapitalReais()+"<br/>";
			relatorio += "Aporte custeio: "+p.getAporteCusteioReais()+"<br/>";
			relatorio += "Data inicio: "+p.getDataInicio()+"<br/>";
			relatorio += "Data termino: "+p.getDataTermino()+"<br/>";
			relatorio += "Custo Total: "+p.getCustoTotal()+"<br/>";
			relatorio += "</body>";
		}
		return relatorio;
		
	}

}
