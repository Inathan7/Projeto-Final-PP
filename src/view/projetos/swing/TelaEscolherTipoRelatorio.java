package view.projetos.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import controller.ControllerRelatorio;
import view.autenticacao.FabricaTela;
import view.autenticacao.swing.FabricaTelaSwing;
import view.autenticacao.swing.SetLookAndFeel;

public class TelaEscolherTipoRelatorio extends JFrame {
	
	private FabricaTela fabricaTela = new FabricaTelaSwing();
	private ControllerRelatorio controllerRelatorio = new ControllerRelatorio();
	
	
	private JRadioButton relatorioHTML;
	private JRadioButton relatorioSwing;
	
	public TelaEscolherTipoRelatorio() {
		setTitle("Menu");
		setLayout(null);
		setResizable(false);
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		
		SetLookAndFeel.addLookAndFeel();
		addLabels();
		addRadioButtons();
		addButtons();

		setVisible(true);
		repaint();
	}
	
	private void addLabels() {
		JLabel labelTitulo = new JLabel("Menu Relatório");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(130, 20, 270, 50);
		add(labelTitulo);
		
	}

	private void addRadioButtons() {
		relatorioHTML= new JRadioButton("Relatório HTML");
		relatorioHTML.setBounds(50, 100, 150, 30);
		relatorioHTML.setSelected(true);

		relatorioSwing = new JRadioButton("Relatório Swing");
		relatorioSwing.setBounds(300, 100, 150, 30);

		ButtonGroup group = new ButtonGroup();
		group.add(relatorioHTML);
		group.add(relatorioSwing);

		add(relatorioHTML);
		add(relatorioSwing);
		
	}

	private void addButtons() {
		JButton buttonRelatorioEdital = new JButton("Gerar Relatório Edital");
		buttonRelatorioEdital.setBackground(Color.gray);
		buttonRelatorioEdital.setBounds(150, 200, 200, 30);
		add(buttonRelatorioEdital);
		
		JButton buttonRelatorioGrupo = new JButton("Gerar Relatório Grupo");
		buttonRelatorioGrupo.setBackground(Color.gray);
		buttonRelatorioGrupo.setBounds(150, 250, 200, 30);
		add(buttonRelatorioGrupo);
		
		JButton buttonRelatorioProjeto = new JButton("Gerar Relatório Projeto");
		buttonRelatorioProjeto.setBackground(Color.gray);
		buttonRelatorioProjeto.setBounds(150, 300, 200, 30);
		add(buttonRelatorioProjeto);
		
		JButton buttonVoltar = new JButton(new ImageIcon(getClass().getResource("/voltar.png")));
		buttonVoltar.setBackground(Color.gray);
		buttonVoltar.setBounds(15, 15, 20, 20);
		add(buttonVoltar);
		
		OuvinteEscolher ouvinteEscolher = new OuvinteEscolher();
		
		buttonRelatorioEdital.addActionListener(ouvinteEscolher);
		buttonRelatorioGrupo.addActionListener(ouvinteEscolher);
		buttonRelatorioProjeto.addActionListener(ouvinteEscolher);
		buttonVoltar.addActionListener(ouvinteEscolher);
		
	}
	
	public class OuvinteEscolher implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String evento = e.getActionCommand();
			
		if(evento.equals("")) {
			dispose();
			fabricaTela.fabricarTelaPrincipal();
		}
			
		if(relatorioHTML.isSelected()) {
			switch (evento) {
			case "Gerar Relatório Edital":
				controllerRelatorio.gerarRelatorioEditalHTML();
				break;

			case "Gerar Relatório Grupo":
				controllerRelatorio.gerarRelatorioGrupoHTML();
				break;
				
			case "Gerar Relatório Projeto":
				controllerRelatorio.gerarRelatorioProjetoHTML();
				break;
			}
		} else {
			switch (evento) {
			case "Gerar Relatório Edital":
				controllerRelatorio.gerarRelatorioEditalSwing();
				break;

			case "Gerar Relatório Grupo":
				controllerRelatorio.gerarRelatorioGrupoSwing();;
				break;
				
			case "Gerar Relatório Projeto":
				controllerRelatorio.gerarRelatorioProjetoSwing();
				break;
			}
		}
			
			
			
		}
		
	}

}
