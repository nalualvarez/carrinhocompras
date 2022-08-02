package src.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarrinhoCompras {

    private Cliente cliente;
    private List<ProdutoNoCarrinho> itens;

    public CarrinhoCompras(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<ProdutoNoCarrinho>();
    }

    public void adicionaProduto(Produto produto, Integer quantidade) {

        itens.add(new ProdutoNoCarrinho(produto, quantidade));

    }

    //TODO retornar nomes de produtos e quantidades
    public List<ProdutoNoCarrinho> getItens(){
        return this.itens;
    }
}
