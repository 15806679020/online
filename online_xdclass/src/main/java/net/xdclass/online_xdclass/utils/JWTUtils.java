package net.xdclass.online_xdclass.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.xdclass.online_xdclass.model.entity.User;

import java.util.Date;

/**
 * @ClassName JWTUtils
 * @Description TODO JWT工具类
 * 1.生成的token是可以通过base64进行解密成明文信息
 * 2.base64进行解密出明文信息，修改再进行编码，则会解密失败
 * 3.无法作废已颁布的token,除非改密钥
 * @Author LD
 * @Date 2020/8/20 20:44
 * @Version 1.0
 **/
public class JWTUtils {

    /**
     * Description: 过期时间
     * @Author: LD
     * @Date: 2020/8/20 21:31
     */
    private static final long EPIRE = 60 * 1000 * 60 * 24 * 7;
    /**
     * Description: 加密密钥
     * @Author: LD
     * @Date: 2020/8/20 21:32
     */
    private static final String SECRET = "xdclass.net168";
    /**
     * Description: 令牌前缀
     * @Author: LD
     * @Date: 2020/8/20 21:32
     */
    private static final String TOKEN_PREFIX="xdclass";
    /**
     * Description: subject
     * @Author: LD
     * @Date: 2020/8/20 21:32
     */
    private static final String SUBJECT = "xdclass";
    /**
     * MethodName: geneJsonWebToken
     * Description:  根据用户信息，生成令牌
     * @Author: LD
     * @Date: 2020/8/20 20:49
     * @Param: [user]
     * @Return: java.lang.String
     */
    public static String geneJsonWebToken(User user){
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("head_img",user.getHeadImg())
                .claim("id",user.getId())
                .claim("name",user.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EPIRE))
                .signWith(SignatureAlgorithm.HS256,SECRET).compact();
        token = TOKEN_PREFIX + token;
        return token;
    }
    /**
     * MethodName: checkJWT
     * Description: 校验token
     * @Author: LD
     * @Date: 2020/8/20 21:53
     * @Param: [token]
     * @Return: io.jsonwebtoken.Claims
     */
    public static Claims checkJWT(String token){
        try{
            final Claims claims = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX,""))
                    .getBody();
            return claims;
        }catch(Exception e){
            return null;
        }
    }
}
