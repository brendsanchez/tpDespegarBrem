import java.time.LocalDate;
import java.util.List;
//TODO parte2 _7: el benefifio de usar herencia es que puedo ahorrar codigo y reutilizar =)
//TODO y que la clase shopping y local comparten los mismos metodos
public abstract class Establecimiento {
    public abstract Double totalVentas();

    public abstract List<Venta> listaDeVentas();

    public abstract List<Venta> ventasFiltradas(LocalDate fecha, String ubicacion);

    public abstract Integer cantidadVentasConAlmenosUnProductoPromocion();

    public abstract Double dineroAhorrado(LocalDate fecha);

    public Double totalVentasPorFechaUbicacion(LocalDate fecha, String ubicacion) {
        List<Venta> ventas = this.ventasFiltradas(fecha, ubicacion);
        return ventas.stream()
                .mapToDouble(Venta::total)
                .sum();
    }

    public Double contribucionMarginalTotal(){
        return listaDeVentas().stream()
                .mapToDouble(Venta::contribucionMarginalTotal)
                .sum();
    }
}
