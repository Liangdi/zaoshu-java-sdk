package me.liangdi.zaoshu.util;

import lombok.extern.slf4j.Slf4j;
import me.liangdi.zaoshu.Constant;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 授权相关工具包
 * 签名文档:
 *      https://github.com/zaoshu/openapi/blob/master/v2/zh-CN/authentication.md
 * Created by liangdi on 6/27/17.
 */
@Slf4j
public class Authorize {
    final static  SimpleDateFormat sdf =
            new SimpleDateFormat("EEE, MMM d, yyyy hh:mm:ss a z");

    static {
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    /**
     * 获得 GMT 格式时间 format
     * @param date
     * @return
     */
    public static String getDate(Date date){
        return sdf.format(date);
    }

    /**
     * 构建请求签名
     * @param secret
     * @param method
     * @param date
     * @param query
     * @param body
     * @return
     */
    public static String signJsonRequest(String secret,String method,String date,Map<String,String> query,String body){
        final StringBuilder sortedQuery = new StringBuilder();
        TreeMap<String,String> tree= new TreeMap<>(query);
        tree.forEach((k,v) -> {
            sortedQuery.append(k)
                    .append("=")
                    .append(v)
                    .append('\n');
        });
        return sign(secret,method, Constant.CONTENT_TYPE,date,sortedQuery.toString(),body);
    }

    /**
     *
     * @param secret
     * @param method
     * @param contentType
     * @param date
     * @param sortedQuery
     * @param body
     * @return
     */
    public static String sign(String secret,String method,String contentType,String date,String sortedQuery,String body){
        StringBuilder strToSign = new StringBuilder();

        /**
         * 构建 签名字符串
         */
        strToSign.append(method)
                .append('\n')
                .append(contentType)
                .append('\n')
                .append(date)
                .append('\n')
                .append(StringUtils.isEmpty(sortedQuery)?"":sortedQuery)
                .append(StringUtils.isEmpty(body)?'\n':body);


        log.info("strToSign:\n{}",strToSign.toString());
        // sha256 签名
        byte[] hmacSha256 = HmacUtils.hmacSha256(secret, strToSign.toString());

        // base64 编码
        return Base64.getEncoder().encodeToString(hmacSha256);
    }

}
