package br.jus.tjse.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

import br.jus.tjse.annotations.ValidarProcesso;

@XmlRootElement(name = "processo")
public class Processo {

	@ValidarProcesso
	private String numero;

	@NotBlank(message = "A situação não pode ser vazia")
	// @Size(min=2,message="tamanho maior que 2")
	private String situacao;

	private List<Parte> partes;

	@NotNull(message = "A classe não pode ser vazia")
	private Classe classe;

	public Processo() {

	}

	public Processo(String numero, String situacao, Classe classe) {
		this.numero = numero;
		this.situacao = situacao;
		this.classe = classe;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	@XmlElement
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public List<Parte> getPartes() {
		return partes;
	}

	public void setPartes(List<Parte> partes) {
		this.partes = partes;
	}

	@Override
	public String toString() {
		return "Processo :{ \n numero: " + getNumero() + "\n," + "situacao: " + getSituacao() + "\n," + getClasse()
				+ "\n}";
	}

}
