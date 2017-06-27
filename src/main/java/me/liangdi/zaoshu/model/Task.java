package me.liangdi.zaoshu.model;

import lombok.Data;

/**
 * Created by liangdi on 6/27/17.
 */
@Data
public class Task extends ApiResult{
    public static final String STATUS_DONE = "done";
    public static final String STATUS_ERROR = "error";

    TaskData data;

    @Data
    public static class TaskData{
        private String id;
        private String status;
        /**
         * 创建时间
         */
        private long createdAt;
        /**
         * 任务采集的 URL 总数
         */
        private int totalUrlCount;
        /**
         * 失败的 URL 数量
         */
        private int failedUrlCount;
    }
}
