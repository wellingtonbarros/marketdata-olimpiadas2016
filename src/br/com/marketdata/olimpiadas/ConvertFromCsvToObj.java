package br.com.marketdata.olimpiadas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.marketdata.olimpiadas.beans.Atleta;
import br.com.marketdata.olimpiadas.beans.Desafio;
import br.com.marketdata.olimpiadas.beans.Podio;
import br.com.marketdata.olimpiadas.enens.NomeJogos;

public class ConvertFromCsvToObj {

	private final String file = "Entrada.csv";

	public List<Podio> covertForObjcts() {

		BufferedReader buff = null;
		String lines = "";
		String fileSplitBy = ";";
		List<Podio> podios = new ArrayList<Podio>();

		try {
			buff = new BufferedReader(new FileReader(file));
			while ((lines = buff.readLine()) != null) {
				String[] collun = lines.split(fileSplitBy);
				
				Podio podio = new Podio();
				Atleta atleta = new Atleta();
				atleta.setNome(collun[0]);
				this.setDesafios(collun, atleta);
				podio.setAtleta(atleta);
				this.orderColocado(podios, atleta, podio);
				podios.add(podio);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Collections.sort(podios);
		return podios;
	}

	private void orderColocado(List<Podio> podios, Atleta atleta, Podio podio) {
		if (podios.size() == 0) {
			podio.setColocado(1);
		} else {
			for (Podio ps : podios) {
				if (ps.getAtleta().getTotalDePontos() < atleta.getTotalDePontos()) {
					podio.setColocado(ps.getColocado());
					ps.setColocado(podio.getColocado() + 1);
				} else if (ps.getAtleta().getTotalDePontos() == atleta.getTotalDePontos()) {
					podio.setColocado(ps.getColocado());
				}
			}
		
		}
	}

	public List<Desafio> setDesafios(String[] collun, Atleta atleta) {
		List<Desafio> desafios = new ArrayList<Desafio>();
		float pontos = 0;
		for (int i = 1; i < collun.length - 1; i++) {
			Desafio desafio = new Desafio();
			switch (i) {
			case 1:
				desafio.setJogo(NomeJogos._100METROS);
				break;
			case 2:
				desafio.setJogo(NomeJogos.SALTOADISTANCIA);
				break;
			case 3:
				desafio.setJogo(NomeJogos.ARREMESSO);
				break;
			case 4:
				desafio.setJogo(NomeJogos.SALTOEMALTURA);
				break;
			case 5:
				desafio.setJogo(NomeJogos._400METROS);
				break;
			case 6:
				desafio.setJogo(NomeJogos._110METROSCOMBARREIRAS);
				break;
			case 7:
				desafio.setJogo(NomeJogos.LANCAMENTODEDISCO);
				break;
			case 8:
				desafio.setJogo(NomeJogos.SALTOCOMVARA);
				break;
			case 9:
				desafio.setJogo(NomeJogos.LANCAMENTODEDARDOS);
				break;
			case 10:
				desafio.setJogo(NomeJogos._1500METROS);
				break;
			}
			desafio.setPonto(Float.parseFloat(collun[i]));
			pontos += Float.parseFloat(collun[i]);
			desafios.add(desafio);
		}
		atleta.setTotalDePontos(pontos);
		atleta.setDesafios(desafios);
		return desafios;
	}
}
