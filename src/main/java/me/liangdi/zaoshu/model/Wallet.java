package me.liangdi.zaoshu.model;

import lombok.Data;

/**
 * Created by liangdi on 6/27/17.
 */
@Data
public class Wallet extends ApiResult{

    WalletData data;

    @Data
    public static class WalletData{
        private int balance;
        private int freeConsumed;
        private int freeTotal;
    }
}
