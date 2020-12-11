package view.autenticacao;

import model.autenticacao.TipoProvedorAutenticacao;

public interface TelaAutenticacao {
	
	public void mostrarMensagem(String mensagem);
	
	public void autenticar(String senha, TipoProvedorAutenticacao provedor);
	
	public void cadastrar();

}
