package src.models;

public class ProdutoNoCarrinho {

    private Integer quantidade;
    private Produto produto;

    public ProdutoNoCarrinho(Produto produto, Integer quantidade) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

}
