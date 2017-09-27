package br.jus.tjse.service;

import java.util.ArrayList;
import java.util.List;

import br.jus.tjse.model.Classe;

public class ClasseService {
	List<Classe> classes = new ArrayList<>();

	public ClasseService() {
		// classes.add(new Classe(144,"Casamento"));
		classes.add(new Classe(144, "Casamento"));
		classes.add(new Classe(145, "Execução"));
		classes.add(new Classe(101, "Mandado de Segurança"));
		classes.add(new Classe(100, "Habeas Corpos"));
		classes.add(new Classe(200, "Inquérito"));

	}

	public List<Classe> getClasses() {
		return classes;
	}

}
