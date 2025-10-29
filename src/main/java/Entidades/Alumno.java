package Entidades;
import lombok.*;

// NOTA: esta clase la uso para tests de Streams.
// Tiene info mínima del alumno: nombre, nota y a qué curso/división pertenece.
// Lombok me genera getters/setters/toString y además @Builder para crear objetos de forma más cómoda.
@Builder
@Getter
@Setter
@ToString
public class Alumno {

    private String nombre;
    private int nota;
    private String curso;

    // Constructor "clásico". Lo dejo porque en el main estoy creando con new Alumno(...)
    public Alumno(String nombre, int nota, String curso){
        this.nombre = nombre;
        this.curso = curso;
        this.nota = nota;
    }
}
