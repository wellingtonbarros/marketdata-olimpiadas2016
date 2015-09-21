package br.com.marketdata.olimpiadas.objects;

import java.util.List;

import br.com.marketdata.olimpiadas.enens.NomeJogos;

public class Desafio   {
	
	private NomeJogos jogo;
	private float ponto;
	
	public NomeJogos getJogo() {
		return jogo;
	}
	public void setJogo(NomeJogos jogo) {
		this.jogo = jogo;
	}
	public float getPonto() {
		return ponto;
	}
	public void setPonto(float ponto) {
		this.ponto = ponto;
	}
}
