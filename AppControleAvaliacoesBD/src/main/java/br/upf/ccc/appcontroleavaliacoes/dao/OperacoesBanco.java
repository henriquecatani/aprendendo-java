/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.upf.ccc.appcontroleavaliacoes.dao;

import java.util.List;
import br.upf.ccc.classes.Avaliacao;

/**
 *
 * @author catani
 */
public interface OperacoesBanco {
	public List<Avaliacao> getLista();
	public void persistir(Avaliacao a);
	public void excluir(Avaliacao a);
	
}
