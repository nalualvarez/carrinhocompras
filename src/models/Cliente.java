package src.models;

public abstract class Cliente {

    private String nome;
    private String id; // cpf ou cnpj

    public Cliente(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }
}
