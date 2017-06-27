package me.liangdi.zaoshu;

/**
 * Created by liangdi on 6/27/17.
 */
public class ApiException extends Exception{
    private int code;

    public ApiException(String message, int code) {
        super(message);
        this.code = code;
    }
}
