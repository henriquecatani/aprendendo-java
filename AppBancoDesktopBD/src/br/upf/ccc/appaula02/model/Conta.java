package br.upf.ccc.appaula02.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Conta {
   // Aqui definimos os atributos
   @Id
   private Integer numero;
   private String titular;
   private Float saldo;

   // Aqui definimos o construtor
   public Conta(){
      saldo = 0.0f;
   }

   // definir um construtor que recebe o número e o titular
   public Conta(Integer numero, String titular){
      //this.numero = numero;
      setNumero(numero);
      this.titular = titular;
      saldo = 0.0f;
   }
   
   public Conta(Integer numero) {
      //this.numero = numero;
      setNumero(numero);
      saldo = 0.0f;
   }

   // Aqui definimos os métodos
   public void depositar(Float valor){
       saldo += valor;
   }

   public void sacar(Float valor){
      saldo -= valor;
   }

   public void transferir(Float valor, Conta destino){
      saldo -= valor; // tirar da origem
      destino.saldo += valor; // colocar no destino
   }

   public Integer getNumero() {
      return numero;
   }

   public void setNumero(Integer numero) {
      if (numero <= 0) {
         throw new IllegalArgumentException("Número da conta deve ser positivo.");
      }
      this.numero = numero;
   }

   public String getTitular() {
      return titular;
   }

   public void setTitular(String titular) {
      this.titular = titular;
   }

   public Float getSaldo() {
      return saldo;
   }

   public void setSaldo(Float saldo) {
      this.saldo = saldo;
   }

   @Override
   public String toString() {
      return numero + " - " + titular;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((numero == null) ? 0 : numero.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Conta other = (Conta) obj;
      if (numero == null) {
         if (other.numero != null)
            return false;
      } else if (!numero.equals(other.numero))
         return false;
      return true;
   }

   

}
