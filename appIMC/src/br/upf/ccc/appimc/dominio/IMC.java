package br.upf.ccc.appimc.dominio;

public class IMC {
    private String cpf;
    private String nome;
    private Double peso;
    private Double altura;

    public IMC(String cpf, String nome, Double peso, Double altura) {
        this.cpf = cpf;
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
    }

    public Double calcularIMC() {
        return peso / (altura * altura);
    }

    public String interpretarIMC(Double imc) {
        if (imc < 18.5) {
            return "Magreza";
        } else if (imc >= 18.5 && imc < 25) {
            return "Normal";
        } else if (imc >= 25 && imc < 30) {
            return "Sobrepeso";
        } else if (imc >= 30 && imc < 40) {
            return "Obesidade";
        } else {
            return "Obesidade Grave";
        }
    }

    public void resultados() {
        Double imc = calcularIMC();
        IO.println("Resultados do teste de IMC:");
        IO.println("CPF: " + cpf);
        IO.println("Nome: " + nome);
        IO.println("Peso: " + peso);
        IO.println("Altura: " + altura);
        IO.println("IMC: " + imc);
        IO.println("Interpretação: " + interpretarIMC(imc));
    }
}
