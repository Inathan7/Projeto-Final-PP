package view.projetos.swing.grupo;

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

import controller.ControllerGrupo;
import controller.ControllerMembro;
import controller.ControllerProjeto;
import view.autenticacao.FabricaTela;
import view.autenticacao.swing.FabricaTelaSwing;
import view.autenticacao.swing.SetLookAndFeel;

public class TelaAdicionarGrupo extends JFrame {

	private FabricaTela fabricaTela = new FabricaTelaSwing();

	private JTextField txtNomeGrupo;
	private JTextField txtDataTermino;
	private JTextField txtLinkCNPq;
	private JComboBox<Integer> listProjetos;


	private ControllerProjeto controllerProjeto = new ControllerProjeto();

	private ControllerGrupo controllerGrupo = new ControllerGrupo();

	private OuvinteTelaAdicionarGrupo ouvinteTelaAdicionarGrupo = new OuvinteTelaAdicionarGrupo();

	public TelaAdicionarGrupo() {
		setTitle("Adicionar Grupo");
		setLayout(null);
		setResizable(false);
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);


		SetLookAndFeel.addLookAndFeel();
		addLabels();
		addTextField();
		//		addJComboBox();
		addButtons();

		setVisible(true);
		repaint();
	}

	public void addLabels() {
		JLabel labelTitulo = new JLabel("Adicionar Grupo");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(100, 20, 400, 50);
		add(labelTitulo);

		JLabel labelNomeGrupo = new JLabel("Nome do Grupo");
		labelNomeGrupo.setFont(new Font("", Font.BOLD, 12));
		labelNomeGrupo.setBounds(120, 80, 90, 30);
		add(labelNomeGrupo);

		JLabel labelDataTermino = new JLabel("Data Termino");
		labelDataTermino.setFont(new Font("", Font.BOLD, 12));
		labelDataTermino.setBounds(120, 130, 90, 30);
		add(labelDataTermino);

		JLabel labelLinkCNPq = new JLabel("LinkCNPq");
		labelLinkCNPq.setFont(new Font("", Font.BOLD, 12));
		labelLinkCNPq.setBounds(120, 180, 90, 30);
		add(labelLinkCNPq);

	}

	public void addTextField() {
		txtNomeGrupo = new JTextField();
		txtNomeGrupo.setBounds(260, 80, 120, 30);
		add(txtNomeGrupo);

		txtDataTermino = new JTextField();
		txtDataTermino.setBounds(260, 130, 120, 30);
		add(txtDataTermino);

		txtLinkCNPq = new JTextField();
		txtLinkCNPq.setBounds(260, 180, 120, 30);
		add(txtLinkCNPq);
	}




	public void addButtons() {

		JButton buttonNovoGrupo = new JButton("Criar");
		buttonNovoGrupo.setBackground(Color.gray);
		buttonNovoGrupo.setBounds(200, 250, 100, 30);
		add(buttonNovoGrupo);

		JButton buttonFinalizar = new JButton("Novo Grupo");
		buttonFinalizar.setBackground(Color.gray);
		buttonFinalizar.setBounds(200, 300, 100, 30);
		add(buttonFinalizar);

		JButton buttonVoltar = new JButton(new ImageIcon(getClass().getResource("/voltar.png")));
		buttonVoltar.setBackground(Color.gray);
		buttonVoltar.setBounds(15, 15, 20, 20);
		add(buttonVoltar);

		//	buttonAddMembro.addActionListener(ouvinteTelaAdicionarGrupo);
		buttonNovoGrupo.addActionListener(ouvinteTelaAdicionarGrupo);
		buttonFinalizar.addActionListener(ouvinteTelaAdicionarGrupo);
		buttonVoltar.addActionListener(ouvinteTelaAdicionarGrupo);
	}

	private class AdicionarMembros extends JFrame {

		public AdicionarMembros() {
			setLayout(null);
			setResizable(false);
			setSize(200, 200);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			SetLookAndFeel.addLookAndFeel();

			JLabel labelMembros = new JLabel("Membros");
			labelMembros.setFont(new Font("", Font.BOLD, 12));
			labelMembros.setBounds(70, 10, 60, 20);
			add(labelMembros);

			Integer[] membrosComboBox = new Integer[controllerProjeto.getProjetos().size()];

			for (int i=0; i<controllerProjeto.getProjetos().size(); i++) {
				membrosComboBox[i] = controllerProjeto.getProjetos().get(i).getId();
			}

			listProjetos = new JComboBox<Integer>(membrosComboBox);
			listProjetos.setBackground(Color.gray);
			listProjetos.setBounds(50, 30, 100, 30);
			add(listProjetos);

			JButton buttonAddMembro = new JButton("Add");
			buttonAddMembro.setBackground(Color.gray);
			buttonAddMembro.setBounds(110, 100, 70, 30);
			add(buttonAddMembro);

			JButton buttonVoltar = new JButton("Voltar");
			buttonVoltar.setBackground(Color.gray);
			buttonVoltar.setBounds(20, 100, 70, 30);
			add(buttonVoltar);

			buttonAddMembro.addActionListener(ouvinteTelaAdicionarGrupo);
			buttonVoltar.addActionListener(ouvinteTelaAdicionarGrupo);

			setVisible(true);
			repaint();
		}
	}

	public class OuvinteTelaAdicionarGrupo implements ActionListener {

		private AdicionarMembros addMembros;

		@Override
		public void actionPerformed(ActionEvent e) {
			String evento = e.getActionCommand();

			switch (evento) {

			case "Novo Grupo":
				dispose();
				new TelaAdicionarGrupo();
				break;

			case "Criar":
				long dataTermino = Long.parseLong(txtDataTermino.getText());
				String linkCNPq = txtLinkCNPq.getText();
				controllerGrupo.addGrupo(txtNomeGrupo.getText(), dataTermino, linkCNPq);

				addMembros = new AdicionarMembros();
				break;

			case "":
				dispose();
				fabricaTela.fabricarTelaCadastroGrupos();
				//			new TelaCadastroGruposSwing();
				break;

			case "Add":
				int id = (Integer) listProjetos.getSelectedItem();

				controllerGrupo.addProjetoAoGrupo(controllerGrupo.pesquisarGrupo(controllerGrupo.getGrupos().size()-1), controllerProjeto.pesquisarProjeto(id));
				for (int i = 0; i < controllerProjeto.pesquisarProjeto(id).getMembros().size(); i++) {
						controllerGrupo.addMembroAogrupo(controllerProjeto.pesquisarProjeto(id).getMembros().get(i), controllerGrupo.getGrupos().size());
					}
				JOptionPane.showMessageDialog(null, "Membros do Projeto Adicionados ao Grupo!");
				break;

			case "Voltar":
				addMembros.dispose();
				break;

			}	

		}
	}
}
