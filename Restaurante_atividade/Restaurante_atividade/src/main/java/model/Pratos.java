package model;

public enum Pratos {
    CARBONARA(Categoria.PRATO_PRINCIPAL),
    LASANHA(Categoria.PRATO_PRINCIPAL),
    BOLONHESA(Categoria.PRATO_PRINCIPAL),
    RISSOTO(Categoria.PRATO_PRINCIPAL),
    GNOCCHI(Categoria.PRATO_PRINCIPAL),
    SPAGHETTI(Categoria.PRATO_PRINCIPAL),
    COGUMELOSTRUFADOS(Categoria.ENTRADA),
    CAMAROESLIMONE(Categoria.ENTRADA),
    TIRAMISU(Categoria.SOBREMESA),
    ZABAIONE(Categoria.SOBREMESA),
    CHIANTI(Categoria.BEBIDA),
    BAROLO(Categoria.BEBIDA);

    private Categoria categoria;

    private Pratos(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}