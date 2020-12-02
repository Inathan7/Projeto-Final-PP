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

import fachadas.Fachada8Relatorio;

public class RelatorioProjetoSwing extends JFrame implements MontadorRelatorioProjeto {
	
	

	@Override
	public void gerarRelatorioHtml() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gerarRelatorioNativoSwing() {
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
			Fachada8Relatorio fachada = new Fachada8Relatorio();
			edPane.setText(fachada.gerarRelatorioGeral());
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.getContentPane().setLayout(new GridLayout(1,1));
			this.add(new JScrollPane(edPane));
			this.setSize(800,570);
			this.setLocation(0,0);
		
	}
	
	public SwingJPanel getProduto() {
		SwingJPanel swing = new SwingJPanel();
		swing.setJPanel(this);
		return swing;
	}

}
