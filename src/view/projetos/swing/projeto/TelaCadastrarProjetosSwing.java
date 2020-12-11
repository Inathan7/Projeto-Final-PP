package view.projetos.swing.projeto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import view.autenticacao.FabricaTela;
import view.autenticacao.swing.FabricaTelaSwing;
import view.autenticacao.swing.SetLookAndFeel;
import view.projetos.TelaCadastroProjetos;

public class TelaCadastrarProjetosSwing extends JFrame implements TelaCadastroProjetos{
	
	private FabricaTela fabricaTela = new FabricaTelaSwing();
	
	public TelaCadastrarProjetosSwing() {
		setTitle("Gerenciamento de Projetos");
		setLayout(null);
		setResizable(false);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		
		SetLookAndFeel.addLookAndFeel();
		addLabels();
		addButtons();

		setVisible(true);
		repaint();
	}

	public void addLabels() {
		JLabel labelTitulo = new JLabel("Gerenciar Projetos");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(100, 20, 430, 50);
		add(labelTitulo);
	}

	public void addButtons() {
		JButton buttonAdicionar = new JButton("Adicionar", new ImageIcon(getClass().getResource("/addProjeto.png")));
		buttonAdicionar.setBounds(120, 80, 110, 70);
		buttonAdicionar.setBackground(Color.gray);
		add(buttonAdicionar);
		
		JButton buttonRemover = new JButton("Remover", new ImageIcon(getClass().getResource("/removerProjeto.png")));
		buttonRemover.setBounds(270, 80, 110, 70);
		buttonRemover.setBackground(Color.gray);
		add(buttonRemover);
		
		JButton buttonAtualizar = new JButton("Atualizar", new ImageIcon(getClass().getResource("/atualizar.png")));
		buttonAtualizar.setBounds(120, 180, 110, 70);
		buttonAtualizar.setBackground(Color.gray);
		add(buttonAtualizar);
		
		JButton buttonMostrarProjetos = new JButton("Projetos", new ImageIcon(getClass().getResource("/projetos.png")));
		buttonMostrarProjetos.setBounds(270, 180, 110, 70);
		buttonMostrarProjetos.setBackground(Color.gray);
		add(buttonMostrarProjetos);
		
		JButton buttonVoltar = new JButton(new ImageIcon(getClass().getResource("/voltar.png")));
		buttonVoltar.setBackground(Color.gray);
		buttonVoltar.setBounds(15, 15, 20, 20);
		add(buttonVoltar);
		
		OuvinteTelaCadastroProjetos ouvinteTelaCadastroProjetos = new OuvinteTelaCadastroProjetos();
		
		buttonAdicionar.addActionListener(ouvinteTelaCadastroProjetos);
		buttonRemover.addActionListener(ouvinteTelaCadastroProjetos);
		buttonAtualizar.addActionListener(ouvinteTelaCadastroProjetos);
		buttonMostrarProjetos.addActionListener(ouvinteTelaCadastroProjetos);
		buttonVoltar.addActionListener(ouvinteTelaCadastroProjetos);
	}
	
	public class OuvinteTelaCadastroProjetos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String evento = e.getActionCommand();
			
			switch (evento) {
			case "Adicionar":
				adicionarProjeto();
				break;

			case "Remover":
				removerProjeto();
				break;
				
			case "Atualizar":
				atualizarProjeto();
				break;
			
			case "Projetos":
				mostrarProjetos();
				break;
				
			case "":
				dispose();
				fabricaTela.fabricarTelaPrincipal();
				break;
			}
			
		}
		
	}

	@Override
	public void adicionarProjeto() {
		dispose();
		new TelaAdicionarProjeto();
	}

	@Override
	public void removerProjeto() {
		dispose();
		new TelaRemoverProjeto();
	}

	@Override
	public void atualizarProjeto() {
		dispose();
		new TelaAtualizarProjeto();
	}

	@Override
	public void mostrarProjetos() {
		dispose();
		new TelaMostrarProjetos();
	}

}
