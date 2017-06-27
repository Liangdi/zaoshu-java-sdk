package me.liangdi.zaoshu.api;

import lombok.extern.slf4j.Slf4j;
import me.liangdi.zaoshu.model.Status;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by liangdi on 6/27/17.
 */
@Slf4j
public class SystemApiTest extends ApiBase{
    SystemApi systemApi;

    @Before
    public void init(){

        //设置 ApiBase 中的 apiKey 和  secret

        KeyPair keyPair = new KeyPair(apiKey,secret);
        systemApi = new SystemApi();
        systemApi.init(keyPair);
    }

    @Test
    public void testStatus() {
        Status status = systemApi.status();

        log.info("status:\n{}",status);
    }
}
