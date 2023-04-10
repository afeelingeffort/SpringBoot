package ch01;

public class MainTest1 {

	public static void main(String[] args) {

		Base64Encoder base64Encoder = new Base64Encoder();
		String result = base64Encoder.encode("오늘의 일기 데이트");
		System.out.println("result  : " + result);

		URLEncoder urlEncoder = new URLEncoder();
		String result2 = urlEncoder.encode("오늘의 일기 데이트");
		System.out.println("result2 : " + result2);
	}

}
