package com.app.generic.service.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestUtil {
	public static final String CLIENT_ID="Client-Id"; 
	
    public static void createCookie(HttpServletResponse httpServletResponse, 
    		String name, String value, Boolean secure, Integer maxAge, String domain) {
        Cookie cookie = new Cookie(name, value);
        cookie.setSecure(secure);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(maxAge);
        cookie.setDomain(domain);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);
    }

    public static void removeCookie(HttpServletResponse httpServletResponse, String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        httpServletResponse.addCookie(cookie);
    }

    public static String getCookie(HttpServletRequest httpServletRequest, String name) {
    	Cookie findCookie = null;
		Cookie[] cookies = httpServletRequest.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (name.equals(cookie.getName())) {
					findCookie= cookie;
				}
			}
		}
        
        return findCookie != null ? findCookie.getValue() : null;
    }
    
    public static String getClientId(HttpServletRequest httpServletRequest) {        
        return httpServletRequest.getHeader(CLIENT_ID);
    }
    
	
}
