package me.liangdi.zaoshu;

import lombok.extern.slf4j.Slf4j;
import me.liangdi.zaoshu.model.Wallet;
import org.junit.Test;

/**
 * Created by liangdi on 6/27/17.
 */
@Slf4j
public class ZaoshuClientTest {

    @Test
    public void testClient() throws ApiException {
        String secret = "...";
        String apiKey = "...";

        ZaoshuClient client = new ZaoshuClient(apiKey,secret);

        Wallet wallet = client.user().wallet();

        log.info("wallet:{}",wallet);
    }
}
