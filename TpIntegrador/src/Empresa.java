import java.util.*;
import java.util.stream.Collectors;

public class Empresa {

    private List<Establecimiento> listaDeEstablecimientos;
    private List<String> lugaresRelevante;

    public Empresa(List<Establecimiento> listaDeEstablecimientos, List<String> lugaresRelevante) {
        this.listaDeEstablecimientos = listaDeEstablecimientos;
        this.lugaresRelevante = lugaresRelevante;
    }

    public List<String> getLugaresRelevante() {
        return lugaresRelevante;
    }

    public List<Venta> listaDeVentasDeEstablecimientos() {
        return listaDeEstablecimientos.stream()
                .flatMap(l->l.listaDeVentas().stream())
                .collect(Collectors.toList());
    }

    public String lugarConMasVentas() {
        return Collections.max(this.agruparCantidadDeVentasPorLugar()
                .entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public Map<String, Integer> agruparCantidadDeVentasPorLugar() {
        return listaDeVentasDeEstablecimientos().stream().collect(Collectors.toMap(Venta::getUbicacion, venta -> 1, Integer::sum));
    }

    public Set<String> lugarDeClientesVentajeros(){
        Map<String, List<Venta>> mapaAgruparVentasPorLugar = this.agruparVentasPorLugar();
        Map<String, Integer> resultado = new HashMap<>();

        mapaAgruparVentasPorLugar.keySet().forEach(lugar -> {
            List<Venta> listaDeVentasDeLugar = mapaAgruparVentasPorLugar.get(lugar);
            boolean hayTodoDescuentos = listaDeVentasDeLugar.stream().allMatch(Venta::productosTodosConDescuento);
            if (hayTodoDescuentos) {
                resultado.put(lugar, listaDeVentasDeLugar.size());
            }
        });
        return resultado.keySet();
    }

    private Map<String, List<Venta>> agruparVentasPorLugar() {
        Map<String, List<Venta>> mapa = new HashMap<>();
        listaDeVentasDeEstablecimientos().forEach(venta -> {
            if (!mapa.containsKey(venta.getUbicacion())) {
                mapa.put(venta.getUbicacion(), new ArrayList<>());
            }
            mapa.get(venta.getUbicacion()).add(venta);
        });
        return mapa;
    }
}
