package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.model.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author LD
 * @Date 2020/8/20 17:35
 * @Version 1.0
 **/
public interface UserMapper {

    /**
     * Description: 注册
     * @Date: 2020/8/20 22:22
     * @param user 用户
     * @return:
     */
    int save(User user);

    /**
     * Description: 根据手机号查询用户
     * @Date: 2020/8/20 22:22
     * @param phone 手机号
     * @return:
     */
    User findByPhone(@Param("phone") String phone);

    /**
     * Description: 根据手机号和密码查询用户
     * @Date: 2020/8/20 22:22
     * @param phone 手机号
     * @param pwd 密码
     * @return:
     */
    User findByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);

    /**
     * Description: 根据用户ID查询用户信息
     * @Date: 2020/8/22 19:27
     * @param userId
     * @return:
     */
    User findByUserId(@Param("user_id") Integer userId);
}
