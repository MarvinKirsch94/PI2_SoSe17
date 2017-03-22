package com.marvinkirsch94.core;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Marvin Kirsch on 21.03.2017.
 * Matrikelnr.: 11118687
 */
public class MaschAnw {

    public static void main(String args[]) throws IOException {
        ArrayList<Maschine> malist = new ArrayList<>();
        //s1
        Maschine m = new Maschine();
        m.ausMasch();
        //s2
        for(String csv : maschGeber()) {
            Maschine mt = new Maschine(csv);
            if(mt.getCrt() != 1) {
                mt.ausMasch();
                System.out.println("Fehler beim anlegen der Maschine !\n");
            } else {
                malist.add(mt);
                mt.ausMasch();
                System.out.println("Korrekt!\n");
            }
        }
        //s3
        String antwort = "y";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Geben sie den Index der Maschine ein,\n" +
                    " zu dem sie den Abschreibungswert berechnen lassen moechten ein: ");
            int index = Integer.parseInt(in.readLine());
            System.out.println("Geben sie die Gesamtlaufzeit in Tagen ein: ");
            int tage = Integer.parseInt(in.readLine());
            System.out.println("Der Abschreibungswert betraegt: " + malist.get(index).abschreibung(tage) + "\n");
            System.out.println("Wollen sie den Vorgang wiederholen ? (y/n)");
            if(in.readLine().equals("n")) {
                antwort = "n";
            }
        } while(antwort.equals("y"));
        //s4
        BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(
                new FileOutputStream(System.getProperty("user.home") + "/Desktop/MASCH.TXT"), "utf-8"));
        for(Maschine ma : malist) {
            out.write(ma.ausMaschCSV());
            out.newLine();
        }
        out.close();
    }

    static String[] maschGeber() {

        final String csv_zeichenketten[] = new String[]{"02;100.00;Kaffeemaschine;Kueche",
                                                        "03;55.40;Maschine2;UmDieEcke",
                                                        "04;33.25;Maschine3;Hier",
                                                        "05;6455.33;Maschine4;Da",
                                                        "06;64.56;Maschine5;Dort",
                                                        "-2457;50;Mschinekaputt6;nichthier;dort",
                                                        "7755;-40;Maschinekaputt7;nirgendwo"};
        return csv_zeichenketten;
    }
}