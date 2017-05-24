package com.marvinkirsch94.core.versuch2;

import java.io.*;

/**
 * Created by Marvin Kirsch on 15.05.2017.
 * Matrikelnr.: 11118687
 */
public class MatAnw {
    public static void main(String args[]) throws IOException {
        boolean running = true;
        BufferedReader dataIn = new BufferedReader(new InputStreamReader(new FileInputStream(System.getProperty("user.home") + "/Desktop/Mat.txt")));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Mat m = new Mat(dataIn);
        BufferedReader dataIn2 = new BufferedReader(new InputStreamReader(new FileInputStream(System.getProperty("user.home") + "/Desktop/Mat2.txt")));
        Mat b = new Mat(dataIn2);
        Mat c;
        do {
            System.out.println("(1)matAus\n(2)matMul\n(3)Beenden...");
            System.out.println("Geben sie ihre Auswahl ein: )");
            int a = Integer.parseInt(in.readLine());
            switch (a) {
                case  1:
                    FileWriter fx = new FileWriter(System.getProperty("user.home") + "/Desktop/Mat3.txt");
                    System.out.println("Rueckgabe matAus m: " + m.matAus(fx));
                    FileWriter fx2 = new FileWriter(System.getProperty("user.home") + "/Desktop/Mat4.txt");
                    System.out.println("Rueckgabe matAus b: " + b.matAus(fx2));
                    break;
                case  2:
                    c = m.matMul(b);
                    FileWriter fx3 = new FileWriter(System.getProperty("user.home") + "/Desktop/Mat5.txt");
                    System.out.println("Rueckgabe matAus c: " + c.matAus(fx3));
                    break;
                case  3:
                    System.out.println("Danke und Auf Wiedersehen! :)");
                    running = false;
                    break;
                default:
                    System.err.println("Unexpected error!!!\nSystem shutdown");
                    System.exit(0);
                    break;
            } // end of switch
        } while (running); // end of do-while
    }
}