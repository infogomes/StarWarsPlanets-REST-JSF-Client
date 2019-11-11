package br.com.infogomes.starwarsplanetas.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.infogomes.starwarsplanetas.model.PlanetClient;

@ManagedBean
public class PlanetControllerBean {
	private Long id;
	private String nome;
	private BigDecimal temperatura;
	private String terreno;

	public List<PlanetClient> getPegaDados() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/starwarsplanetas/planet");
		String json = target.request().get(String.class);
		Gson gson = new Gson();
		return gson.fromJson(json, new TypeToken<List<PlanetClient>>() {
		}.getType());
	}

	public Response enviaDados() {
		PlanetClient planetClient = new PlanetClient();
		
		planetClient.setNome(nome);
		planetClient.setTemperatura(temperatura.doubleValue());
		planetClient.setTerreno(terreno);

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/starwarsplanetas/planet");
		Invocation.Builder ib = target.request(MediaType.APPLICATION_JSON);
		Response response = ib.post(Entity.entity(planetClient, MediaType.APPLICATION_JSON));
		this.limparCampos();
		return response;
		
	}

	public void apagaDados(long id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/starwarsplanetas/planet/" + id);
		target.request().delete();

	}

	private void limparCampos() {
		this.setNome(null);
		this.setTemperatura(null);
		this.setTerreno(null);
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getTemperatura() {
		return temperatura;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTemperatura(BigDecimal temperatura) {
		this.temperatura = temperatura;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	
	
}
