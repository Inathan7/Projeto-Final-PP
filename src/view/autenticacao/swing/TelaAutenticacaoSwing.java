package view.autenticacao.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.apache.commons.mail.EmailException;

import controller.ControllerTelaAutenticacao;
import model.autenticacao.Membro;
import model.autenticacao.TipoProvedorAutenticacao;
import view.autenticacao.TelaAutenticacao;

public class TelaAutenticacaoSwing extends JFrame implements TelaAutenticacao{
	
	private JTextField campoLogin;
	private JPasswordField campoSenha;
	private JRadioButton smtp;
	private JRadioButton interno;
	public TelaAutenticacaoSwing() {
		SetLookAndFeel.addLookAndFeel();
		setTitle("Autentica��o");
		setLayout(null);
		setResizable(false);
		setSize(500, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		botoes();
		textField();
		label();
		radioButton();
		setVisible(true);
		repaint();
	}
	public void botoes(){
		OuvinteAutenticar ouvinte = new OuvinteAutenticar();
		JButton autenticar = new JButton("Autenticar", new ImageIcon(getClass().getResource("/autenticar.png")));
		autenticar.setBackground(Color.gray);
		autenticar.setBounds(190, 270, 120, 30);
		autenticar.addActionListener(ouvinte);
		add(autenticar);
		
		JButton cadastrar = new JButton("Cadastrar", new ImageIcon(getClass().getResource("/addMembro.png")));
		cadastrar.setBackground(Color.gray);
		cadastrar.setBounds(190, 330, 120, 30);
		cadastrar.addActionListener(ouvinte);
		add(cadastrar);
	}
	public void textField(){
		campoLogin = new JTextField();
		campoLogin.setBounds(170, 100, 180, 30);
		add(campoLogin);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(170, 140, 180, 30);
		add(campoSenha);
	}
	public void radioButton(){
		smtp = new JRadioButton("Provedor SMTP");
		interno = new JRadioButton("Provedor interno");

		smtp.setBounds(125, 200, 120, 30);
		interno.setBounds(255, 200, 120, 30);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(smtp);
		grupo.add(interno);
		
		add(smtp);
		add(interno);
		
	}
	public void label(){
		JLabel autenticarLabel = new JLabel("Autenticar");
		autenticarLabel.setFont(new Font("Monospaced", Font.BOLD, 30));
		autenticarLabel.setBounds(150, 30, 200, 50);
		add(autenticarLabel);
		
		JLabel login = new JLabel("Login");
		login.setFont(new Font("", Font.BOLD, 12));
		login.setBounds(115, 100, 50, 30);
		
		JLabel senha = new JLabel("Senha");
		senha.setFont(new Font("", Font.BOLD, 12));
		senha.setBounds(115, 140, 50, 30);
		
		JLabel labelCadastrar = new JLabel("N�o tem uma conta? Cadastre-se!");
		labelCadastrar.setFont(new Font("", Font.BOLD, 12));
		labelCadastrar.setBounds(160, 370, 200, 30);
		add(labelCadastrar);
		
		add(autenticarLabel);
		add(login);
		add(senha);
	}
	public class OuvinteAutenticar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ControllerTelaAutenticacao controller = new ControllerTelaAutenticacao();
			String senha = new String(campoSenha.getPassword());
			TipoProvedorAutenticacao provedor = null;
			String tipoProvedor = "";
			if(smtp.isSelected()){
				provedor = TipoProvedorAutenticacao.EMAIL_SMTP;
				tipoProvedor = "Provedor SMTP achou o membro: ";
			}else if(interno.isSelected()){
				provedor = TipoProvedorAutenticacao.INTERNO;
				tipoProvedor = "Provedor interno achou o membro: ";
			}
			Membro m = null;
				try {
					m = controller.autenticarContaEmail(campoLogin.getText(), senha, provedor);
					if(m == null){
						JOptionPane.showMessageDialog(null, "Esse login ou senha n�o existe");
					}else{
						JOptionPane.showMessageDialog(null, tipoProvedor+m.getNome());
					}
				} catch (EmailException e1) {
					JOptionPane.showMessageDialog(null, "Esse login ou senha n�o foi encontrado\n No provedor SMTP");
				}
		}
		
	}
	
	public static void main(String[] args) {
		new TelaAutenticacaoSwing();
	}

}
