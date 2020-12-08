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
import javax.swing.JTextField;

import controller.ControllerMembro;
import controller.ControllerProjeto;
import exception.ExceptionMembroDuplicado;
import view.autenticacao.FabricaTela;
import view.autenticacao.swing.FabricaTelaSwing;
import view.autenticacao.swing.SetLookAndFeel;

public class TelaAdicionarProjeto extends JFrame {
	
	private FabricaTela fabricaTela = new FabricaTelaSwing();
	
	private ControllerProjeto controllerProjeto = new ControllerProjeto();
	private ControllerMembro controllerMembro = new ControllerMembro();
	
	private JComboBox<Long> listMembros;
	private JTextField txtNomeProjeto;
	private JTextField textCapital;
	private JTextField textCusteio;
	private JTextField textTermino;
	private JTextField textGCapital;
	private JTextField textGCusteio;
	private JButton buttonAddMembro;

	public TelaAdicionarProjeto() {
		setTitle("Adicionar Projeto");
		setLayout(null);
		setResizable(false);
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		
		SetLookAndFeel.addLookAndFeel();
		addLabels();
		addTextField();
		addJComboBox();
		addButtons();

		setVisible(true);
		repaint();
	}
	
	public void addLabels() {
		JLabel labelTitulo = new JLabel("Adicionar Projeto");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(200, 20, 400, 50);
		add(labelTitulo);
		
		JLabel labelNomeProjeto = new JLabel("Nome do Projeto");
		labelNomeProjeto.setFont(new Font("", Font.BOLD, 12));
		labelNomeProjeto.setBounds(220, 80, 100, 30);
		add(labelNomeProjeto);
		
		JLabel labelMembros = new JLabel("Membros");
		labelMembros.setFont(new Font("", Font.BOLD, 12));
		labelMembros.setBounds(220, 260, 60, 30);
		add(labelMembros);
		
		JLabel labelCapital = new JLabel("Capital");
		labelCapital.setFont(new Font("", Font.BOLD, 12));
		labelCapital.setBounds(40, 140, 50, 30);
		add(labelCapital);
		
		JLabel labelCusteio = new JLabel("Custeio");
		labelCusteio.setFont(new Font("", Font.BOLD, 12));
		labelCusteio.setBounds(170, 140, 50, 30);
		add(labelCusteio);
		

		JLabel labelTermino = new JLabel("Termino");
		labelTermino.setFont(new Font("", Font.BOLD, 12));
		labelTermino.setBounds(300, 140, 50, 30);
		add(labelTermino);
		
		JLabel labelGastoCapital = new JLabel("G.Capital");
		labelGastoCapital.setFont(new Font("", Font.BOLD, 12));
		labelGastoCapital.setBounds(430, 140, 50, 30);
		add(labelGastoCapital);
		
		JLabel labelGastoCusteio = new JLabel("G.Custeio");
		labelGastoCusteio.setFont(new Font("", Font.BOLD, 12));
		labelGastoCusteio.setBounds(560, 140, 50, 30);
		add(labelGastoCusteio);
		
	}
	
	public void addTextField() {
		txtNomeProjeto = new JTextField();
		txtNomeProjeto.setBounds(330, 80, 210, 30);
		
		textCapital = new JTextField();
		textCapital.setBounds(100, 140, 60, 30);
		
		textCusteio = new JTextField();
		textCusteio.setBounds(230, 140, 60, 30);
		
		textTermino = new JTextField();
		textTermino.setBounds(360, 140, 60, 30);
		
		textGCapital = new JTextField();
		textGCapital.setBounds(490, 140, 60, 30);
		
		textGCusteio = new JTextField();
		textGCusteio.setBounds(620, 140, 60, 30);
		
		add(textCusteio);
		add(textCapital);
		add(txtNomeProjeto);
		add(textTermino);
		add(textGCapital);
		add(textGCusteio);
	}
	
	public void addJComboBox() {
		Long[] membrosComboBox = new Long[controllerMembro.getMembros().size()];
		
		for (int i=0; i<controllerMembro.getMembros().size(); i++) {
			membrosComboBox[i] = controllerMembro.getMembros().get(i).getMatricula();
		}
		
		listMembros = new JComboBox<Long>(membrosComboBox);
		listMembros.setBackground(Color.gray);
		listMembros.setBounds(200, 290, 100, 30);
		add(listMembros);
	}


