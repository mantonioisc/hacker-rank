package javatrack.advanced.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static java.lang.String.format;
import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;
/*
HelloWorld
68e109f0f40ca72a15e05cc22786f8e6

Javarmi123
2da2d1e0ce7b4951a858ed2d547ef485
 */
public class Solution {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        s.close();

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(line.getBytes());
        byte[] bytes = md5.digest();

        String checksum = range(0, bytes.length).mapToObj(i -> format("%02x", bytes[i])).collect(joining());

        System.out.println(checksum);
    }
}