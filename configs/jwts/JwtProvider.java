package com.example.test.configs.jwts;

import com.example.test.entities.UserPrinciple;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;

@Component
@Slf4j
public class JwtProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private String jwtSecret = "ming.tran.104855";
    private int jwtExpiration = 86400;
//    public String createToken(Authentication authentication){
//        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
//        return Jwts.builder().setSubject(userPrinciple.getUsername())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(new Date().getTime()+jwtExpiration*1000))
//                .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                .compact();
//
//    }
    public String generateJwtToken(UserPrinciple userPrinciple){
        return generateTokenFromUsername(userPrinciple.getUsername());
    }
    public String generateTokenFromUsername(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime()+jwtExpiration))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
//    public String generateJwtRefreshToken(UserPrinciple userPrinciple){
//        return generateRefreshTokenFromUsername(userPrinciple.getUsername());
//    }
//    public String generateRefreshTokenFromUsername(String username){
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date((new Date()).getTime()+jwtRefreshExpiration))
//                .signWith(SignatureAlgorithm.HS512,jwtSecret)
//                .compact();
//    }
    public String getUserNameFromJwtToken(String token){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        }
        catch (SignatureException e){
            logger.error("Invalid Jwt signature -> Message: {}", e);
        }
        catch (MalformedJwtException e){
            logger.error("Invalid format Token -> Message: {}", e);
        }
        catch (ExpiredJwtException e){
            logger.error("Expired Jwt token -> Message: {}", e);
        }
        catch (UnsupportedJwtException e){
            logger.error("Unsupported Jwt token -> Message: {}", e);
        }
        catch (IllegalArgumentException e){
            logger.error("Jwt claims string is empty -> Message: {}", e);
        }
        return false;
    }
//    public String getUsernameFromToken(String token){
//        String username = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
//        return username;
//    }
}
