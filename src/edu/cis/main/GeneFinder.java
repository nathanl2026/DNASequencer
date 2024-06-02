package edu.cis.main;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

import static edu.cis.main.DNAStrand.getString;

public class GeneFinder
{
    public static String restOfORF(String DNA) {
        String ORFStrand = "";
        int startIndex = DNA.indexOf("atg");
        if (startIndex == -1) {
            return "";
        }
        int endIndex = startIndex + 3;
        while (endIndex+3 <= DNA.length()) {
            String codon = DNA.substring(startIndex, endIndex);
            if (codon.equals("taa") || codon.equals("tag") || codon.equals("tga")){
                break;
            }
            else {
                ORFStrand+=(codon);
                startIndex += 3;
                endIndex +=3;
            }
        }
        return ORFStrand;
    }
    public static ArrayList<String> oneFrame(String DNA) {
        int startIndex = 0;
        int endIndex = startIndex+3;
        String intoORF = "";
        ArrayList<String> myArrayList = new ArrayList<>();
        while (endIndex+3 <= DNA.length()) {
            String nucleotide = DNA.substring(startIndex, endIndex);
            if (nucleotide.equals("atg")) {
                intoORF = DNA. substring(startIndex);
                myArrayList.add(restOfORF(intoORF));
            }
            else {
                startIndex+=3;
                endIndex+=3;
            }
        }
        return myArrayList;
    }
    public static String longestORF(String DNA){
        List<String> frames = oneFrame(DNA);
        String longestORF = "";

        for (int i = 0; i < frames.size(); i++) {
            if (frames.get(i).length() > longestORF.length()) {
                longestORF = frames.get(i);
            }
            i++;
        }
        return longestORF;
    }
    public static String reverseCompliment(String DNA) {
        StringBuilder reversed = new StringBuilder(DNA);
        reversed.reverse();
        return reversed.toString();
    }
    public static String longestORFBothStrands(String DNA) {
        String longestORFPossible;
        String longestORFreversed = longestORF(reverseCompliment(DNA));
        String longestORFnormal = longestORF(getString(DNA));
        if (longestORFreversed.length() > longestORFnormal.length()) {
            longestORFPossible = longestORFreversed;
        }
        else {
            longestORFPossible = longestORFnormal;
        }
        return longestORFPossible;
    }
    public static int longestORFNonCoding(String DNA, int numReps) {
        int longestORFLength = 0;
        for (int i = 0; i < numReps; i++) {
            String shuffled;
            char[] charArray = DNA.toCharArray();
            ArrayList<Character> myArrayList = new ArrayList<>();
            for (char character:charArray) {
                myArrayList.add(character);
            }
            Collections.shuffle(myArrayList);
            shuffled = collapse(myArrayList);

            String longestORF = longestORFBothStrands(shuffled);
            int currentORFLength = longestORF.length();
            if (currentORFLength > longestORFLength) {
                longestORFLength = currentORFLength;
            }
        }
        return longestORFLength;
    }
    public static String collapse(ArrayList<Character> charList) {
        String backTogether = ""; // This is our initial output string
        for (Character ch : charList) { // for each char in the list...
            backTogether += ch; // ... construct a new output string
        }
        return backTogether; // and return the final output string
    }
    public ArrayList<String> findORFs(String DNA) {
        ArrayList<String> allORFs = new ArrayList<>();

        ArrayList<String> checkNormal = oneFrame(DNA); //normal given dna parameter to check using oneFrame and return the one frame sequence
        ArrayList<String> checkReverse = oneFrame(reverseCompliment(DNA));
        ArrayList<String> checkReverseCompliment = new ArrayList<>();
        checkReverseCompliment.add(getString(reverseCompliment(DNA)));

        allORFs.addAll(checkNormal);
        allORFs.addAll(checkReverse);
        allORFs.addAll(checkReverseCompliment);
        return allORFs;
        //use given dna parameter, make the compliment of it, reverse it, plug into oneframe and return the one frame sequence
        //add all these three arraylists into allORFS (check to make sure oneFrame returns an arraylist or string, change variable accordingly)
            //if oneframe returns arraylist, maybe turn into string and add into allORFs
        // return allORFs ArrayList<String>
    }
    public ArrayList<String> findORFBothStrands(String DNA) {
        ArrayList<String> bothStrands = new ArrayList<>();
        //searches both the forward and reverse complement strands for ORFs and returns a list with all the ORFs found.
        //ex) >>> findORFsBothStrands('ATGAAACAT') DNA parameter
        //['ATGAAACAT', 'ATGTTTCAT'] return value
        bothStrands.add(reverseCompliment(getString(DNA)));
        ArrayList<String> myArrayList =  oneFrame(DNA);
        String normalString = "";
        normalString = myArrayList.toString();
        bothStrands.add(normalString);
        return bothStrands;
    }
    public Coordinate getCoordinates(String gene, String DNA)
    {
        String geneToUse = gene;
        int start = DNA.indexOf(geneToUse);

        if (start == -1)
        {
            geneToUse = reverseCompliment(gene);
            start = DNA.indexOf(geneToUse);
        }

        int end = start + gene.length();
        return new Coordinate(start, end);
    }
//    public void geneFinder(String DNA, int minlen) {
//        List<List<Object>> finalOutputList = new ArrayList<>(); //make a list to hold the lists of finalProtein (list in a list)
//        //at end of code change return finalProtein; to finalOutputList.add(finalProtein) and return the finalOutputList instead
//        List<Object> finalProtein = new ArrayList<>();
//        String longerORF = "";
//        ArrayList<String> bothStrands = findORFBothStrands(DNA);
//        if (bothStrands.get(0).length() > bothStrands.get(1).length()){
//            longerORF = bothStrands.get(0);
//        }
//        else {
//            longerORF = bothStrands.get(1);
//        }
//        ArrayList<String> myArrayList = oneFrame(DNA);
//        String gene = myArrayList.toString();
//        Coordinate coordinates = getCoordinates(gene, longerORF);
//        int start = coordinates.getStart();
//        int end = coordinates.getEnd();
//        ArrayList<String> orfProtein = new ArrayList<>();
//        orfProtein.add(longerORF);
//        ArrayList<String> ORF = Ribosome.createProtein(orfProtein);
//        String proteinSequence = ORF.toString();
//        finalProtein.add(start);
//        finalProtein.add(end);
//        finalProtein.add(proteinSequence);
//        finalOutputList.add(finalProtein);
//        System.out.println(finalOutputList);
////        return finalOutputList;
//    }
    public void geneFinder(String DNA, int minLen) {
        List<List<Object>> finalOutputList = new ArrayList<>();

        ArrayList<String> orfs = findORFBothStrands(DNA);

        for (String orf : orfs) {
            if (orf.length() > minLen) {
                List<Object> finalProtein = new ArrayList<>();
                Coordinate coordinates = getCoordinates(orf, DNA);
                int start = coordinates.getStart();
                int end = coordinates.getEnd();

                ArrayList<String> orfProtein = new ArrayList<>();
                orfProtein.add(orf);
                ArrayList<String> protein = Ribosome.createProtein(orfProtein);
                String proteinSequence = protein.toString();

                finalProtein.add(start);
                finalProtein.add(end);
                finalProtein.add(proteinSequence);

                finalOutputList.add(finalProtein);
            }
        }
        System.out.println(finalOutputList);
//        return finalOutputList;
    }
}