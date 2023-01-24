package ru.itmo.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class TokenUtils {
    public String getToken() {
        return DigestUtils.sha512Hex(UUID.randomUUID().toString() + ":" + new Date().getTime());
    }
}