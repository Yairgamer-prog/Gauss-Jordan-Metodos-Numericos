// Yair de Jesús Hernández Campuzano
// Gauss.java — Módulo de la práctica anterior (Eliminación Gaussiana simple)

package Ecuaciones_lineales;

public class Gauss {

    /**
     * Triangulación superior por Eliminación Gaussiana simple.
     * @param matriz Matriz aumentada [A | b]; se modifica directamente en memoria.
     */
    public static void eliminacionGaussiana(double[][] matriz) {
        int n = matriz.length; // número de ecuaciones

        // i: renglón pivote (recorre la diagonal principal)
        for (int i = 0; i < n; i++) {
            // j: renglones que están DEBAJO del pivote
            for (int j = i + 1; j < n; j++) {
                // factor que hace cero el elemento matriz[j][i]
                double factor = matriz[j][i] / matriz[i][i];
                // k: aplica R_j = R_j - factor * R_i en toda la fila (incluye la columna b)
                for (int k = i; k <= n; k++) {
                    matriz[j][k] -= factor * matriz[i][k];
                }
            }
        }
    }

    /**
     * Sustitución regresiva sobre una matriz triangular superior.
     * @param matriz Matriz ya triangulada.
     * @return Vector de soluciones x1, x2, ..., xn.
     */
    public static double[] sustitucionRegresiva(double[][] matriz) {
        int n = matriz.length;
        double[] x = new double[n];

        // del último renglón hacia el primero
        for (int i = n - 1; i >= 0; i--) {
            double suma = 0;
            for (int j = i + 1; j < n; j++) {
                suma += matriz[i][j] * x[j]; // incógnitas ya conocidas
            }
            x[i] = (matriz[i][n] - suma) / matriz[i][i];
        }
        return x;
    }
}
