package src.models;

import java.math.BigDecimal;
import java.util.UUID;

public class Produto {
    private String id;
    
    public String getId() {
        return id;
    }

    private String nome;
    private BigDecimal preco;
    private EnumTipoProduto tipo;

    // Construtores
    public Produto() {
        this.id = UUID.randomUUID().toString();    
    }

    

    public Produto(String nome, BigDecimal preco, EnumTipoProduto tipo) {
        this.id  = UUID.randomUUID().toString();
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
    }

    public Produto(String nome, double preco, EnumTipoProduto tipo) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.preco = BigDecimal.valueOf(preco);
        this.tipo = tipo;
    }

    // Getters and setters
    public String getNome() {
        return this.nome;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }

    public double getPrecoDouble() {
        return this.preco.doubleValue();
    }

    public EnumTipoProduto getTipo() {
        return tipo;
    }
}
