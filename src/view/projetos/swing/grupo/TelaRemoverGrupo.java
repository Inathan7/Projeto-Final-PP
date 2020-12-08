package view.projetos.swing.grupo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.ControllerGrupo;
import view.autenticacao.FabricaTela;
import view.autenticacao.swing.FabricaTelaSwing;
import view.autenticacao.swing.SetLookAndFeel;

public class TelaRemoverGrupo extends JFrame {
	
	private FabricaTela fabricaTela = new FabricaTelaSwing();
	
	private ControllerGrupo controllerGrupo = new ControllerGrupo();
	
	private JComboBox<Integer> listGrupos;
	
	public TelaRemoverGrupo() {
		setTitle("Remover Grupo");
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
		JLabel labelTitulo = new JLabel("Remover Grupo");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(125, 20, 250, 50);
		add(labelTitulo);
		
		JLabel labelGrupos = new JLabel("Grupos");
		labelGrupos.setFont(new Font("", Font.BOLD, 12));
		labelGrupos.setBounds(150, 80, 60, 30);
		add(labelGrupos);
	}

	private void addJComboBox() {
		Integer[] gruposComboBox = new Integer[controllerGrupo.getGrupos().size()];
		for (int i=0; i<controllerGrupo.getGrupos().size(); i++) {
			gruposComboBox[i] = (controllerGrupo.getGrupos().get(i).getId());
		}
		
		listGrupos = new JComboBox<Integer>(gruposComboBox);
		listGrupos.setBackground(Color.gray);
		listGrupos.setBounds(120, 110, 120, 30);
		add(listGrupos);
	}

	private void addButtons() {
		JButton buttonRemoverGrupo = new JButton("Remover");
		buttonRemoverGrupo.setBackground(Color.gray);
		buttonRemoverGrupo.setBounds(280, 110, 100, 30);
		add(buttonRemoverGrupo);
		
		JButton buttonFinalizar = new JButton("Finalizar");
		buttonFinalizar.setBackground(Color.gray);
		buttonFinalizar.setBounds(200, 190, 100, 30);
		add(buttonFinalizar);
		
		OuvinteRemoverGrupos ouvinteRemoverGrupos = new OuvinteRemoverGrupos();
		buttonFinalizar.addActionListener(ouvinteRemoverGrupos);
		buttonRemoverGrupo.addActionListener(ouvinteRemoverGrupos);
	}
	
	public class OuvinteRemoverGrupos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String evento = e.getActionCommand();
			
			switch (evento) {
			
			case "Remover":
				int index = (Integer)listGrupos.getSelectedItem();
				controllerGrupo.removerGrupo(index);
				JOptionPane.showMessageDialog(null, "Grupo Removido");
				Integer[] gruposComboBox = new Integer[controllerGrupo.getGrupos().size()];
				for (int i=0; i<controllerGrupo.getGrupos().size(); i++) {
					gruposComboBox[i] = (controllerGrupo.getGrupos().get(i).getId());
				}
				JComboBox<Integer> comboG = new JComboBox<Integer>(gruposComboBox);
				listGrupos.setModel(comboG.getModel());
				break;

			case "Finalizar":
				dispose();
				fabricaTela.fabricarTelaCadastroGrupos();
	//			new TelaCadastroGruposSwing();
				break;
			}
			
		}
		
	}

}
