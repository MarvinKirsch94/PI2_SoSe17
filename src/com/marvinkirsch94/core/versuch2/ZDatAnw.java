package com.marvinkirsch94.core.versuch2;

import java.io.*;

/**
 * Created by Marvin Kirsch on 15.05.2017.
 * Matrikelnr.: 11118687
 */
public class ZDatAnw {

    private static String dsn = System.getProperty("user.home") + "/Desktop/Masch.txt";
    public static void main(String args[]) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        //read
        ZDatM bsp = new ZDatM(dsn, 1);

        //write
        ZDatM bspsec = new ZDatM(dsn, 2);

        //einlesen
        System.out.println("Ausgabe bsp.einlesen : " + bsp.einlesen());
        System.out.println("Ausgabe bspsec.einlesen : " + bspsec.einlesen());
        //list2Dat
        bsp.list2Dat();
        bspsec.list2Dat();
        //bubble
        System.out.println("Geben sie iox fuer bubble ein: ");
        int iox = Integer.parseInt(in.readLine());
        System.out.println("bubble rueckgabewert: " + bsp.bubble(iox));
        System.out.println("bubble sec rueckgabewert: " + bspsec.bubble(iox));
        //sortDA
        System.out.println("Geben sie iox fuer sortDA ein: ");
        iox = Integer.parseInt(in.readLine());
        System.out.println("sortDA rueckgabewert: " + bsp.sortDA(iox));
        System.out.println("sortDA sec rueckgabewert: " + bspsec.sortDA(iox));
    }
}