package br.com.marketdata.olimpiadas.tests;

import org.junit.Test;

import br.com.marketdata.olimpiadas.ConvertToxml;

public class ConvertToxmlTest {
		@Test
		public void testConvertToXml(){
			ConvertToxml convertToxml = new ConvertToxml();
			System.out.println(convertToxml.toXml());
		}
}
