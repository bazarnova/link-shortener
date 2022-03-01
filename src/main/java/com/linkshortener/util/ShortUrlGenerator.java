package com.linkshortener.util;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Component;

@Component
public class ShortUrlGenerator {

    private RandomStringGenerator randomStringGenerator;

    public ShortUrlGenerator() {
        this.randomStringGenerator = new RandomStringGenerator
                .Builder().filteredBy(ShortUrlGenerator::isLatinLetterOrDigit)
                .build();
    }

    public String generate(int length) {
        return randomStringGenerator.generate(length);
    }

    private static boolean isLatinLetterOrDigit(int codePoint) {
        return ('a' <= codePoint && codePoint <= 'z')
                || ('0' <= codePoint && codePoint <= '9');
    }
}
