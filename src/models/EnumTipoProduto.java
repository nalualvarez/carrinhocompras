package src.models;

public enum EnumTipoProduto {
    LIMPEZA("LIMPEZA"),
    BEBIDAS("BEBIDAS"),
    HIGIENE("HIGIENE"),
    ALIMENTO("ALIMENTO"),
    UTENSILIOS("UTENSILIOS"),
    HORTIFRUTI("HORTIFRUTI");

    private String value;

    EnumTipoProduto(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
