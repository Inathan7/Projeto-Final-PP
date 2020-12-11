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

import controller.ControllerProjeto;
import view.autenticacao.FabricaTela;
import view.autenticacao.swing.FabricaTelaSwing;
import view.autenticacao.swing.SetLookAndFeel;

public class TelaMostrarProjetos extends JFrame {
	
	private FabricaTela fabricaTela = new FabricaTelaSwing();
	private ControllerProjeto controllerProjeto = new ControllerProjeto();

	public TelaMostrarProjetos() {
		setTitle("Mostrar Projeto");
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

	public void addLabels() {
		JLabel labelTitulo = new JLabel("Seus Projetos");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(150, 20, 250, 50);
		add(labelTitulo);
		
		JLabel labelGrupos = new JLabel("Projetos");
		labelGrupos.setFont(new Font("", Font.BOLD, 12));
		labelGrupos.setBounds(225, 80, 50, 30);
		add(labelGrupos);
	}

	public void addJComboBox() {
		String[] projetosComboBox = new String[controllerProjeto.getProjetos().size()];
		for (int i=0; i<controllerProjeto.getProjetos().size(); i++) {
			for (int j = 0; j < controllerProjeto.getProjetos().get(i).getMembros().size(); j++) {
				if (controllerProjeto.getProjetos().get(i).getMembros().get(j).isAtivo()) {
					projetosComboBox[i] = (controllerProjeto.getProjetos().get(i).getNome());
				}
			}	
		}
		
		JComboBox<String> listGrupos = new JComboBox<String>(projetosComboBox);
		listGrupos.setBackground(Color.gray);
		listGrupos.setBounds(190, 110, 120, 30);
		add(listGrupos);
	}

	public void addButtons() {
		JButton buttonOk = new JButton("Ok");
		buttonOk.setBackground(Color.gray);
		buttonOk.setBounds(200, 190, 100, 30);
		add(buttonOk);
		
		JButton buttonVoltar = new JButton(new ImageIcon(getClass().getResource("/voltar.png")));
		buttonVoltar.setBackground(Color.gray);
		buttonVoltar.setBounds(15, 15, 20, 20);
		add(buttonVoltar);
		
		OuvinteMostrarProjetos ouvinteMostrarProjetos = new OuvinteMostrarProjetos();
		buttonOk.addActionListener(ouvinteMostrarProjetos);
		buttonVoltar.addActionListener(ouvinteMostrarProjetos);
	}
	
	public class OuvinteMostrarProjetos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			fabricaTela.fabricarTelaCadastroProjetos();
		}
		
	}

}
