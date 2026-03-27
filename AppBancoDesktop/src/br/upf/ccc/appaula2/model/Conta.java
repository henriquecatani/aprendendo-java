package br.upf.ccc.appaula2.model;

public class Conta {
    private Integer id;
    private String titular;
    private Double saldo;

    static private Integer maxId = 0;
    // construtores
    public Conta(String titular, Double saldo) {
        this.id = novoId();
        this.titular = titular;
        this.saldo = saldo;
    }

    public Conta(String titular) {
        this.id = novoId();
        this.titular = titular;
        this.saldo = 0.0;
    }
    // fim dos construtores

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
    
    
    // getters e setters
    public String getTitular() {
        return titular;
    }
    
    private Integer novoId() {
    maxId++;
    return maxId;
    }
    
    public Double getSaldo() {
        return saldo;
    }

    // métodos de negócio
    public void depositar(Double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(Double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(Conta destino, Double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

}
