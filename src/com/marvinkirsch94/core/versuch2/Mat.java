package com.marvinkirsch94.core.versuch2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Marvin Kirsch on 22.05.2017.
 * Matrikelnr.: 11118687
 */
public class Mat {
    //a
    private double a[][];
    private int n;
    private int m = 0;
    private int crt = 1;

    public Mat(BufferedReader br1) throws IOException {
        //init
        ArrayList<String[]> strings = new ArrayList<>();
        //loop
        do {
            String temp = br1.readLine();
            //abbruch
            if (temp == null) {
                break;
            }
            String c[] = temp.split(";");

            //m
            if (this.m != c.length && this.m != 0) {
                this.crt = -1;
            }
            this.m = c.length;

            strings.add(c);
        } while (true);

        //n
        this.n = strings.size();

        //init a[][]
        this.a = new double[this.n][this.m];

        //befuellen von a wenn crt immer noch 1 ist um Fehler zu vermeiden
        if (this.crt == 1) {
            for (int y = 0; y < this.n; y++) {
                for (int x = 0; x < this.m; x++) {
                    try {
                        this.a[y][x] = Double.parseDouble(strings.get(y)[x]);
                    } catch (NumberFormatException e) {
                        System.err.println(e + "\nEs gab ein Porblem bei ihrer Matrix, eine Zahl konnte nicht geparst werden!");
                        this.crt = -1;
                    }
                }
            }
        } else {
            System.err.println("a[][] kann nicht befuellt werden da ein Fehler aufgetreten ist ...");
        }
    }

    //fuer die ergebniss Matrix ??
    private Mat() {
        // todo hole lot of nothing ? do i need this
    }


    //b1
    public boolean matAus(FileWriter fx) {
        try {
            for (int y = 0; y < this.n; y++) {
                String out = "";
                for (int x = 0; x < this.m; x++) {
                    out += (x == m - 1 ? a[y][x] + "" : a[y][x] + ";");
                }
                fx.write(out + "\n");
            }
        } catch (Exception e) {
            System.err.println(e + "\nIch hab ein schlechtes gefuehl bei der Sache ... ");
            return false;
        }
        return true;
    }

    //b2
    public Mat matMul(Mat b) throws IOException {
        Mat re = new Mat();
        re.crt = 1;
        re.m = b.m;
        re.n = this.n;
        re.a = new double[re.n][re.m];
        if (this.m != b.n) {
            //end
            re.crt = -3;
            return re;
        } else {
            //rows of this or this.n
            for(int roT = 0; roT < this.n; roT++) {
                //columns of b or b.m
                for (int coB = 0; coB < b.m; coB++) {
                    //counter for this columns of this or rows of b
                    for (int bz = 0; bz < b.n; bz++) {
                        //adding them products together
                        re.a[roT][coB] += (this.a[roT][bz] * b.a[bz][coB]);
                    }
                }
            }
        }
        return re;
    }
}
