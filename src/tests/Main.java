package src.tests;

import java.math.BigDecimal;

import src.models.CarrinhoCompras;
import src.models.Cliente;
import src.models.PessoaFisica;
import src.models.Produto;

public class Main {
    public static void main(String[] args) {


        Cliente client = new PessoaFisica("Zezin", "1234567");

        CarrinhoCompras carrinho = new CarrinhoCompras(client);

        Produto bacia = new Produto("Bacia", BigDecimal.valueOf(14.95));
        Produto pera = new Produto("pera", BigDecimal.valueOf(15.95));
        Produto pinga1 = new Produto("pinga", BigDecimal.valueOf(150.95));
        Produto pinga2 = new Produto("pinga", BigDecimal.valueOf(5.95));
        Produto pinga3 = new Produto("pinga", BigDecimal.valueOf(14.95));
        Produto redbull = new Produto("redbull", BigDecimal.valueOf(20.95));


        carrinho.adicionaProduto(bacia, 1);
        carrinho.adicionaProduto(pera, 1);
        carrinho.adicionaProduto(pinga1, 1);
        carrinho.adicionaProduto(pinga2, 1);
        carrinho.adicionaProduto(pinga3, 1);
        carrinho.adicionaProduto(redbull, 4);

        System.out.println(carrinho.getItens());

    }
}
