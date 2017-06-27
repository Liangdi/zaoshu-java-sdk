package me.liangdi.zaoshu.api;

import lombok.extern.slf4j.Slf4j;
import me.liangdi.zaoshu.Constant;
import me.liangdi.zaoshu.model.Status;
import me.liangdi.zaoshu.util.HttpUtil;

import java.util.Map;

/**
 * 系统相关操作 API
 * Created by liangdi on 6/27/17.
 */
@Slf4j
public class SystemApi extends AbstractApi{
    private String accountUrl = Constant.API_URL +  "/user/account";

    /**
     * 获取 API 限制状态
     * 目前使用 /user/account 接口读取 header 信息
     * @return
     */
    public Status status() {
        Status status = new Status();

        Map<String, String> headers = HttpUtil.headers(keyPair,  accountUrl);
        log.info("headers:{}",headers);

        status.setRateLimit(Integer.parseInt(headers.getOrDefault(Constant.RATE_LIMIT_HEADER,"0")));
        status.setRateLimitRemaining(Integer.parseInt(headers.getOrDefault(Constant.RATE_LIMIT_REMAINING_HEADER,"0")));
        status.setRateLimitRest(Long.parseLong(headers.getOrDefault(Constant.RATE_LIMIT_RESET_HEADER,"0")));

        return status;
    }
}
