package view.projetos.relatorios;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

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
	
	//TODO Retirar Fachadas
	//Retirar códigos HTML
	
	public SwingJPanel getProduto() {
		SwingJPanel swing = new SwingJPanel();
		swing.setJPanel(this);
		return swing;
	}

	@Override
	public void construirInterface() {
//		HTMLEditorKit htmlEdKit = new HTMLEditorKit();
//		HTMLDocument htmlDoc = (HTMLDocument) htmlEdKit.createDefaultDocument();
//		HTML html = new HTML();
//		
//		try{
//			htmlEdKit.insertHTML(htmlDoc,0,toString(),0,0,html.getTag("html"));
//		}
//		catch(IOException ioe){
//			JOptionPane.showMessageDialog(null,"Exception: ioe");
//		}
//		catch(BadLocationException ble){
//			JOptionPane.showMessageDialog(null,"Exception: ble");
//		};
		
		JEditorPane edPane = new JEditorPane();
		edPane.setBorder(BorderFactory.createLineBorder(Color.yellow));
//		edPane.setContentType("text/html");
		edPane.setEditable(false);
//		edPane.setEditorKit(htmlEdKit);
//		edPane.setDocument(htmlDoc);
//		htmlEdKit.install(edPane);
		edPane.setText(relatorio);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(1,1));
		this.add(new JScrollPane(edPane));
		this.setSize(800,570);
		this.setLocation(0,0);
		
	}

	@Override
	public String gerarRelatorioEdital(ArrayList<Edital> editais) {
		for(Edital edital : editais){
			relatorio += "[Edital ID: "+edital.getId()+"\n";
			relatorio += "[NOME] - "+edital.getNome()+"\n";
			relatorio += "[DATA INICIO] - "+edital.getDataInicio()+"\n";
			relatorio += "[DATA TERMINO] - "+edital.getDataTermino()+"\n";
			relatorio += "[CUSTO TOTAL] - "+edital.getCustoTotal()+"\n";
			relatorio += "[CAPITAL NÃO GASTO] - "+edital.getCapitalReaisNaoGastoTotal()+"\n";
			relatorio += "[CUSTEIO NÃO GASTO] - "+edital.getCusteioReaisNaoGastoTotal()+"\n";
			relatorio +="[EDITAL ATIVO] - "+edital.getAtivo()+"\n";
		}
		return relatorio;
		
	}

	@Override
	public String gerarRelatorioGrupo(ArrayList<Grupo> grupos) {
		for(Grupo grupo : grupos){
			relatorio += "[Grupo ID: "+grupo.getId()+"\n";
			relatorio += "[LINK CNPq] - "+grupo.getLinkCNPq()+"\n";
			relatorio += "[DATA CRIAÇÂO] - "+grupo.getDataCriacao()+"\n";
			relatorio += "[GRUPO ATIVO] - "+grupo.getAtivo()+"\n";
		}
		return relatorio;
	}

	@Override
	public String gerarRelatorioProjeto(ArrayList<Projeto> projetos) {
		for(Projeto p: projetos){
			relatorio += "[Projeto ID: "+p.getId()+"\n";
			relatorio += "Nome do projeto: "+p.getNome()+"\n";
			relatorio += "Gastos executados capital: "+p.getGastoExecutadoCapitalReais()+"\n";
			relatorio += "Gastos executados custeio: "+p.getGastoExecutadoCusteioReais()+"\n";
			relatorio += "Aporte capital: "+p.getAporteCapitalReais()+"\n";
			relatorio += "Aporte custeio: "+p.getAporteCusteioReais()+"\n";
			relatorio += "Data inicio: "+p.getDataInicio()+"\n";
			relatorio += "Data termino: "+p.getDataTermino()+"\n";
			relatorio += "Custo Total: "+p.getCustoTotal()+"\n";
		}
		return relatorio;
		
	}

}
