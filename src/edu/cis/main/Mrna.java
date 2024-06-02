package edu.cis.main;

import java.util.ArrayList;

public class Mrna {
    ArrayList<String> messengerDNA;

    public Mrna() {
        messengerDNA = new ArrayList<>();
    }
    public void createCopy(ArrayList<String> dnaList) {
        ArrayList<String> copyList = new ArrayList<>();

        for (int i = 0; i < dnaList.size(); i++) {
            String dnaNucleotide = dnaList.get(i);
            StringBuilder nucleotideMrna = new StringBuilder();
            for (int j = 0; j < dnaNucleotide.length(); j++) {
                if (dnaNucleotide.charAt(j) == 'a') {
                    nucleotideMrna.append('u');
                }
            }
            copyList.add(nucleotideMrna.toString());
        }
        messengerDNA = copyList;
        //loop through each string in dnaList
        //for each string, we are going to create a copy of it
            //string ccc, we will create a copy that is now ccc
            //cac --> cuc
            // add the copy to copyList
    }

    public ArrayList<String> getMessengerDna() {
        return messengerDNA;
    }
}
