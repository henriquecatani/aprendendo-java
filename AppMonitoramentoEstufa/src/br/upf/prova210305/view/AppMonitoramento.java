package br.upf.prova210305.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.upf.prova210305.dominio.Leitura;

public class AppMonitoramento {
    private static ArrayList<Leitura> leituras;

    private static void adicionarLeituras (int qntLeituras) {
        leituras = new ArrayList<Leitura>();

        int i = 1;
        while (i <= qntLeituras) {
            JOptionPane.showMessageDialog(null, "\nAdicionando leitura " + i);
            Leitura leitura = new Leitura();

            leitura.setHorario(JOptionPane.showInputDialog("Horário: "));


            Boolean tempValida = false;
            while (!tempValida) {
                try { 
                    leitura.setValorCelsius(Double.parseDouble(JOptionPane.showInputDialog("Temperatura (Celsius): ")));

                    tempValida = true;
                } 
                catch ( IllegalArgumentException ex ) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }

            if (!leituras.contains(leitura)) {
                leituras.add(leitura);
                i++;
            } 
            else JOptionPane.showMessageDialog(null, "Leitura duplicada!");
        }
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
            JOptionPane.showMessageDialog(null, "Média de temperaturas Muito Baixa");
        else if (media > 30)
            JOptionPane.showMessageDialog(null, "Média de temperaturas Muito Alta");
    }

    private static void historico () {
        Double maiorTemperatura = 0d; // valor minimo permitido no setter: 1
        Double menorTemperatura = 40d; // valor maximo permitido no setter: 39
        // ps.: esses valores podiam ser atributos estaticos em Leitura
        String mensagem = "";

        for (Leitura l : leituras) {

            Double t = l.getValorCelsius();
            mensagem += l.getHorario() + " - " 
            + t.toString() + " - " + l.getFaixa() + "\n";
            
            menorTemperatura = Double.min(t, menorTemperatura);
            maiorTemperatura = Double.max(t, maiorTemperatura);
        }

        mensagem += "\nMenor temperatura: " + menorTemperatura.toString()
        + "\nMaior temperatura: " + maiorTemperatura.toString()
        + "\nMédia de temperaturas: " + obterMedia().toString();

        JOptionPane.showMessageDialog(null, mensagem);
    }
    public static void main(String[] args) throws Exception {
        JOptionPane.showMessageDialog(null, "Bem vindo ao app de Monitoramento de temperaturas!");
        
        int qntLeituras = Integer.parseInt(JOptionPane.showInputDialog("\nDiga a quantidade de leituras a fazer."));
        adicionarLeituras(qntLeituras);

        historico();
        alerta();
        
        return;
    }
}
