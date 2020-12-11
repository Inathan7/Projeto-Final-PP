package view.projetos.swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.ControllerMembro;
import fachadas.Fachada12JustificarPonto;
import model.projetos.ponto.HorarioPrevisto;
import model.projetos.ponto.ValidarJustificativa;
import model.projetos.ponto.ValidarPontoIvalido;
import model.projetos.ponto.ValidarPrevisao;
import view.autenticacao.swing.SetLookAndFeel;
import view.projetos.TelaJustificativaPonto;

public class TelaJustificativaPontoSwing extends JFrame implements TelaJustificativaPonto {
	private ControllerMembro controllerMembro = new ControllerMembro();
	private JTextField txtLogin;
	private JTextArea txtJustificatica;
	
	public TelaJustificativaPontoSwing() {
		setTitle("Justificar Ponto");
		setLayout(null);
		setResizable(false);
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		
		SetLookAndFeel.addLookAndFeel();
		addLabels();
		addTextField();
		addButtons();

		setVisible(true);
		repaint();
	}

	private void addLabels() {
		JLabel labelTitulo = new JLabel("Justificar Ponto");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(100, 20, 300, 50);
		add(labelTitulo);
		
		JLabel labelLogin = new JLabel("Login");
		labelLogin.setFont(new Font("", Font.BOLD, 12));
		labelLogin.setBounds(70, 90, 50, 30);
		add(labelLogin);
		
		JLabel labelJustificativa = new JLabel("Justificativa");
		labelJustificativa.setFont(new Font("", Font.BOLD, 12));
		labelJustificativa.setBounds(215, 140, 70, 30);
		add(labelJustificativa);
	}

	private void addTextField() {
		txtLogin = new JTextField();
		txtLogin.setBounds(150, 90, 200, 30);
		add(txtLogin);
		
		txtJustificatica = new JTextArea();
		txtJustificatica.setBounds(100, 180, 300, 70);
		add(txtJustificatica);
	}

	private void addButtons() {
		JButton buttonJustificar = new JButton("Justificar");
		buttonJustificar.setBounds(200, 300, 100, 30);
		add(buttonJustificar);
	}
	

	@Override
	public void mostrarMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
	public class OuvinteJustificar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<ValidarPontoIvalido> validar = new ArrayList<>();
			validar.add(new ValidarJustificativa());
			for(int i = 0;i < controllerMembro.getMembros().size();i++){
				if(controllerMembro.getMembros().get(i).getLogin().equals(txtLogin.getText())){
					Fachada12JustificarPonto justificar = new Fachada12JustificarPonto();
					justificar.justificarPontoInvalido(txtJustificatica.getText(), controllerMembro.getMembros().get(i).getParticipacao().getPontoTrabalhado(), new HorarioPrevisto(), validar);
				}
			}
			
		}
		
	}
	public static void main(String[] args) {
		new TelaJustificativaPontoSwing();
	}
}
