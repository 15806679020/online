package net.xdclass.online_xdclass.exception;

/**
 * @ClassName XDException
 * @Description TODO 自定义异常信息
 * @Author LD
 * @Date 2020/8/19 23:16
 * @Version 1.0
 **/
public class XDException extends RuntimeException{
    private Integer code;

    private String msg;

    public XDException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
