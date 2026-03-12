import java.util.Scanner;

public class AppScanner {
   // Criar uma conta e ler dados do usuário
   public static void main(String[] args) {
      Conta c = new Conta();
      // para ler os dados vamos instanciar um objeto Scanner de input
      Scanner ler = new Scanner(System.in);
      System.out.print("Número: ");
      c.numero = ler.nextInt();
      System.out.print("Titular: ");
      c.titular = ler.next();
      c.saldo = 0f;
      ler.close();
      // agora mostrar os dados da conta
      System.out.println("Conta lida");
      System.out.println(c.numero+" "+c.titular);
   }
}
