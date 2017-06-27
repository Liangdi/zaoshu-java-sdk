package me.liangdi.zaoshu.api;

import lombok.Data;

/**
 * Created by liangdi on 6/27/17.
 */
@Data
public class KeyPair {
    private String apiKey;
    private String secret;

    public KeyPair(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
    }
}
