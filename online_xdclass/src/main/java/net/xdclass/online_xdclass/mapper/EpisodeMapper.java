package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.model.entity.Episode;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName EpisodeMapper
 * @Description TODO
 * @Author LD
 * @Date 2020/8/22 20:16
 * @Version 1.0
 **/
public interface EpisodeMapper {

    Episode findFirstEpisodeByVideoId(@Param("video_id") int videoId);
}
