import Categorias.Comprado;
import Categorias.Conservado;
import Categorias.Fabricado;
import Materiales.Hierro;
import Materiales.Madera;
import Productos.Decoracion;
import Productos.Electronica;
import Productos.Indumentaria;
import Productos.Producto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

public class App {
    private static final String ANSI_PICK = "\u001B[31m";
    private static final String ANSI_GRIS = "\u001B[37m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_PURPLE = "\u001B[34m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Producto tv = new Electronica(100.0, 50, new Comprado(20.0));
        Producto remera = new Indumentaria(10, 0.6, 0, new Comprado(4.0));
        Producto pantalon = new Indumentaria(10, 0.6, 0, new Comprado(2.0));
        Producto conjunto = new Indumentaria(30, 0.6, 0, new Fabricado(2.0, Arrays.asList(pantalon, remera)));
        Producto cadena = new Indumentaria(45, 0.6, 10, new Comprado(2.0));
        Producto lampara = new Decoracion(0.25, 0.1, 0.1, Arrays.asList(new Hierro(20.0), new Madera(10.0)), 0, new Conservado(5.0, 12));
        Producto reloj = new Electronica(40.0, 50, new Comprado(300.0));

        Electronica.setConstanteElectronica(15);
        Venta venta1 = new Venta(Arrays.asList(tv, cadena, lampara), LocalDate.of(2019, 10, 10), "buenos aires");
        Venta venta2 = new Venta(Arrays.asList(cadena, lampara, reloj), LocalDate.of(2019, 5, 5), "cordoba");
        Venta venta3 = new Venta(Arrays.asList(tv, tv), LocalDate.of(2019, 9, 9), "santa fe");
        Venta venta4 = new Venta(Arrays.asList(tv, lampara), LocalDate.of(2019, 9, 9), "santa fe");
        Venta venta5 = new Venta(Collections.singletonList(tv), LocalDate.of(2019, 9, 9), "buenos aires");
        Venta venta6 = new Venta(Arrays.asList(cadena, tv), LocalDate.of(2019, 11, 15), "rio negro");
        Venta venta7 = new Venta(Arrays.asList(tv, tv, cadena), LocalDate.of(2019, 11, 15), "rio negro");
        Venta venta8 = new Venta(Arrays.asList(lampara, conjunto, lampara), LocalDate.of(2019, 9, 9), "rio negro");


        Local local1 = new Local(Arrays.asList(venta1, venta2, venta3, venta4));
        Local local2 = new Local(Arrays.asList(venta1, venta3, venta4));
        Local local3 = new Local(Arrays.asList(venta5, venta8));
        Local local4 = new Local(Arrays.asList(venta3, venta5));
        Local local5 = new Local(Arrays.asList(venta6, venta8));
        Local local6 = new Local(Arrays.asList(venta4, venta7));
        Local local7 = new Local(Arrays.asList(venta4, venta3, venta6));

        Establecimiento shopping1 = new Shopping(Arrays.asList(local1, local2));
        Establecimiento shopping2 = new Shopping(Collections.singletonList(local3));
        Establecimiento shopping3 = new Shopping(Arrays.asList(local4, local5));
        Establecimiento shopping4 = new Shopping(Arrays.asList(local5, local3));

        Empresa empresa1 = new Empresa(Arrays.asList(shopping2, shopping3, local5, local4, local1, local2), Arrays.asList("buenos aires", "cordoba"));
        Empresa empresa2 = new Empresa(Arrays.asList(local3, shopping4), Arrays.asList("santa fe", "buenos aires"));
        Empresa empresa3 = new Empresa(Arrays.asList(shopping1, local7, local4, local6), Arrays.asList("cordoba", "rio negro"));


        //*********************PARTE1 _1*************************
        System.out.println(ANSI_PURPLE + "1.1) Conocer el precio de un producto cualquiera, ya sea de Indumentaria, electrónico o de decoración.");
        System.out.println(ANSI_PURPLE + "tv: " + ANSI_RESET + tv.precioSinDescuento());
        System.out.println(ANSI_PURPLE + "cadena: " + ANSI_RESET + cadena.precioSinDescuento());
        System.out.println(ANSI_PURPLE + "lampara: " + ANSI_RESET + lampara.precioSinDescuento());

        //*********************PARTE1 _2*************************
        System.out.println(" ");
        System.out.println(ANSI_GRIS + "1.2) Saber el precio total de una venta, dado por la sumatoria de todos los productos que se venden.");
        System.out.println(ANSI_GRIS + "venta1: " + ANSI_RESET + venta1.total());
        System.out.println(ANSI_GRIS + "venta2: " + ANSI_RESET + venta2.total());
        System.out.println(ANSI_GRIS + "venta3: " + ANSI_RESET + venta3.total());

        //*********************PARTE1 _3**************************
        System.out.println(" ");
        System.out.println(ANSI_PICK + "1.3) Conocer el total de las ventas para un local");
        System.out.println(ANSI_PICK + "local1: " + ANSI_RESET + local1.totalVentas());
        System.out.println(ANSI_PICK + "local2: " + ANSI_RESET + local2.totalVentas());
        System.out.println(ANSI_PICK + "local3: " + ANSI_RESET + local3.totalVentas());

        //*********************PARTE1 _4**************************
        System.out.println();
        System.out.println(ANSI_YELLOW + "1.4) A partir de una fecha y una ubicación:");
        System.out.println(ANSI_YELLOW + "a. Saber que ventas realizó un local en esa fecha y esa ubicación:" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "local1: " + ANSI_RESET + "fecha: 2019/9/9, ubicacion: santa fe: ");
        System.out.println("ventas: " + local1.ventasFiltradas(LocalDate.of(2019, 9, 9), "santa fe"));

        System.out.println();
        System.out.println(ANSI_YELLOW + "shopping1: " + ANSI_RESET + "fecha: 2019/10/10, ubicacion: buenos aires: ");
        System.out.println("ventas: " + shopping1.ventasFiltradas(LocalDate.of(2019, 10, 10), "buenos aires"));

        System.out.println();
        System.out.println(ANSI_YELLOW + "b. Conocer el monto total de las ventas realizadas en esa fecha y esa ubicación" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "local1: " + ANSI_RESET + "fecha: 2019/9/9, ubicacion: santa fe: ");
        System.out.println("monto total: " + local1.totalVentasPorFechaUbicacion(LocalDate.of(2019, 9, 9), "santa fe"));

        System.out.println();
        System.out.println(ANSI_YELLOW + "shopping1: " + ANSI_RESET + "fecha: 2019/10/10, ubicacion: buenos aires: ");
        System.out.println("monto total: " + shopping1.totalVentasPorFechaUbicacion(LocalDate.of(2019, 10, 10), "buenos aires"));

        //*********************PARTE2 _1**************************
        System.out.println();
        System.out.println(ANSI_PURPLE + "2.1) Rehacer la lógica del precio para que haga el cálculo correspondiente, teniendo en cuenta el valor de descuento.");
        System.out.println(ANSI_PURPLE + "tv: " + ANSI_RESET + tv.precio());
        System.out.println(ANSI_PURPLE + "cadena: " + ANSI_RESET + cadena.precio());
        System.out.println(ANSI_PURPLE + "lampara: " + ANSI_RESET + lampara.precio());

        //*********************PARTE2 _2**************************
        System.out.println();
        System.out.println(ANSI_GRIS + "2.2) Modelar los shoppings de forma tal que pueda responder los mismos mensajes que un\n" +
                "Local, teniendo en cuenta que lo resuelve de manera totalmente distinta." + ANSI_RESET);
        System.out.println("aplicado en la clase shopping.");

        //*********************PARTE2 _3**************************
        System.out.println();
        System.out.println(ANSI_PICK + "2.3) Saber la cantidad de ventas que tuvo un establecimiento con al menos un producto en promoción." + ANSI_RESET);
        System.out.println(ANSI_PICK + "local1: " + ANSI_RESET + local1.cantidadVentasConAlmenosUnProductoPromocion());
        System.out.println(ANSI_PICK + "shopping1: " + ANSI_RESET + shopping1.cantidadVentasConAlmenosUnProductoPromocion());
        System.out.println(ANSI_PICK + "shopping3: " + ANSI_RESET + shopping3.cantidadVentasConAlmenosUnProductoPromocion());

        //*********************PARTE2 _4**************************
        System.out.println();
        System.out.println(ANSI_YELLOW + "2.4) Conocer el dinero ahorrado en un establecimiento en una fecha dada." + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "local4:" + ANSI_RESET + " dinero ahorrado en 2019/09/09 : " + local4.dineroAhorrado(LocalDate.of(2019, 9, 9)));
        System.out.println(ANSI_YELLOW + "shopping1:" + ANSI_RESET + " dinero ahorrado en 2019/05/05 : " + shopping1.dineroAhorrado(LocalDate.of(2019, 5, 5)));

        //*********************PARTE2 _5**************************
        System.out.println();
        System.out.println(ANSI_CYAN + "2.5) Saber para una empresa, cuál fue el lugar que tuvo más ventas, entre sus locales y shoppings." + ANSI_RESET);
        System.out.println(ANSI_CYAN + "empresa1: " + ANSI_RESET + empresa1.agruparCantidadDeVentasPorLugar());
        System.out.println("LUGAR CON MAS VENTAS: " + empresa1.lugarConMasVentas());

        System.out.println();
        System.out.println(ANSI_CYAN + "empresa2: " + ANSI_RESET + empresa2.agruparCantidadDeVentasPorLugar());
        System.out.println("LUGAR CON MAS VENTAS: " + empresa2.lugarConMasVentas());

        System.out.println();
        System.out.println(ANSI_CYAN + "empresa3: " + ANSI_RESET + empresa3.agruparCantidadDeVentasPorLugar());
        System.out.println("LUGAR CON MAS VENTAS: " + empresa3.lugarConMasVentas());


        //*********************PARTE2 _6**************************
        System.out.println();
        System.out.println(ANSI_GREEN + "2.6) Saber si algún lugar es de clientes ventajeros. Esto es si tiene sólo ventas con productos con descuento.");
        System.out.println("empresa1: " + ANSI_RESET);
        System.out.println("LUGAR DE CLIENTES VENTAJEROS: " + empresa1.lugarDeClientesVentajeros());

        System.out.println();
        System.out.println(ANSI_GREEN + "empresa2: " + ANSI_RESET);
        System.out.println("LUGAR DE CLIENTES VENTAJEROS: " + empresa2.lugarDeClientesVentajeros());

        System.out.println();
        System.out.println(ANSI_GREEN + "empresa3: " + ANSI_RESET);
        System.out.println("LUGAR DE CLIENTES VENTAJEROS: " + empresa3.lugarDeClientesVentajeros());

        //*********************PARTE2 _7**************************
        System.out.println();
        System.out.println(ANSI_GRIS + "2.7) La solución propuesta, ¿tiene algún punto en el que se use herencia? En caso de haber,\n" +
                "justificar qué beneficios aportó su aplicación a la solución. Escribir la justificación en la\n" +
                "superclase que corresponda, como comentario." + ANSI_RESET);
        System.out.println("la respuesta esta en la clase establecimiento.");

        //*************************PARTE 3_1*******************************
        System.out.println();
        System.out.println(ANSI_PURPLE + "3.1) Poder calcular el costo de un producto:" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "conjunto: " + ANSI_RESET + conjunto.costo());
        System.out.println(ANSI_PURPLE + "tv: " + ANSI_RESET + tv.costo());
        System.out.println(ANSI_PURPLE + "cadena: " + ANSI_RESET + cadena.costo());
        System.out.println(ANSI_PURPLE + "lampara: " + ANSI_RESET + lampara.costo());

        //*************************PARTE 3_2*******************************
        System.out.println();
        System.out.println(ANSI_GRIS + "3.2) Conocer la contribución marginal de un producto, que representa la posible\n" +
                "  ganancia que se obtiene al vender el producto. Dicha contribución se calcula\n" +
                "  como la diferencia entre el precio de venta y el costo." + ANSI_RESET);
        System.out.println(ANSI_GRIS + "conjunto: " + ANSI_RESET + conjunto.contribucionMarginal());
        System.out.println(ANSI_GRIS + "tv: " + ANSI_RESET + tv.contribucionMarginal());
        System.out.println(ANSI_GRIS + "cadena: " + ANSI_RESET + cadena.contribucionMarginal());
        System.out.println(ANSI_GRIS + "lampara: " + ANSI_RESET + lampara.contribucionMarginal());

        //*************************PARTE 3_3*******************************
        System.out.println();
        System.out.println(ANSI_PICK + "3.3) Poder decir si un producto es redituable, es decir, si deja ganancia alguna." + ANSI_RESET);
        System.out.println(ANSI_PICK + "conjunto: " + ANSI_RESET + conjunto.esProductoRedituable());
        System.out.println(ANSI_PICK + "tv: " + ANSI_RESET + tv.esProductoRedituable());
        System.out.println(ANSI_PICK + "cadena: " + ANSI_RESET + cadena.esProductoRedituable());
        System.out.println(ANSI_PICK + "lampara: " + ANSI_RESET + lampara.esProductoRedituable());
        //System.out.println();
        System.out.println(ANSI_PICK + "reloj: " + ANSI_RESET + reloj.esProductoRedituable());
        //System.out.println(ANSI_PICK + "precio reloj: " + ANSI_RESET + reloj.precio());

        //*************************PARTE 3_4*******************************
        System.out.println();
        System.out.println(ANSI_YELLOW + "3.4) Conocer la contribución marginal total de un establecimiento si vendiera todos los productos que tiene." + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "local1: " + ANSI_RESET + local1.contribucionMarginalTotal());
        System.out.println(ANSI_YELLOW + "shopping1: " + ANSI_RESET + shopping1.contribucionMarginalTotal());
        System.out.println(ANSI_YELLOW + "shopping3: " + ANSI_RESET + shopping3.contribucionMarginalTotal());

        //*************************PARTE 3_5*******************************
        System.out.println();
        System.out.println(ANSI_CYAN + "3.5) Para los productos fabricados, poder conocer de qué productos está compuesto." + ANSI_RESET);
        System.out.println(ANSI_CYAN + "conjunto: " + ANSI_RESET + conjunto.productosQueComponenFabricacion());

        //*************************PARTE 3_6*******************************
        System.out.println();
        System.out.println(ANSI_GREEN + "3.6) Cuál es la diferencia entre los modelos de la clasificación de tipo de producto (indumentaria, tecnología y\n" +
                "decoración) y la categorización de los costos? Qué puedo hacer y  no  hacer en cada modelo?" + ANSI_RESET);
        System.out.println("por que en la clasificacion de producto usa una clase padre y en la categoria una interfaz ya que no habia atributos en comun");
    }
}
