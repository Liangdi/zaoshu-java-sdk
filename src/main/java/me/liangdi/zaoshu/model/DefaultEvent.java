package me.liangdi.zaoshu.model;

import lombok.Data;

/**
 * Created by liangdi on 6/27/17.
 */
@Data
public class DefaultEvent extends Event{

    EventData data;

    @Data
    public static class EventData {
        /**
         * 任务ID
         */
        private String taskId;
        /**
         * 实例标题
         */
        private String title;
        /**
         * 实例 ID
         */
        private String appInstanceId;
        /**
         * 任务创建时间?
         */
        private long createdAt;
    }
}
