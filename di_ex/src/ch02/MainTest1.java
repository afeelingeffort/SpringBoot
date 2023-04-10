package ch02;

public class MainTest1 {

	public static void main(String[] args) {

		// 중간 클래스 만들었음 !
		String url = "www.naver.com/books?id=100";

		// IEncoder 생성자 타입 --> 의존 주입 받을 수 있도록 설계
		// Base64Encoder는 IEncoder 타입으로 바라볼 수 있다.
		// URLEncoder는 IEncoder 타입을 바라볼 수 있다.

		// 하고싶은 인코드 클래스를 주입만 하면 그 구현 클래스에 맞게
		// 기능을 처리할 수 있다.
		Encoder encoder = new Encoder(new URLEncoder());
		String result1 = encoder.encode(url);
		System.out.println("result1 : " + result1);

		encoder.setiEncoder(new Base64Encoder());
		System.out.println(encoder.encode("ㅎㅇ"));
		
		encoder.setiEncoder(new URLEncoder());
		System.out.println(encoder.encode(url));
		
//		Encoder encoder2 = new Encoder(new Base64Encoder());
//		String result2 = encoder2.encode(url);
//		System.out.println("result2 : " + result2);
//
//		Encoder encoder3 = new Encoder(new MyEncoder());
//		String result3 = encoder3.encode(url);
//		System.out.println("result3 : " + result3);
	}

}
