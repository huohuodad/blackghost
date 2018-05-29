package com.firetech.blackghost;

public class Constants {

    public static final boolean MOCK_TEST = true;
    public static final String SESSION_USER = "SESSION_USER";
    public static final String SESSION_DRIVER = "SESSION_DRIVER";
    
    // Wechat constants
    public static final String WECHAT_TOKEN = System.getProperty("wechat_token", "joeylovehuohuo");
    public static final String WECHAT_APPID = System.getProperty("wechat_appid", "wx97eed0e96b6996b6");
    public static final String WECHAT_SECRET = System.getProperty("wechat_secret", "487dc57b8f6e4979ce308d9073b00151");
    
    public static final String GET_ACCESS_TOKEN_URL = String.join("",
            "https://api.weixin.qq.com/sns/oauth2/access_token?appid=", WECHAT_APPID,
            "&secret=", WECHAT_SECRET,
            "&code=CODE&grant_type=authorization_code");

    public static final String GET_USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
}
