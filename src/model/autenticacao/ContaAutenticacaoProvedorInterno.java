package model.autenticacao;

public class ContaAutenticacaoProvedorInterno extends Conta{

	@Override
	public Membro autenticar(char[] login, char[] senha) {  //FALTA IMPLEMENTAR
		if(getLogin()==login && getSenha()==senha){
			
		}
		return null;
	}

}
