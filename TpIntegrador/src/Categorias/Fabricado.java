package Categorias;

import Productos.Producto;
import Exceptions.ValidationError;

import java.util.List;

public class Fabricado implements Categoria {
    private Double costoManoDeObra;
    private List<Producto> productosDeFabricacion;

    public Fabricado(Double costoManoDeObra, List<Producto> productosDeFabricacion) {
        validacionCostoManoDeObra(costoManoDeObra);
        this.costoManoDeObra = costoManoDeObra;
        this.productosDeFabricacion = productosDeFabricacion;
    }

    private void validacionCostoManoDeObra(Double costoManoDeObra) {
        if (!(costoManoDeObra >= 1 && costoManoDeObra <= 2)) {
            throw new ValidationError("el valor ingresado de " + costoManoDeObra + " no esta entre 1 y 2");
        }
    }

    private Double sumatoriaCostoFabricacion() {
        return productosDeFabricacion.stream()
                .mapToDouble(Producto::costo)
                .sum();
    }

    public List<Producto> productosQueLoComponen() {
        return productosDeFabricacion;
    }

    @Override
    public Double costo() {
        return this.sumatoriaCostoFabricacion() * this.costoManoDeObra;
    }

}
