package me.liangdi.zaoshu.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 运行任务配置
 * Created by liangdi on 6/27/17.
 */
@Data
public class RunConfig {
    private List<String> urls = new ArrayList<>();
    private String method;
    Map<String,String> headers = new HashMap<>();
}
