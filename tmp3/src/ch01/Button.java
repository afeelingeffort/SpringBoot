package ch01;

/*
 * 1. 인터페이스가 필요하다.
 * 2. 인터페이스를 컴포지션 관계 (포함 관계)로 선언한다.
 * 3. 인터페이스를 구현한 클래스를 받을 setter 메서드를 만들어준다.
 * */
public class Button {

	private String name;
	private IButtonListener iButtonListener;

	public Button(String name) {
		this.name = name;
	}

	// setter를 만들어야 한다.
	public void setIButtonListener(IButtonListener iButtonListener) {
		this.iButtonListener = iButtonListener;
	}

	public void click(String message) {
		// 콜백 메서드 - 호출이 되면 돌아간다.
		if (iButtonListener != null) {
			this.iButtonListener.clickEvent(message);
		}
	}

}
