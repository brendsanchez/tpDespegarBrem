import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Local extends Establecimiento {
    private List<Venta> ventas;

    public Local(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public Double totalVentas() {
        return ventas.stream()
                .mapToDouble(Venta::total)
                .sum();
    }

    public List<Venta> ventasFiltradas(LocalDate fecha, String ubicacion) {
        return ventas.stream()
                .filter(v -> v.getUbicacion().equals(ubicacion) && v.getFechaVenta().equals(fecha))
                .collect(Collectors.toList());
    }

    @Override
    public Integer cantidadVentasConAlmenosUnProductoPromocion() {
        return (int) ventas.stream()
                .filter(Venta::hayUnProductoEnPromocion)
                .count();
    }

    private List<Venta> filtrarVentaPorFecha(LocalDate fecha) {
        return ventas.stream()
                .filter(v -> v.getFechaVenta().equals(fecha))
                .collect(Collectors.toList());
    }

    @Override
    public Double dineroAhorrado(LocalDate fecha) {
        List<Venta> ventasFiltradas = this.filtrarVentaPorFecha(fecha);
        return ventasFiltradas.stream()
                .mapToDouble(Venta::totalDescuentoDeProductos)
                .sum();
    }

    @Override
    public List<Venta> listaDeVentas() {
        return this.ventas;
    }
}
