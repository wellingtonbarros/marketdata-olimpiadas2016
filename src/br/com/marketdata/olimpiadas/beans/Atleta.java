package br.com.marketdata.olimpiadas.beans;

import java.util.ArrayList;
import java.util.List;

import br.com.marketdata.olimpiadas.annotation.TagName;

@TagName(nome="atleta")
public class Atleta implements Comparable<Atleta> {
	
	@TagName(nome="nome-do-atleta")
	private String nome;
	@TagName(nome="total-de-pontos")
	private float totalDePontos;
	private List<Desafio> desafios = new ArrayList<Desafio>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getTotalDePontos() {
		return totalDePontos;
	}
	public void setTotalDePontos(float totalDePontos) {
		this.totalDePontos = totalDePontos;
	}

	public List<Desafio> getDesafios() {
		return desafios;
	}
	public void setDesafios(List<Desafio> desafios) {
		this.desafios = desafios;
	}
	public int compareTo(Atleta o) {

		if (this.totalDePontos > o.totalDePontos) {
			return -1;	
		}else if (this.totalDePontos < o.totalDePontos) {
			return 1;
		}else{
			return 0;
		}
		
	}
	
	
}
