package edu.cis.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DNAStrand {
    ArrayList<String> dnaSequenceList;
    ArrayList<String> complimentList;

    public DNAStrand(){ //this method reads the dna strand. it takes the String filename, which helps locate the file
        //name. it is in string because the path of the Main is a string, and it locates that string, and then reads the
        //items inside that file after locating it. It reads each line of the file, and adds it to the DnaSequenceList list.
        dnaSequenceList = new ArrayList<>();
        complimentList = new ArrayList<>();
    }

    public void readDNA(String filename) {
        try {
            File fileToRead = new File(filename);
            Scanner myScanner = new Scanner(fileToRead);
            while(myScanner.hasNextLine()) {
                String line = myScanner.nextLine();
                dnaSequenceList.add(line);
            }

        }
        catch (Exception error) {
            System.out.println(error); //error.printStackTrace();
        }
    }

    public void createCompliment() {
        for (int i = 0; i < dnaSequenceList.size(); i++) {
            String dnaNucleotide = dnaSequenceList.get(i);
            String nucleotideCompliment = getString(dnaNucleotide);
            complimentList.add(nucleotideCompliment.toString());
        }
        //loop through dnaSequenceList
        //for each thing in dnaSequenceList
        //create the string that is compliment
            // if string is "atc", compliment should be "tag"
        //add the new compliment string into complimentList

    }

    public static String getString(String dnaNucleotide) {
        String nucleotideCompliment = "";
        for (int j = 0; j < dnaNucleotide.length(); j++) {
            if (dnaNucleotide.charAt(j) == 'a') {
                nucleotideCompliment += 't';}
            else if (dnaNucleotide.charAt(j) == 't') {
                nucleotideCompliment += 'a';}
            else if (dnaNucleotide.charAt(j) == 'c') {
                nucleotideCompliment += 'g';}
            else if (dnaNucleotide.charAt(j) == 'g') {
                nucleotideCompliment += 'c';}
        }
        return nucleotideCompliment;
    }

    public ArrayList<String> getCompliment(){
        // System.out.println(complimentList);
        return complimentList; //return compliment list
    }

    public ArrayList<String> getDnaSequence() {
        // System.out.println(dnaSequenceList);
        return dnaSequenceList; //return dnaSequenceList
    }
}


