package br.jus.tjse.service;

import java.util.ArrayList;
import java.util.List;

import br.jus.tjse.model.Parte;

public class PartesService {

	List<Parte> partes = new ArrayList<>();

	public PartesService() {
		partes.add(new Parte("João da Silva", "99999999999"));
		partes.add(new Parte("Maria Celestina", "88888888888"));
		partes.add(new Parte("Gabriela Resende", "77777777777"));
		partes.add(new Parte("José das Covas", "11111111111"));
		partes.add(new Parte("Hugo Guimarães", "22222222222"));
		partes.add(new Parte("Helena Cardoso", "44444444444"));
		partes.add(new Parte("Gilmar R.", "55555555555"));

	}
	
	public List<Parte> todas(){
		return partes;
	}

}
