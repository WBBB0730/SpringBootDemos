package com.wbbb.demo01.dto.response;

import com.wbbb.demo01.dto.constant.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseDto<T> {
    private Integer code;
    private String message;
    private T data;

    // 200，操作成功
    public static <T> ResponseDto<T> success(T data) {
        return new ResponseDto<T>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
    }
    public static <T> ResponseDto<T> success(T data, String message) {
        return new ResponseDto<T>(ResponseCode.SUCCESS.getCode(), message, data);
    }

    // 400，请求错误
    public static <T> ResponseDto<T> badRequest(T data) {
        return new ResponseDto<T>(ResponseCode.BAD_REQUEST.getCode(), ResponseCode.BAD_REQUEST.getMessage(), data);
    }
    public static <T> ResponseDto<T> badRequest(T data, String message) {
        return new ResponseDto<T>(ResponseCode.BAD_REQUEST.getCode(), message, data);
    }

    // 404，资源不存在
    public static <T> ResponseDto<T> notFound(T data) {
        return new ResponseDto<T>(ResponseCode.NOT_FOUND.getCode(), ResponseCode.NOT_FOUND.getMessage(), data);
    }
    public static <T> ResponseDto<T> notFound(T data, String message) {
        return new ResponseDto<T>(ResponseCode.NOT_FOUND.getCode(), message, data);
    }

    // 409，资源冲突
    public static <T> ResponseDto<T> conflict(T data) {
        return new ResponseDto<T>(ResponseCode.CONFLICT.getCode(), ResponseCode.CONFLICT.getMessage(), data);
    }
    public static <T> ResponseDto<T> conflict(T data, String message) {
        return new ResponseDto<T>(ResponseCode.CONFLICT.getCode(), message, data);
    }

    // 500，服务器错误
    public static <T> ResponseDto<T> serverError(T data) {
        return new ResponseDto<T>(ResponseCode.SERVER_ERROR.getCode(), ResponseCode.SERVER_ERROR.getMessage(), data);
    }
    public static <T> ResponseDto<T> serverError(T data, String message) {
        return new ResponseDto<T>(ResponseCode.SERVER_ERROR.getCode(), message, data);
    }
}
