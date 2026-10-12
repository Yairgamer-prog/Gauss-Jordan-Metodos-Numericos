// Yair de Jesús Hernández Campuzano
// Lanzador_GaussJordan.java — Clase principal

package Ecuaciones_lineales;

public class Lanzador_GaussJordan {
    public static void main(String[] args) {
        // 1. Obtener la matriz aumentada [A | b]
        double[][] matriz = defmatrizz.defmatriz();

        System.out.println("Matriz aumentada original [A | b]:");
        GaussJordan.imprimirMatriz(matriz);

        // 2. Resolver por Gauss-Jordan (internamente reutiliza Gauss.eliminacionGaussiana)
        double[] soluciones = GaussJordan.resolver(matriz);

        // 3. Mostrar la matriz transformada: debe verse la identidad a la izquierda
        System.out.println("\nMatriz después de Gauss-Jordan [I | x]:");
        GaussJordan.imprimirMatriz(matriz);

        // 4. Resultados
        System.out.println("\nSoluciones del sistema (Gauss-Jordan):");
        for (int i = 0; i < soluciones.length; i++) {
            System.out.printf("x%d = %.6f%n", i + 1, soluciones[i]);
        }
    }
}
