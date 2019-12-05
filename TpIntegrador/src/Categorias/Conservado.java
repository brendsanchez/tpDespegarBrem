package Categorias;

import Exceptions.ValidationError;

public class Conservado implements Categoria {
    private Double costoCompra;
    private Integer cantidadDiasDeConservacion;
    private static Double indiceConservacion = 0.15;

    public Conservado(Double costoCompra, Integer cantidadDiasDeConservacion) {
        this.costoCompra = costoCompra;
        this.cantidadDiasDeConservacion = cantidadDiasDeConservacion;
    }

    public static void setIndiceConservacion(Double indiceConservacion) {
        validacionDeValor(indiceConservacion);
        Conservado.indiceConservacion = indiceConservacion;
    }

    private static void validacionDeValor(Double indiceConservacion) {
        if (!(indiceConservacion >= 0 && indiceConservacion <= 1)) {
            throw new ValidationError("el valor ingresado de " + indiceConservacion + " no esta entre 0 y 1");
        }
    }

    @Override
    public Double costo() {
        return this.costoCompra * this.cantidadDiasDeConservacion * indiceConservacion;
    }

}
