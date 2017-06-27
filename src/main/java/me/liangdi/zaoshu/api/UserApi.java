package me.liangdi.zaoshu.api;

import me.liangdi.zaoshu.Constant;
import me.liangdi.zaoshu.model.Account;
import me.liangdi.zaoshu.util.HttpUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * doc https://github.com/zaoshu/openapi/blob/master/v2/zh-CN/user.md
 * Created by liangdi on 6/27/17.
 */
public class UserApi extends AbstractApi{
    private String accountUrl = Constant.API_URL +  "/user/account";

    /**
     * 获取帐号信息
     * @return
     */
    Account account(){
        Account acc = new Account();
        String result = HttpUtil.get(keyPair,  accountUrl);
        if(StringUtils.isNotEmpty(result)) {
            acc = gson.fromJson(result,Account.class);
        }
        return acc;
    }
}
