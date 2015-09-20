/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util.Algorithm;

/**
 *
 * @author HIPPY
 */
public class Extended_Euclide {

    public static int[] Extended_Euclide(int p, int q) {
        if (q == 0) {
            return new int[]{p, 1, 0};
        } else {
            int vals[] = Extended_Euclide(q, p % q);
            int d = vals[0];
            int a = vals[2];
            int b = vals[1] - (p / q) * vals[2];
            return new int[]{d, a, b};
        }
    }
}
