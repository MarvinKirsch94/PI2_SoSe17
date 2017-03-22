package com.marvinkirsch94.core;

/**
 * Created by Marvin Kirsch on 21.03.2017.
 * Matrikelnr.: 11118687
 */
public class Maschine {

    private int manr;
    private double preis;
    private String mabez;
    private String stao;
    private int crt;

    public Maschine() {

    }

    public Maschine(String csv) {
        String s[] = csv.split(";");
        boolean b[] = new boolean[4];
        boolean f = true;
        if((int)Double.parseDouble(s[0]) < 0) {
            f = false;
            b[0] = setManr(((int)Double.parseDouble(s[0]))*-1);
        } else {
            b[0] = setManr((int)Double.parseDouble(s[0]));
        }
        b[1] = setPreis(Double.parseDouble(s[1]));
        b[2] = setMabez(s[2]);
        b[3] = setStao(s[3]);
        for(int i = 0; i < 4; i++) {
            if(!b[i]) {
                f = false;
            }
        }
        if(f && s.length == 4) {
            this.crt = 1;
        } else {
            this.crt = 2;
        }
    }

    void ausMasch() {
        System.out.println("Maschinennr.: " + this.getManr() + "\n"
                        + "Preis: " + this.getPreis() + "\n"
                        + "Maschinenbezeichnung: " + this.getMabez() + "\n"
                        + "Standort der Maschine: " + this.getStao() + "\n"
                        + "Kontrollwert: " + this.crt + "\n");
    }

    String ausMaschCSV() {

        return this.getManr() + ";" + this.getPreis() + ";" + this.getMabez() + ";" + this.getStao();
    }

    double abschreibung(int laufz) {

        return this.getPreis()/laufz;
    }

    public int getManr() {
        return manr;
    }

    public boolean setManr(int manr) {
        if (manr >= 1) {
            this.manr = manr;
            return true;
        } else {
            return false;
        }
    }

    public double getPreis() {
        return preis;
    }

    public boolean setPreis(double preis) {
        if(preis > 1) {
            this.preis = preis;
            return true;
        } else {
            return false;
        }
    }

    public String getMabez() {
        return mabez;
    }

    public boolean setMabez(String mabez) {
        if(mabez.charAt(0) >= 65 && mabez.charAt(0) <= 90) {
            this.mabez = mabez;
            return true;
        } else {
            return false;
        }
    }

    public String getStao() {
        return stao;
    }

    public boolean setStao(String stao) {
        if(stao.charAt(0) >= 65 && stao.charAt(0) <= 90) {
            this.stao = stao;
            return true;
        } else {
            return false;
        }
    }

    public int getCrt() {
        return crt;
    }
}