package me.liangdi.zaoshu.util;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.HmacUtils;
import org.junit.Test;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liangdi on 6/27/17.
 */
@Slf4j
public class AuthorizeTest {
    Gson gson = new Gson();

    @Test
    public void testSignJsonRequest(){
        String appKey = "qwertyuiop";
        String secret = "1234567890-=";
        String method = "POST";
        Date now = new Date();

        String gmtDate = Authorize.getDate(now);

        // for test
        gmtDate = "Wed, 18 Mar 2016 08:04:06 GMT";

        log.info("gmtDate:{}",gmtDate);
        Map<String,String> query  = new HashMap<>();
        query.put("a","1");
        query.put("b","2");

        Map<String,String> body = new HashMap<>();

        body.put("v","tt");

        String bodyStr = "{\"v\": \"tt\"}";
        String sign = Authorize.signJsonRequest(secret, method, gmtDate, query, bodyStr);

        log.info("sing:\n{}",sign);
    }
    @Test
    public  void testSign(){
        String str = "POST\napplication/json; charset=utf-8\nWed, 18 Mar 2016 08:04:06 GMT\na=1\nb=2\n{\"v\": \"tt\"}";
        // sha256 签名
        String secret = "1234567890-=";
        byte[] hmacSha256 = HmacUtils.hmacSha256(secret, str);

        // base64 编码
        String sign =  Base64.getEncoder().encodeToString(hmacSha256);
        log.info("strToSign:\n{}",str);
        log.info("sign:\n{}",sign);
    }
}
