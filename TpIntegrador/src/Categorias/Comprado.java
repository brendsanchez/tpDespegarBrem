package Categorias;

public class Comprado implements Categoria {
    private Double costoCompra;

    public Comprado(Double costoCompra) {
        this.costoCompra = costoCompra;
    }

    @Override
    public Double costo() {
        return this.costoCompra;
    }
}
