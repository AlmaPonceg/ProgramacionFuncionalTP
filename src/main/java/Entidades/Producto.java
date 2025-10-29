package Entidades;
import lombok.*;

// Modelo sencillo de productos de un inventario.
// Lo uso para agrupar por categoría, sacar promedios de precios,
// sumar stock total, etc. Básicamente práctica de Streams comerciales.
@Builder
@Getter
@Setter
@ToString
public class Producto {

    private String nombre;
    private String categoria;
    private double precio;
    private int stock;

    // Dejo el constructor explícito porque también los creo con "new Producto(...)"
    public Producto(String nombre, String categoria, double precio, int stock){
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }
}
