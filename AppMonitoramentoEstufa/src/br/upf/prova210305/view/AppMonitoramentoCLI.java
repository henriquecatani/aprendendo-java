package br.upf.prova210305.view;

import java.util.ArrayList;
import java.util.Scanner;

import br.upf.prova210305.dominio.Leitura;

public class AppMonitoramentoCLI {
    private static ArrayList<Leitura> leituras;

    private static void adicionarLeituras () {
        leituras = new ArrayList<Leitura>();

        Scanner ler = new Scanner(System.in);
        int i = 1;
        while (i <= 5) {
            System.out.println("\nAdicionando leitura " + i);
            Leitura leitura = new Leitura();

            System.out.print("Horário: ");
            leitura.setHorario(ler.next());

            Boolean tempValida = false;
            while (!tempValida) {
                try { 
                    System.out.print("Temperatura (Celsius): ");
                    leitura.setValorCelsius(ler.nextDouble());

                    tempValida = true;
                } 
                catch ( IllegalArgumentException ex ) {
                    System.out.println(ex.getMessage());
                }
            }

            // Boolean leituraValida = leituras.isEmpty() ? true : false;
            // for (Leitura l : leituras) {
            //     if (leitura.getValorCelsius().equals(l.getValorCelsius()) &&
            //         leitura.getHorario().equals(l.getHorario())) {
            //         leituraValida = false;
            //         break;
            //     } 
            //     else 
            //         leituraValida = true;
            // }

            // if (leituraValida) {

            if (!leituras.contains(leitura)) {
                leituras.add(leitura);
                i++;
            } 
            else System.out.println("Leitura duplicada!");
        }

        ler.close();
    }

    private static Double obterMedia () {
        Double soma = 0d;

        for (Leitura l : leituras) 
            soma += l.getValorCelsius();

        int qntLeituras = leituras.size();
        return qntLeituras != 0 ? soma / qntLeituras : null;
    }

    private static void alerta () {
        Double media = obterMedia();
        if (media == null) return;

        if (media < 15) 
            System.out.println("Média de temperaturas Muito Baixa");
        else if (media > 30)
            System.out.println("Média de temperaturas Muito Alta");
    }

    private static void historico () {
        Double menorTemperatura = 0d; // valor minimo permitido no setter: 1
        Double maiorTemperatura = 40d; // valor maximo permitido no setter: 39
        // ps.: esses valores podiam ser atributos estaticos em Leitura

        for (Leitura l : leituras) {

            Double t = l.getValorCelsius();
            System.out.print(l.getHorario() + " - ");
            System.out.print(t.toString() + " - ");
            System.out.println(l.getFaixa());
            
            menorTemperatura = Double.min(t, menorTemperatura);
            maiorTemperatura = Double.max(t, maiorTemperatura);
        }

        System.out.println("Menor temperatura: " + menorTemperatura.toString());
        System.out.println("Maior temperatura: " + maiorTemperatura.toString());
        System.out.println("Média de temperaturas: " + obterMedia().toString());
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Bem vindo ao app de Monitoramento de temperaturas!");
        
        System.out.println("\nAdicionando 5 leituras.");
        adicionarLeituras();

        System.out.println("\nHistórico:");
        historico();
        alerta();
        
        return;
    }
}
