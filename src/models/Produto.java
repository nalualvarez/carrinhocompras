package src.models;

import java.math.BigDecimal;

public class Produto {
    private String nome;
    private double preco;

    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Produto() {

    }

}
