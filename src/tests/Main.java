package src.tests;

import java.util.DoubleSummaryStatistics;
import java.util.Map;

import src.dao.EstoqueDao;
import src.models.*;

public class Main {
    public static void main(String[] args) {

        Cliente client = new PessoaFisica("Zezin", "1234567");
        EstoqueDao estoque = EstoqueDao.inicializar();
        CarrinhoCompras carrinho = new CarrinhoCompras();

        Produto bacia = new Produto("Bacia", 14.95, EnumTipoProduto.UTENSILIOS);
        Produto pera = new Produto("pera", 15.95, EnumTipoProduto.HORTIFRUTI);
        Produto pinga1 = new Produto("pinga", 150.95, EnumTipoProduto.BEBIDAS);
        Produto pinga2 = new Produto("pinga", 150.95, EnumTipoProduto.BEBIDAS);
        Produto redbull = new Produto("redbull", 20.95, EnumTipoProduto.BEBIDAS);

        // Teste adicionar estoque
        estoque.adicionarEstoque(10, bacia, pera, pinga1, pinga2, redbull);
        System.out.println(estoque.listarEstoque().values().toString());

        // carrinho.adicionaProduto(bacia);
        carrinho.adicionaProduto(pera);
        carrinho.adicionaProduto(pera);
        carrinho.adicionaProduto(pera);
        carrinho.adicionaProduto(pera);
        carrinho.adicionaProduto(pera);
        carrinho.adicionaProduto(pinga1);
        carrinho.adicionaProduto(pinga2);

        carrinho.adicionaProduto(bacia, 7);

        carrinho.adicionaProduto(redbull);



        Map<String, DoubleSummaryStatistics> c = carrinho.getItens();

        System.out.println((c.get(pinga1.getId()).getCount()));
        System.out.println((c.get(redbull.getId()).getCount()));

        // Teste alterar quantidade
        System.out.println(carrinho);
        carrinho.alterarQuantidade(bacia, 150);
        System.out.println(carrinho);


        Compra minhaCompra = new Compra(carrinho, client);
        System.out.println("Valor com taxas: "+minhaCompra.calcularValor());
        System.out.println("Valor do frete: "+minhaCompra.calcularFrete());
        System.out.println("Valor total: "+minhaCompra.calcularTotal());
    }
}
