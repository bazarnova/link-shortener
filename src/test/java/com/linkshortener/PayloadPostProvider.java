package com.linkshortener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linkshortener.util.CreateSignatureInTest;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

import static com.linkshortener.util.TestConstants.*;
import static java.util.Map.entry;

public class PayloadPostProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        List<Arguments> payloads = new ArrayList<>();
        ObjectMapper om = new ObjectMapper();

        for (Map<String, String> map : testPayloads()) {
            String sign = CreateSignatureInTest.createSign(map);
            Map<String, String> m = new HashMap<>(map);
            m.put(SIGNATURE, sign);
            payloads.add(Arguments.of(om.writeValueAsString(m)));
        }

        return payloads.stream();
    }


    private List<Map<String, String>> testPayloads() {
        return Arrays.asList(
                Map.ofEntries(
                        entry(URL, "https://www.google.com/"),
                        entry(EXP_DATE, LocalDateTime.of(2022, 2, 5, 18, 12).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))),
                        entry(NAME, "Aa1"),
                        entry(PASSWORD, "aaa111")
                ),
                Map.ofEntries(
                        entry(URL, "https://www.ya.ru/"),
                        entry(EXP_DATE, LocalDateTime.of(2022, 2, 5, 18, 12).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))),
                        entry(NAME, "Bb2"),
                        entry(PASSWORD, "bbb222")
                ),
                Map.ofEntries(
                        entry(URL, "https://www.google.com/"),
                        entry(EXP_DATE, LocalDateTime.of(2022, 2, 5, 18, 12).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))),
                        entry(NAME, "Aa1"),
                        entry(PASSWORD, "aaa111")
                ),
                Map.ofEntries(
                        entry(URL, "https://www.ya.ru/"),
                        entry(EXP_DATE, LocalDateTime.of(2022, 2, 5, 18, 12).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))),
                        entry(NAME, "Cc3"),
                        entry(PASSWORD, "ccc333")
                )
        );
    }
}