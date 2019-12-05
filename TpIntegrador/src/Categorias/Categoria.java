package Categorias;

import Productos.Producto;

import java.util.ArrayList;
import java.util.List;

public interface Categoria {
    Double costo();
    default List<Producto> productosQueLoComponen(){
        return new ArrayList<>();
    }
}
