/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.upf.ccc.appaula02.dao;

import br.upf.ccc.appaula02.model.Conta;
import java.util.List;

/**
 *
 * @author 210305@upf.br
 */
public interface OperacoesBanco {
	public List<Conta> getLista();
	public void persistir(Conta c);
	public void excluir(Conta c);
	
}
