package Productos;

import Categorias.Categoria;

public class Electronica extends Producto {
    private Double precioBase;
    private static Integer constanteElectronica = 15;

    public Electronica(Double precioBase, Integer porcentajeDescuento, Categoria categoria) {
        super(porcentajeDescuento, categoria);
        this.precioBase = precioBase;
    }

    public static void setConstanteElectronica(Integer constanteElectronica) {
        Electronica.constanteElectronica = constanteElectronica;
    }

    @Override
    public Double precioSinDescuento() {
        return this.precioBase * constanteElectronica;
    }

}
