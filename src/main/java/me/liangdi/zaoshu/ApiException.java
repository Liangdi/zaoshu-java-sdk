package me.liangdi.zaoshu;

import lombok.Data;

/**
 * Created by liangdi on 6/27/17.
 */
@Data
public class ApiException extends Exception{
    private int code;

    public ApiException(String message, int code) {
        super(message);
        this.code = code;
    }
}
