package com.app.generic.endpoint.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.generic.core.constant.SecurityConstant;

public class JwtUtil {
	
    public static String generateToken(String signingKey, String subject, Map<String, Object> claims) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder()
        		.setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, signingKey);

        return builder.compact();
    }
    
    public static Claims getClaims(String signingKey, String jwt){
    	return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(jwt).getBody();
    }
    
    public static Map<String, Object> getClaimsMap(String signingKey, String jwt){
    	return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(jwt).getBody(); 
    }

    public static String getSubject(String signingKey, String jwt){
    	return JwtUtil.getClaims(signingKey, jwt).getSubject(); 
    }
    
    public static void main(String[] args) {
    	List<String> authorities = new ArrayList<>();
    	authorities.add("CUS_ACC_OPE_R");
    	authorities.add("CUS_ACC_OPE_I");
    	authorities.add("CUS_ACC_OPE_U");
    	authorities.add("CUS_ACC_OPE_D");
    	authorities.add("COR_ACC_OFF_R");
    	authorities.add("COR_ACC_OFF_I");
    	authorities.add("COR_ACC_OFF_U");
    	authorities.add("COR_ACC_OFF_D");

    	Map<String, Object> map = new HashMap<>();
    	map.put("authorities", authorities);

    	System.out.println("SignIn Key : "+ SecurityConstant.SIGN_IN_KEY);
    	
		String jwt = JwtUtil.generateToken(SecurityConstant.SIGN_IN_KEY, "admin", map);
    	System.out.println("Your token is : "+jwt);
    	
    	System.out.println("Claims : "+ getClaims(SecurityConstant.SIGN_IN_KEY, jwt));
	}
    
}
