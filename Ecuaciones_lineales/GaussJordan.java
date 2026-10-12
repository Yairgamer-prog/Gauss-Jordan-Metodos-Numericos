// Yair de Jesús Hernández Campuzano
// GaussJordan.java — Completa la eliminación gaussiana hasta llegar a la matriz identidad

package Ecuaciones_lineales;

public class GaussJordan {

    /**
     * Resuelve el sistema por Gauss-Jordan reutilizando la triangulación de Gauss.
     * La matriz se recibe por referencia, así que todos los cambios se hacen
     * directamente sobre el mismo arreglo en RAM (no se crea una copia).
     * @param matriz Matriz aumentada [A | b].
     * @return Vector de soluciones leído de la última columna.
     */
    public static double[] resolver(double[][] matriz) {
        int n = matriz.length;

        // PASO 1: Reutilización. Se triangula con el método de la práctica anterior.
        Gauss.eliminacionGaussiana(matriz);

        // PASO 2: Normalización de pivotes y barrido hacia arriba.
        // Se recorre de abajo hacia arriba porque el último renglón
        // ya solo tiene una incógnita después de triangular.
        for (int i = n - 1; i >= 0; i--) {

            // 2a. Normalizar: dividir toda la fila entre el pivote para que quede en 1
            double pivote = matriz[i][i];
            for (int k = i; k <= n; k++) {
                matriz[i][k] = matriz[i][k] / pivote;
            }

            // 2b. Barrido superior: hacer cero la columna i en los renglones de arriba
            for (int j = 0; j < i; j++) {
                double factor = matriz[j][i]; // como el pivote ya vale 1, el factor es el propio coeficiente
                for (int k = i; k <= n; k++) {
                    matriz[j][k] = matriz[j][k] - factor * matriz[i][k];
                }
            }
        }

        // PASO 3: Lectura directa. Con la identidad a la izquierda,
        // cada x_i queda despejada en matriz[i][n] (sin sustitución regresiva).
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = matriz[i][n];
        }
        return x;
    }

    /**
     * Imprime la matriz aumentada para comprobar visualmente que quedó la identidad.
     */
    public static void imprimirMatriz(double[][] matriz) {
        for (double[] fila : matriz) {
            System.out.print("| ");
            for (int k = 0; k < fila.length; k++) {
                if (k == fila.length - 1) System.out.print("| ");
                System.out.printf("%10.4f ", fila[k]);
            }
            System.out.println("|");
        }
    }
}
