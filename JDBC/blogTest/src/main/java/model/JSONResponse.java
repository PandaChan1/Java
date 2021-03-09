package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 前后端约定的统一格式，返回的状态码都是200
 */
@Getter
@Setter
@ToString
public class JSONResponse {
    //业务是否成功
    private boolean success;
    //错误码:开发人员使用来定位问题
    private String code;
    //错误信息：给用户看看的信息
    private String message;
    //业务数据
    private Object data;
}


