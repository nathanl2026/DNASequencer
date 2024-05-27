package edu.cis.main;

import java.util.ArrayList;

public class Ribosome {

    public ArrayList createProtein(ArrayList copiedDNA) {
         ArrayList<String> aminoAcids = new ArrayList<>();
            for (int i = 0; i < copiedDNA.size(); i++) {
                if (copiedDNA.get(i) == "uuu" || copiedDNA.get(i) == "uuc") {
                    aminoAcids.add("Phenylalanine");
                }
                else if (copiedDNA.get(i) == "uua" || copiedDNA.get(i) == "uug" || copiedDNA.get(i) == "cuu" || copiedDNA.get(i) == "cuc"
                        || copiedDNA.get(i) == "cua" || copiedDNA.get(i) == "cug") {
                    aminoAcids.add("Leucine");
                }
                else if (copiedDNA.get(i) == "auu" || copiedDNA.get(i) == "auc" || copiedDNA.get(i) == "aua") {
                    aminoAcids.add("Isoleucine");
                }
                else if (copiedDNA.get(i) == "aug") {
                    aminoAcids.add("Methionine");
                }
                else if (copiedDNA.get(i) == "guu" || copiedDNA.get(i) == "guc" || copiedDNA.get(i) == "gua" || copiedDNA.get(i) == "gug") {
                    aminoAcids.add("Valine");
                }
                else if (copiedDNA.get(i) == "ucu" || copiedDNA.get(i) == "ucc" || copiedDNA.get(i) == "uca" || copiedDNA.get(i) == "ucg" ||
                        copiedDNA.get(i) == "agu" || copiedDNA.get(i) == "agc") {
                    aminoAcids.add("Serine");
                }
                else if (copiedDNA.get(i) == "ccu" || copiedDNA.get(i) == "ccc" || copiedDNA.get(i) == "cca" || copiedDNA.get(i) == "ccg") {
                    aminoAcids.add("Proline");
                }
                else if (copiedDNA.get(i) == "acu" || copiedDNA.get(i) == "acc" || copiedDNA.get(i) == "aca" || copiedDNA.get(i) == "acg") {
                    aminoAcids.add("Threonine");
                }
                else if (copiedDNA.get(i) == "gcu" || copiedDNA.get(i) == "gcc" || copiedDNA.get(i) == "gca" || copiedDNA.get(i) == "gcg") {
                    aminoAcids.add("Alanine");
                }
                else if (copiedDNA.get(i) == "uau" || copiedDNA.get(i) == "uac") {
                    aminoAcids.add("Tyrosine");
                }
                else if (copiedDNA.get(i) == "cau" || copiedDNA.get(i) == "cac") {
                    aminoAcids.add("Histidine");
                }
                else if (copiedDNA.get(i) == "caa" || copiedDNA.get(i) == "cag") {
                    aminoAcids.add("Glutamine");
                }
                else if (copiedDNA.get(i) == "aau" || copiedDNA.get(i) == "aac") {
                    aminoAcids.add("Asparagine");
                }
                else if (copiedDNA.get(i) == "aaa" || copiedDNA.get(i) == "aag") {
                    aminoAcids.add("Lysine");
                }
                else if (copiedDNA.get(i) == "gau" || copiedDNA.get(i) == "gac") {
                    aminoAcids.add("Aspartic acid");
                }
                else if (copiedDNA.get(i) == "gaa" || copiedDNA.get(i) == "gag") {
                    aminoAcids.add("Glutamic acid");
                }
                else if (copiedDNA.get(i) == "ugu" || copiedDNA.get(i) == "ugc") {
                    aminoAcids.add("Cysteine");
                }
                else if (copiedDNA.get(i) == "ugg") {
                    aminoAcids.add("Tryptophan");
                }
                else if (copiedDNA.get(i) == "cgu" || copiedDNA.get(i) == "cgc" || copiedDNA.get(i) == "cga" ||
                        copiedDNA.get(i) == "cgg" || copiedDNA.get(i) == "aga" || copiedDNA.get(i) == "agg") {
                    aminoAcids.add("Arginine");
                }
                else if (copiedDNA.get(i) == "ggu" || copiedDNA.get(i) == "ggc" || copiedDNA.get(i) == "gga" || copiedDNA.get(i) == "ggg") {
                    aminoAcids.add("Glycine");
                }
            }
         //for each codon(String, aka group of 3) in copiedDNA
            // if codon equals "uuu", then add "Phenylalanine" to aminos
            // (add corresponding amino of each codon)
            // if codon equals "uuc", then add "Phenylalaline" to aminos
        return aminoAcids;
    }
}
