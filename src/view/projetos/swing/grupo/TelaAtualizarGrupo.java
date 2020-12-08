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
import javax.swing.JTextField;

import controller.ControllerGrupo;
import controller.ControllerMembro;
import view.autenticacao.FabricaTela;
import view.autenticacao.swing.FabricaTelaSwing;
import view.autenticacao.swing.SetLookAndFeel;

public class TelaAtualizarGrupo extends JFrame {

	private FabricaTela fabricaTela = new FabricaTelaSwing();
	
	private ControllerGrupo controllerGrupo = new ControllerGrupo();
	private ControllerMembro controllerMembro = new ControllerMembro();
	
	private JComboBox<Integer> listGrupos;
	private JComboBox<Long> listMembrosGrupo;
	private JComboBox<Long> listMembros;
	private JTextField txtNovoNome;
	private JTextField txtDataTermino;
	private JTextField txtLinkCNPq;


	public TelaAtualizarGrupo() {
		setTitle("Atualizar Grupo");
		setLayout(null);
		setResizable(false);
		setSize(500, 450);
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
		JLabel labelTitulo = new JLabel("Atualizar Grupo");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(100, 20, 300, 50);
		add(labelTitulo);

		JLabel labelGrupos = new JLabel("Grupos");
		labelGrupos.setFont(new Font("", Font.BOLD, 12));
		labelGrupos.setBounds(145, 80, 50, 30);
		add(labelGrupos);
		
		JLabel labelNome = new JLabel("Novo Nome");
		labelNome.setFont(new Font("", Font.BOLD, 12));
		labelNome.setBounds(310, 80, 70, 30);
		add(labelNome);
		
		JLabel labelDataTermino = new JLabel("Data Termino");
		labelDataTermino.setFont(new Font("", Font.BOLD, 12));
		labelDataTermino.setBounds(120, 150, 90, 30);
		add(labelDataTermino);

		JLabel labelLinkCNPq = new JLabel("LinkCNPq");
		labelLinkCNPq.setFont(new Font("", Font.BOLD, 12));
		labelLinkCNPq.setBounds(120, 190, 90, 30);
		add(labelLinkCNPq);
		
		JLabel labelMembros = new JLabel("Membros");
		labelMembros.setFont(new Font("", Font.BOLD, 12));
		labelMembros.setBounds(300, 220, 60, 30);
		add(labelMembros);
		
		JLabel labelMembrosGrupo = new JLabel("Membros no Grupo");
		labelMembrosGrupo.setFont(new Font("", Font.BOLD, 12));
		labelMembrosGrupo.setBounds(100, 220, 120, 30);
		add(labelMembrosGrupo);
	}
	
	public void addTextFields() {
		txtNovoNome = new JTextField();
		txtNovoNome.setBounds(270, 110, 130, 30);
		add(txtNovoNome);
		
		txtDataTermino = new JTextField();
		txtDataTermino.setBounds(270, 150, 130, 30);
		add(txtDataTermino);
		
		txtLinkCNPq = new JTextField();
		txtLinkCNPq.setBounds(270, 190, 130, 30);
		add(txtLinkCNPq);
	}

	public void addComboBox() {
		//Lista dos grupos
		Integer[] gruposComboBox = new Integer[controllerGrupo.getGrupos().size()];
		for (int i=0; i<controllerGrupo.getGrupos().size(); i++) {
			gruposComboBox[i] = (controllerGrupo.getGrupos().get(i).getId());
		}
		
		listGrupos = new JComboBox<Integer>(gruposComboBox);
		listGrupos.setBackground(Color.gray);
		listGrupos.setBounds(100, 110, 130, 30);
		OuvinteComboBox ouvinteCombo = new OuvinteComboBox();
		listGrupos.addActionListener(ouvinteCombo);
		add(listGrupos);
		
		//Lista dos membros
		Long[] membrosComboBox = new Long[controllerMembro.getMembros().size()];
		for (int i=0; i<controllerMembro.getMembros().size(); i++) {
			membrosComboBox[i] = controllerMembro.getMembros().get(i).getMatricula();
		}

		listMembros = new JComboBox<Long>(membrosComboBox);
		listMembros.setBackground(Color.gray);
		listMembros.setBounds(270, 250, 130, 30);
		add(listMembros);
		
		
		int index = (Integer)listGrupos.getSelectedItem();
		
		//Lista dos membros que estão no grupo selecionado
		Long[] membrosGrupoComboBox = new Long[controllerGrupo.pesquisarGrupo(index).getMembros().size()];
		if(controllerGrupo.getGrupos().size() > 0) {
			for (int i=0; i<controllerGrupo.pesquisarGrupo(index).getMembros().size(); i++) {
				membrosGrupoComboBox[i] = controllerGrupo.pesquisarGrupo(index).getMembros().get(i).getMatricula();
			}
		}
		

		listMembrosGrupo = new JComboBox<Long>(membrosGrupoComboBox);
		listMembrosGrupo.setBackground(Color.gray);
		listMembrosGrupo.setBounds(100, 250, 130, 30);
		add(listMembrosGrupo);
		
	}

