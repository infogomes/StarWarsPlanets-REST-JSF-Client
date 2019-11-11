package br.com.infogomes.starwarsplanetas.model;

import java.io.Serializable;

public class PlanetClient implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private double temperatura;
	private String terreno;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

}
