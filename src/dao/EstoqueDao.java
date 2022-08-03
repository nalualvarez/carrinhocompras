package src.dao;

import java.util.HashMap;
import java.util.Map;

import src.models.Produto;

public class EstoqueDao {
    private static EstoqueDao estoqueDao;
    private Map<Produto, Integer> estoque = new HashMap<Produto, Integer>();

    // Padrão Singleton
    public static EstoqueDao inicializar() {
        if (estoqueDao == null) {
            estoqueDao = new EstoqueDao();
        }
        return estoqueDao;
    }

    private EstoqueDao() {
    }

    // CRUD
    public void adicionarEstoque(Produto produto, Integer quantidade) {
        this.estoque.put(produto, quantidade);
    }

    public void adicionarEstoque(Integer quantidade, Produto... produtos) {
        for (Produto produto : produtos) {
            this.adicionarEstoque(produto, quantidade);
        }
    }

    public void removerEstoque(Produto produto) {
        this.estoque.remove(produto);
    }

    public void atualizarEstoque(Produto produto, Integer quantidade) {
        this.estoque.replace(produto, quantidade);
    }

    public Map<Produto, Integer> listarEstoque() {
        return this.estoque;
    }
}
