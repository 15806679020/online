package net.xdclass.online_xdclass.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import net.xdclass.online_xdclass.utils.JWTUtils;
import net.xdclass.online_xdclass.utils.JsonData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @ClassName LoginInterceptor
 * @Description TODO
 * @Author LD
 * @Date 2020/8/22 18:55
 * @Version 1.0
 **/
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * Description: 进入controller之前的方法
     * @Date: 2020/8/22 18:55
     * @param request
     * @param response
     * @param handler
     * @return:
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try{
            String accesToken = request.getHeader("token");
            if(accesToken == null){
                accesToken = request.getParameter("token");
            }
            if(StringUtils.isNotBlank(accesToken)){
                Claims claims = JWTUtils.checkJWT(accesToken);
                if(claims == null){
                    //登录过期，重新登录
                    setJsonMessage(response, JsonData.buildError("登录过期，重新登录"));
                    return false;
                }
                Integer id = (Integer) claims.get("id");
                String name = (String) claims.get("name");
                request.setAttribute("user_id",id);
                request.setAttribute("name",name);
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        //登录失败
        setJsonMessage(response, JsonData.buildError("登录过期，重新登录"));
        return false;
    }


    /**
     * Description: 响应JSON数据给前端
     * @Date: 2020/8/22 19:06
     * @param response
     * @param obj
     * @return:
     */
    public static void setJsonMessage(HttpServletResponse response,Object obj){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(objectMapper.writeValueAsString(obj));
            writer.close();
            response.flushBuffer();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
