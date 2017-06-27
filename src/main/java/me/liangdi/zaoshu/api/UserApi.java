package me.liangdi.zaoshu.api;

import me.liangdi.zaoshu.ApiException;
import me.liangdi.zaoshu.Constant;
import me.liangdi.zaoshu.model.Account;
import me.liangdi.zaoshu.model.Wallet;
import me.liangdi.zaoshu.util.HttpUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * doc https://github.com/zaoshu/openapi/blob/master/v2/zh-CN/user.md
 * Created by liangdi on 6/27/17.
 */
public class UserApi extends AbstractApi{
    private String accountUrl = Constant.API_URL +  "/user/account";
    private String walletUrl = Constant.API_URL +  "/user/wallet";

    /**
     * 获取帐号信息
     * @return
     */
    Account account() throws ApiException {
        Account acc = new Account();
        String result = HttpUtil.get(keyPair,  accountUrl);
        if(StringUtils.isNotEmpty(result)) {
            acc = gson.fromJson(result,Account.class);
        }
        return acc;
    }

    /**
     * 获取钱包信息
     * @return
     */
    public Wallet wallet() throws ApiException {
        Wallet wallet = new Wallet();
        String result = HttpUtil.get(keyPair,  walletUrl);
        if(StringUtils.isNotEmpty(result)) {
            wallet = gson.fromJson(result,Wallet.class);
        }

        return wallet;
    }
}
