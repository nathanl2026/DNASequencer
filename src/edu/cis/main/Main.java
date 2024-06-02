//package edu.cis.main;
//
//import java.util.ArrayList;
//
//public class Main {
//    public static void main(String[] args) {
//        DNAStrand dnaStrand = new DNAStrand();
//        dnaStrand.readDNA("X73525.fna");
//        dnaStrand.createCompliment();
//        ArrayList<String> dnaSequence = dnaStrand.getDnaSequence();
//
//        Mrna mrna = new Mrna();
//        mrna.createCopy(dnaSequence);
//        ArrayList<String> messengerDna = mrna.getMessengerDna();
//
//        ArrayList<String> aminoAcids = Ribosome.createProtein(messengerDna);
//
//        for (String aminoAcid : aminoAcids) {
//            System.out.println(aminoAcid);
//        }
//
//        // Call the geneFinder method
//        GeneFinder geneFinder = new GeneFinder();
//        geneFinder.geneFinder(DNAStrand.getString(String.valueOf(dnaSequence)), 3);
//    }
//}

package edu.cis.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
         * PART 1a and 1b
         */
        // UNCOMMENT THE FOLLOWING CODE WHEN YOU'RE READY TO TEST
        DNAStrand myDna = new DNAStrand();
        Mrna myMRNA = new Mrna();
        Ribosome myRib = new Ribosome();
        myDna.readDNA("dnaSequence");

        myMRNA.createCopy(myDna.getDnaSequence());
        ArrayList<String> protein = myRib.createProtein(myMRNA.getMessengerDna());
        for (String section : protein) {
            System.out.println(section);
        }

        /*
         * PART 2
         */

        // READ the file and turn it into one long DNA string
        GeneFinder myFinder = new GeneFinder();
        try {
            String X73525 = "";
            Scanner sc = new Scanner(new File("X73525.fna"));
            while (sc.hasNext()) {
                X73525 += sc.next();
            }
            int minLen = myFinder.longestORFNonCoding(X73525, 1500);
            ArrayList<ArrayList<Object>> geneList = myFinder.geneFinder(X73525, minLen);
            printGenes(geneList);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public static void printGenes(ArrayList<ArrayList<Object>> geneList) {
        for (List<Object> gene : geneList) {
            int start = (int) gene.get(0);
            int end = (int) gene.get(1);
            String proteinSequence = (String) gene.get(2);

            System.out.println("Start: " + start);
            System.out.println("End: " + end);
            System.out.println("Protein Sequence: " + proteinSequence);
            System.out.println();
        }
    }
}