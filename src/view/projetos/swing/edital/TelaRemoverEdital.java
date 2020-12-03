package view.projetos.swing.edital;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.autenticacao.FabricaTela;
import view.autenticacao.swing.FabricaTelaSwing;
import view.autenticacao.swing.SetLookAndFeel;

public class TelaRemoverEdital extends JFrame{
	
	private FabricaTela fabricaTela = new FabricaTelaSwing();

	public TelaRemoverEdital() {
		setTitle("Remover Edital");
		setLayout(null);
		setResizable(false);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		
		SetLookAndFeel.addLookAndFeel();
		addLabels();
		addJComboBox();
		addButtons();

		setVisible(true);
		repaint();
	}
	private void addLabels() {
		JLabel labelTitulo = new JLabel("Remover Edital");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(125, 20, 250, 50);
		add(labelTitulo);
		
		JLabel labelProjetos = new JLabel("Edital");
		labelProjetos.setFont(new Font("", Font.BOLD, 12));
		labelProjetos.setBounds(150, 80, 60, 30);
		add(labelProjetos);
	}

	private void addJComboBox() {
		JComboBox<String> listEditais = new JComboBox<String>();
		listEditais.setBackground(Color.gray);
		listEditais.setBounds(120, 110, 120, 30);
		add(listEditais);
	}

	private void addButtons() {
		JButton buttonRemoverEdital = new JButton("Remover");
		buttonRemoverEdital.setBackground(Color.gray);
		buttonRemoverEdital.setBounds(280, 110, 100, 30);
		add(buttonRemoverEdital);
		
		JButton buttonFinalizar = new JButton("Finalizar");
		buttonFinalizar.setBackground(Color.gray);
		buttonFinalizar.setBounds(200, 190, 100, 30);
		add(buttonFinalizar);
		
		JButton buttonVoltar = new JButton(new ImageIcon(getClass().getResource("/voltar.png")));
		buttonVoltar.setBackground(Color.gray);
		buttonVoltar.setBounds(15, 15, 20, 20);
		add(buttonVoltar);
		
		OuvinteRemoverEdital ouvinteRemoverEdital = new OuvinteRemoverEdital();
		buttonFinalizar.addActionListener(ouvinteRemoverEdital);
		buttonRemoverEdital.addActionListener(ouvinteRemoverEdital);
		buttonVoltar.addActionListener(ouvinteRemoverEdital);
		
	}
	
	public class OuvinteRemoverEdital implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String evento = e.getActionCommand();
			
			switch (evento) {
			case "Remover":
				
				break;

			case "Finalizar":
				
				break;
				
			case "":
				dispose();
				fabricaTela.fabricarTelaCadastrarEditais();
				break;
			}
			
		}
		
	}
}
