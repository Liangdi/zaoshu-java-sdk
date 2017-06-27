package me.liangdi.zaoshu.util;

import lombok.extern.slf4j.Slf4j;
import me.liangdi.zaoshu.Constant;
import me.liangdi.zaoshu.api.KeyPair;
import org.apache.http.Header;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Map;

import static me.liangdi.zaoshu.Constant.AUTH_HEADER;
import static me.liangdi.zaoshu.Constant.AUTH_PRE;

/**
 * 使用 http 协议调用 API 接口的工具包
 * 暂时用 httplicent 实现 后期再优化
 * Created by liangdi on 6/27/17.
 */
@Slf4j
public class HttpUtil {
    /**
     * 无参数 GET 请求
     * @param keyPair
     * @param url
     * @return
     */
    public static String get(KeyPair keyPair,String url){
        return get(keyPair,url,null);
    }
    /**
     * 处理 GET 请求
     * @param url
     * @param query
     * @return
     */
    public static String get(KeyPair keyPair, String url, Map<String,String> query) {
        String result = "";



        Date now = new Date();
        String gmtDate = Authorize.getDate(now);

        String sign = Authorize.signJsonRequest(keyPair.getSecret(), Constant.METHOD_GET, gmtDate, query, "");

        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            if( query != null && !query.isEmpty()) {
                query.forEach(uriBuilder::addParameter);
            }

            Header authorHeader = authorHeader(keyPair.getApiKey(), sign);
            log.info("authorHeader:{}",authorHeader);
            Response resp = Request.Get(uriBuilder.build())
                    .addHeader(new BasicHeader("Content-Type", Constant.CONTENT_TYPE))
                    .addHeader(new BasicHeader("Date", gmtDate))
                    .addHeader(authorHeader)
                    .execute();

            //int code = resp.returnResponse().getStatusLine().getStatusCode();
            // todo 处理 status code 相关业务逻辑


            result = resp
                    .returnContent()
                    .asString(Charset.forName("UTF-8"));
        } catch (IOException | URISyntaxException e) {
            log.error("http exception:{}",e.getMessage());
            e.printStackTrace();
        }


        return result;
    }

    /**
     * 构建 API 认证相关 header
     * @param secret
     * @param sign
     * @return
     */
    private static Header authorHeader(String secret,String sign){
        return  new BasicHeader(AUTH_HEADER,AUTH_PRE + secret + ":" + sign);
    }
}
