package br.aulashelder.model;

public class Aluno {
	
	private double nota1;
	private double nota2;
	private double media;
	
	public Aluno(double nota1, double nota2){
		this.setNota1(nota1);
		this.setNota2(nota2);
	}
	
	public double calcularMedia() throws Exception {
		if (getNota1() >10 || getNota1() <0 || getNota2() >10 || getNota2() <0){
			throw new Exception("Notas Invalidas");
		}
		else{
	    	setMedia((getNota1() + getNota2())/2);
		}
		return getMedia();
	}


	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}
}
