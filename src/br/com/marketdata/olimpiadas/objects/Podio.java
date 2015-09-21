package br.com.marketdata.olimpiadas.objects;

import br.com.marketdata.olimpiadas.annotation.TagName;

@TagName(nome="podio")
public class Podio implements Comparable<Podio>{
	
	private int colocado;
	private Atleta atleta;
	
	public int getColocado() {
		return colocado;
	}
	public void setColocado(int colocado) {
		this.colocado = colocado;
	}
	public Atleta getAtleta() {
		return atleta;
	}
	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
	public int compareTo(Podio o) {
		if (this.colocado < o.colocado) {
			return -1;	
		}else if (this.colocado > o.colocado) {
			return 1;
		}else{
			return 0;
		}
	}
	
	
}
