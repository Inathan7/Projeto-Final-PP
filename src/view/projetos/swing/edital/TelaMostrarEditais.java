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

public class TelaMostrarEditais extends JFrame { 
	
	private FabricaTela fabricaTela = new FabricaTelaSwing();

	public TelaMostrarEditais() {
		setTitle("Mostrar Editais");
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
		JLabel labelTitulo = new JLabel("Seus Editais");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(150, 20, 250, 50);
		add(labelTitulo);
		
		JLabel labelEditais = new JLabel("Editais");
		labelEditais.setFont(new Font("", Font.BOLD, 12));
		labelEditais.setBounds(225, 80, 50, 30);
		add(labelEditais);
	}

	public void addJComboBox() {
		JComboBox<String> listEditais = new JComboBox<String>();
		listEditais.setBackground(Color.gray);
		listEditais.setBounds(190, 110, 120, 30);
		add(listEditais);
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
		
		OuvinteMostrarEditais ouvinteMostrarEditais = new OuvinteMostrarEditais();
		buttonOk.addActionListener(ouvinteMostrarEditais);
		buttonVoltar.addActionListener(ouvinteMostrarEditais);
	}
	
	public class OuvinteMostrarEditais implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
				dispose();
				fabricaTela.fabricarTelaCadastrarEditais();
		}
		
	}

}
