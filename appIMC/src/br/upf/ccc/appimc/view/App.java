package br.upf.ccc.appimc.view;

import java.util.ArrayList;
import br.upf.ccc.appimc.dominio.IMC;
import br.upf.ccc.appimc.util.ConsoleInput;


public class App {
    public static void main(String[] args) throws Exception {
        IO.println("Cálculo de IMC");
        ArrayList<IMC> testes = new ArrayList<>();
        String continuar = "s";

        while (continuar.equalsIgnoreCase("s")) {
            String cpf = ConsoleInput.lerString("Digite o CPF: ");
            String nome = ConsoleInput.lerString("Digite o nome: ");
            Double peso = ConsoleInput.lerDouble("Digite o peso (kg): ");
            Double altura = ConsoleInput.lerDouble("Digite a altura (m): ");

            IMC imc = new IMC(cpf, nome, peso, altura);
            testes.add(imc);

            continuar = ConsoleInput.lerString("Realizar outro teste? (s/n): ");
        }

        for (IMC teste : testes) {
            teste.resultados();
            IO.println("-------------------------");
        }
        IO.println("Até mais!");
    }
}
