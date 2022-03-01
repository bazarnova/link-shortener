package com.linkshortener.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

import static com.linkshortener.util.TestConstants.*;

public class CreateSignatureInTest {


    public static String createSign(Map<String, String> payload){

        Map<String, String> sortedSignMap = new TreeMap<>();
        sortedSignMap.put(URL, payload.get(URL));
        sortedSignMap.put(EXP_DATE, payload.get(EXP_DATE));
        sortedSignMap.put(NAME, payload.get(NAME));


        StringBuilder sighString = new StringBuilder();
        for (Map.Entry<String, String> entry : sortedSignMap.entrySet()) {
            sighString
                    .append(entry.getKey())
                    .append("=")
                    .append(entry.getValue())
                    .append("&");
        }
        sighString.append(PASSWORD + "=").append(payload.get(PASSWORD));
        String signature = sighString.toString();

        String sha = getSha1(signature);
        return sha;
    }


    public static String getSha1(String sighString) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(sighString.getBytes());
            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for(byte b : bytes){
                sb.append(String.format("%02X ", b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }
}
