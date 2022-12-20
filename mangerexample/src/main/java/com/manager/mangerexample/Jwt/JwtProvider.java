package com.manager.mangerexample.Jwt;

import com.manager.mangerexample.Entidades.UsuarioPrincipal;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.security.core.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private final  static Logger logger= LoggerFactory.getLogger(JwtProvider.class);
    @Value("${jwt.secret}")
    private  String secret ;
    @Value("${jwt.expiration}")
    private int expiration;
    public String generateToken(Authentication authentication){
        /*String userName= authentication.getName();
        Date fechaHoy= new Date();
        Date expiracion= new Date(fechaHoy.getTime()+expiration);
        Claims claims= Jwts.claims().setSubject(userName);
        claims.put("fechaHoy",fechaHoy);
        claims.put("fechaExpiracion",expiracion);
        claims.put("roles",authentication.getAuthorities());
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256,secret).compact();*/
        UsuarioPrincipal usuarioPrincipal= (UsuarioPrincipal) authentication.getPrincipal();
        logger.debug(Jwts.builder().setSubject(usuarioPrincipal.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+ expiration*1000))
                .signWith(SignatureAlgorithm.HS256,secret).compact());
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+ expiration*1000))
                .signWith(SignatureAlgorithm.HS256,secret).compact();

    }
    public   String getNombreUsuarioFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJwt(token).getBody().getSubject();
    }
    public boolean validateToken(String token){

        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);

            return true;

        } catch (MalformedJwtException e) {
            logger.error("token mal formado "+e.getMessage());
            logger.error(token);
            e.printStackTrace();
        }catch (UnsupportedJwtException e) {
            logger.error("token no soportado "+e.getMessage());
            logger.error(token);
            e.printStackTrace();
        }catch (ExpiredJwtException e) {
            logger.error("token expirado "+e.getMessage());
            logger.error(token);
            e.printStackTrace();
        }catch (IllegalArgumentException e) {
            logger.error("token vacio "+e.getMessage());
            logger.error(token);
            e.printStackTrace();
        }catch (SignatureException e) {
            logger.error("fail en la firma token "+e.getMessage());
            logger.error(token);
            e.printStackTrace();
        }
        return false;


    }

}
