package net.xdclass.online_xdclass.service;

import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoBanner;

import java.util.List;

/**
 * @ClassName VideoService
 * @Description TODO 视频接口
 * @Author LD
 * @Date 2020/8/19 21:53
 * @Version 1.0
 **/
public interface VideoService {

    List<Video> listVideo();

    List<VideoBanner> listVideoBanner();

    Video findDetailById(int videoId);
}
