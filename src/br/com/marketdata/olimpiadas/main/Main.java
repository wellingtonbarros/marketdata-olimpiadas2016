package br.com.marketdata.olimpiadas.main;

import br.com.marketdata.olimpiadas.Convert;

public class Main {
	public static void main(String[] args) {
		Convert convertToxml = new Convert();
		System.out.println(convertToxml.toXml());
	}
}
