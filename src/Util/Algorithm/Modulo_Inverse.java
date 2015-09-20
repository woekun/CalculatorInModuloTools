/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util.Algorithm;

import static Util.Algorithm.Extended_Euclide.Extended_Euclide;

/**
 *
 * @author HIPPY
 */
public class Modulo_Inverse {

    public static int Modulo_Inverse(int a, int n) {
        int vals[] = Extended_Euclide(a, n);
        int c = vals[0];
        int d = vals[1];

        if (c > 1) {
            return 0;
        }

        if (d > 0) {
            return d;
        }

        return n + d;
    }
}
