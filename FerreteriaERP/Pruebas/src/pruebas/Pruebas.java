/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

/**
 *
 * @author johan
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String S = "form";
        String T = "from";
        String resultado = "";
        String car = "";
        String car2 = "";
        if (S.equals(T)) {
            resultado = "NOTHING";
        } else {
            if (T.length() > S.length() && (T.length() - S.length()) <= 1) {
                for (int i = 0; i < T.length(); i++) {
                    if (T.charAt(i) != S.charAt(i)) {
                        car = String.valueOf(T.charAt(i));
                        String fin = S.substring(i, S.length());
                        S = S.substring(0, i).concat(car).concat(fin);
                    }
                }
                if (S.equals(T)) {
                    resultado = "INSERT " + car;
                } 
            } else if (S.length() > T.length() && (S.length() - T.length()) <= 1 ) {
                for (int i = 0; i < S.length(); i++) {
                    if (T.charAt(i) != S.charAt(i)) {
                        car = String.valueOf(S.charAt(i));
                        String fin = S.substring(i + 1, S.length());
                        S = S.substring(0, i).concat(fin);
                    }
                }
                if (S.equals(T)) {
                    resultado = "DELETE " + car;
                } 
            } else if (T.length() == S.length()) {
                for (int i = 0; i < T.length(); i++) {
                    if (T.charAt(i) != S.charAt(i)) {
                        if (car.equals("")) {
                            car = String.valueOf(T.charAt(i));
                        } else {
                            car2 = String.valueOf(T.charAt(i));
                        }                        
                        String fin = S.substring(i + 1, S.length());
                        S = S.substring(0, i).concat(car2.equals("") ? car : car2).concat(fin);
                    }
                }
                if (S.equals(T)) {
                    resultado = "SWAP " + car2 + " " + car ;
                }
            } else {
                resultado = "IMPOSSIBLE";
            }
        }
        
        System.out.println(resultado);
    }

}
