import Productos.Producto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Venta {
    private List<Producto> productos;
    private LocalDate fechaVenta;
    private String ubicacion;

    public Venta(List<Producto> productos, LocalDate fechaVenta, String ubicacion) {
        this.productos = productos;
        this.fechaVenta = fechaVenta;
        this.ubicacion = ubicacion;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "productos=" + productos +
                ", fechaVenta=" + fechaVenta +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }

    public Double total() {
        return productos.stream().
                mapToDouble(Producto::precio)
                .sum();
    }

    public boolean hayUnProductoEnPromocion() {
        return productos.stream()
                .anyMatch(Producto::getEnPromocion);
    }

    public Double totalDescuentoDeProductos() {
        return productos.stream()
                .mapToDouble(Producto::descuento)
                .sum();
    }

    public boolean productosTodosConDescuento(){
        return productos.stream()
                .allMatch(Producto::getEnPromocion);
    }

    private List<Producto> filtrarProductosRedituables(){
        return productos.stream()
                .filter(Producto::esProductoRedituable)
                .collect(Collectors.toList());
    }

    public Double contribucionMarginalTotal(){
        List<Producto> listaProductosRedituables = this.filtrarProductosRedituables();
        return listaProductosRedituables.stream()
                .mapToDouble(Producto::contribucionMarginal)
                .sum();
    }
}
