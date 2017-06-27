package me.liangdi.zaoshu;

/**
 * Created by liangdi on 6/27/17.
 */
public class Constant {
    public static final String CONTENT_TYPE = "application/json; charset=utf-8";
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PATCH = "PATCH";

    public static final String API_URL = "https://openapi.zaoshu.io/v2";
    public static final String AUTH_PRE = "ZAOSHU ";
    public static final String AUTH_HEADER = "Authorization";
    public static final String EVENT_HEADER = "x-zaoshu-event";
    public static final String RATE_LIMIT_HEADER = "X-RateLimit-Limit";
    public static final String RATE_LIMIT_REMAINING_HEADER = "X-RateLimit-Remaining";
    public static final String RATE_LIMIT_RESET_HEADER = "X-RateLimit-Reset";

}
