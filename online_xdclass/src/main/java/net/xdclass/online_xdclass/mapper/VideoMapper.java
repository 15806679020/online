package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName VideoMapper
 * @Description TODO 视频接口
 * @Author LD
 * @Date 2020/8/19 21:51
 * @Version 1.0
 **/
public interface VideoMapper {

    /**
     * @Description: 查询视频列表
     * @Author: LD
     * @Date: 2020/8/19 21:53
     * @return: java.util.List<net.xdclass.online_xdclass.model.entity.Video>
     **/
    List<Video> listVideo();

    /**
     * @Description: 首页轮播图列表
     * @Author: LD
     * @Date: 2020/8/19 22:30
     * @return: java.util.List<net.xdclass.online_xdclass.model.entity.VideoBanner>
     **/
    List<VideoBanner> listVideoBanner();

    /**
     * @Description: 根据视频ID查询视频详情
     * @Author: LD
     * @Date: 2020/8/19 22:48
     * @param videoId: 视频ID
     * @return: net.xdclass.online_xdclass.model.entity.Video
     **/
    Video findDetailById(@Param("video_id") int videoId);

    /**
     * Description: 简单查询视频详情
     * @Date: 2020/8/22 19:58
     * @param videoId
     * @return:
     */
    Video findById(int videoId);
}
