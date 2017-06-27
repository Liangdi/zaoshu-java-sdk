package me.liangdi.zaoshu.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import me.liangdi.zaoshu.ApiException;
import me.liangdi.zaoshu.model.Account;
import me.liangdi.zaoshu.model.Wallet;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by liangdi on 6/27/17.
 */
@Slf4j
public class UserApiTest extends ApiBase{
    UserApi userApi;

    @Before
    public void init(){

        //设置 ApiBase 中的 apiKey 和  secret

        KeyPair keyPair = new KeyPair(apiKey,secret);
        userApi = new UserApi();
        userApi.init(keyPair);
    }

    @Test
    public void testUserAccount() {
        Account account = null;
        try {
            account = userApi.account();
        } catch (ApiException e) {
            log.info("业务逻辑异常:{},{}",e.getCode(),e.getMessage());
        }
        log.info("account:\n{}",gson.toJson(account));

    }

    @Test
    public void testUserWallet() throws ApiException {
        Wallet wallet = userApi.wallet();
        log.info("wallet:\n{}",wallet);
    }
}
