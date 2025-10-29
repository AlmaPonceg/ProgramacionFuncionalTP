package Entidades;
import lombok.*;

// Representa libros para hacer consultas tipo "cuál es el más caro",
// "cuántas páginas tienen en promedio", etc.
// OJO: precio es double porque después hago comparaciones y el max().
@Getter
@Setter
@ToString
public class Libro {

    private String titulo;
    private String autor;
    private int paginas;
    private double precio;

    public Libro(String titulo, String autor, int paginas, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.precio = precio;
    }
}
