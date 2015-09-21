package br.com.marketdata.olimpiadas.enens;

public enum TagsXml {
		
	INI("<"),END(">"),INIBAR("</");
	
	private String nome;
	private TagsXml(String st){
		nome=st;
	}
	@Override
	public String toString() {
		return nome;
	}
}
