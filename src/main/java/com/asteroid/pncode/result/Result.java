package com.asteroid.pncode.result;

import lombok.Data;

/**
 * @author YuSai
 */
@Data
public class Result {
    private int code;
    private String message;
    private Object result;

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.result = data;
    }
}
