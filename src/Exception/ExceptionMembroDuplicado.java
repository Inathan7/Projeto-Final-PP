package Exception;
/**
 * @author PAULO E INATHAN
 * Essa classe � uma exce��o de membros duplicados
 */
public class ExceptionMembroDuplicado extends Exception{
	
	/**
	 * Esse � o construtor que seta uma mensagem do tipo String
	 * @param menssage: � a mensagem de erro que vai ser exibido
	 */
	public ExceptionMembroDuplicado(String menssage) {
		super(menssage);
	}
}
