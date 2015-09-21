package br.com.arketdata.olimpiadas.main;

import br.com.marketdata.olimpiadas.ConvertToxml;

public class Main {
	public static void main(String[] args) {
		ConvertToxml convertToxml = new ConvertToxml();
		System.out.println(convertToxml.toXml());
	}
}
