package org.example.exception;

import lombok.Getter;
import lombok.Setter;

/*
自定义异常：保存错误码和错误消息
 */
@Getter
@Setter
public class APPexception extends RuntimeException{
private String code;

public APPexception (String code,String message) {
//    super(message);
//    this.code = code;
    this(code,message,null);
}

public APPexception (String code,String message,Throwable t) {
    super(message,t);
    this.code = code;
}


}
