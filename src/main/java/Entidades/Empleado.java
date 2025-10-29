package Entidades;
import lombok.*;

// Esto sería como el registro de RRHH.
// Punto importante: salario es double y edad es int, así después puedo hacer cálculos
// (promedio de sueldos, min por edad, etc.) con Streams.
@Getter
@Setter
@ToString
public class Empleado {

    private String nombre;
    private String departamento;
    private double salario;
    private int edad;

    // Constructor con todos los campos porque no estoy usando builder acá
    public Empleado(String nombre, String departamento, double salario, int edad) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
        this.edad = edad;
    }
}
