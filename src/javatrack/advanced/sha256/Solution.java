package javatrack.advanced.sha256;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static java.lang.String.format;

public class Solution {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        s.close();

        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] bytes = sha.digest(line.getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(format("%02x", b));
        }
        System.out.println(sb.toString());
    }
}