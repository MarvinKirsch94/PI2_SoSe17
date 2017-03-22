package com.marvinkirsch94.core;

/**
 * Created by Marvin Kirsch on 21.03.2017.
 * Matrikelnr.: 11118687
 */
public class MaschAnw {

    public static void main(String args[]) {
        //s1
        Maschine m = new Maschine();
        m.ausMasch();
        //s2
        for(String csv : maschGeber()) {
            Maschine mt = new Maschine(csv);
        }
        //s3
        //s4
    }

    static String[] maschGeber() {

        final String csv_zeichenketten[] = new String[]{"02;100.00;Kaffeemaschine;Kueche",
                                                        "03;55.40;Maschine2;umDieEcke",
                                                        "04;33.25;Maschine3;hier",
                                                        "05;6455.33;Maschine4;da",
                                                        "06;64.56;Maschine5;dort",
                                                        "-2457;50;Mschinekaputt6;nichthier;dort",
                                                        "7755;-40;Maschinekaputt7;nirgendwo"};
        return csv_zeichenketten;
    }
}