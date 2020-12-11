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
import view.projetos.TelaEscolherTipoRelatorio;

public class TelaEscolherTipoRelatorioSwing extends JFrame implements TelaEscolherTipoRelatorio {

	private FabricaTela fabricaTela = new FabricaTelaSwing();
	private ControllerRelatorio controllerRelatorio = new ControllerRelatorio();


	private JRadioButton relatorioHTML;
	private JRadioButton relatorioSwing;

	public TelaEscolherTipoRelatorioSwing() {
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
		buttonRelatorioEdital.setBounds(10, 200, 200, 30);
		add(buttonRelatorioEdital);

		JButton buttonRelatorioGrupo = new JButton("Gerar Relatório Grupo");
		buttonRelatorioGrupo.setBackground(Color.gray);
		buttonRelatorioGrupo.setBounds(10, 250, 200, 30);
		add(buttonRelatorioGrupo);

		JButton buttonRelatorioProjeto = new JButton("Gerar Relatório Projeto");
		buttonRelatorioProjeto.setBackground(Color.gray);
		buttonRelatorioProjeto.setBounds(10, 300, 200, 30);
		add(buttonRelatorioProjeto);
		
		JButton buttonRelatorioEditalCompleto = new JButton("Gerar Relatório Edital Completo");
		buttonRelatorioEditalCompleto.setBackground(Color.gray);
		buttonRelatorioEditalCompleto.setBounds(260, 200, 220, 30);
		add(buttonRelatorioEditalCompleto);

		JButton buttonRelatorioGrupoCompleto = new JButton("Gerar Relatório Grupo Completo");
		buttonRelatorioGrupoCompleto.setBackground(Color.gray);
		buttonRelatorioGrupoCompleto.setBounds(260, 250, 220, 30);
		add(buttonRelatorioGrupoCompleto);

		JButton buttonRelatorioProjetoCompleto = new JButton("Gerar Relatório Projeto Completo");
		buttonRelatorioProjetoCompleto.setBackground(Color.gray);
		buttonRelatorioProjetoCompleto.setBounds(260, 300, 220, 30);
		add(buttonRelatorioProjetoCompleto);

		JButton buttonVoltar = new JButton(new ImageIcon(getClass().getResource("/voltar.png")));
		buttonVoltar.setBackground(Color.gray);
		buttonVoltar.setBounds(15, 15, 20, 20);
		add(buttonVoltar);

		OuvinteEscolher ouvinteEscolher = new OuvinteEscolher();

		buttonRelatorioEdital.addActionListener(ouvinteEscolher);
		buttonRelatorioGrupo.addActionListener(ouvinteEscolher);
		buttonRelatorioProjeto.addActionListener(ouvinteEscolher);
		buttonRelatorioEditalCompleto.addActionListener(ouvinteEscolher);
		buttonRelatorioGrupoCompleto.addActionListener(ouvinteEscolher);
		buttonRelatorioProjetoCompleto.addActionListener(ouvinteEscolher);
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


			switch (evento) {
			case "Gerar Relatório Edital":
				gerarRelatorioEdital();
				break;

			case "Gerar Relatório Grupo":
				gerarRelatorioGrupo();
				break;

			case "Gerar Relatório Projeto":
				gerarRelatorioProjeto();
				break;
				
			case "Gerar Relatório Edital Completo":
				gerarRelatorioEditalCompleto();
				break;

			case "Gerar Relatório Grupo Completo":
				gerarRelatorioGrupoCompleto();
				break;

			case "Gerar Relatório Projeto Completo":
				gerarRelatorioProjetoCompleto();
				break;
			}


		}

	}

	@Override
	public void gerarRelatorioEdital() {
		if(relatorioHTML.isSelected()) {
			controllerRelatorio.gerarRelatorioEditalHTML();
		} else {
			controllerRelatorio.gerarRelatorioEditalSwing();
		}
	}

	@Override
	public void gerarRelatorioGrupo() {
		if(relatorioHTML.isSelected()) {
			controllerRelatorio.gerarRelatorioGrupoHTML();
		} else {
			controllerRelatorio.gerarRelatorioGrupoSwing();
		}
	}

	@Override
	public void gerarRelatorioProjeto() {
		if(relatorioHTML.isSelected()) {
			controllerRelatorio.gerarRelatorioProjetoHTML();
		} else {
			controllerRelatorio.gerarRelatorioProjetoSwing();
		}
	}

	@Override
	public void gerarRelatorioEditalCompleto() {
		if(relatorioHTML.isSelected()) {
			controllerRelatorio.gerarRelatorioEditalCompletoHTML();
		} else {
			controllerRelatorio.gerarRelatorioEditalCompletoSwing();
		}
	}

	@Override
	public void gerarRelatorioGrupoCompleto() {
		if(relatorioHTML.isSelected()) {
			controllerRelatorio.gerarRelatorioGrupoCompletoHTML();
		} else {
			controllerRelatorio.gerarRelatorioGrupoCompletoSwing();
		}
	}

	@Override
	public void gerarRelatorioProjetoCompleto() {
		if(relatorioHTML.isSelected()) {
			controllerRelatorio.gerarRelatorioProjetoCompletoHTML();
		} else {
			controllerRelatorio.gerarRelatorioProjetoCompletoSwing();
		}
	}

}
