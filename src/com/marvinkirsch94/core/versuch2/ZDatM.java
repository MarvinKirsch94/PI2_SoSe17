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
    public ZDatM(String dsn, int mod) throws IOException {
        switch(mod) {
            case 1:
                //read
                File f = new File(dsn);
                fr1 = new FileReader(dsn);
                br1 = new BufferedReader(fr1);
                this.dsliste = new ArrayList<>();
                this.einlesen();
                fw1 = null;
                pr1 = null;
                break;
            case 2:
                //write
                fw1 = new FileWriter(dsn);
                pr1 = new PrintWriter(fw1);
                dsliste = null;
                fr1 = null;
                br1 = null;
                break;
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
        for(Maschine m : this.dsliste) {
            this.pr1.write(m.toString() + "\n");
        }
    }

    //c3
    public int bubble(int iox) {
        boolean isNotSorted = true;
        int c = 0;
        while(isNotSorted) {
            isNotSorted = false;
            for(int i = 0; i < this.dsliste.size() - 1; i++) {
                switch(iox) {
                    case 1:
                        //mabez
                        if (this.dsliste.get(i).getMabez().compareTo(this.dsliste.get(i + 1).getMabez()) > 0) {
                            Maschine tm = this.dsliste.get(i);
                            this.dsliste.remove(i);
                            this.dsliste.add(i + 1, tm);
                        }
                        isNotSorted = true;
                        break;
                    case 2:
                        //preis
                        if (this.dsliste.get(i).getPreis() > this.dsliste.get(i + 1).getPreis()) {
                            Maschine tm = this.dsliste.get(i);
                            this.dsliste.remove(i);
                            this.dsliste.add(i + 1, tm);
                        }
                        isNotSorted = true;
                        break;
                    case 3:
                        //stao
                        if (this.dsliste.get(i).getStao().compareTo(this.dsliste.get(i + 1).getStao()) > 0) {
                            Maschine tm = this.dsliste.get(i);
                            this.dsliste.remove(i);
                            this.dsliste.add(i + 1, tm);
                        }
                        isNotSorted = true;
                        break;
                }
                if(isNotSorted) {
                    c++;
                }
            }
        }
        return c;
    }

    //c4
    public int sortDA(int iox) {
        int c = 0;
        ArrayList<Maschine> hlist = new ArrayList<>();
        for(Maschine m : this.dsliste) {
            if(hlist.isEmpty()) {
                hlist.add(m);
                continue;
            }
            switch(iox) {
                case 1:
                    //mabez
                    if (hlist.get(hlist.size()).getMabez().compareToIgnoreCase(m.getMabez()) < 0) {
                        hlist.add(hlist.size(), m);
                    } else if(hlist.get(0).getMabez().compareToIgnoreCase(m.getMabez()) > 0) {
                        hlist.add(0, m);
                    } else {
                        for(int i = 1; i < hlist.size(); i++) {
                            if(hlist.get(i).getMabez().compareToIgnoreCase(m.getMabez()) > 0) {
                                hlist.add(i, m);
                            }
                        }
                    }
                    c++;
                    break;
                case 2:
                    //preis
                    if (hlist.get(hlist.size()).getPreis() < m.getPreis()) {
                        hlist.add(hlist.size(), m);
                    } else if(hlist.get(0).getPreis() > m.getPreis()) {
                        hlist.add(0, m);
                    } else {
                        for(int i = 1; i < hlist.size(); i++) {
                            if(hlist.get(i).getPreis() > m.getPreis()) {
                                hlist.add(i, m);
                            }
                        }
                    }
                    c++;
                    break;
                case 3:
                    //stao
                    if (hlist.get(hlist.size()).getStao().compareToIgnoreCase(m.getStao()) < 0) {
                        hlist.add(hlist.size(), m);
                    } else if(hlist.get(0).getStao().compareToIgnoreCase(m.getStao()) > 0) {
                        hlist.add(0, m);
                    } else {
                        for(int i = 1; i < hlist.size(); i++) {
                            if(hlist.get(i).getStao().compareToIgnoreCase(m.getStao()) > 0) {
                                hlist.add(i, m);
                            }
                        }
                    }
                    c++;
                    break;
            }
        }
        dsliste = hlist;
        return c;
    }
}
