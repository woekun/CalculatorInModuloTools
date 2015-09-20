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
public class Modulo_Exponentiation {

    public static int Modulo_Exponentiation(int A, int k, int M) {
        int result = 1;
        while (k > 0) {
            if (Integer.lowestOneBit(k) == 1) {
                result = result * A % M;
            }
            k >>= 1;
            A = A * A % M;
        }
        return result % M;
    }
}
