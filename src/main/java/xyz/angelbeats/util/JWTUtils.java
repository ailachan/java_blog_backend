package xyz.angelbeats.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.impl.JWTParser;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * JWTUtils
 *
 * @date 2021/3/4 1:14
 */
public class JWTUtils {

    private static final String SIGN="WE123456789";

//    生成token
    public static String getToken(Map<String, String> map) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 1);

//        创建builder
        JWTCreator.Builder builder = JWT.create();
//        payload
        map.forEach((k, v)->{
           builder.withClaim(k, v);
        });
        String token = builder.withExpiresAt(instance.getTime())//token过期时间为1天
                .sign(Algorithm.HMAC256(SIGN));

        return token;
    }

//    验证token
    public static DecodedJWT verify(String token) {
        return JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
    }

    // 解析JWT令牌
    // 解析JWT令牌
    public static Map<String, String> parseToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SIGN);
        DecodedJWT decodedJWT = JWT.require(algorithm).build().verify(token);

        Map<String, String> data = new HashMap<>();
        for (Map.Entry<String, Claim> entry : decodedJWT.getClaims().entrySet()) {
            data.put(entry.getKey(), entry.getValue().asString());
        }

        return data;
    }
}
