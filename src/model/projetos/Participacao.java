package model.projetos;

import model.projetos.ponto.HorarioPrevisto;
import model.projetos.ponto.PontoTrabalhado;

/**
 * @author PAULO E INATHAN - TATAKAE!
 * Essa classe � a participa��o do projeto
 */
public class Participacao extends CompositorProjeto {
	/**
	 * {@link #aporteCusteioMensalReais} Esse atributo informa o custeio mensal
	 * {@link #qtdMesesCusteados} Esse atributo informa a quantidade de m�ses custeados
	 * {@link #qtdMesesPagos} Esse atributo informa os m�ses pagos
	 * {@link #coordenador} Esse atributo informa se tem ou n�o coordenador
	 */
	private float aporteCusteioMensalReais;
	private short qtdMesesCusteados;
	private short qtdMesesPagos;
	private boolean coordenador;
	private HorarioPrevisto horario;
	private PontoTrabalhado ponto;
	
	@Override
	public void ativar() {
		setAtivo(true);
		
	}
	@Override
	public void desativar() {
		setAtivo(false);
	}
	@Override
	public float getCustoTotal() {
		return (aporteCusteioMensalReais*qtdMesesCusteados);
	}
	@Override
	public float getCusteioReaisNaoGastoTotal() {
		return (aporteCusteioMensalReais*qtdMesesCusteados)-(aporteCusteioMensalReais*qtdMesesPagos);
	}
	public float getAporteCusteioMensalReais() {
		return aporteCusteioMensalReais;
	}
	public void setAporteCusteioMensalReais(float aporteCusteioMensalReais) {
		this.aporteCusteioMensalReais = aporteCusteioMensalReais;
	}
	public short getQtdMesesCusteados() {
		return qtdMesesCusteados;
	}
	public void setQtdMesesCusteados(short qtdMesesCusteados) {
		this.qtdMesesCusteados = qtdMesesCusteados;
	}
	public short getQtdMesesPagos() {
		return qtdMesesPagos;
	}
	public void setQtdMesesPagos(short qtdMesesPagos) {
		this.qtdMesesPagos = qtdMesesPagos;
	}
	public boolean isCoordenador() {
		return coordenador;
	}
	public void setCoordenador(boolean coordenador) {
		this.coordenador = coordenador;
	}
	public void adicionarPontoTrabalhado(PontoTrabalhado ponto){
		this.ponto = ponto;
		this.ponto.setParticipacao(this);
	}
	public void adicionarHorarioPrevisto(HorarioPrevisto horario){
		this.horario = horario;
		this.horario.setParticipacao(this);
	}
	public PontoTrabalhado getPontoTrabalhado(){
		return ponto;
	}
	public HorarioPrevisto getHorarioPrevisto(){
		return horario;
	}
	@Override
	public void remover(CompositorProjeto compositorProjeto) {
		for(CompositorProjeto com: getCompositorProjeto()){
			if(com.getId()== com.getId()){
				getCompositorProjeto().remove(com);
				setCompositorProjeto(getCompositorProjeto());
				break;
			}
		}
	}
}

