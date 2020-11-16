package net.xdclass.online_xdclass.utils;

/**
 * @ClassName JsonData
 * @Description TODO 返回数据工具类
 * @Author LD
 * @Date 2020/8/19 22:02
 * @Version 1.0
 **/
public class JsonData {
    /**
     * @Description: 状态码，0表示成功，1 表示处理中，-1 表示失败
     * @Author: LD
     * @Date: 2020/8/19 22:09
     **/
    private Integer code;
    /**
     * @Description: 业务数据
     * @Author: LD
     * @Date: 2020/8/19 22:09
     **/
    private Object data;
    /**
     * @Description: 信息表示
     * @Author: LD
     * @Date: 2020/8/19 22:09
     **/
    private String msg;

    /**
     * @Description: 带参构造函数
     * @Author: LD
     * @Date: 2020/8/19 22:10
     * @param code: 状态码
     * @param data: 业务数据
     * @param msg: 返回信息
     * @return: null
     **/
    public JsonData(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
    /**
     * @Description: 成功，不返回数据
     * @Author: LD
     * @Date: 2020/8/19 22:08
     * @return: net.xdclass.online_xdclass.utils.JsonData
     **/
    public static JsonData buildSuccess(){
        return new JsonData(0,null,null);
    }

    /**
     * @Description:成功，返回数据
     * @Author: LD
     * @Date: 2020/8/19 22:08
     * @param data: 业务数据
     * @return: net.xdclass.online_xdclass.utils.JsonData
     **/
    public static JsonData buildSuccess(Object data){
        return new JsonData(0,data,null);
    }

    /**
     * Description: 成功，不返回数据，自定义成功码和成功提示信息
     * @Date: 2020/8/22 20:54
     * @param msg
     * @return:
     */
    public static JsonData buildSuccess(Integer code,String msg){return new JsonData(code,null,msg);}
    /**
     * @Description:失败，固定状态码
     * @Author: LD
     * @Date: 2020/8/19 22:07
     * @param msg: 返回信息
     * @return: net.xdclass.online_xdclass.utils.JsonData
     **/
    public static JsonData buildError(String msg){
        return new JsonData(-1,null,msg);
    }

    /**
     * @Description: 失败，自定义错误码和信息
     * @Author: LD
     * @Date: 2020/8/19 22:07
     * @param code: 状态码
     * @param msg: 返回信息
     * @return: net.xdclass.online_xdclass.utils.JsonData
     **/
    public static JsonData buildError(Integer code,String msg){
        return new JsonData(code,null,msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
