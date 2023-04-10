package ch02;

//중간 클래스
public class Encoder {

	// 멤버 변수 선언
	private IEncoder iEncoder;

	// DI 의존 주입 설정 + 전략 패턴(스트래티지 패턴 ?)
	public Encoder(IEncoder iEncoder) {
		this.iEncoder = iEncoder;
	}

	//setter까지 만들면 전략 패턴 완성
	public void setiEncoder(IEncoder iEncoder) {
		this.iEncoder = iEncoder;
	}
	
	// 기능
	public String encode(String message) {
		return iEncoder.encode(message);
	}

}
