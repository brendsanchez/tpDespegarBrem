import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Shopping extends Establecimiento {
    private List<Local> locales;

    public Shopping(List<Local> locales) {
        this.locales = locales;
    }

    public Double totalVentas() {
        return locales.stream()
                .mapToDouble(Local::totalVentas)
                .sum();
    }

    @Override
    public List<Venta> listaDeVentas() {
        return locales.stream()
                .flatMap(local -> local.listaDeVentas().stream())
                .collect(Collectors.toList());
    }

    @Override
    public List<Venta> ventasFiltradas(LocalDate fecha, String ubicacion) {
        return locales.stream()
                .flatMap(local -> local.ventasFiltradas(fecha,ubicacion).stream())
                .collect(Collectors.toList());
    }

    @Override
    public Integer cantidadVentasConAlmenosUnProductoPromocion() {
        return locales.stream()
                .mapToInt(Local::cantidadVentasConAlmenosUnProductoPromocion)
                .sum();
    }

    @Override
    public Double dineroAhorrado(LocalDate fecha) {
        return locales.stream()
                .mapToDouble(l -> l.dineroAhorrado(fecha))
                .sum();
    }
}
