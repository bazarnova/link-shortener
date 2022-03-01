package com.linkshortener.service;

import com.linkshortener.model.Link;
import com.linkshortener.model.Payload;

public interface LinkCreateService {

    Link createLink(Payload payload);

}
