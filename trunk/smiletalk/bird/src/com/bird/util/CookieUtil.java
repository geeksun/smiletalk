package com.bird.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 姜志强
 * cookie 工具类
 * 2009-11-10
 */
public class CookieUtil {
	
	public static String getValue(HttpServletRequest request, String cName,
			String value) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cName.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return value;
	}

	public static Cookie getCookie(HttpServletRequest request, String cName) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cName.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		return null;
	}
	
	

}
