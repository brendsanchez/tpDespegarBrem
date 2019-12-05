package Productos;

import Categorias.Categoria;

public class Indumentaria extends Producto {
    private Integer talle;
    private Double factorDeConversion;

    public Indumentaria(Integer talle, Double factorDeConversion, Integer porcentajeDescuento, Categoria categoria) {
        super(porcentajeDescuento, categoria);
        this.talle = talle;
        this.factorDeConversion = factorDeConversion;
    }

    @Override
    public Double precioSinDescuento() {
        return this.talle * this.factorDeConversion;
    }

}
