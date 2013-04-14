package com.uvalimised.impl;

import java.util.UUID;

import com.visural.common.StringUtil;

public class Facebook{   
    private static final String secret = "ca3e70a23a25c963d209fee08628b2a2";
    private static final String client_id = "386869324759549";  
    private static final String redirect_uri = "http://localhost:8080/ValimisedSnoopy/FBauth"; 
    private static final UUID state = UUID.randomUUID();
    
    //List of permissions.
    private static final String[] perms = new String[] {"read_stream", "email"};

    public static String getAPIKey() {
        return client_id;
    }

    public static String getSecret() {
        return secret;
    }

    public static String getLoginRedirectURL() {
        return "https://www.facebook.com/dialog/oauth?client_id=" + 
            client_id + "&display=page&redirect_uri=" + 
            redirect_uri+"&state="+state+"&scope="+StringUtil.delimitObjectsToString(",", perms);
    }

    public static String getAuthURL(String authCode) {
        return "https://www.facebook.com/dialog/oauth?client_id=" + 
            client_id+"&redirect_uri=" + 
            redirect_uri+"&client_secret="+secret+"&code="+authCode;
    }
	
}
