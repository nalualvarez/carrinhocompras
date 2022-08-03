package src.dao;
import java.util.HashMap;
import java.util.Map;

import src.models.EnumTipoProduto;
import src.models.Produto;

public class EstoqueDao {

    private static Map<Produto, Integer> estoque = new HashMap<Produto, Integer>();

    public static void adicionarEstoque(Produto produto, Integer quantidade) {
        EstoqueDao.estoque.put(produto, quantidade);
    }
    public static void removerEstoque(Produto produto){
        EstoqueDao.estoque.remove(produto);
    }
    public static void atualizarEstoque(Produto produto, Integer quantidade) {
        EstoqueDao.estoque.replace(produto, quantidade);
    }
    public static Map<Produto, Integer> listarEstoque() {
       return estoque;
    }
    
    /* public void inicializar() {

        Produto bacia = new Produto("Bacia", 14.95, EnumTipoProduto.UTENSILIOS);
        Produto pera = new Produto("pera", 15.95, EnumTipoProduto.HORTIFRUTI);
        Produto pinga1 = new Produto("pinga", 150.95, EnumTipoProduto.BEBIDAS);
        Produto pinga2 = new Produto("pinga", 150.95, EnumTipoProduto.BEBIDAS);
        Produto redbull = new Produto("redbull", 20.95, EnumTipoProduto.BEBIDAS);

        //TODO: VARARGS ADD ESTOQUE
        adicionarEstoque(bacia, 10);
        adicionarEstoque(pera, 10);
        adicionarEstoque(pinga1, 10);
        adicionarEstoque(pinga2, 10);
        adicionarEstoque(redbull, 10);
        
    } */
}
