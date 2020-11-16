package net.xdclass.online_xdclass.config;

/**
 * @ClassName CacheKeyManager
 * @Description TODO 缓存key管理类
 * @Author LD
 * @Date 2020/8/23 20:30
 * @Version 1.0
 **/
public class CacheKeyManager {
    /**
     * 首页轮播图缓存key
     */
    public static final String INDEX_BANNER_KEY = "index:banner:list";
    /**
     * 视频列表缓存key
     */
    public static final String INDEX_VIDEO_KEY = "index:video:list";
    /**
     * 视频详情缓存key,%s是视频id
     */
    public static final String INDEX_VIDEO_DETAIL_KEY = "video:detail:%s";

}
