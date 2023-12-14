package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class HashTable {
    private LinkedList<String>[] table;

    public HashTable(int size) {
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public int moduloHash(String key) {
        int hash = 0;
        int prime = 31;

        if (isNumber(key)) {
            int number = Integer.parseInt(key);
            hash = Math.abs(number % table.length);
        } else {
            for (char c : key.toCharArray()) {
                hash = (hash * prime + c) % table.length;
            }
        }

        return hash;
    }

    public int multiplicacaoHash(String key) {
        int hash = 0;
        double A = 0.6180339887;

        if (isNumber(key)) {
            int number = Integer.parseInt(key);
            double fractionalPart = number * A - Math.floor(number * A);
            hash = (int) (table.length * fractionalPart);
        } else {
            for (char c : key.toCharArray()) {
                hash = (int) (table.length * (hash * A + c * A) % 1);
            }
        }

        return hash;
    }

    public boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int hashFunction(String key, int hashFunction) {
        if (hashFunction == 1) {
            return moduloHash(key);
        } else if (hashFunction == 2) {
            return multiplicacaoHash(key);
        }
        return 0;
    }

    public void insert(String key, int hashFunction) {
        int index = hashFunction(key, hashFunction);
        table[index].add(key);
    }

    public void printHistogram() {
        int[] histogram = new int[table.length];

        for (int i = 0; i < table.length; i++) {
            histogram[i] = table[i].size();
        }

        int maxCount = 0;
        for (int count : histogram) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        for (int i = 0; i < table.length; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < histogram[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(100);

        String[] keys = {
            "naruto", "sasuke", "sakura", "kakashi", "ichigo", "rukia", "orihime", "renji", "monkey", "roronoa",
            "nami", "sanji", "goku", "vegeta", "gohan", "piccolo", "seiya", "shiryu", "hyoga", "shun", "tanjiro",
            "nezuko", "zenitsu", "inosuke", "saitama", "genos", "mumen", "boros", "edward", "alphonse", "winry",
            "roy", "eren", "mikasa", "armin", "levi", "natsu", "lucy", "gray", "erza", "gon", "killua", "kurapika",
            "leorio", "lelouch", "suzaku", "c.c.", "kallen", "guts", "griffith", "casca", "judeau", "simon", "kamina",
            "yoko", "nia", "luffy", "zoro", "chopper", "robin", "franky", "usopp", "kaneki", "touka", "hide", "amon",
            "emma", "norman", "ray", "isabella", "mob", "reigen", "ritsu", "teruki", "izuku", "bakugo", "todoroki",
            "allmight", "saito", "louise", "kirito", "asuna", "sinon", "leafa", "eugeo", "kiritsugu", "saber", "waver",
            "rin", "accelerator", "misaka", "touma", "index", "kenpachi", "byakuya", "toshiro", "rangiku", "328", "715",
            "42", "890", "167", "512", "789", "94", "631", "248", "573", "390", "721", "187", "926", "542", "309",
            "674", "815", "139", "458", "573", "829", "214", "687", "943", "526", "178", "609", "352", "491", "724",
            "267", "680", "915", "75", "418", "856", "103", "590", "281", "936", "654", "427", "788", "135", "869",
            "512", "246", "713", "387", "940", "569", "320", "751", "194", "837", "458", "107", "832", "375", "619",
            "284", "953", "621", "479", "186", "543", "796", "235", "981", "564", "427", "158", "739", "502", "865",
            "297", "651", "434", "789", "325", "892", "568", "210", "763", "482", "147", "904", "639", "315", "598",
            "261", "874", "519", "376", "729", "173", "718", "432", "875", "198", "541", "287", "956", "614", "369",
            "826", "135", "682", "958", "507", "244", "903", "569", "212", "758", "491", "146", "819", "632", "394",
            "747", "508", "261", "697", "893", "430", "975", "611", "376", "729", "183", "716", "439", "882", "207",
            "552", "298", "951", "609", "364", "abcd1234", "xyZ7890", "user4567", "alphaBeta1", "987name", "qwerty321",
            "coolUser42", "codeMaster123", "rainbow99", "ninja123X", "moonlight22", "stellar123", "cryptoNinja",
            "silverSurfer", "alphaOmega88", "phantomX1", "galacticCoder", "nebula567", "firestorm99", "cyberPioneer",
            "quantumLion", "infinityBlaze", "codeVortex42", "cosmicSpark", "zenMaster789", "technoWizard1", "novaEagle",
            "cipherGeek", "xenonPulse", "stellarDancer", "omegaPhoenix", "lunarPanda123", "astralScribe", "stellarFlare",
            "quantumLynx", "infinityKnight", "zenithBlizzard", "cipherFalcon", "alphaSpectre", "solarWarden",
            "quantumSphinx", "nebulaCatalyst", "novaRevenant", "cryptoOracle", "zephyrNebula", "quantumCatalyst",
            "cyberPulse", "stellarBlossom", "infinityNomad", "crypticVoyager", "zenithCipher", "lunarRebel",
            "stellarShifter", "cosmicPioneer", "omegaCipher", "quantumNebula", "lunarLynx", "zephyrScribe", "nebulaMystic",
            "marcos", "canejo"
        };

        for (String key : keys) {
            hashTable.insert(key, 1); // Escolha a função de dispersão apropriada (1 para moduloHash, 2 para multiplicacaoHash, etc.)
        }

        System.out.println("Histograma (moduloHash):");
        hashTable.printHistogram();
    }
}
