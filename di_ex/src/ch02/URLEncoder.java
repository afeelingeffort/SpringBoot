package ch02;

import java.io.UnsupportedEncodingException;

public class URLEncoder implements IEncoder {

	@Override
	public String encode(String message) {

		try {
			return java.net.URLEncoder.encode(message, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

}
