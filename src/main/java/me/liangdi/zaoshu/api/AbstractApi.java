package me.liangdi.zaoshu.api;

import com.google.gson.Gson;

/**
 * Created by liangdi on 6/27/17.
 */
public abstract class AbstractApi implements Api{
    protected KeyPair keyPair;
    protected Gson gson = new Gson();

    @Override
    public void init(KeyPair keyPair) {
        this.keyPair = keyPair;
    }
}
