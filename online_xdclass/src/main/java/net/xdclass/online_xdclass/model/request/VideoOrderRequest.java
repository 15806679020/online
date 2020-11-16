package net.xdclass.online_xdclass.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @ClassName VideoOrderRequest
 * @Description TODO
 * @Author LD
 * @Date 2020/8/22 19:39
 * @Version 1.0
 **/
public class VideoOrderRequest {

    @JsonProperty("video_id")
    private int videoId;

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }


}
