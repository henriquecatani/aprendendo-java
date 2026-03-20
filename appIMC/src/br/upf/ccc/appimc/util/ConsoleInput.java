package br.upf.ccc.appimc.util;

public class ConsoleInput {

    /**
     * Método para ler um número inteiro do console.
     * @param mensagem A mensagem a ser exibida para o usuário.
     * @return O número inteiro lido.
     */
    public static Integer lerInt(String mensagem) {
        IO.print(mensagem);
        return Integer.parseInt(System.console().readLine());
    }

    /**
     * Método para ler um número decimal do console.
     * @param mensagem A mensagem a ser exibida para o usuário.
     * @return O número decimal lido.
     */
    public static Double lerDouble(String mensagem) {
        IO.print(mensagem);
        return Double.parseDouble(System.console().readLine());
    }

    /**
     * Método para ler uma string do console.
     * @param mensagem A mensagem a ser exibida para o usuário.
     * @return A string lida.
     */    
    public static String lerString(String mensagem) {
        IO.print(mensagem);
        return System.console().readLine();
     }


}
