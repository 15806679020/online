package net.xdclass.online_xdclass.service.impl;

import net.xdclass.online_xdclass.model.entity.User;
import net.xdclass.online_xdclass.mapper.UserMapper;
import net.xdclass.online_xdclass.service.UserService;
import net.xdclass.online_xdclass.utils.CommonUtils;
import net.xdclass.online_xdclass.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author LD
 * @Date 2020/8/20 17:38
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(Map<String, String> userInfo) {
        User user = parseToUser(userInfo);
        if(user != null){
            return userMapper.save(user);
        }else{
            return -1;
        }
    }

    /**
     * @Description: 解析User对象
     * @Author: LD
     * @Date: 2020/8/20 17:47
     * @param userInfo:
     * @return: net.xdclass.online_xdclass.model.entity.User
     **/
    private User parseToUser(Map<String, String> userInfo) {
        if(userInfo.containsKey("phone") && userInfo.containsKey("pwd") && userInfo.containsKey("name")){
            User user = new User();
            user.setName(userInfo.get("name"));
            user.setHeadImg(getRandomImg());
            user.setCreateTime(new Date());
            user.setPhone(userInfo.get("phone"));
            String pwd = userInfo.get("pwd");
            //MD5加密
            user.setPwd(CommonUtils.MD5(pwd));
            return user;
        }else{
            return null;
        }
    }

    @Override
    public User fingByPhone(String phone) {
        return null;
    }
    /**
     * @Description: 放在CDN上的随机头像
     * @Author: LD
     * @Date: 2020/8/20 17:56
     **/
    private static final String [] headImg = {
            "https://xd-video-pc-img.oss-cnbeijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cnbeijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cnbeijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cnbeijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cnbeijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };
    /**
     * MethodName: getRandomImg
     * Description: 获取随机头像
     * @Author: LD
     * @Date: 2020/8/20 18:24
     * @Param: []
     * @Return: java.lang.String
     */
    private String getRandomImg(){
        int size = headImg.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return headImg[index];
    }

    /**
     * Description: 登录接口
     * @Date: 2020/8/20 22:17
     * @param phone
     * @param pwd
     * @return:
     */
    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {
        User user = userMapper.findByPhoneAndPwd(phone,CommonUtils.MD5(pwd));
        if(user == null){
            return null;
        }else{
            String token = JWTUtils.geneJsonWebToken(user);
            return token;
        }
    }

    /**
     * Description: 根据用户ID查询用户信息
     * @Date: 2020/8/22 19:27
     * @param userId
     * @return:
     */
    @Override
    public User findByUserId(Integer userId) {
        User user =  userMapper.findByUserId(userId);
        return user;
    }
}
