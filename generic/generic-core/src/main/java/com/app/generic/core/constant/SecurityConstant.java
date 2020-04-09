package com.app.generic.core.constant;

/**
 * This class is used for store information about constant used in security like JWT sign in key, etc.
 * @author abdullah.alim
 *
 */
public class SecurityConstant {
	
	/**
	 * base64 encoded string for generate & parse JWT 
	 */
	public static final String SIGN_IN_KEY = "c2VjcmV0LWtleQ==";// "secret-key"
	
	/**
	 * <p>
	 * 		Prefix for Authorization with Type Bearer Token <br>
	 * 		ex : <code>Bearer <em>&lt;token&gt;</em></code>
	 * </p>
	 */
	public static final String BEARER_PREFIX = "Bearer ";
	
	public static final String AUTHORIZATION = "Authorization";
	
	/**
	 * used for default value when process internal system like COB,etc
	 */
	public static final String SYSTEM = "SYSTEM";
	
	/**
     * used for default value when create transaction from web services
     */
    public static final String CHANNEL = "CHANNEL";
	
}
