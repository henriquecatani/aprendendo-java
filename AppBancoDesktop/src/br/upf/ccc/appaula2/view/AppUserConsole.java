package br.upf.ccc.appaula2.view;

import java.util.ArrayList;
import br.upf.ccc.appaula2.model.Conta;

public class AppUserConsole {
    static ArrayList<Conta> contas = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao sistema bancário!");
        System.out.println("------------------------------");
        System.out.println("1. Criar conta, 2. Listar contas, 3. Depositar, 4. Sacar, 5. Transferir, 6. Alterar conta, 0. Sair");

    }
}
