# 🧠 Trabajo Práctico – Programación Funcional en Java

**Materia:** Programación III  
**Carrera:** Tecnicatura Universitaria en Programación (a distancia)  
**Tema:** Streams y Expresiones Lambda en Java  
**Docente:** —  
**Alumno:** —  
**Año:** 2025  

---

## 🎯 Objetivo General

Practicar operaciones intermedias y terminales de los **Streams** en Java para procesar colecciones de forma **declarativa**, reemplazando estructuras imperativas por un enfoque más funcional y expresivo.

---

## 🧩 Marco Teórico

| Concepto | Aplicación en el Proyecto |
|-----------|----------------------------|
| **Stream** | Flujo de datos que permite aplicar transformaciones como `map`, `filter` y `sorted`. |
| **Collectors** | Permiten agrupar, contar, promediar, unir en cadenas, etc. |
| **Expresiones Lambda + Streams** | Facilitan el procesamiento de colecciones con mínima complejidad y mayor legibilidad. |
| **Operaciones Terminales** | Útiles para agrupar datos, calcular totales y generar reportes. |
| **Inmutabilidad** | Clave para evitar errores en sistemas con manejo de datos. |

---

## 💻 Casos Prácticos

### 🧮 Caso 1: `Alumno(nombre, nota, curso)`

1. Obtener los nombres de los alumnos **aprobados (nota ≥ 7)** en **mayúsculas** y **ordenados**.  
2. Calcular el **promedio general** de notas.  
3. **Agrupar alumnos por curso** usando `Collectors.groupingBy()`.  
4. Obtener los **3 mejores promedios**.

**Conclusiones:**
- Comprensión del pipeline de Streams.
- Uso de mapeo, filtrado, reducción y agrupación.
- Código declarativo y más legible.

---

### 🛒 Caso 2: `Producto(nombre, categoria, precio, stock)`

1. Listar los productos con **precio > 100**, ordenados por precio **descendente**.  
2. Agrupar productos por **categoría** y calcular el **stock total**.  
3. Generar un **String** que contenga nombre y precio de cada producto, separados por “;” usando `map` + `collect(joining)`.  
4. Calcular el **precio promedio** general y por categoría.

**Conclusiones:**
- Aplicación práctica de programación funcional.
- Generación de reportes y estadísticas con Streams.
- Consolidación de `lambdas`, `collectors` y manipulación funcional de listas.

---

### 📚 Caso 3: `Libro(titulo, autor, paginas, precio)`

1. Listar los títulos de libros con **más de 300 páginas**, ordenados **alfabéticamente**.  
2. Calcular el **promedio de páginas** de todos los libros.  
3. Agrupar libros por **autor** y contar cuántos tiene cada uno.  
4. Obtener el **libro más caro** de la lista.

**Conclusiones:**
- Práctica con `filter`, `map`, `sorted` y `collect`.  
- Uso de `Collectors.groupingBy()` y `counting()`.  
- Cálculo de promedios y máximos con Streams.

---

### 👔 Caso 4: `Empleado(nombre, departamento, salario, edad)`

1. Listar empleados con **salario > 2000**, ordenados por salario **descendente**.  
2. Calcular el **salario promedio general**.  
3. Agrupar empleados por **departamento** y sumar los salarios de cada uno.  
4. Obtener los nombres de los **2 empleados más jóvenes**.

**Conclusiones:**
- Uso de filtros, ordenamiento y límites (`limit`).  
- Cálculo de promedios y sumatorias con `collectors`.  
- Agrupación con `groupingBy` y `summingDouble`.

---

## ⚙️ Tecnologías Utilizadas

- **Java 21+**
- **Colecciones y Streams**
- **Lambdas y Collectors**
- **IDE:** IntelliJ IDEA / Eclipse / NetBeans

---

## 🧾 Conclusión General

Este trabajo práctico permite afianzar los conocimientos sobre **programación funcional en Java**, mostrando cómo los **Streams** simplifican las operaciones sobre colecciones.  
El enfoque declarativo facilita la lectura del código y reduce la probabilidad de errores, promoviendo una programación más limpia, eficiente y moderna.


