package br.aulashelder.listview;

public class Task {

	private String nome;
	private int status;
	private int imagem;


	public Task() {
	}

	public Task(String nome, int status, int imagem) {
		super();
		this.nome = nome;
		this.status = status;
		this.imagem = imagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getImagem() {
		return imagem;
	}

	public void setImagem(int imagem) {
		this.imagem = imagem;
	}	
	
	@Override
	public String toString() {
		return nome;
	}
}