package src.models;

import java.math.BigDecimal;

public class Compra {
    private CarrinhoCompras carrinho;
    private Cliente cliente;

    public Compra(CarrinhoCompras carrinho, Cliente cliente) {
            this.carrinho = carrinho;
            this.cliente = cliente;
    }

    public BigDecimal calcularValor(){
        BigDecimal total = BigDecimal.valueOf(0);
        for (Produto item : carrinho.getProdutos()) {
            if (item.getTipo() == EnumTipoProduto.BEBIDAS){
                total = total.add(item.getPreco().multiply(BigDecimal.valueOf(1.05)));
            }
            else {
                total = total.add(item.getPreco());
            }
        }

        return total;
    }

    public BigDecimal calcularFrete(){
        BigDecimal frete = BigDecimal.valueOf(50);
        boolean temBebida = false;
        boolean temUtensilio = false;
//        if(carrinho.getProdutos().contains()){}
        for (Produto item : carrinho.getProdutos()) {
            if (item.getTipo() == EnumTipoProduto.BEBIDAS){
                temBebida = true;
            }
            if (item.getTipo() == EnumTipoProduto.UTENSILIOS){
                temUtensilio = true;
            }
        }
        if (temBebida){
            return frete.subtract(BigDecimal.valueOf(5));
        }
        if (temUtensilio){
            return frete.subtract(BigDecimal.valueOf(7));
        }
        return frete;
    }

    public BigDecimal calcularTotal(){
        return calcularValor().add(calcularFrete());
    }



}
