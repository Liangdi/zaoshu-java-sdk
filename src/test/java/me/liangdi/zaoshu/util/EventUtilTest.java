package me.liangdi.zaoshu.util;

import lombok.extern.slf4j.Slf4j;
import me.liangdi.zaoshu.model.DefaultEvent;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by liangdi on 6/27/17.
 */
@Slf4j
public class EventUtilTest {
    @Test
    public void testParseFromJson(){
        String json = "{\n" +
                "  \"taskId\": \"de9d0c7496c247e2ba27f34cafeb052c\"," +
                "  \"title\": \"抓数据去造数！！！\"," +
                "  \"appInstanceId\" : \"aaaaf632-0d4b-42bc-b71f-669ee0d6f9aa\"," +
                "  \"createdAt\" : 690177600" +
                "}";


        String taskId = "de9d0c7496c247e2ba27f34cafeb052c";
        DefaultEvent event = EventUtil.parse("default", json, DefaultEvent.class);

        log.info("event:{}",event);

        Assert.assertEquals(event.getData().getTaskId(),taskId);

        Assert.assertEquals(event.getEvent(),"default");
    }
}
