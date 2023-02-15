package com.bankly.userservice.config;

import com.bankly.userservice.dto.ResponseDto;
import com.bankly.userservice.entities.UserApp;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Component
public class JwtUtile {

    private String jwtSingningKey = "secret";
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }


    public <T> T extractClaim(String token , Function<Claims,T> claimsResolver){
        if (extractAllClaims(token).getStatus().equals("bad request")){
            return null;
        }else {
            final Claims claims = (Claims) extractAllClaims(token).getData();

            return claimsResolver.apply(claims);
        }
    }


    public ResponseDto extractAllClaims(String token){
        try {
            Claims claims = Jwts.parser().setSigningKey(jwtSingningKey).parseClaimsJws(token).getBody();
            return new ResponseDto("success", "claims", claims);
        }catch (Exception e){
            return new ResponseDto("bad request","jwt expired",e.getMessage());
        }

    }

    public Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public ResponseDto generateToken(UserApp userApp) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims,userApp);
    }

    public ResponseDto createToken(Map<String,Object> claims, UserApp userDetails){

        return new ResponseDto("success","token",Jwts.builder().setClaims(claims)
                .setSubject(userDetails.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ TimeUnit.HOURS.toMillis(24)))
                .signWith(SignatureAlgorithm.HS256,jwtSingningKey).compact());
    }
}
