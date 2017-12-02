/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenere;

import java.util.Scanner;

/**
 *
 * @author G4lk
 */
public class Vigenere {

    public static void main(String[] args) {
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; //Alphabet for crypt/decrypt
        System.out.print("Escribe tu clave: ");
        Scanner sc = new Scanner(System.in);       //Getting key from user
        String clave = sc.nextLine();
        System.out.println("Escribeme el texto");  
        String texto = sc.nextLine();              //Getting text
        System.out.print("Quieres cifrar o descifrar?: ");
        String tipo = sc.nextLine();
        char[] textoArray = texto.toCharArray();   //Getting option
        if (tipo.equalsIgnoreCase("crypt")) {
            int contador = 0;
            while (contador < textoArray.length) {  //While text dont finish get letter by letter the text to crypt.
                for (int i = 0; i < clave.length() && contador < textoArray.length; i++) { 
                    if (textoArray[contador] == ' ') {
                        i -= 1;
                        contador++;
                    } else {
                        textoArray[contador] = alfabeto.charAt((alfabeto.indexOf(textoArray[contador]) + alfabeto.indexOf(clave.charAt(i))) % 36);
                        contador++;
                    }
                }
            }
            System.out.println();
            for (int j = 0; j < textoArray.length; j++) {

                System.out.print(textoArray[j]);    //Print text crypted.
            }
        } else if(tipo.equalsIgnoreCase("decrypt")){
            int contador = 0;
            while (contador < textoArray.length) {  //While text dont finish get letter by letter the text to decrypt.
                for (int i = 0; i < clave.length() && contador < textoArray.length; i++) {
                    if (textoArray[contador] == ' ') {  // If its a space get next.
                        i -= 1;
                        contador++;
                    } else {
                        textoArray[contador] = alfabeto.charAt(Math.abs(alfabeto.indexOf(clave.charAt(i)) - alfabeto.indexOf(textoArray[contador])));
                        contador++;
                    }
                }
            }
            System.out.println();
            for (int j = 0; j < textoArray.length; j++) {

                System.out.print(textoArray[j]); //Print text decrypted.
            }
        }
    }
}
