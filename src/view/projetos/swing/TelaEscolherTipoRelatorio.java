package view.projetos.swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import fachadas.Fachada8Relatorio;
import view.autenticacao.FabricaTela;
import view.autenticacao.swing.FabricaTelaSwing;
import view.autenticacao.swing.SetLookAndFeel;

public class TelaEscolherTipoRelatorio extends JFrame {
	
	private FabricaTela fabricaTela = new FabricaTelaSwing();
	private Fachada8Relatorio fachadaRelatorio = new Fachada8Relatorio();
	
	public TelaEscolherTipoRelatorio() {
		setTitle("Menu");
		setLayout(null);
		setResizable(false);
		setSize(300, 170);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		
		SetLookAndFeel.addLookAndFeel();
		addButtons();

		setVisible(true);
		repaint();
	}

	private void addButtons() {
		JButton buttonRelatorioSwing = new JButton("Gerar Relatório Swing");
		buttonRelatorioSwing.setBackground(Color.gray);
		buttonRelatorioSwing.setBounds(50, 40, 200, 30);
		add(buttonRelatorioSwing);
		
		JButton buttonRelatorioHTML = new JButton("Gerar Relatório HTML");
		buttonRelatorioHTML.setBackground(Color.gray);
		buttonRelatorioHTML.setBounds(50, 90, 200, 30);
		add(buttonRelatorioHTML);
		
		JButton buttonVoltar = new JButton(new ImageIcon(getClass().getResource("/voltar.png")));
		buttonVoltar.setBackground(Color.gray);
		buttonVoltar.setBounds(15, 15, 20, 20);
		add(buttonVoltar);
		
		OuvinteEscolher ouvinteEscolher = new OuvinteEscolher();
		
		buttonRelatorioHTML.addActionListener(ouvinteEscolher);
		buttonRelatorioSwing.addActionListener(ouvinteEscolher);
		buttonVoltar.addActionListener(ouvinteEscolher);
		
	}
	
	public class OuvinteEscolher implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String evento = e.getActionCommand();
			
			switch (evento) {
			case "Gerar Relatório Swing":
				dispose();
				//Logica gerar Relatorio Swing
	//			fachadaRelatorio.relatorioSwing();
				break;

			case "Gerar Relatório HTML":
				dispose();
			//Logica gerar Relatorio HTML
	//			fachadaRelatorio.relatorioHTML();
				break;
				
			case "":
				dispose();
				fabricaTela.fabricarTelaPrincipal();
				break;	
			
				
			}
			
			
			
		}
		
	}

}
