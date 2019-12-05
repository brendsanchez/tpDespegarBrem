package Productos;

import Categorias.Categoria;
import Exceptions.ValidationError;

import java.util.List;

public abstract class Producto {
    private Integer porcentajeDescuento;
    private Categoria categoria;

    public Producto(Integer porcentajeDescuento, Categoria categoria) {
        this.verificacionPorcentaje(porcentajeDescuento);
        this.porcentajeDescuento = porcentajeDescuento;
        this.categoria = categoria;
    }

    private void verificacionPorcentaje(Integer porcentajeDescuento) {
        if (porcentajeDescuento > 70 || porcentajeDescuento < 0) {
            throw new ValidationError("el valor de porcentaje " + porcentajeDescuento + " no es valido");
        }
    }

    public void setPorcentajeDescuento(Integer porcentajeDescuento) {
        this.verificacionPorcentaje(porcentajeDescuento);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public void setCambiarCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Double precio() {
        return this.precioSinDescuento() - this.descuento();
    }

    public abstract Double precioSinDescuento();

    public Double descuento() {
        if (porcentajeDescuento.equals(0)) {
            return 0.0;
        } else {
            return (porcentajeDescuento * this.precioSinDescuento()) / 100;
        }
    }

    public boolean getEnPromocion() {
        return this.porcentajeDescuento >= 1 && this.porcentajeDescuento <= 70;
    }

    public Double costo() {
        return this.categoria.costo();
    }

    public Double contribucionMarginal() {
        return this.precio() - this.costo();
    }

    public boolean esProductoRedituable() {
        return this.contribucionMarginal() > 0;
    }

    public List<Producto> productosQueComponenFabricacion() {
        return categoria.productosQueLoComponen();
    }

}
