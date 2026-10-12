// Yair de Jesús Hernández Campuzano
// defmatrizz.java — Definición de la matriz aumentada [A | b]

package Ecuaciones_lineales;

public class defmatrizz {

    // Sistema de 3 ecuaciones con 3 incógnitas:
    //  3.0x1 - 0.1x2 - 0.2x3 =   7.85
    //  0.1x1 + 7.0x2 - 0.3x3 = -19.3
    //  0.3x1 - 0.2x2 + 10.0x3 =  71.4
    public static double[][] defmatriz() {
        return new double[][] {
                { 3.0, -0.1, -0.2,  7.85 },
                { 0.1,  7.0, -0.3, -19.3 },
                { 0.3, -0.2, 10.0,  71.4 }
        };
    }
}
