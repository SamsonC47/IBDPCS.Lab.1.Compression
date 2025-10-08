package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RLE {

    public static void main(String[] args) throws FileNotFoundException {
        String decompressedString = textToString("src/main/resources/COVID-19");
        String compressedString = compress(decompressedString);
        System.out.println(compressedString);
    }

    /** This method converts the information stored in a text file into a String. */
    public static String textToString(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            String subSeq = sc.next();
            for (int i = 0; i < subSeq.length(); i++) {
                sb.append(subSeq.charAt(i));
            }
        }
        return sb.toString();
    }

        /** TODO 1: Given a String (a genome sequence of COVID-19) implement the RLE algorithm that will use RLE to compress a String. Returns the compressed String. */
        public static String compress(String uncompressed) {
            if (uncompressed == null || uncompressed.isEmpty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < uncompressed.length()) {
                char c = uncompressed.charAt(i);
                int count = 0;
                while (i < uncompressed.length() && uncompressed.charAt(i) == c) {
                    count++;
                    i++;
                }
                sb.append(c);
                sb.append(count);
            }
            return sb.toString();
        }

        /** TODO 2: Given a String (a genome sequence of COVID-19) implement the RLE algorithm that will use RLE to decompress a String. Returns the uncompressed String. */
        public static String decompress(String compressed) {
            if (compressed == null || compressed.isEmpty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < compressed.length()) {
                if (!Character.isLetter(compressed.charAt(i))) {
                    i++;
                    continue;
                }
                char c = compressed.charAt(i);
                i++;
                int num = 0;
                while (i < compressed.length() && Character.isDigit(compressed.charAt(i))) {
                    num = num * 10 + (compressed.charAt(i) - '0');
                    i++;
                }
                for (int j = 0; j < (num == 0 ? 1 : num); j++) {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }

