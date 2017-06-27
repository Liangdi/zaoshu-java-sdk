package me.liangdi.zaoshu.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by liangdi on 6/27/17.
 */
public class ApiBase {
    protected String secret = "...";
    protected String apiKey = "...";
    protected Gson gson = new GsonBuilder().setPrettyPrinting().create();

}
