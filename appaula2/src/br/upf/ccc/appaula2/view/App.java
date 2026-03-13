package br.upf.ccc.appaula2.view;

import br.upf.ccc.appaula2.model.Conta;

public class App {
    public static void main(String[] args) {
        Conta c = new Conta("João Silva", 1000.0);
        IO.println(c.toString());

        c.depositar(250.0);
        IO.println(c.toString());

        boolean sucesso = c.sacar(100.0);
        IO.println("Saque realizado: " + sucesso);
        IO.println(c.toString());

        Conta c2 = new Conta( "Maria Souza", 500.0);
        c.transferir(c2, 200.0);
        IO.println(c.toString());
        IO.println(c2.toString());
    }
}
