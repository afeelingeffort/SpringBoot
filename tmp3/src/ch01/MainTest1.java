package ch01;

public class MainTest1 {

	// main 함수
	public static void main(String[] args) {

		// 옵저버 패턴
		// 코드 흐름이 원래는 순차적으로 진행되는데
		// 이벤트가 일어나면 다시 수행한다.
		Button button = new Button("btn1");

		// 인터페이스 --> 익명 클래스 --> 익명 구현 클래스
		button.setIButtonListener(new IButtonListener() {
			
			@Override
			public void clickEvent(String event) {
				// 하고 싶은 동작, 알고리즘 구현하면 된다.
				System.out.println("콜백 들어왔어1111" + event);
			}
		});
		/////////////////////////// 콜백 메서드 = 옵저버 패턴 설계 완료
		// 오후 4시 됨 --> 알람 울림
		button.click("야 너 집에 가야지 엄마 기다려");
		
		button.click("이게 정말 콜백이야?");
		button.click("맞아 옵저버 패턴이라고도 불려");
	} // end of main

} // end of class
