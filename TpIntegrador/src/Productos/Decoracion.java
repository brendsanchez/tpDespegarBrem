package Productos;

import Categorias.Categoria;
import Materiales.Material;

import java.util.List;

public class Decoracion extends Producto {
    private Double altoEnMetros;
    private Double anchoEnMetros;
    private Double pesoKilogramos;
    private List<Material> material;

    public Decoracion(Double pesoKilogramos, Double altoEnMetros, Double anchoEnMetros, List<Material> material, Integer porcentajeDescuento, Categoria categoria) {
        super(porcentajeDescuento, categoria);
        this.altoEnMetros = altoEnMetros;
        this.anchoEnMetros = anchoEnMetros;
        this.pesoKilogramos = pesoKilogramos;
        this.material = material;
    }

    private Double precioMateriales() {
        return material.stream()
                .mapToDouble(m -> m.getPrecio())
                .sum();
    }

    @Override
    public Double precioSinDescuento() {
        return (pesoKilogramos * altoEnMetros * anchoEnMetros * 100) + this.precioMateriales();
    }

}
