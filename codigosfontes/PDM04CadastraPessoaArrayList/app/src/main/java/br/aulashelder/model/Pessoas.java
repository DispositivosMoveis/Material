package br.aulashelder.model;

import java.util.ArrayList;

public class Pessoas {
	
	private ArrayList arrayPessoas = null;
	
	public Pessoas(){
		arrayPessoas = new ArrayList();
	}
	
	public void adicionar(Pessoa p){
		this.arrayPessoas.add(p);
	}
	public Pessoa obter(int i){
		return (Pessoa)this.arrayPessoas.get(i);
	}
	public int tamanho(){
		return this.arrayPessoas.size();
	}

}
