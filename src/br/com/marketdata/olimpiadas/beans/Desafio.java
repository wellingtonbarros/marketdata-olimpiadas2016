package br.com.marketdata.olimpiadas.beans;

import java.util.List;

import br.com.marketdata.olimpiadas.enuns.NomeJogos;

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
