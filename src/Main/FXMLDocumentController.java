/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import static Util.Algorithm.Chinese_Remainder_Theorem.Chinese_Remainder;
import static Util.Algorithm.Extended_Euclide.Extended_Euclide;
import static Util.Algorithm.MillerRabin_Primality_Test.isPrime;
import static Util.Algorithm.Modulo_Exponentiation.Modulo_Exponentiation;
import static Util.Algorithm.Modulo_Inverse.Modulo_Inverse;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author HIPPY
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField CRTinput1;
    @FXML
    private Label CRToutput;
    @FXML
    private TextField CRTinput2;
    @FXML
    private TextField EEinput;
    @FXML
    private Label EEoutput;
    @FXML
    private TextField MRPTinput;
    @FXML
    private Label MRPToutput;
    @FXML
    private TextField MEinput;
    @FXML
    private Label MEoutput;
    @FXML
    private TextField MIinput;
    @FXML
    private Label MIoutput;

    private static String[] trimString(String s) {
        String temp[] = s.split(",");
        return temp;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void EEcalculator(ActionEvent event) {
        String a[] = trimString(EEinput.getText());
        for (String item : a) {
            System.out.println(item);
        }
        int p = Integer.parseInt(a[0]);
        int q = Integer.parseInt(a[1]);
        int EEarray[] = Extended_Euclide(p, q);

        EEoutput.setText(p + " * " + EEarray[1] + " + " + q + " * " + EEarray[2] + " = " + EEarray[0]);
    }

    @FXML
    private void CRTcalculator(ActionEvent event) {
        String a[] = trimString(CRTinput1.getText());
        String n[] = trimString(CRTinput2.getText());

        int a1[] = new int[a.length];
        int n1[] = new int[n.length];
        int m = 1;

        for (int i = 0; i < a.length; i++) {
            a1[i] = Integer.parseInt(a[i]);
            n1[i] = Integer.parseInt(n[i]);
            m *= n1[i];
        }
        CRToutput.setText("x = " + String.valueOf(Chinese_Remainder(a1, n1)) + " + k." + m);
    }

    @FXML
    private void MRPTcalculator(ActionEvent event) {
        int a = Integer.parseInt(MRPTinput.getText());
        boolean test = isPrime(a);

        if (test == true) {
            MRPToutput.setText(a + " is prime");
        } else {
            MRPToutput.setText(a + " is composite");
        }
    }

    @FXML
    private void MEcalculator(ActionEvent event) {
        String s[] = trimString(MEinput.getText());
        int a = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int n = Integer.parseInt(s[2]);

        MEoutput.setText(a + "^" + k + " mod " + n + " = " + Modulo_Exponentiation(a, k, n));
    }

    @FXML
    private void MIcalculator(Event event) {
        String s[] = trimString(MIinput.getText());
        int a = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        
        MIoutput.setText(a+"^-1 mod "+n+" = "+ Modulo_Inverse(a,n));
    }

}
