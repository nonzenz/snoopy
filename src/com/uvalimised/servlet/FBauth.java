package com.uvalimised.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.uvalimised.data.User;
import com.uvalimised.impl.Facebook;
import com.visural.common.IOUtil;
import com.visural.common.StringUtil;

@WebServlet("/FBauth")
public class FBauth extends HttpServlet{
	private static final long serialVersionUID = -6259191452173678066L;

	public FBauth() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}
		
		/*String faceCode = request.getParameter("code");
		if (StringUtil.isNotBlankStr(faceCode)) {
			String authURL = Facebook.getAuthURL(faceCode);
            URL url = new URL(authURL);
            try {
                String result = readURL(url);
                String accessToken = null;
                Integer expires = null;
                String[] pairs = result.split("&");
                for (String pair : pairs) {
                    String[] kv = pair.split("=");
                    if (kv.length != 2) {
                        throw new RuntimeException("Unexpected auth response");
                    } else {
                        if (kv[0].equals("access_token")) {
                            accessToken = kv[1];
                        }
                        if (kv[0].equals("expires")) {
                            expires = Integer.valueOf(kv[1]);
                        }
                    }
                }
                if (accessToken != null && expires != null) {
                	User fbUser = authFacebookLogin(accessToken, expires);
                	HttpSession session = request.getSession(true);
                	session.setAttribute("user", fbUser);
                    response.sendRedirect("/LoginSuccess.jsp");
                } else {
                    throw new RuntimeException("Access token and expire time not found");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
		} else {
			Facebook.getLoginRedirectURL();
		}
		

	}

	private String readURL(URL url) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream is = url.openStream();
        int r;
        while ((r = is.read()) != -1) {
            baos.write(r);
        }
        return new String(baos.toByteArray());
    }

	public User authFacebookLogin(String accessToken, int expires) {
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject resp = (JsonObject)jsonParser.parse(IOUtil.urlToString(new URL("https://graph.facebook.com/me?access_token=" + accessToken)));
            //String id = resp.get("id").getAsString();
            String firstName = resp.get("first_name").getAsString();
            String lastName = resp.get("last_name").getAsString();
            String email = resp.get("email").getAsString();

            User user = new User(firstName, lastName, email);
            return user;

        } catch (Throwable ex) {
            throw new RuntimeException("failed login", ex);
        }
    } */
}
