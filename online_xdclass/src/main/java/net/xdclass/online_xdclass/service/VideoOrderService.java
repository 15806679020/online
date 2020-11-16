package net.xdclass.online_xdclass.service;

import net.xdclass.online_xdclass.model.entity.VideoOrder;

import java.util.List;

/**
 * @ClassName VideoOrderService
 * @Description TODO
 * @Author LD
 * @Date 2020/8/22 19:42
 * @Version 1.0
 **/
public interface VideoOrderService {
    /**
     * Description: 下单接口
     * @Date: 2020/8/22 19:42
     * @param userId
     * @param VideoId
     * @return:
     */
    int save(int userId,int VideoId);
    /**
     * Description: 根据用户ID查询订单列表
     * @Date: 2020/8/22 20:58
     * @param userId
     * @return:
     */
    List<VideoOrder> listOrderByUserId(Integer userId);
}
