package com.linkshortener.util;

import com.linkshortener.model.Payload;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

import static com.linkshortener.util.Constants.*;


@Service
public class CreateSignature {

    public static String createSign(Payload payload){

        Map<String, String> sortedSignMap = new TreeMap<>();
        sortedSignMap.put(URL, payload.getUrl());
        sortedSignMap.put(EXP_DATE, payload.getExpDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        sortedSignMap.put(NAME, payload.getName());


        StringBuilder sighString = new StringBuilder();
        for (Map.Entry<String, String> entry : sortedSignMap.entrySet()) {
            sighString
                    .append(entry.getKey())
                    .append("=")
                    .append(entry.getValue())
                    .append("&");
        }
        sighString.append(PASSWORD + "=").append(payload.getPassword());
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
