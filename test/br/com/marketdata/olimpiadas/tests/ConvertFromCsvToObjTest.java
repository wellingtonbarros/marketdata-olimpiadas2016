package br.com.marketdata.olimpiadas.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.marketdata.olimpiadas.ConvertFromCsvToObj;
import br.com.marketdata.olimpiadas.beans.Atleta;
import br.com.marketdata.olimpiadas.beans.Desafio;
import br.com.marketdata.olimpiadas.beans.Podio;

public class ConvertFromCsvToObjTest {

	ConvertFromCsvToObj readCSV = new ConvertFromCsvToObj();

	@Test
	public void convertObjects() {
		List<Podio> covertForObjcts = readCSV.covertForObjcts();
		for (Podio podio : covertForObjcts) {
			System.out.println("------------------------------------");
			System.out.println("Colocado: " +podio.getColocado());
			System.out.println("nome: " + podio.getAtleta().getNome());
			System.out.println("total de ponto: " + podio.getAtleta().getTotalDePontos());
			for (Desafio desafio : podio.getAtleta().getDesafios()) {
				System.out.println("Jogo: " + desafio.getJogo() + " || pontos: " + desafio.getPonto());
			}
			System.out.println("------------------------------------");
		}
	}
}
