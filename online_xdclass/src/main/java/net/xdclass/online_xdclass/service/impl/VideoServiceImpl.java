package net.xdclass.online_xdclass.service.impl;

import net.xdclass.online_xdclass.config.CacheKeyManager;
import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoBanner;
import net.xdclass.online_xdclass.mapper.VideoMapper;
import net.xdclass.online_xdclass.model.entity.VideoOrder;
import net.xdclass.online_xdclass.service.VideoService;
import net.xdclass.online_xdclass.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName VideoServiceImpl
 * @Description TODO 视频接口实现类
 * @Author LD
 * @Date 2020/8/19 21:54
 * @Version 1.0
 **/
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private BaseCache baseCache;

    @Override
    public List<Video> listVideo() {
        try{
            Object cacheObj = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_VIDEO_KEY, ()->{
                List<Video> videoList = videoMapper.listVideo();
                return videoList;
            });
            if(cacheObj instanceof List){
                List<Video> videoList =  (List<Video>)cacheObj;
                return videoList;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        //可以返回兜底数据，业务系统降级
        return null;
    }

    @Override
    public List<VideoBanner> listVideoBanner() {
        try{
            Object cacheObj = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_KEY, ()->{
                List<VideoBanner> videoBannerList = videoMapper.listVideoBanner();
                return videoBannerList;
            });
            if(cacheObj instanceof List){
                List<VideoBanner> videoBannerList = (List<VideoBanner>)cacheObj;
                return videoBannerList;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Video findDetailById(int videoId) {

        String videoCacheKey = String.format(CacheKeyManager.INDEX_VIDEO_DETAIL_KEY,videoId);
        try{
            Object cacheObj = baseCache.getOneHourCache().get(videoCacheKey,()->{
                // 需要使用 mybatis 关联复杂查询
                Video video = videoMapper.findDetailById(videoId);
                return video;
            });
            if(cacheObj instanceof Video){
                Video video = (Video)cacheObj;
                return video;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
