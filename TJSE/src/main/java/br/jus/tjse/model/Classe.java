package br.jus.tjse.model;

import javax.xml.bind.annotation.XmlRootElement;

import br.jus.tjse.annotations.ValidarProcesso;

@XmlRootElement(name="classe")

@ValidarProcesso
public class Classe {
	
	private int codigo;
	private String descricao;
	
	public Classe() {
	
	}
	
	public Classe(int codigo, String descricao) {
		
		this.codigo = codigo;
		this.descricao = descricao;
	}



	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString(){
		return "Classe :{codigo: "+getCodigo()+"\n,"+"descricao: "+getDescricao()+"\n}";
	}

}
