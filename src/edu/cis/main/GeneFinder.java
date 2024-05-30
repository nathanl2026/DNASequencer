package edu.cis.main;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class GeneFinder
{
    public String restOfORF(String DNA) {
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
    public ArrayList<String> oneFrame(String DNA) {
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
    public String longestORF(String DNA){
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
    public String reverseCompliment(String DNA) {
        StringBuilder reversed = new StringBuilder(DNA);
        reversed.reverse();
        return reversed.toString();
    }
    public String longestORFBothStrands(String DNA) {
        String longestORFPossible;
        String longestORFreversed = longestORF(reverseCompliment(DNA));
        String longestORFnormal = longestORF(DNAStrand.getString(DNA));
        if (longestORFreversed.length() > longestORFnormal.length()) {
            longestORFPossible = longestORFreversed;
        }
        else {
            longestORFPossible = longestORFnormal;
        }
        return longestORFPossible;
    }
    public int longestORFNoncoding(String DNA, int numReps) {
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
    public String collapse(ArrayList<Character> charList) {
        String backTogether = ""; // This is our initial output string
        for (Character ch : charList) { // for each char in the list...
            backTogether += ch; // ... construct a new output string
        }
        return backTogether; // and return the final output string
    }
    public ArrayList<String> findORFs(String DNA) {
        ArrayList<String> allORFs = new ArrayList<>();

        ArrayList<String> checkNormal = oneFrame(DNA); //normal given dna parameter to check using oneFrame and return the one frame sequence
        ArrayList<String> checkReverse = oneFrame(reverseCompliment(DNA)); //use given dna parameter and reverse/compliment (check part 2c video), plug into one frame
        ArrayList<String> checkReverseCompliment = //use given dna parameter, make the compliment of it, reverse it, plug into oneframe and return the one frame sequence
        //add all these three arraylists into allORFS (check to make sure oneFrame returns an arraylist or string, change variable accordingly)
            //if oneframe returns arraylist, maybe turn into string and add into allORFs
        // return allORFs ArrayList<String>
    }
    public ArrayList<String> findORFBothStrands(String DNA) {
        ArrayList<String> bothStrands = new ArrayList<>();
        //searches both the forward and reverse complement strands for ORFs and returns a list with all the ORFs found.
        //ex) >>> findORFsBothStrands('ATGAAACAT') DNA parameter
        //['ATGAAACAT', 'ATGTTTCAT'] return value
    }
}
