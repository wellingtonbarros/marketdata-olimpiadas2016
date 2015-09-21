package br.com.marketdata.olimpiadas;

import java.util.List;

import br.com.arketdata.olimpiadas.serialization.Xml;
import br.com.marketdata.olimpiadas.objects.Desafio;
import br.com.marketdata.olimpiadas.objects.Podio;

public class ConvertToxml {

	private final String xmlTag = "xml";
	private final String resultTag = "Resultado";
	private final String colocado = "colocado-";
	
	public String toXml() {
		StringBuilder xml = new StringBuilder();
		ConvertFromCsvToObj readCSV = new ConvertFromCsvToObj();
		Xml gXml = new Xml();
		List<Podio> podio = readCSV.covertForObjcts();

		xml.append(gXml.headFromString(xmlTag));
		xml.append(gXml.headFromString(resultTag));
		xml.append(gXml.head(Podio.class));
		
		for (int i = 0; i < podio.size(); i++) {

			if (!(i > 0 &&  podio.get(i).getColocado() == podio.get(i - 1).getColocado())) {
				xml.append(gXml.headFromString(colocado+podio.get(i).getColocado()));
			}
			xml.append(gXml.head(podio.get(i).getAtleta().getClass()));

			xml.append(gXml.toXml(podio.get(i).getAtleta()));
			xml.append(gXml.head(Desafio.class));
			for (Desafio desafio : podio.get(i).getAtleta().getDesafios()) {
				xml.append(gXml.toXml(desafio));
			}
			xml.append(gXml.footer(Desafio.class));
			xml.append(gXml.footer(podio.get(i).getAtleta().getClass()));
			if (!(i > 0 &&  i < podio.size()  -1 && podio.get(i).getColocado() == podio.get(i + 1).getColocado())) {
				xml.append(gXml.footerFromString(colocado+podio.get(i).getColocado()));
			}
		}
		xml.append(gXml.footer(Podio.class));
		xml.append(gXml.footerFromString((resultTag)));
		xml.append(gXml.footerFromString((xmlTag)));

		return xml.toString();
	}

}
