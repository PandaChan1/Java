package exception;

import lombok.Getter;

@Getter
public class myexception extends RuntimeException{
    private String code;
    public myexception(String code,String message) {
//        super(message);
//        this.code = code;
        this(message,null,code);
    }

    public myexception(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }
}
