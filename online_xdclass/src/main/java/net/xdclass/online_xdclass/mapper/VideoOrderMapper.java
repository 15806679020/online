package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName VideoOrderMapper
 * @Description TODO
 * @Author LD
 * @Date 2020/8/22 19:45
 * @Version 1.0
 **/
public interface VideoOrderMapper {

    /**
     * Description: 查询用户是否购买过次商品
     * @Date: 2020/8/22 19:46
     * @param userId
     * @param videoId
     * @param state
     * @return:
     */
    VideoOrder findByUserIdAndVideoIdAndState(@Param("user_id") int userId, @Param("video_id") int videoId, @Param("state") int state);

    /**
     * Description: 下单
     * @Date: 2020/8/22 19:47
     * @param
     * @return:
     */
    int saveOrder(VideoOrder videoOrder);

    /**
     * Description: 视频列表
     * @Date: 2020/8/22 21:00
     * @param userId
     * @return:
     */
    List<VideoOrder> listOrderByUserId(@Param("user_id") Integer userId);
}
