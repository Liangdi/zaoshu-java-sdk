package me.liangdi.zaoshu.model;

import lombok.Data;

/**
 * Created by liangdi on 6/27/17.
 */
@Data
public class Account extends ApiResult{

    AccountData data;

    @Data
    public static final class AccountData {
        private String email;
        private String status;
    }
}