	public void addButtons() {
		buttonAddMembro = new JButton("Adicionar");
		buttonAddMembro.setBackground(Color.gray);
		buttonAddMembro.setBounds(400, 290, 120, 30);
		buttonAddMembro.setEnabled(false);
		add(buttonAddMembro);
		
		JButton buttonNovoProjeto = new JButton("Novo Projeto");
		buttonNovoProjeto.setBackground(Color.gray);
		buttonNovoProjeto.setBounds(300, 340, 100, 30);
		add(buttonNovoProjeto);
		
		JButton buttonFinalizar = new JButton("Finalizar");
		buttonFinalizar.setBackground(Color.gray);
		buttonFinalizar.setBounds(300, 380, 100, 30);
		add(buttonFinalizar);
		
		JButton buttonCriarProjeto = new JButton("Criar Projeto");
		buttonCriarProjeto.setBackground(Color.gray);
		buttonCriarProjeto.setBounds(300, 200, 100, 30);
		add(buttonCriarProjeto);
		
		JButton buttonVoltar = new JButton(new ImageIcon(getClass().getResource("/voltar.png")));
		buttonVoltar.setBackground(Color.gray);
		buttonVoltar.setBounds(15, 15, 20, 20);
		add(buttonVoltar);
		
		OuvinteTelaCadastroProjetos ouvinteTelaCadastroProjetos = new OuvinteTelaCadastroProjetos();
		
		buttonCriarProjeto.addActionListener(ouvinteTelaCadastroProjetos);
		buttonNovoProjeto.addActionListener(ouvinteTelaCadastroProjetos);
		buttonFinalizar.addActionListener(ouvinteTelaCadastroProjetos);
		buttonVoltar.addActionListener(ouvinteTelaCadastroProjetos);
		buttonAddMembro.addActionListener(ouvinteTelaCadastroProjetos);
	}
	
	public class OuvinteTelaCadastroProjetos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String evento = e.getActionCommand();
			
			switch (evento) {
			
			case "Criar Projeto":
				float capital = Float.parseFloat(textCapital.getText());
				float custeio = Float.parseFloat(textCusteio.getText());
				long dataTermino = Long.parseLong(textTermino.getText());
				float gastoExecutadoCapitalReais = Float.parseFloat(textGCapital.getText());
				float gastoExecutadoCusteioReais = Float.parseFloat(textGCusteio.getText());
				controllerProjeto.adicionarProjeto(txtNomeProjeto.getText(), capital, custeio, dataTermino,
						gastoExecutadoCapitalReais, gastoExecutadoCusteioReais);
				buttonAddMembro.setEnabled(true);
				break;
			
			case "Adicionar":
				try {
					long matricula = (Long) listMembros.getSelectedItem();
					controllerProjeto.adicionarMembroNoProjeto(controllerMembro.pesquisar(matricula));
					controllerMembro.pesquisar(matricula).getParticipacao().adicionar(controllerProjeto.pesquisarProjeto(controllerProjeto.getProjetos().size()));
					controllerMembro.atualizar();
					JOptionPane.showMessageDialog(null, "Membro Adicionado ao Projeto!");
				} catch (ExceptionMembroDuplicado e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Não exite membro no sistema");
				}
	
//				
//				for (int i = 0; i < controllerMembro.getMembros().size(); i++) {
//					if(controllerMembro.getMembros().get(i).equals(controllerMembro.getMembros().get(index))) {
//						controllerProjeto.adicionarMembroNoProjeto(controllerMembro.getMembros().get(index));
//						JOptionPane.showMessageDialog(null, "Membro Adicionado ao Projeto!");
//						break;

				//	}else {
				//		JOptionPane.showMessageDialog(null, "Membro Já Adicionado!");
			//		}
			//	}
				
				break;

			case "Finalizar":
				dispose();
				fabricaTela.fabricarTelaCadastroProjetos();
				break;
				
			case "Novo Projeto":
				dispose();
				new TelaAdicionarProjeto();
				break;
			
			case "":
				dispose();
				fabricaTela.fabricarTelaCadastroProjetos();
				break;
			}
			
		}
		
	}
	
}
