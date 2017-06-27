package me.liangdi.zaoshu.api;

import lombok.extern.slf4j.Slf4j;
import me.liangdi.zaoshu.model.ApiResult;
import me.liangdi.zaoshu.model.Instance;
import me.liangdi.zaoshu.model.InstanceList;
import me.liangdi.zaoshu.model.TaskList;
import org.junit.Assert;
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

    @Test
    public void testRunInstance(){
        String instanceId = "d4351194a41f4526bbada92eff75e743";

        ApiResult apiResult = instanceApi.run(instanceId, null, null);

        log.info("run result:\n{}",gson.toJson(apiResult));
    }

    @Test
    public void testEditInstance(){
        String instanceId = "d4351194a41f4526bbada92eff75e743";
        String title = "modify by api";
        ApiResult apiResult = instanceApi.edit(instanceId, title, null);

        log.info("run result:\n{}",gson.toJson(apiResult));

        Instance instance = instanceApi.get(instanceId);

        log.info("new instance:\n{}",gson.toJson(instance));
        // todo 确定问题
        //Assert.assertEquals(instance.getData().getTitle(),title);
    }
}
