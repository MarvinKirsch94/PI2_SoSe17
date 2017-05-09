package com.marvinkirsch94.core.versuch1;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Marvin Kirsch on 21.03.2017.
 * Matrikelnr.: 11118687
 */
public class MaschDV {

    private static ArrayList<Maschine> malist = new ArrayList<>();
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        BufferedReader rc = new BufferedReader(
                            new InputStreamReader(
                            new FileInputStream(
                                    System.getProperty("user.home") + "/Desktop/MASCH.TXT")));
        while(true) {
            String s = rc.readLine();
            if(s == null) break;
            Maschine m = new Maschine(s);
            malist.add(m);
            m.ausMasch();
        }
        rc.close();
        //Ausgabe des Menues
        boolean loop = true;
        do {
            System.out.println("(1)\tAnlegen und Einketten eines neuen Knotens zu einer gegebenen Postion in die Liste\n"
                    + "(2)\tLoeschen eines Knotens in der Liste\n"
                    + "(3)\tAendern der Inhalte eines Knotens\n"
                    + "(4)\tSchreiben der Listenknoten in eine Datei\n"
                    + "(5)\tAbbrechen\n");
            int aw = Integer.parseInt(in.readLine());
            try {
                switch (aw) {
                    case 1:
                        System.out.println(anlegen() ? "Erfolgreich!" : "Fehler! ... Versuchen sie es erneut oder etwas Anderes!");
                        break;
                    case 2:
                        loeschen();
                        System.out.println("Maschine wurde geloescht!");
                        break;
                    case 3:
                        System.out.println(aendern() ? "Erfolgreich!" : "HIER IST ETWAS GRAVIEREND FALSCH GELAUFEN!!!");
                        break;
                    case 4:
                        System.out.println(writeToData() ? "Erfolgreich!" : "Versuchen sie es erneut oder geben sie einen " +
                                "anderen Befehl ein.");
                        break;
                    case 5:
                        System.out.println("Beenden . . .");
                        loop = false;
                        break;
                }
            } catch (IOException ioe) {
                System.err.println(ioe + "\n" + "Whooops da ist was schief gegangen!!");
            }
        } while(loop);

    }

    private static boolean anlegen() throws IOException {
        System.out.println("Geben sie csv String zum deffinieren der neuen Maschine ein: ");
        String csv = in.readLine();
        System.out.println("Geben sie den Index der Stelle an welcher sie die Maschine einfuegen wollen: ");
        int index = Integer.parseInt(in.readLine());
        Maschine m = new Maschine(csv);
        malist.add(index, m);
        return m.getCrt()==1;
    }

    private static void loeschen() throws IOException {
        System.out.println("Geben sie den Index der Maschine an, die sie loeschen wollen: ");
        int index = Integer.parseInt(in.readLine());
        malist.remove(index);
    }

    private static boolean aendern() throws IOException {
        System.out.println("Geben sie den Index der Maschine an, die sie aendern wollen: ");
        int index = Integer.parseInt(in.readLine());
        malist.get(index).ausMasch();
        malist.get(index).ausMaschCSV();
        System.out.println("s.o. die Maschine ... \n " +
                "Geben sie einen neuen csv String um die Maschine zu aendern: ");
        String csv = in.readLine();
        Maschine m = new Maschine(csv);
        if(m.getCrt()==1) {
            System.out.println("Hier die neue Maschine: " + "\n" + m.ausMaschCSV());
            m.ausMasch();
            malist.remove(index);
            malist.add(index, m);
            return true;
        } else {
            System.out.println("csv String Fehlerhaft! ... neustart ...");
            aendern();
        }
        return false;
    }

    private static boolean writeToData() throws IOException {
        try {
            BufferedWriter out = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(System.getProperty("user.home") + "/Desktop/MASCH.TXT"), "utf-8"));
            for (Maschine ma : malist) {
                out.write(ma.ausMaschCSV());
                out.newLine();
            }
            out.close();
        } catch(IOException ioe) {
            System.err.println(ioe + "\n");
            return false;
        }
        return true;
    }
}