package br.com.marketdata.olimpiadas.tests;

import org.junit.Test;

import br.com.marketdata.olimpiadas.Convert;

public class ConvertToxmlTest {
		@Test
		public void testConvertToXml(){
			Convert convertToxml = new Convert();
			System.out.println(convertToxml.toXml());
		}
}
