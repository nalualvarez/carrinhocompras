import java.util.HashMap;


public class CarrinhoCompras {

    private Cliente cliente;
    public HashMap<Produto, Integer> item;

    public CarrinhoCompras(Cliente cliente, HashMap item) {
        this.cliente = cliente;
        this.item = item;
    }
}
