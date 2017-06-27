package me.liangdi.zaoshu;

import me.liangdi.zaoshu.api.InstanceApi;
import me.liangdi.zaoshu.api.KeyPair;
import me.liangdi.zaoshu.api.UserApi;

/**
 * Zaoshu Client 是各 API 接口的组合封装
 * Created by liangdi on 6/27/17.
 */
public class ZaoshuClient {
    private KeyPair keyPair;
    private String apiKey;
    private String secret;
    private UserApi user = null;
    private InstanceApi instance = null;



    public ZaoshuClient(String apiKey,String secret) {
       this.keyPair = new KeyPair(apiKey, secret);
    }




    /**
     * 获取用户操作 API 接口
     * @return
     */
    public UserApi user(){
        if(user == null) {
            user = new UserApi();
            user.init(keyPair);
        }

        return user;
    }

    /**
     * 实例相关 API 接口
     * @return
     */
    public InstanceApi instance(){
        if(instance == null){
            instance = new InstanceApi();
            instance.init(keyPair);
        }

        return instance;
    }
}
