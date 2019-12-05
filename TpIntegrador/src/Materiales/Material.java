package Materiales;

public abstract class Material {
    private Double precio;

    Material(Double precio) {
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }
}
