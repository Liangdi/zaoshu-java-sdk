package me.liangdi.zaoshu.model;

import lombok.Data;

/**
 * Created by liangdi on 6/27/17.
 */
@Data
public class Event {
    public static final String EVENT_DEFAULT = "default";
    private String event = EVENT_DEFAULT;
}
