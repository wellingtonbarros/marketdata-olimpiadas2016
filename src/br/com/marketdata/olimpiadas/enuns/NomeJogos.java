package br.com.marketdata.olimpiadas.enuns;

public enum NomeJogos {

	_100METROS("100 Metros"), SALTOADISTANCIA("Salto à distância"), ARREMESSO("Arremesso"), SALTOEMALTURA(
			"Salto em altura"), _400METROS("400 Metros"), _110METROSCOMBARREIRAS(
					"110 metros com barreiras"), LANCAMENTODEDISCO("Lançamento de Disco"), SALTOCOMVARA(
							"Salto com Vara"), LANCAMENTODEDARDOS("Lançamento de Dardos"), _1500METROS("1500 metros");

	private final String nome;

	private NomeJogos(String s) {
		nome = s;
	}

	@Override
	public String toString() {
		return this.nome;
	}
}
