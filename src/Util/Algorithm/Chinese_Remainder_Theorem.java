/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util.Algorithm;

import static Util.Algorithm.Modulo_Inverse.Modulo_Inverse;

/**
 *
 * @author HIPPY
 */
public class Chinese_Remainder_Theorem {
   
    public static int Chinese_Remainder(int a[], int m[]) {
        int prod = 1;
        int sum = 0;

        for (int n1 : m) {
            prod *= n1;
        }

        for (int i = 0; i < m.length; i++) {
            int p = prod / m[i];
            sum += a[i] * Modulo_Inverse(p, m[i]) * p;
        }

        return sum % prod;
    }
}
