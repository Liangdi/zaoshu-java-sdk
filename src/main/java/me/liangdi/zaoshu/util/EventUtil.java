package me.liangdi.zaoshu.util;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import me.liangdi.zaoshu.Constant;
import me.liangdi.zaoshu.model.Event;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * webhook event 工具类
 * Created by liangdi on 6/27/17.
 */
@Slf4j
public class EventUtil {
    private static Gson gson = new Gson();

    /**
     * 解析 webhook 事件
     * @param event
     * @param body
     * @param clazz
     * @param <T>
     * @return
     */
    public static  <T extends Event> T parse(String event,String body,Class<T>clazz){
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{")
                .append("\"event\":")
                    .append("\"")
                    .append(event)
                    .append("\",")

                .append("\"data\":")
                    .append(body)
                .append("}");

       return gson.fromJson(jsonBuilder.toString(), clazz);
    }

    /**
     * 从 httpServletRequest 中解析 webhook event
     * @param request
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T extends Event> T parse(HttpServletRequest request,Class<T> clazz) {
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            try {
                String  jsonBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
                String event = request.getHeader(Constant.EVENT_HEADER);
                return parse(event,jsonBody,clazz);
            } catch (IOException e) {
                log.error("IOException:{}",e.getMessage());
                return null;
            }
        } else {
            return null;
        }
    }


}