	public void addButtons() {
		
		JButton buttonRemoverMembroDoGrupo = new JButton("Remover");
		buttonRemoverMembroDoGrupo.setBackground(Color.gray);
		buttonRemoverMembroDoGrupo.setBounds(100, 280, 80, 30);
		add(buttonRemoverMembroDoGrupo);

		JButton buttonAdionarMembroAoGrupo = new JButton("Adicionar");
		buttonAdionarMembroAoGrupo.setBackground(Color.gray);
		buttonAdionarMembroAoGrupo.setBounds(320, 280, 80, 30);
		add(buttonAdionarMembroAoGrupo);
		
		JButton buttonAtualizar = new JButton("Atualizar");
		buttonAtualizar.setBackground(Color.gray);
		buttonAtualizar.setBounds(100, 380, 100, 30);
		add(buttonAtualizar);

		JButton buttonFinalizar = new JButton("Finalizar");
		buttonFinalizar.setBackground(Color.gray);
		buttonFinalizar.setBounds(300, 380, 100, 30);
		add(buttonFinalizar);
		
		OuvinteAtualizarGrupo ouvinteAtualizarGrupo = new OuvinteAtualizarGrupo();
		
		buttonAtualizar.addActionListener(ouvinteAtualizarGrupo);
		buttonFinalizar.addActionListener(ouvinteAtualizarGrupo);
		
	}
	public class OuvinteComboBox implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//Lista dos membros
			Long[] membrosComboBox = new Long[controllerMembro.getMembros().size()];
			for (int i=0; i<controllerMembro.getMembros().size(); i++) {
				membrosComboBox[i] = controllerMembro.getMembros().get(i).getMatricula();
			}
			JComboBox<Long> comboM = new JComboBox<Long>(membrosComboBox);
			listMembros.setModel(comboM.getModel());
			
			
			int index = (Integer)listGrupos.getSelectedItem();
			
			//Lista dos membros que estão no grupo selecionado
			Long[] membrosGrupoComboBox = new Long[controllerGrupo.pesquisarGrupo(index).getMembros().size()];
			if(controllerGrupo.getGrupos().size() > 0) {
				for (int i=0; i<controllerGrupo.pesquisarGrupo(index).getMembros().size(); i++) {
					membrosGrupoComboBox[i] = controllerGrupo.pesquisarGrupo(index).getMembros().get(i).getMatricula();
				}
			}
			JComboBox<Long> comboMG = new JComboBox<Long>(membrosGrupoComboBox);
			listMembrosGrupo.setModel(comboMG.getModel());
		}
		
	}
	public class OuvinteAtualizarGrupo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String evento = e.getActionCommand();
			
			int idGrupo = 0;
			for (int i = 0; i < controllerGrupo.getGrupos().size(); i++) {
				if(controllerGrupo.getGrupos().get(i).equals(controllerGrupo.getGrupos().get(listGrupos.getSelectedIndex()))) {
					idGrupo = controllerGrupo.getGrupos().get(i).getId();
				}
			}
			
			switch (evento) {
			case "Atualizar":
				int index = listGrupos.getSelectedIndex();
				
				String nomeGrupo = txtNovoNome.getText();
				long dataTermino = Long.parseLong(txtDataTermino.getText());
				String linkCNPq = txtLinkCNPq.getText();
				
				for (int i = 0; i < controllerGrupo.getGrupos().size(); i++) {
					if(controllerGrupo.getGrupos().get(i).equals(controllerGrupo.getGrupos().get(index))) {
						controllerGrupo.setAtributosGrupo(controllerGrupo.getGrupos().get(index), nomeGrupo, dataTermino, linkCNPq);
						controllerGrupo.atualizarGrupo();
						JOptionPane.showMessageDialog(null, "Grupo Atualizado");
						listGrupos.repaint();
					}
				}
				break;

			case "Finalizar":
				dispose();
				fabricaTela.fabricarTelaCadastroGrupos();
				break;
				
			case "Remover":
				int indexMembroGrupo = listMembrosGrupo.getSelectedIndex();
				for (int i = 0; i < controllerMembro.getMembros().size(); i++) {
					if(controllerMembro.getMembros().get(i).equals(controllerMembro.getMembros().get(indexMembroGrupo))) {
						controllerGrupo.removerMembroDoGrupo(controllerMembro.getMembros().get(indexMembroGrupo), idGrupo);
						JOptionPane.showMessageDialog(null, "Removido!");
					}
				}
				
				break;
				
			case "Adicionar":
				int indexMembro = listMembros.getSelectedIndex();
				for (int i = 0; i < controllerMembro.getMembros().size(); i++) {
					if(controllerMembro.getMembros().get(i).equals(controllerMembro.getMembros().get(indexMembro))) {
						controllerGrupo.addMembroAogrupo(controllerMembro.getMembros().get(indexMembro), idGrupo);
					}
				}
				
				break;
			}
		}
		
	}

}
