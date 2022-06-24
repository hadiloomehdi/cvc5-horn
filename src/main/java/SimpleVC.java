/******************************************************************************
 * Top contributors (to current version):
 *   Mudathir Mohamed, Morgan Deters, Andres Noetzli
 *
 * This file is part of the cvc5 project.
 *
 * Copyright (c) 2009-2022 by the authors listed in the file AUTHORS
 * in the top-level source directory and their institutional affiliations.
 * All rights reserved.  See the file COPYING in the top-level source
 * directory for licensing information.
 * ****************************************************************************
 *
 * A simple demonstration of the Java interface.
 *
 * To run the resulting class file, you need to do something like the
 * following:
 *   javac  "-cp" "../build/src/api/java/cvc5.jar" SimpleVC.java
 *   java \
 *     "-Djava.library.path=../build/src/api/java" "-cp" "../build/src/api/java/cvc5.jar:." \
 *     SimpleVC
 */

import io.github.cvc5.Kind;
import io.github.cvc5.Solver;
import io.github.cvc5.Sort;
import io.github.cvc5.Term;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.ArrayList;


class Horn {
    private Head head;
    private Body body;
}


class Head{
    private Predicate rel;
}

class Body{
    private ArrayList<Predicate> rels;
    private String fi;
}

class Predicate{
    private String name;
    private ArrayList<String> params;

}



public class SimpleVC {

    public void readFile(){

    }

    public static void main(String[] args) {
        try {
            File myObj = new File("/home/mahdi/Desktop/synthesis/project/cvc5-horn/src/main/java/f.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] a = data.split("=>");
                System.out.println(data);
                System.out.println(a[0].replaceAll("\\s+",""));
                System.out.println(a[1].replaceAll("\\s+",""));
                System.out.println("wwwwwwwwwwwwwwwwwwwwwww");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



      try (Solver slv = new Solver()) {
            // Prove that for integers x and y:
            //   x > 0 AND y > 0  =>  2x + y >= 3

            Sort integer = slv.getIntegerSort();

            Term x = slv.mkConst(integer, "x");
            Term y = slv.mkConst(integer, "y");
            Term zero = slv.mkInteger(0);

            Term x_positive = slv.mkTerm(Kind.GT, x, zero);
            Term y_positive = slv.mkTerm(Kind.GT, y, zero);

            Term two = slv.mkInteger(2);
            Term twox = slv.mkTerm(Kind.MULT, two, x);
            Term twox_plus_y = slv.mkTerm(Kind.ADD, twox, y);

            Term three = slv.mkInteger(3);
            Term twox_plus_y_geq_3 = slv.mkTerm(Kind.GEQ, twox_plus_y, three);

            Term formula = slv.mkTerm(Kind.AND, x_positive, y_positive).impTerm(twox_plus_y_geq_3);

            System.out.println("Checking entailment of formula " + formula + " with cvc5.");
            System.out.println("cvc5 should report UNSAT.");
            System.out.println(
                    "Result from cvc5 is: " + slv.checkSatAssuming(formula.notTerm()));
        }
    }
}
