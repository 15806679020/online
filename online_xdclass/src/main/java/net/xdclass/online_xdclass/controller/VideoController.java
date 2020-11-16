package net.xdclass.online_xdclass.controller;

import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoBanner;
import net.xdclass.online_xdclass.service.VideoService;
import net.xdclass.online_xdclass.utils.BaseCache;
import net.xdclass.online_xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName VideoController
 * @Description TODO
 * @Author LD
 * @Date 2020/8/19 21:55
 * @Version 1.0
 **/
@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private BaseCache baseCache;


    /**
     * @Description: 轮播图列表
     * @Author: LD
     * @Date: 2020/8/19 22:28
     * @return: net.xdclass.online_xdclass.utils.JsonData
     **/
    @GetMapping("list_banner")
    public JsonData indexBanner(){
        List<VideoBanner> videoBannerList = videoService.listVideoBanner();
        return JsonData.buildSuccess(videoBannerList);
    }

    /**
     * @Description: 视频列表
     * @Author: LD
     * @Date: 2020/8/19 22:28
     * @return: java.lang.Object
     **/
    @RequestMapping("list")
    public JsonData listVideo(){
        List<Video> videoList = videoService.listVideo();
        return JsonData.buildSuccess(videoList);
    }

    /**
     * @Description: 查询视频详情，包含章集信息
     * @Author: LD
     * @Date: 2020/8/19 22:46
     * @param videoId: 视频ID
     * @return: net.xdclass.online_xdclass.utils.JsonData
     **/
    @GetMapping("find_detail_by_id")
    public JsonData findDetailById(@RequestParam(value = "video_id",required = true) int videoId){
        Video video = videoService.findDetailById(videoId);
        return JsonData.buildSuccess(video);
    }
}
