package src.tests;


import java.util.DoubleSummaryStatistics;
import java.util.Map;

import src.dao.EstoqueDao;
import src.models.CarrinhoCompras;
import src.models.Cliente;
import src.models.EnumTipoProduto;
import src.models.PessoaFisica;
import src.models.Produto;

public class Main {
    public static void main(String[] args) {

        Cliente client = new PessoaFisica("Zezin", "1234567");

        CarrinhoCompras carrinho = new CarrinhoCompras(client);

        Produto bacia = new Produto("Bacia", 14.95, EnumTipoProduto.UTENSILIOS);
        Produto pera = new Produto("pera", 15.95, EnumTipoProduto.HORTIFRUTI);
        Produto pinga1 = new Produto("pinga", 150.95, EnumTipoProduto.BEBIDAS);
        Produto pinga2 = new Produto("pinga", 150.95, EnumTipoProduto.BEBIDAS);
        Produto redbull = new Produto("redbull", 20.95, EnumTipoProduto.BEBIDAS);

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

        //System.out.println(carrinho);

        
        carrinho.alterarQuantidade(bacia, 150);

        //System.out.println(carrinho);

        EstoqueDao.adicionarEstoque(pinga1, 15  );
        EstoqueDao.adicionarEstoque(pera, 25);
        EstoqueDao.adicionarEstoque(pinga2, 10);

        System.out.println(EstoqueDao.listarEstoque().values().toString()); 

        


    }
}
