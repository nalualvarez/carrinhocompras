package src.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarrinhoCompras {

    private Cliente cliente;
    private List<Produto> itens;

    public CarrinhoCompras(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<Produto>();
    }

    public void adicionaProduto(Produto produto, int quantidade) {

        if (quantidade <= 0) {
            return;
        }

        for (int i = 1; i <= quantidade; i++) {
            this.adicionaProduto(produto);
        }

    }

    public void adicionaProduto(Produto produto) {

        itens.add(produto);

    }

    // TODO retornar nomes de produtos e quantidades
    /**
     * @return
     */
    public Map<String, DoubleSummaryStatistics> getItens() {

        Map<String, DoubleSummaryStatistics> carrinho = this.itens.stream()
                .collect(Collectors.groupingBy(Produto::getNome,
                        Collectors.summarizingDouble(Produto::getPreco)));

        return carrinho;

    }

    // TODO: Implement
    public void removeProduto(Produto produto) {

    }

    @Override
    public String toString() {
        String mensagem = "";

        Map<String, DoubleSummaryStatistics> carrinho = this.getItens();

        for (String key : carrinho.keySet()) {

            mensagem += "PRODUTO " + key + " | PREÇO UND: "
                    + carrinho.get(key).getAverage() + " | QTD.: " + carrinho.get(key).getCount() + " | PREÇO TOTAL: R$ "
                    + String.format("%.2f", carrinho.get(key).getSum()) + "\n";

        }

        return mensagem;
    }

}
