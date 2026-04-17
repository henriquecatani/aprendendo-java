/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.upf.ccc.classes;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author 210305@upf.br
 */
@Entity
public class Avaliacao {

	public Avaliacao(Integer matricula, String nome, Float notaUm, Float notaDois, Float notaTres, Float notaRecuperacao, Float notaExame) throws Exception {
		setMatricula(matricula);
		setNome(nome);
		setNotaUm(notaUm);
		setNotaDois(notaDois);
		setNotaTres(notaTres);
		setNotaRecuperacao(notaRecuperacao);
		setNotaExame(notaExame);
	}
	@Id
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
		if (matricula != null) this.matricula = matricula;
		else throw new IllegalArgumentException("Insira a matrícula!");
	}

	public void setNome(String nome) {
		if (nome != null) this.nome = nome;
		else this.nome = "Sem Nome";
	}

	public void setNotaUm(Float notaUm) {
		this.notaUm = verificarNota(notaUm);
	}

	public void setNotaDois(Float notaDois) {
		this.notaDois = verificarNota(notaDois);
	}

	public void setNotaTres(Float notaTres) {
		this.notaTres = verificarNota(notaTres);
	}

	public void setNotaRecuperacao(Float notaRecuperacao) {
		this.notaRecuperacao = verificarNota(notaRecuperacao);
	}

	public void setNotaExame(Float notaExame) {
		this.notaExame = verificarNota(notaExame);
	}
	
	private Float verificarNota(Float nota) {
		if (nota == null) return nota;
		if (nota < 0 || nota > 10)
			throw new IllegalArgumentException("Nota inválida!");
		else return nota;
	}
		
	public Float getMedia() throws Exception{
		Float soma = 0f;
		int cnt = 0;
		if (notaUm	!= null) { soma += notaUm; cnt++; }
		if (notaDois	!= null) { soma += notaDois; cnt++; }
		if (notaTres	!= null) { soma += notaTres; cnt++; }
                if (cnt < 3) {
                    if (notaRecuperacao != null) { soma += notaRecuperacao; cnt++;}
		    else throw new Exception("Faltam notas para calcular a média!");
                }
		return soma / 3;
	}

	public Float getMediaFinal() throws Exception{
		Float soma = getMedia();
		if (notaExame != null) { 
			soma += notaExame;
			return soma / 2;
		} else return soma;
	}

	public String getSituacao() throws Exception{
		Float mediaFinal;
		mediaFinal = getMediaFinal();
		if (notaExame != null) {
			return (mediaFinal >= 5) ? "aprovado" : "reprovado";
		} else {
			return (mediaFinal >= 7) ? "aprovado" : "em exame";
		}
	}
}
