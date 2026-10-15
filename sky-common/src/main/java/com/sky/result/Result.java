package com.sky.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 后端统一返回结果。
 *
 * <p>所有 Controller 都尽量使用这个对象返回数据，
 * 前端只需要根据 code 判断请求是否成功，再读取 data。</p>
 *
 * @param <T> data 字段中实际数据的类型
 */
@Data
public class Result<T> implements Serializable {

    private Integer code; // 编码：1 表示成功，0 表示失败
    private String msg; // 失败时返回给前端的提示信息
    private T data; // 请求成功时返回的业务数据

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = 1;
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.data = object;
        result.code = 1;
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result result = new Result();
        result.msg = msg;
        result.code = 0;
        return result;
    }

}
