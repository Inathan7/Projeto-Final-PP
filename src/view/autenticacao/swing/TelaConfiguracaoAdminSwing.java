package view.autenticacao.swing;

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

import controller.ControllerMembro;
import view.autenticacao.FabricaTela;
import view.autenticacao.TelaConfiguracaoAdmin;

public class TelaConfiguracaoAdminSwing extends JFrame implements TelaConfiguracaoAdmin {
	
	ControllerMembro controllerMembro = new ControllerMembro();
	
	FabricaTela fabricaTela = new FabricaTelaSwing();
	
	private JComboBox<Long> listMembros;
	public TelaConfiguracaoAdminSwing() {
		setTitle("Configurações do Administrador");
		setLayout(null);
		setResizable(false);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		
		SetLookAndFeel.addLookAndFeel();
		addLabels();
		addComboBox();
		addButtons();

		setVisible(true);
		repaint();
	}

	public void addLabels() {
		JLabel labelTitulo = new JLabel("Habilitar Membros");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(100, 20, 400, 50);
		add(labelTitulo);
		
		JLabel labelMembros = new JLabel("Membros");
		labelMembros.setFont(new Font("", Font.BOLD, 12));
		labelMembros.setBounds(225, 75, 60, 30);
		add(labelMembros);
	}
	
	public void addComboBox() {
		Long[] membrosComboBox = new Long[controllerMembro.getMembros().size()];
		for (int i = 0; i < controllerMembro.getMembros().size(); i++) {
			membrosComboBox[i] = controllerMembro.getMembros().get(i).getMatricula();
		}
		
		listMembros = new JComboBox<Long>(membrosComboBox);
		listMembros.setBounds(150, 100, 200, 30);
		add(listMembros);
		
	}
	
	public void addButtons() {
		JButton buttonTornarAdmin = new JButton("Tornar Administrador", new ImageIcon(getClass().getResource("/tornarAdmin.png")));
		buttonTornarAdmin.setBackground(Color.gray);
		buttonTornarAdmin.setBounds(160, 170, 180, 50);
		OuvinteBotao ovuinte = new OuvinteBotao();
		buttonTornarAdmin.addActionListener(ovuinte);
		add(buttonTornarAdmin);
		
		JButton buttonVoltar = new JButton(new ImageIcon(getClass().getResource("/voltar.png")));
		buttonVoltar.setBackground(Color.gray);
		buttonVoltar.setBounds(15, 15, 20, 20);
		buttonVoltar.addActionListener(ovuinte);
		add(buttonVoltar);
		
	}
	public class OuvinteBotao implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand().equals("Tornar Administrador")) {
				tornarAdministrador();
			}else {
				dispose();
				fabricaTela.fabricarTelaPrincipal();
			}
			
		}
		
	}
	@Override
	public void mostrarMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

	@Override
	public void tornarAdministrador() {
		long matricula = (Long)listMembros.getSelectedItem();
		controllerMembro.tornarMembroAdim(controllerMembro.pesquisar(matricula));
		mostrarMensagem("Membro Agora é um Administrador");
		controllerMembro.atualizar();
	}

}
