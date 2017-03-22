package com.marvinkirsch94.core;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Marvin Kirsch on 21.03.2017.
 * Matrikelnr.: 11118687
 */
public class MaschDV {

    private static ArrayList<Maschine> malist = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                            new FileInputStream(
                                    System.getProperty("user.home") + "/Desktop/MASCH.TXT")));
        while(in.readLine() != null) {
            Maschine m = new Maschine(in.readLine());
            malist.add(m);
            m.ausMasch();
        }
        in.close();
        //Ausgabe des Menues
        System.out.println("(1)\tAnlegen und Einketten eines neuen Knotens zu einer gegebenen Postion in die Liste\n"
                        + "(2)\tLoeschen eines Knotens in der Liste\n"
                        + "(3)\tAendern der Inhalte eines Knotens\n"
                        + "(4)\tSchreiben der Listenknoten in eine Datei\n");
        BufferedReader rc = new BufferedReader(new InputStreamReader(System.in));
        int aw = Integer.parseInt(rc.readLine());
        switch(aw) {
            case 1:
                System.out.println(anlegen());
                break;
            case 2:
                System.out.println(loeschen());
                break;
            case 3:
                System.out.println(aendern());
                break;
            case 4:
                System.out.println(writeToData());
                break;
        }
    }

    private static boolean anlegen() {

        return true;
    }

    private static boolean loeschen() {
        return true;
    }

    private static boolean aendern() {
        return true;
    }

    private static boolean writeToData() {
        return true;
    }
}