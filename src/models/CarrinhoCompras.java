package src.models;

import src.dao.EstoqueDao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarrinhoCompras {

    private List<Produto> itens;

    public CarrinhoCompras() {

        this.itens = new ArrayList<Produto>();
    }

    public void adicionaProduto(Produto produto, long quantidade) {

        EstoqueDao estoque = EstoqueDao.inicializar();

        if (quantidade <= 0) {
            return;
        }

        if (estoque.listarEstoque().get(produto) >= quantidade){
            for (long i = 1; i <= quantidade; i++) {
                this.adicionaProduto(produto);
                estoque.atualizarEstoque(produto, (estoque.listarEstoque().get(produto) - 1));
            }
        }
        else {
            System.out.println("Produto "+ produto.getNome() +" não disponível nessa quantidade.");
        }



    }

    public void adicionaProduto(Produto produto) {

        itens.add(produto);

    }

    public Map<String, DoubleSummaryStatistics> getItens() {

        Map<String, DoubleSummaryStatistics> carrinho = this.itens.stream()
                .collect(Collectors.groupingBy(Produto::getId, Collectors.summarizingDouble(Produto::getPrecoDouble)));

        return carrinho;
    }

    public List<Produto> getProdutos(){
        return this.itens;
    }

    public void removeProduto(Produto produto) {
        removeProduto(produto, 1);
    }

    public void removeProduto(Produto produto, long quantidade) {
        EstoqueDao estoque = EstoqueDao.inicializar();
        for (long i = 0; i < quantidade; i++) {
            itens.remove(produto);
        }
        estoque.adicionarEstoque(produto, Integer.valueOf((int) quantidade));
    }

    public long contarProduto(Produto produto) {

        return this.getItens().get(produto.getId()).getCount();
    }

    public void alterarQuantidade(Produto produto) {
        alterarQuantidade(produto, 1);
    }

    public void alterarQuantidade(Produto produto, int quantidade) {

        long contagem = contarProduto(produto) - quantidade;
        if (contagem > 0) {
            this.removeProduto(produto, contagem);
        } else {
            this.adicionaProduto(produto, -1 * contagem);
        }
    }

    @Override
    public String toString() {
        String mensagem = "";

        Map<String, DoubleSummaryStatistics> carrinho = this.getItens();

        for (String key : carrinho.keySet()) {

            mensagem += "PRODUTO " + key + " | PREÇO UND: "
                    + carrinho.get(key).getAverage() + " | QTD.: " + carrinho.get(key).getCount()
                    + " | PREÇO TOTAL: R$ "
                    + String.format("%.2f", carrinho.get(key).getSum()) + "\n";

        }

        return mensagem;
    }

}
