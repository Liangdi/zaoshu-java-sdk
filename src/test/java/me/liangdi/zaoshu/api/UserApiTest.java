package me.liangdi.zaoshu.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import me.liangdi.zaoshu.model.Account;
import org.junit.Test;

/**
 * Created by liangdi on 6/27/17.
 */
@Slf4j
public class UserApiTest {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Test
    public void testUserAccount(){
        String secret = "";
        String apiKey = "";
        KeyPair keyPair = new KeyPair(apiKey,secret);
        UserApi userApi = new UserApi();
        userApi.init(keyPair);

        Account account = userApi.account();

        log.info("account:\n{}",account);

    }
}
