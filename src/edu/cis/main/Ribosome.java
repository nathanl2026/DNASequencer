package edu.cis.main;

import java.util.ArrayList;

public class Ribosome {

    public static ArrayList<String> createProtein(ArrayList<String> copiedDNA) {
        ArrayList<String> aminoAcids = new ArrayList<>();

        for (int i = 0; i < copiedDNA.size(); i++) {
            String codon = copiedDNA.get(i).toLowerCase();

            if (codon.equals("uuu") || codon.equals("uuc")) {
                aminoAcids.add("Phenylalanine");
            } else if (codon.equals("uua") || codon.equals("uug") || codon.equals("cuu") || codon.equals("cuc") ||
                    codon.equals("cua") || codon.equals("cug")) {
                aminoAcids.add("Leucine");
            } else if (codon.equals("auu") || codon.equals("auc") || codon.equals("aua")) {
                aminoAcids.add("Isoleucine");
            } else if (codon.equals("aug")) {
                aminoAcids.add("Methionine");
            } else if (codon.equals("guu") || codon.equals("guc") || codon.equals("gua") || codon.equals("gug")) {
                aminoAcids.add("Valine");
            } else if (codon.equals("ucu") || codon.equals("ucc") || codon.equals("uca") || codon.equals("ucg") ||
                    codon.equals("agu") || codon.equals("agc")) {
                aminoAcids.add("Serine");
            } else if (codon.equals("ccu") || codon.equals("ccc") || codon.equals("cca") || codon.equals("ccg")) {
                aminoAcids.add("Proline");
            } else if (codon.equals("acu") || codon.equals("acc") || codon.equals("aca") || codon.equals("acg")) {
                aminoAcids.add("Threonine");
            } else if (codon.equals("gcu") || codon.equals("gcc") || codon.equals("gca") || codon.equals("gcg")) {
                aminoAcids.add("Alanine");
            } else if (codon.equals("uau") || codon.equals("uac")) {
                aminoAcids.add("Tyrosine");
            } else if (codon.equals("cau") || codon.equals("cac")) {
                aminoAcids.add("Histidine");
            } else if (codon.equals("caa") || codon.equals("cag")) {
                aminoAcids.add("Glutamine");
            } else if (codon.equals("aau") || codon.equals("aac")) {
                aminoAcids.add("Asparagine");
            } else if (codon.equals("aaa") || codon.equals("aag")) {
                aminoAcids.add("Lysine");
            } else if (codon.equals("gau") || codon.equals("gac")) {
                aminoAcids.add("Aspartic acid");
            } else if (codon.equals("gaa") || codon.equals("gag")) {
                aminoAcids.add("Glutamic acid");
            } else if (codon.equals("ugu") || codon.equals("ugc")) {
                aminoAcids.add("Cysteine");
            } else if (codon.equals("ugg")) {
                aminoAcids.add("Tryptophan");
            } else if (codon.equals("cgu") || codon.equals("cgc") || codon.equals("cga") ||
                    codon.equals("cgg") || codon.equals("aga") || codon.equals("agg")) {
                aminoAcids.add("Arginine");
            } else if (codon.equals("ggu") || codon.equals("ggc") || codon.equals("gga") || codon.equals("ggg")) {
                aminoAcids.add("Glycine");
            }
        }
        return aminoAcids;
    }
}