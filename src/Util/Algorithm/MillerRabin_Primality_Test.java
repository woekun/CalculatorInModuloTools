/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util.Algorithm;

import static Util.Algorithm.Modulo_Exponentiation.Modulo_Exponentiation;
import java.util.Random;

/**
 *
 * @author HIPPY
 */
public class MillerRabin_Primality_Test {

    public static boolean isPrime(int n) {

        int s = 0;
        int subN = n - 1;

        while ((subN) % 2 == 0) {
            subN >>= 1;
            s++;
        }

        for (int k = 0; k < 10; k++) {

            int randomNum = new Random().nextInt((n - 2 - 2) + 1) + 2;

            int a = Modulo_Exponentiation(randomNum, subN, n);
            if (a == 1 || a == n - 1) {
                return true;
            }

            for (int i = 0; i <= s - 1; i++) {
                a = (int) Math.pow(a, 2) % n;
                if (a == 1) {
                    return false;
                }
                if (a == n - 1) {
                    break;
                }
            }

            if (a == n - 1) {
                continue;
            }

            return false;
        }
        return false;
    }
}
