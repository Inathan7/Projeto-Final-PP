package model.projetos.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout.Group;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import fachadas.Fachada13Horario;
import fachadas.Fachada5Projeto;
import fachadas.Fachada9MembroRealizarLogout;
import model.projetos.Projeto;
import model.projetos.controller.ControllerTelaPonto;

// CLASSE CLIENTE DO PROXY

public class TelaPonto extends JFrame {
	
	private Fachada13Horario fachadaHorario = new Fachada13Horario();
	
	private OuvinteBaterPonto ouvinteBaterPonto = new OuvinteBaterPonto();
	
	private boolean liberarBaterPonto = false;
	private boolean liberarDetalhes = false;
	
	private JComboBox<Projeto> listComboBox;
	private JTextField textLogin;
	private JRadioButton provedorInterno;
	private JRadioButton provedorSMTP;
	
	public TelaPonto() {
		setTitle("Bater Ponto");
    	setLayout(null);
        setResizable(false);
    	setSize(400, 420);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	setLocationRelativeTo(null);
     	
     	try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			    if ("Nimbus".equals(info.getName())) {
			        UIManager.setLookAndFeel(info.getClassName());
			        break;
			    }
			}
			} catch (Exception e) {}
     	

     	labels();
     	textFields();
     	buttonLogar();
     	comboBox();
     	radioButton();
     	botaoBaterPonto(null, null);
     	botaoVerDetalhes();
     	setVisible(true);
    
    	repaint();
    }
	
	public void labels() {
		JLabel labelProjeto = new JLabel("Projetos");
		labelProjeto.setBounds(30, 170, 60, 30);
		add(labelProjeto);
		
		JLabel labelLogin = new JLabel("Login");
		labelLogin.setBounds(30, 30, 60, 30);
		add(labelLogin);
		
		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setBounds(30, 70, 60, 30);
		add(labelSenha);
	}
	
	public void textFields() {
		textLogin = new JTextField();
		textLogin.setBounds(110, 30, 200, 30);
		add(textLogin);
		
		JTextField textSenha = new JPasswordField();
		textSenha.setBounds(110, 70, 200, 30);
		add(textSenha);
	}
	
	public void buttonLogar() {
		JButton btBaterPonto = new JButton("Logar");
		btBaterPonto.setBounds(150, 120, 100, 30);
		add(btBaterPonto);
		
		btBaterPonto.addActionListener(ouvinteBaterPonto);
	}
	
	public void comboBox() {
		Projeto[] projetosComboBox = Fachada5Projeto.getProjetosPersistidos().toArray(new Projeto[0]);
		listComboBox = new JComboBox<Projeto>(projetosComboBox);
		listComboBox.setBounds(110, 170, 200, 30);
		add(listComboBox);
	}
	
	public void radioButton() {
		provedorInterno = new JRadioButton("Provedor Interno");
		provedorInterno.setBounds(30, 220, 150, 30);
		provedorInterno.setSelected(true);
		
		provedorSMTP = new JRadioButton("Provedor SMTP");
		provedorSMTP.setBounds(200, 220, 150, 30);
		
		ButtonGroup group = new ButtonGroup();
		group.add(provedorInterno);
		group.add(provedorSMTP);
		
		add(provedorInterno);
		add(provedorSMTP);
	}
	
	
	public void botaoBaterPonto(Projeto projeto, String login) {
		JButton btBaterPonto = new JButton("Bater Ponto");
		btBaterPonto.setBounds(150, 290, 100, 30);
		add(btBaterPonto);
		
		btBaterPonto.addActionListener(ouvinteBaterPonto);
		
	}
	
	public void botaoVerDetalhes() {
		JButton btBaterPonto = new JButton("Ver Detalhes");
		btBaterPonto.setBounds(150, 340, 100, 30);
		add(btBaterPonto);
		
		btBaterPonto.addActionListener(ouvinteBaterPonto);
	}
	
	
	public class OuvinteBaterPonto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String evento = e.getActionCommand();
			
			ControllerTelaPonto controllerTelaPonto = new ControllerTelaPonto();
			
			Projeto projetoSelecionado = (Projeto)listComboBox.getSelectedItem();
			
			switch (evento) {
				
			case "Logar":
				
			//TODO Confere essa l�gica kkkkk, ficou bem loc�o - Inathan
				if( Fachada5Projeto.getProjetosPersistidos().size()>0) {
					for (int j = 0; j < Fachada5Projeto.getProjetosPersistidos().size(); j++) {
						if(Fachada5Projeto.getProjetosPersistidos().get(j).equals(projetoSelecionado)) {
							for (int i = 0; i < Fachada5Projeto.getProjetosPersistidos().get(j).getMembros().size(); i++) {
								if(Fachada5Projeto.getProjetosPersistidos().get(j).getMembros().get(i).getLogin().equals(textLogin.getText())) {
									Fachada9MembroRealizarLogout.realizarLogin(Fachada5Projeto.getProjetosPersistidos().get(j).getMembros().get(i));
									Fachada9MembroRealizarLogout.isOnline(textLogin.getText());
									JOptionPane.showMessageDialog(null, "Logado");
									liberarBaterPonto = true;
								}
							}
						
						} else {
							JOptionPane.showMessageDialog(null, "Login n�o cadastrado");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "N�o h� ningu�m cadastrado");
				}
					
				break;
			
			case "Bater Ponto":
				
				if(liberarBaterPonto==true) {
					controllerTelaPonto.conectarProxy(projetoSelecionado, textLogin.getText());
					liberarDetalhes = true;
				} else {
					JOptionPane.showMessageDialog(null, "Voc� precisar estar Logado");
				}
				
				
				break;
				
			case "Ver Detalhes":
				
				if(liberarDetalhes==true) {
					JOptionPane.showMessageDialog(null, "Horas Trabalhadas: " + 
							fachadaHorario.horasTrabalhadas(projetoSelecionado.getDataInicio(), projetoSelecionado.getDataTermino(), textLogin.getText())
									+ "\nD�ficit Horas: " + 
							controllerTelaPonto.deficitHoras(projetoSelecionado.getDataInicio(), projetoSelecionado.getDataTermino(), textLogin.getText())
									+ "\nPontos Inv�lidos: " +
							controllerTelaPonto.pontosInvalidos(textLogin.getText()));
				} else {
					JOptionPane.showMessageDialog(null, "Voc� precisar bater o ponto");
				}
				
				break;
			}
			
		}
		
	}

}
