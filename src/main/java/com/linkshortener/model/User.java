package com.linkshortener.model;

import java.util.List;

public class User {

    private Long id;
    private String identifier;
    private String secretKey;
    private List<Url> urls;
}
