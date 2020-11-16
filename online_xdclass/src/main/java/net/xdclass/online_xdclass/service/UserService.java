package net.xdclass.online_xdclass.service;

import net.xdclass.online_xdclass.model.entity.User;

import java.util.Map;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author LD
 * @Date 2020/8/20 17:36
 * @Version 1.0
 **/
public interface UserService {
    /**
     * @Description: 注册接口
     * @Date: 2020/8/20 17:37
     * @param userInfo: 用户
     * @Return:
     **/
    int save(Map<String,String> userInfo);
    /**
     * Description: 根据手机号查询用户
     * @Date: 2020/8/20 22:15
     * @param phone
     * @Return:
     */
    User fingByPhone(String phone);

    /**
     * Description: 登录接口
     * @Date: 2020/8/20 22:16
     * @param phone
     * @param pwd
     * @Return:
     */
    String findByPhoneAndPwd(String phone, String pwd);
    /**
     * Description: 根据用户ID查询用户信息
     * @Date: 2020/8/22 19:26
     * @param userId
     * @return:
     */
    User findByUserId(Integer userId);
}
