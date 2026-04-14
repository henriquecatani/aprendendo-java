/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.upf.ccc.classes;

/**
 *
 * @author 210305@upf.br
 */
public class Avaliacao {
	private Integer matricula;
	private String nome;
	private Float notaUm;
	private Float notaDois;
	private Float notaTres;
	private Float notaRecuperacao;
	private Float notaExame;
	
	public Integer getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public Float getNotaUm() {
		return notaUm;
	}

	public Float getNotaDois() {
		return notaDois;
	}

	public Float getNotaTres() {
		return notaTres;
	}

	public Float getNotaRecuperacao() {
		return notaRecuperacao;
	}

	public Float getNotaExame() {
		return notaExame;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNotaUm(Float notaUm) {
		this.notaUm = verificarNota(notaUm) ? notaUm : null;
	}

	public void setNotaDois(Float notaDois) {
		this.notaDois = verificarNota(notaDois) ? notaDois : null;
	}

	public void setNotaTres(Float notaTres) {
		this.notaTres = verificarNota(notaTres) ? notaTres : null;
	}

	public void setNotaRecuperacao(Float notaRecuperacao) {
		this.notaRecuperacao = verificarNota(notaRecuperacao) ? notaRecuperacao : null;
	}

	public void setNotaExame(Float notaExame) {
		this.notaExame = verificarNota(notaExame) ? notaExame : null;
	}
	
	public Boolean verificarNota(Float nota) {
		if (nota > 0 && nota <= 10) return true;
		else if (nota == null) return true;
		else return false;
	}
		
	public Float getMedia(){
		Float soma = 0f;
		int cnt = 0;
		if (notaUm	!= null) { soma += notaUm; cnt++; }
		if (notaDois	!= null) { soma += notaDois; cnt++; }
		if (notaTres	!= null) { soma += notaTres; cnt++; }
		if (cnt != 0) return soma / cnt;
		return null;
	}
}
