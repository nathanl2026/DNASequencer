package edu.cis.main;

import java.util.ArrayList;

public class Mrna {
    ArrayList messengerDNA;

    public Mrna() {
        messengerDNA = new ArrayList();
    }
    public void createCopy(ArrayList dnaList) {
        ArrayList<String> copyList = new ArrayList<>();


        //loop through each string in dnaList
        //for each string, we are going to create a copy of it
            //string ccc, we will create a copy that is now ccc
            //cac --> cuc
            // add the copy to copyList

        messengerDNA = copyList;
    }

    public ArrayList getMessengerDNA() {
        return messengerDNA;
    }
}
