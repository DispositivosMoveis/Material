package br.aulashelder.model;

public class Pessoa {
	
	private String nome;
	private int idade;
	
	public Pessoa(String nome, int idade){
		this.setNome(nome);
		this.setIdade(idade);
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString(){
		return nome+";"+idade;
	}
	

}
