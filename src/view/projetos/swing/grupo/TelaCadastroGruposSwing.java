package view.projetos.swing.grupo;

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
import view.projetos.TelaCadastroGrupos;

public class TelaCadastroGruposSwing extends JFrame implements TelaCadastroGrupos {
	
	private FabricaTela fabricaTela = new FabricaTelaSwing();
	
	public TelaCadastroGruposSwing() {
		setTitle("Gerenciamento de Grupos");
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
		JLabel labelTitulo = new JLabel("Gerenciar Grupos");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(100, 20, 400, 50);
		add(labelTitulo);
	}

	public void addButtons() {
		JButton buttonAdicionar = new JButton("Adicionar",  new ImageIcon(getClass().getResource("/addGrupo.png")));
		buttonAdicionar.setBounds(120, 80, 110, 70);
		buttonAdicionar.setBackground(Color.gray);
		add(buttonAdicionar);
		
		JButton buttonRemover = new JButton("Remover",  new ImageIcon(getClass().getResource("/removerGrupo.png")));
		buttonRemover.setBounds(270, 80, 110, 70);
		buttonRemover.setBackground(Color.gray);
		add(buttonRemover);
		
		JButton buttonAtualizar = new JButton("Atualizar",  new ImageIcon(getClass().getResource("/atualizar.png")));
		buttonAtualizar.setBounds(120, 180, 110, 70);
		buttonAtualizar.setBackground(Color.gray);
		add(buttonAtualizar);
		
		JButton buttonMostrarGrupos = new JButton("Grupos",  new ImageIcon(getClass().getResource("/grupos.png")));
		buttonMostrarGrupos.setBounds(270, 180, 110, 70);
		buttonMostrarGrupos.setBackground(Color.gray);
		add(buttonMostrarGrupos);
		
		JButton buttonVoltar = new JButton(new ImageIcon(getClass().getResource("/voltar.png")));
		buttonVoltar.setBackground(Color.gray);
		buttonVoltar.setBounds(15, 15, 20, 20);
		add(buttonVoltar);
		
		OuvinteTelaCadastroGrupos ouvinteTelaCadastroGrupos = new OuvinteTelaCadastroGrupos();
		
		buttonAdicionar.addActionListener(ouvinteTelaCadastroGrupos);
		buttonRemover.addActionListener(ouvinteTelaCadastroGrupos);
		buttonAtualizar.addActionListener(ouvinteTelaCadastroGrupos);
		buttonMostrarGrupos.addActionListener(ouvinteTelaCadastroGrupos);
		buttonVoltar.addActionListener(ouvinteTelaCadastroGrupos);
	}
	
	public class OuvinteTelaCadastroGrupos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String evento = e.getActionCommand();
			
			switch (evento) {
			case "Adicionar":
				adicionarGrupo();
				break;

			case "Remover":
				removerGrupo();
				break;
				
			case "Atualizar":
				atualizarGrupo();
				break;
			
			case "Grupos":
				mostrarGrupos();
				break;
				
			case "":
				dispose();
				fabricaTela.fabricarTelaPrincipal();
				break;
			}
			
		}
		
	}

	@Override
	public void adicionarGrupo() {
		dispose();
		new TelaAdicionarGrupo();
	}

	@Override
	public void removerGrupo() {
		dispose();
		new TelaRemoverGrupo();
	}

	@Override
	public void atualizarGrupo() {
		dispose();
		new TelaAtualizarGrupo();
	}

	@Override
	public void mostrarGrupos() {
		dispose();
		new TelaMostrarGrupos();
	}

	

}
