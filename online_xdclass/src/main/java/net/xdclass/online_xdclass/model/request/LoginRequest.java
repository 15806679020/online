package net.xdclass.online_xdclass.model.request;

/**
 * @ClassName LoginRequest
 * @Description TODO 登录 request
 * @Author LD
 * @Date 2020/8/20 22:04
 * @Version 1.0
 **/
public class LoginRequest {
    private String phone;

    private String pwd;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
