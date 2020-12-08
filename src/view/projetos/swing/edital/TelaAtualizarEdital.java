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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ControllerEdital;
import view.autenticacao.FabricaTela;
import view.autenticacao.swing.FabricaTelaSwing;
import view.autenticacao.swing.SetLookAndFeel;

public class TelaAtualizarEdital extends JFrame {
	
	private FabricaTela fabricaTela = new FabricaTelaSwing();
	private ControllerEdital controllerEdital = new ControllerEdital();
	
	private JTextField txtNovoNome;
	private JTextField txtTermino;
	private JComboBox<String> listEditais;

	public TelaAtualizarEdital() {
		setTitle("Atualizar Edital");
		setLayout(null);
		setResizable(false);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);


		SetLookAndFeel.addLookAndFeel();
		addLabels();
		addTextFields();
		addComboBox();
		addButtons();

		setVisible(true);
		repaint();
	}

	public void addLabels() {
		JLabel labelTitulo = new JLabel("Atualizar Edital");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(100, 20, 320, 50);
		add(labelTitulo);

		JLabel labelEditais = new JLabel("Edital");
		labelEditais.setFont(new Font("", Font.BOLD, 12));
		labelEditais.setBounds(145, 80, 50, 30);
		add(labelEditais);
		
		JLabel labelNome = new JLabel("Novo Nome");
		labelNome.setFont(new Font("", Font.BOLD, 12));
		labelNome.setBounds(310, 80, 70, 30);
		add(labelNome);
		
		JLabel labelTermino = new JLabel("Data Termino");
		labelTermino.setFont(new Font("", Font.BOLD, 12));
		labelTermino.setBounds(120, 150, 100, 30);
		add(labelTermino);
		
	}
	
	public void addTextFields() {
		txtNovoNome = new JTextField();
		txtNovoNome.setBounds(270, 110, 130, 30);
		add(txtNovoNome);
		
		txtTermino = new JTextField();
		txtTermino.setBounds(270, 150, 100, 30);
		add(txtTermino);
	}

	public void addComboBox() {
		String[] editaisComboBox = new String[controllerEdital.getEditais().size()];
		for (int i=0; i<controllerEdital.getEditais().size(); i++) {
			editaisComboBox[i] = controllerEdital.getEditais().get(i).getNome();
		}
		
		listEditais = new JComboBox<String>(editaisComboBox);
		listEditais.setBackground(Color.gray);
		listEditais.setBounds(100, 110, 130, 30);
		add(listEditais);
	}

	public void addButtons() {
		JButton buttonAtualizar = new JButton("Atualizar");
		buttonAtualizar.setBackground(Color.gray);
		buttonAtualizar.setBounds(100, 220, 100, 30);
		add(buttonAtualizar);

		JButton buttonFinalizar = new JButton("Finalizar");
		buttonFinalizar.setBackground(Color.gray);
		buttonFinalizar.setBounds(300, 220, 100, 30);
		add(buttonFinalizar);
		
		JButton buttonVoltar = new JButton(new ImageIcon(getClass().getResource("/voltar.png")));
		buttonVoltar.setBackground(Color.gray);
		buttonVoltar.setBounds(15, 15, 20, 20);
		add(buttonVoltar);
		
		OuvinteButao ouvinteButao = new OuvinteButao();
		buttonAtualizar.addActionListener(ouvinteButao);
		buttonFinalizar.addActionListener(ouvinteButao);
		buttonVoltar.addActionListener(ouvinteButao);
	}
	
	public class OuvinteButao implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand().equals("Finalizar")){
				dispose();
				fabricaTela.fabricarTelaCadastrarEditais();
			}else if (e.getActionCommand().equals("Atualizar")){
				int index = listEditais.getSelectedIndex();
				
				String nome = txtNovoNome.getText();
				long dataTermino = Long.parseLong(txtTermino.getText());
				
				for (int i = 0; i < controllerEdital.getEditais().size(); i++) {
					if(controllerEdital.getEditais().get(i).equals(controllerEdital.getEditais().get(index))) {
						controllerEdital.setAtributosEdital(controllerEdital.getEditais().get(index),nome, dataTermino);
						controllerEdital.atualizarEdital();
						JOptionPane.showMessageDialog(null, "Edital Atualizado");
						listEditais.repaint();
					}
				}
			}else {
				dispose();
				fabricaTela.fabricarTelaCadastrarEditais();
			}
			
		}
		
	}
}
