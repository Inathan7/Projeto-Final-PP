package persistenciaXML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.projetos.Edital;
import model.projetos.Grupo;

public class DAOXMLEdital {
	
	private HashMap<Long, Edital> persistidos = carregarXML();
	private File arquivoColecao;
	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
	
	public boolean criar(Edital edital) {   
		for (int i = 0; i <= persistidos.size(); i++) {            //PERCORRO A LISTA
			if(persistidos.size() == i) {                          //SE O TAMANHO DA LISTA FOR IGUAL AO I
				persistidos.put((long) (i+1), edital);                     //ADICIONO O PROJETO NA POSI��O(CHAVE) I+1
				salvarXML();                                       //SALVO O ARQUIVO   
				return true;                                       //RETORNO TRUE SE DEU CERTO
			}
		}
		return false;      
	}
	
	public void remover(long id) { 
		persistidos.remove(id);                                   //REMOVE PELA CHAVE
		salvarXML();                                              //SALVA
	}
	
	public boolean atualizar(long id, Edital edital) {   
		for (int i = 0; i < persistidos.size(); i++) {           //PERCORRO A LISTA
			if(id <= persistidos.size()) {                       //SE O ID FOR MENOR QUE O TAMANHO DA LISTA, SIGNIFICA QUE O OBJETO EST� NELA
				persistidos.put(id, edital);                     //ATUALIZO O OBJETO PARA O ID DESEJADO
				salvarXML();                                     //SALVO O ARQUIVO
				return true;                                     //RETORNO TRUE SE DEU CERTO
			}
		}
		return false;                                            //RETORNO FALSE SE DEU ERRADO
	}
	public Edital pesquisarEdital(long idEdital){
		return persistidos.get(idEdital);
	}
	public HashMap<Long,Edital> getEdital(){
		return carregarXML();
	}
	public HashSet<Edital> consultarAnd(String[] atributos, Object[] respectivosValoresAtributos) {
		HashSet<Edital> editaisAnd = new HashSet<Edital>();

		for (int i = 0; i < persistidos.size(); i++) {
			for (int x = 0; x<atributos.length;x++) {
				if(atributos[x].equalsIgnoreCase("Nome")) {
					if(!respectivosValoresAtributos[x].equals(persistidos.get(i).getNome())){
						return editaisAnd;
					}
			}
			else if(atributos[x].equalsIgnoreCase("CapitalReaisNaoGastoTotal")){
				if((float) respectivosValoresAtributos[x] != persistidos.get(i).getCapitalReaisNaoGastoTotal()){
					return editaisAnd;
				}
			}
			else if(atributos[x].equalsIgnoreCase("CusteioReaisNaoGastoTotal")){
				if((float) respectivosValoresAtributos[x] != persistidos.get(i).getCusteioReaisNaoGastoTotal()){
					return editaisAnd;
				}
			}
			else if(atributos[x].equalsIgnoreCase("CustoTotal")){
				if((float) respectivosValoresAtributos[x] != persistidos.get(i).getCustoTotal()){
					return editaisAnd;
				}
			}
			else if(atributos[x].equalsIgnoreCase("DataInicio")){
				if((long) respectivosValoresAtributos[x] != persistidos.get(i).getDataInicio()){
					return editaisAnd;
				}
			}
			else if(atributos[x].equalsIgnoreCase("DataTermino")){
				if((long) respectivosValoresAtributos[x] != persistidos.get(i).getDataTermino()){
					return editaisAnd;
				}
			}else{
				return editaisAnd;
			}
		  }
			editaisAnd.add(persistidos.get(i));
		}
		return editaisAnd;
	}
	
	public HashSet<Edital> consultarOr(String[] atributos, Object[] respectivosValoresAtributos) {
		HashSet<Edital> editais = new HashSet<Edital>();

		for (int i = 0; i < persistidos.size(); i++) {
			for (int j = 0; j < atributos.length; j++) {
				//consulta os atributos
				if(atributos[j].equalsIgnoreCase("Nome") || 
						atributos[j].equalsIgnoreCase("CapitalReaisNaoGastoTotal") ||
						atributos[j].equalsIgnoreCase("CusteioReaisNaoGastoTotal") ||
						atributos[j].equalsIgnoreCase("CustoTotal") ||
						atributos[j].equalsIgnoreCase("DataInicio") ||
						atributos[j].equalsIgnoreCase("DataTermino")) {
					
					//compara o valor dos atributos respectivamente
					if(respectivosValoresAtributos[j].equals(persistidos.get(i).getNome()) ||
							(float) respectivosValoresAtributos[j] == persistidos.get(i).getCapitalReaisNaoGastoTotal() ||
							(float) respectivosValoresAtributos[j] == persistidos.get(i).getCusteioReaisNaoGastoTotal() ||
							(float) respectivosValoresAtributos[j] == persistidos.get(i).getCustoTotal() ||
							(long) respectivosValoresAtributos[j] == persistidos.get(i).getDataInicio() ||
							(long) respectivosValoresAtributos[j] == persistidos.get(i).getDataTermino()) {
						editais.add(persistidos.get(i));
					}
				}
			}
		}
		return editais;
	}
	
	private void salvarXML() {
		arquivoColecao = new File("Edital.xml");
		String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>\n";
		xml += xstream.toXML(persistidos);
		try {
			arquivoColecao.createNewFile();
			PrintWriter gravar = new PrintWriter(arquivoColecao);
			gravar.print(xml);
			gravar.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private HashMap<Long, Edital> carregarXML() {                       
		arquivoColecao = new File("Edital.xml");
		try {
			if(arquivoColecao.exists()) {
				FileInputStream fis = new FileInputStream(arquivoColecao);
				return (HashMap<Long, Edital>) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new HashMap<Long, Edital>();
	}

}
