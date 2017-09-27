package br.jus.tjse.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.jus.tjse.model.Classe;
import br.jus.tjse.model.Parte;
import br.jus.tjse.model.Processo;

public class ProcessoService {

	private List<Processo> processos = new ArrayList<>();
	private HashMap<String, List<Parte>> partesProcesso = new HashMap<>();

	public ProcessoService() {
		System.out.println("****** Inicializou o Processo Service********");
		Processo p = new Processo("20161000001", "Andamento", new Classe(100, "Habeas Corpos"));

		List<Parte> partes = new ArrayList<>();
		partes.add(new Parte("João da Silva", "99999999999"));
		partes.add(new Parte("Maria Celestina", "88888888888"));
		partes.add(new Parte("Gabriela Resende", "77777777777"));

		partesProcesso.put("20161000001", partes);
		processos.add(p);

		partes = new ArrayList<>();
		p = new Processo("20161000002", "Andamento", new Classe(101, "Mandado de Segurança"));

		partes.add(new Parte("José das Covas", "11111111111"));
		partes.add(new Parte("Hugo Guimarães", "22222222222"));

		partesProcesso.put("20161000002", partes);
		processos.add(p);

		partes = new ArrayList<>();
		partes.add(new Parte("Helena Cardoso", "44444444444"));
		partes.add(new Parte("Gilmar R.", "55555555555"));
		p = new Processo("20161000003", "Andamento", new Classe(200, "Inquérito"));

		partesProcesso.put("20161000003", partes);
		processos.add(p);

		partes = null;
	}

	public Boolean gravar(Processo p) {
		System.out.println("****** Salvando Processo******");
		System.out.println("Número processo: " + p.getNumero());
		System.out.println("Classe: " + p.getClasse().getDescricao());
		System.out.println("Situação: " + p.getSituacao());
		return true;
	}

	public List<Parte> listarPartes(String numero) {

		if (partesProcesso.containsKey(numero))
			return partesProcesso.get(numero);

		// lista de partes vazia
		return new ArrayList<Parte>();

	}

	public Processo processoPorNumero(String numero) {
		for (Processo p : processos)
			if (p.getNumero().equals(numero))
				return p;
		return null;
	}

	public List<Processo> todos() {
		return processos;
	}

	public Processo remover(String numero) {
		return processoPorNumero(numero);
	}

	public Processo atualizar(Processo p) {
		return processoPorNumero(p.getNumero());
	}
}
