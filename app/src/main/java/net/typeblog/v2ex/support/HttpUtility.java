package net.typeblog.v2ex.support;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;

public class HttpUtility
{
	private static final String UA = "Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";
	
	public static String request(String url, HttpParameters getParams, HttpParameters postParams, String cookie) {
		Request.Builder builder = new Request.Builder()
			.addHeader("User-Agent", UA);
		
		String reqUrl = url;
		if (getParams != null) {
			reqUrl += "?" + getParams.encode();
		}
		
		builder.url(reqUrl);
		
		if (postParams != null) {
			builder.post(postParams.toRequestBody());
		} else {
			builder.get();
		}
		
		// TODO Add cookies
		
		try {
			return new OkHttpClient().newCall(builder.build()).execute().body().string();
		} catch (IOException e) {
			return null;
		}
	}
}
