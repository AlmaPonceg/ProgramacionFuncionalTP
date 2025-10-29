import Entidades.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        // =========================
        // Bloque ALUMNOS
        // =========================
        // Simulación de notas del último examen de Programación
        Alumno alu1 = new Alumno("Alma", 10, "3k10");
        Alumno alu2 = new Alumno("Facundo", 10, "3k10");
        Alumno alu3 = new Alumno("Camila", 7, "3k9");
        Alumno alu4 = new Alumno("Candela", 2, "3k9");

        List<Alumno> listadoAlumnos = List.of(alu1, alu2, alu3, alu4);

        // Me quedo con los que aprobaron, paso el nombre a mayúsculas y ordeno
        List<String> alumnosQueAprueban = listadoAlumnos.stream()
                .filter(al -> al.getNota() >= 7)
                .map(al -> al.getNombre().toUpperCase())
                .sorted()
                .collect(Collectors.toList());

        System.out.println("✔ Aprobados: " + alumnosQueAprueban);
        System.out.println();

        // Calcular promedio general de las notas
        double promedioNotasCurso = listadoAlumnos.stream()
                .mapToDouble(Alumno::getNota)
                .average()
                .orElse(0.0);

        System.out.println("Promedio general del curso: " + promedioNotasCurso);
        System.out.println();

        // Agrupar alumnos por curso/división
        Map<String, List<Alumno>> alumnosPorDivision = listadoAlumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));

        System.out.println("Alumnos agrupados por división:");
        alumnosPorDivision.forEach((division, grupo) -> {
            System.out.println("División " + division + ":");
            grupo.forEach(System.out::println);
        });

        System.out.println("=====================================");
        System.out.println();

        // =========================
        // Bloque PRODUCTOS
        // =========================
        // Inventario chico tipo "tienda online"
        Producto it1 = new Producto("Teclado Mecánico", "Periféricos", 45999.0, 11);
        Producto it2 = new Producto("Auriculares BT", "Periféricos", 29999.0, 5);
        Producto it3 = new Producto("Silla Gamer", "Mobiliario", 199999.0, 2);
        Producto it4 = new Producto("Mate de Acero", "Hogar", 7999.0, 24);

        List<Producto> inventario = List.of(it1, it2, it3, it4);

        // Productos de precio alto (ej: +30000), ordenados de caro a barato
        List<Producto> productosPremium = inventario.stream()
                .filter(prod -> prod.getPrecio() > 30000.0)
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .collect(Collectors.toUnmodifiableList());

        System.out.println("Productos premium (+$30000): " + productosPremium);
        System.out.println();

        // Agrupar por categoría del producto
        Map<String, List<Producto>> agrupadoPorCategoria = inventario.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria));

        System.out.println("Inventario agrupado por categoría:");
        agrupadoPorCategoria.forEach((cat, listaCat) -> {
            System.out.println("Categoría: " + cat);
            listaCat.forEach(System.out::println);
        });

        System.out.println();

        // Sumar stock total disponible
        double cantidadTotalEnStock = inventario.stream()
                .mapToDouble(Producto::getStock)
                .sum();
        System.out.println("Stock total disponible (todas las categorías): " + cantidadTotalEnStock);

        System.out.println();

        // Armar un resumen tipo "Teclado Mecánico $45999.0; Auriculares BT $29999.0; ..."
        String resumenPrecios = inventario.stream()
                .map(p -> p.getNombre() + " $" + p.getPrecio())
                .collect(Collectors.joining("; "));
        System.out.println("Catálogo rápido: " + resumenPrecios);

        // Precio promedio de todos los productos
        double precioPromedioGeneral = inventario.stream()
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0.0);
        System.out.println("Precio promedio general: $" + precioPromedioGeneral);

        System.out.println();

        // Precio promedio por categoría
        Map<String, Double> promedioPorCat = inventario.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio)
                ));

        System.out.println("Precio promedio por categoría:");
        promedioPorCat.forEach((cat, prom) ->
                System.out.println(cat + " => $" + prom)
        );

        System.out.println("=====================================");
        System.out.println();

        // =========================
        // Bloque LIBROS
        // =========================
        // Datos tipo librería técnica / estudio
        Libro b1 = new Libro("Sistemas Distribuidos", "K. García", 520, 88000.0);
        Libro b2 = new Libro("Algoritmos Avanzados", "P. Duarte", 310, 99000.0);
        Libro b3 = new Libro("Fundamentos de Bases de Datos", "L. Ortega", 270, 65000.0);
        Libro b4 = new Libro("Introducción a la Seguridad", "K. García", 190, 47000.0);

        List<Libro> biblioteca = List.of(b1, b2, b3, b4);

        // Libros considerados "largos": más de 300 páginas
        List<String> librosExtensos = biblioteca.stream()
                .filter(lib -> lib.getPaginas() > 300)
                .map(Libro::getTitulo)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Libros extensos (+300 págs): " + librosExtensos);
        System.out.println();

        // Promedio de páginas por libro
        double promedioDePaginas = biblioteca.stream()
                .mapToInt(Libro::getPaginas)
                .average()
                .orElse(0.0);
        System.out.println("Promedio de páginas por título: " + promedioDePaginas);
        System.out.println();

        // Agrupar por autor
        Map<String, List<Libro>> librosAgrupadosPorAutor = biblioteca.stream()
                .collect(Collectors.groupingBy(Libro::getAutor));

        System.out.println("Libros agrupados por autor:");
        librosAgrupadosPorAutor.forEach((autor, listaLibros) -> {
            System.out.println("Autor: " + autor);
            listaLibros.forEach(System.out::println);
        });

        System.out.println();

        // Libro más caro
        Optional<Libro> tituloMasCaro = biblioteca.stream()
                .max(Comparator.comparingDouble(Libro::getPrecio));

        tituloMasCaro.ifPresent(lib ->
                System.out.println("Libro más caro: " + lib.getTitulo() + " ($" + lib.getPrecio() + ")")
        );

        System.out.println("=====================================");
        System.out.println();

        // =========================
        // Bloque EMPLEADOS
        // =========================
        // Ejemplo tipo "planilla RRHH"
        Empleado empA = new Empleado("Valentina", "Infraestructura", 980000.0, 33);
        Empleado empB = new Empleado("Sergio", "Infraestructura", 910000.0, 41);
        Empleado empC = new Empleado("Anabella", "Desarrollo", 1250000.0, 27);
        Empleado empD = new Empleado("Julián", "Desarrollo", 1380000.0, 30);

        List<Empleado> personal = List.of(empA, empB, empC, empD);

        // Me quedo con la gente que gana más de 1M, ordenado de mayor sueldo a menor
        List<Empleado> sueldosAltos = personal.stream()
                .filter(e -> e.getSalario() > 1_000_000.0)
                .sorted(Comparator.comparingDouble(Empleado::getSalario).reversed())
                .collect(Collectors.toList());

        System.out.println("Gente con sueldo alto (> $1.000.000): " + sueldosAltos);
        System.out.println();

        // Promedio salarial general
        double promedioSueldos = personal.stream()
                .mapToDouble(Empleado::getSalario)
                .average()
                .orElse(0.0);
        System.out.println("Promedio salarial: $" + promedioSueldos);
        System.out.println();

        // Agrupar por departamento/área
        Map<String, List<Empleado>> porArea = personal.stream()
                .collect(Collectors.groupingBy(Empleado::getDepartamento));

        System.out.println("Personal agrupado por área:");
        porArea.forEach((area, listaArea) -> {
            System.out.println("Área: " + area);
            listaArea.forEach(System.out::println);
        });
        System.out.println();

        // Suma total de todos los sueldos
        double costoTotalSueldos = personal.stream()
                .mapToDouble(Empleado::getSalario)
                .sum();
        System.out.println("Costo total mensual en salarios: $" + costoTotalSueldos);
        System.out.println();

        // Sueldo total que representa cada área
        Map<String, Double> masaSalarialPorArea = personal.stream()
                .collect(Collectors.groupingBy(
                        Empleado::getDepartamento,
                        Collectors.summingDouble(Empleado::getSalario)
                ));

        System.out.println("Masa salarial por área:");
        masaSalarialPorArea.forEach((area, totalArea) ->
                System.out.println(area + " => $" + totalArea)
        );

        System.out.println();

        // Los dos más jóvenes de toda la nómina (esto sería útil tipo "plan de carrera")
        List<Empleado> candidatosJunior = personal.stream()
                .sorted(Comparator.comparingInt(Empleado::getEdad))
                .limit(2)
                .collect(Collectors.toList());

        System.out.println("Perfiles más jóvenes: " + candidatosJunior);
        System.out.println();
    }
}
