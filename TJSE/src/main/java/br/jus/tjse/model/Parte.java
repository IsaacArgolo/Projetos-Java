package br.jus.tjse.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Parte {
	
	private String nome;
	private String cpf;

	public Parte() {

	}
	
	public Parte(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
