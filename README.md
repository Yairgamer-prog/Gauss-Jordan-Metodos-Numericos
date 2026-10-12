# Práctica: Método de Gauss-Jordan

**Asignatura:** SCC-1017 Métodos Numéricos (Unidad 3)
**Alumno:** Yair de Jesús Hernández Campuzano
**Docente:** Víctor Hugo Vásquez Herrera
**Institución:** Instituto Tecnológico Superior de Xalapa (ITSX) — Ingeniería en Sistemas Computacionales

---

## Estructura modular

```
Ecuaciones_lineales/
├── defmatrizz.java            → Define la matriz aumentada [A | b]
├── Gauss.java                 → Módulo de la práctica anterior (eliminacionGaussiana)
├── GaussJordan.java           → Normalización de pivotes + barrido superior
└── Lanzador_GaussJordan.java  → Clase principal (main)
```

- **`defmatrizz`**: solo guarda el sistema de ecuaciones.
- **`Gauss`**: se reutiliza tal cual de la práctica anterior. `GaussJordan` llama a `Gauss.eliminacionGaussiana(matriz)` en lugar de volver a escribir la triangulación.
- **`GaussJordan`**:
  1. Triangula reutilizando `Gauss`.
  2. Recorre de abajo hacia arriba: divide cada renglón entre su pivote (lo vuelve 1) y anula los coeficientes de esa columna en los renglones superiores.
  3. Lee las soluciones directamente de `matriz[i][n]`, sin sustitución regresiva.
  También incluye `imprimirMatriz` para comprobar que quedó la identidad.
- **`Lanzador_GaussJordan`**: coordina los módulos e imprime resultados.

Como en Java los arreglos se pasan por referencia, todas las operaciones se hacen sobre la misma matriz en RAM.

## Sistema resuelto

```
3.0x1 - 0.1x2 - 0.2x3  =   7.85
0.1x1 + 7.0x2 - 0.3x3  = -19.3
0.3x1 - 0.2x2 + 10.0x3 =  71.4
```

## Cómo compilar y ejecutar

Requisito: tener instalado el **JDK**.

Desde la terminal, en la carpeta que contiene `Ecuaciones_lineales`:

```bash
javac Ecuaciones_lineales/*.java
java Ecuaciones_lineales.Lanzador_GaussJordan
```

En un IDE basta con ejecutar la clase `Lanzador_GaussJordan`.

## Ejemplo de ejecución

```
Matriz aumentada original [A | b]:
|     3.0000    -0.1000    -0.2000 |     7.8500 |
|     0.1000     7.0000    -0.3000 |   -19.3000 |
|     0.3000    -0.2000    10.0000 |    71.4000 |

Matriz después de Gauss-Jordan [I | x]:
|     1.0000     0.0000     0.0000 |     3.0000 |
|     0.0000     1.0000     0.0000 |    -2.5000 |
|     0.0000     0.0000     1.0000 |     7.0000 |

Soluciones del sistema (Gauss-Jordan):
x1 = 3.000000
x2 = -2.500000
x3 = 7.000000
```
