package net.xdclass.online_xdclass.config;

import net.xdclass.online_xdclass.interceptor.CorsInterceptor;
import net.xdclass.online_xdclass.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName InterceptorConfig
 * @Description TODO 拦截器配置
 * 不用权限可以访问的url /api/v1/pub/
 * 需要登录才可以访问的url /api/v1/pri/
 * @Author LD
 * @Date 2020/8/22 19:08
 * @Version 1.0
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }
    @Bean
    CorsInterceptor corsInterceptor(){
        return new CorsInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截全部路径，这个跨域要放在最上面
        registry.addInterceptor(corsInterceptor()).addPathPatterns("/**");

        //拦截全部
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/v1/pri/*/*/**")
                //不拦截的路径,  开头斜杠一定要有
                .excludePathPatterns("/api/v1/pri/user/login","/api/v1/pri/user/register");

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
