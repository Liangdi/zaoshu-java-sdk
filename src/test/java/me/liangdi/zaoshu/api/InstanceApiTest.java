package me.liangdi.zaoshu.api;

import lombok.extern.slf4j.Slf4j;
import me.liangdi.zaoshu.model.InstanceList;
import me.liangdi.zaoshu.model.TaskList;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by liangdi on 6/27/17.
 */
@Slf4j
public class InstanceApiTest extends ApiBase{

    InstanceApi instanceApi;

    @Before
    public void init(){
        //设置 ApiBase 中的 apiKey 和  secret
        KeyPair keyPair = new KeyPair(apiKey,secret);
        instanceApi = new InstanceApi();
        instanceApi.init(keyPair);
    }


    @Test
    public void testListInstances() {
        InstanceList list = instanceApi.list();

        list.getData().forEach(data -> {
            log.info("instance:\n{}",gson.toJson(data));
        });
    }

    @Test
    public void testListTask(){
        String instanceId = "1ebd240d26a14db4a3acae5e287be5ac";
        TaskList list = instanceApi.taskList(instanceId);
        list.getData().forEach(data -> {
            log.info("task:\n{}",gson.toJson(data));
        });
    }
}
