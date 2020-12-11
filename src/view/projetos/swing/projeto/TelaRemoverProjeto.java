package view.projetos.swing.projeto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.ControllerProjeto;
import view.autenticacao.FabricaTela;
import view.autenticacao.swing.FabricaTelaSwing;
import view.autenticacao.swing.SetLookAndFeel;

public class TelaRemoverProjeto extends JFrame {
	
	private FabricaTela fabricaTela = new FabricaTelaSwing();
	private ControllerProjeto controllerProjeto = new ControllerProjeto();
	
	private JComboBox<String> listProjetos;

	public TelaRemoverProjeto() {
		setTitle("Remover Projeto");
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
		JLabel labelTitulo = new JLabel("Remover Projeto");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(100, 20, 300, 50);
		add(labelTitulo);
		
		JLabel labelProjetos = new JLabel("Projetos");
		labelProjetos.setFont(new Font("", Font.BOLD, 12));
		labelProjetos.setBounds(150, 80, 60, 30);
		add(labelProjetos);
	}

	private void addJComboBox() {
		String[] projetosComboBox = new String[controllerProjeto.getProjetos().size()];
		for (int i=0; i<controllerProjeto.getProjetos().size(); i++) {
			projetosComboBox[i] = (controllerProjeto.getProjetos().get(i).getNome());
		}
		
		listProjetos = new JComboBox<String>(projetosComboBox);
		listProjetos.setBackground(Color.gray);
		listProjetos.setBounds(120, 110, 120, 30);
		add(listProjetos);
	}

	private void addButtons() {
		JButton buttonRemoverProjeto = new JButton("Remover");
		buttonRemoverProjeto.setBackground(Color.gray);
		buttonRemoverProjeto.setBounds(280, 110, 100, 30);
		add(buttonRemoverProjeto);
		
		JButton buttonFinalizar = new JButton("Finalizar");
		buttonFinalizar.setBackground(Color.gray);
		buttonFinalizar.setBounds(200, 190, 100, 30);
		add(buttonFinalizar);
		
		JButton buttonVoltar = new JButton(new ImageIcon(getClass().getResource("/voltar.png")));
		buttonVoltar.setBackground(Color.gray);
		buttonVoltar.setBounds(15, 15, 20, 20);
		add(buttonVoltar);
		
		OuvinteRemoverProjeto ouvinteRemoverProjeto = new OuvinteRemoverProjeto();
		buttonVoltar.addActionListener(ouvinteRemoverProjeto);
		buttonFinalizar.addActionListener(ouvinteRemoverProjeto);
		buttonRemoverProjeto.addActionListener(ouvinteRemoverProjeto);
	}
	
	public class OuvinteRemoverProjeto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String evento = e.getActionCommand();
			
			switch (evento) {
			case "Remover":
				int index = listProjetos.getSelectedIndex();
				
				for (int i = 0; i < controllerProjeto.getProjetos().size(); i++) {
					if(controllerProjeto.getProjetos().get(i).equals(controllerProjeto.getProjetos().get(index))) {
						controllerProjeto.removerProjeto(index);
						JOptionPane.showMessageDialog(null, "Projeto Removido");
						listProjetos.repaint();
					}
				}
				
				break;

			case "Finalizar":
				dispose();
				fabricaTela.fabricarTelaCadastroProjetos();
	//			new TelaCadastroGruposSwing();
				break;
			case "":
				dispose();
				fabricaTela.fabricarTelaCadastroProjetos();
			}
			
		}
		
	}
}
