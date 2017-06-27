package me.liangdi.zaoshu.model;

import lombok.Data;

/**
 * Created by liangdi on 6/27/17.
 */
@Data
public class Instance extends ApiResult{
    // 闲置状态
    public static final String STATUS_IDLE = "idle";
    // 错误
    public static final String STATUS_ERROR = "error";
    // 运行中
    public static final String STATUS_RUNNING = "running";
    // all 供查询
    public static final String STATUS_ALL = "all";

    InstanceData data;

    @Data
    public static class InstanceData{
        private String id;
        private String title;
        private String status;
        /**
         * 创建时间
         */
        private long createdAt;
        /**
         * 总共运行次数
         */
        private int totalExecution;
        /**
         * 总共采集记录数量
         */
        private int totalFetchingRows;
    }
}
