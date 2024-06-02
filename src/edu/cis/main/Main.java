package edu.cis.main;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DNAStrand dnaStrand = new DNAStrand();
        dnaStrand.readDNA("X73525.fna");
        dnaStrand.createCompliment();
        ArrayList<String> dnaSequence = dnaStrand.getDnaSequence();

        Mrna mrna = new Mrna();
        mrna.createCopy(dnaSequence);
        ArrayList<String> messengerDna = mrna.getMessengerDna();

        ArrayList<String> aminoAcids = Ribosome.createProtein(messengerDna);

        for (String aminoAcid : aminoAcids) {
            System.out.println(aminoAcid);
        }

        // Call the geneFinder method
        GeneFinder geneFinder = new GeneFinder();
        geneFinder.geneFinder(DNAStrand.getString(String.valueOf(dnaSequence)), 3);
    }
}