package com.marvinkirsch94.core.versuch2;

import com.marvinkirsch94.core.versuch1.Maschine;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Marvin Kirsch on 24.04.2017.
 * Matrikelnr.: 11118687
 */
public class ZDatM {
    //a
    //attributes
    private FileReader fr1;
    private BufferedReader br1;
    private FileWriter fw1;
    private PrintWriter pr1;
    private ArrayList<Maschine> dsliste;

    //b
    //constructor
    public ZDatM(String dsn, int mod) throws FileNotFoundException, IOException {
        switch(mod) {
            case 1:
                //read
                File f = new File(dsn);
                fr1 = new FileReader(dsn);
                br1 = new BufferedReader(fr1);
                this.einlesen();
                fw1 = null;
                pr1 = null;
            case 2:
                //write
                fw1 = new FileWriter(dsn);
                pr1 = new PrintWriter(fw1);
        }
    }

    //c

    //c1
    public int einlesen() throws IOException {
        int zeile = 0;
        int data = 0;
        while(true) {
            String s = this.br1.readLine();
            if(s == null) {
                break;
            }
            Maschine m = new Maschine(s);
            if(m.getCrt() != 1) {
                System.err.println("Fehlerhafte Maschine in Zeile: " + zeile + "!");
            } else {
                this.dsliste.add(m);
                data++;
            }
            zeile++;
        }
        return data;
    }

    //c2
    public void list2Dat() {
        for(Maschine m : dsliste) {
            this.pr1.write(m.toString() + "\n");
        }
    }

    //c3
    public int bubble(int iox) {
        return 0;
    }

    //c4
    public int sortDA(int iox) {
        return 0;
    }
}
