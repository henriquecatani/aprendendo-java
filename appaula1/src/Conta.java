public class Conta {
   // Aqui definimos os atributos
   Integer numero;
   String titular;
   Float saldo;

   // Aqui definimos os métodos
   void depositar(Float valor){
       saldo += valor;
   }

   void sacar(Float valor){
      saldo -= valor;
   }

   void transferir(Float valor, Conta destino){
      saldo -= valor; // tirar da origem
      destino.saldo += valor; // colocar no destino
   }

}
