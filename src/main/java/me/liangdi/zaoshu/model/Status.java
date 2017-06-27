package me.liangdi.zaoshu.model;

import lombok.Data;

/**
 * 用于记录 API 请求状态
 * Created by liangdi on 6/27/17.
 */
@Data
public class Status {
    /**
     * 请求限制数量
     */
    private int rateLimit;
    /**
     * 请求限制剩余数量
     */
    private int rateLimitRemaining;
    /**
     * 请求限制重置剩余时间
     */
    private long rateLimitRest;
}
